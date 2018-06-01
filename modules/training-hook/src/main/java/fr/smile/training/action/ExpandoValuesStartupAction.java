package fr.smile.training.action;

import org.osgi.service.component.annotations.Component;

import com.liferay.expando.kernel.exception.NoSuchTableException;
import com.liferay.expando.kernel.model.ExpandoColumn;
import com.liferay.expando.kernel.model.ExpandoColumnConstants;
import com.liferay.expando.kernel.model.ExpandoTable;
import com.liferay.expando.kernel.model.ExpandoTableConstants;
import com.liferay.expando.kernel.model.ExpandoValue;
import com.liferay.expando.kernel.service.ExpandoColumnLocalServiceUtil;
import com.liferay.expando.kernel.service.ExpandoTableLocalServiceUtil;
import com.liferay.expando.kernel.service.ExpandoValueLocalServiceUtil;
import com.liferay.portal.kernel.events.ActionException;
import com.liferay.portal.kernel.events.LifecycleAction;
import com.liferay.portal.kernel.events.LifecycleEvent;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.CompanyLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.UnicodeProperties;

@Component(
		immediate = true, property = {
			"key=global.startup.events"
		}, service = LifecycleAction.class
)
public class ExpandoValuesStartupAction implements LifecycleAction {
	/**
	 * The logger
	 */
	private static final Log LOGGER = LogFactoryUtil.getLog(ExpandoValuesStartupAction.class);
	
	@Override
	public void processLifecycleEvent(LifecycleEvent lifecycleEvent) throws ActionException {
		
		// Slide 119
		// get User test
		
	 	/// 
		// PortalUtil.getCompanyId(lifecycleEvent.getRequest());
		
		// Get default web id from portal.properties
		String webId = PropsUtil.get("company.default.web.id");
		
		try {
			// Get Company id -> virtual instance
			long companyId = CompanyLocalServiceUtil.getCompanyByWebId( webId).getCompanyId();
			
			// Get liferay user
			// Use liferay user service
			// Local est un accès à la base de données sans filtrages des permissions
			// Pas local utilisation du check des permissions
			User user = UserLocalServiceUtil.getUserByEmailAddress(companyId, "test@liferay.com");

			// Get user class name
			String className = User.class.getName();
			String tableName = ExpandoTableConstants.DEFAULT_TABLE_NAME;
			ExpandoTable expandoTable = addExpandoTable(companyId, className, tableName);
			ExpandoColumn existingEc = addExpandoColumn(companyId, className, tableName, "user-type", expandoTable);
			
			String[] data = {"queen"};
			if (existingEc != null) {
				// –Change the user-type custom field value for the user « test » programmatically at
				// startup
				ExpandoValue expandoValue = ExpandoValueLocalServiceUtil.getValue(expandoTable.getTableId(), existingEc.getColumnId(), user.getUserId());
				if (expandoValue == null) {
					
					expandoValue = ExpandoValueLocalServiceUtil.addValue(companyId, className, tableName, existingEc.getName(), user.getUserId(), data);
				} else {
					expandoValue.setStringArray(data);
					ExpandoValueLocalServiceUtil.updateExpandoValue(expandoValue);
				}
				
				LOGGER.info("test@liferay.com => user-type = " + expandoValue.getData());
			}
			
			// From portlet use :
			// LOGGER.info("user-type" +
			// GetterUtil.getString(user.getExpandoBridge().getAttribute("user-type")
			// ));

		} catch (PortalException e) {
			LOGGER.error("Unable to set user-type for test@liferay.com : " + e.getMessage());
		}
		LOGGER.info("start up");

	}

	
	/**
	 * @param companyId
	 * @param className
	 * @param tableName
	 * @return
	 */
	public ExpandoTable addExpandoTable(long companyId, String className, String tableName) {
		ExpandoTable expandoTable = null;
		try {
			expandoTable = ExpandoTableLocalServiceUtil.getDefaultTable(companyId, className);
		} catch (NoSuchTableException nste) {
			try {
				expandoTable = ExpandoTableLocalServiceUtil.addTable(companyId, className, tableName);
			} catch (Exception e) {
				LOGGER.error(e);
			}
		} catch (Exception e) {
			LOGGER.error(e);
		}
		return expandoTable;

	}


	/**
	 * @param companyId
	 * @param className
	 * @param tableName
	 * @param columnName
	 * @param expandoTable
	 * @return
	 */
	public ExpandoColumn addExpandoColumn(long companyId, String className, String tableName, String columnName,
			ExpandoTable expandoTable) {
		ExpandoColumn exandoColumn = null;
		try {
			exandoColumn = ExpandoColumnLocalServiceUtil.getColumn(companyId, className, tableName, columnName);
			if (exandoColumn == null) {
				exandoColumn = ExpandoColumnLocalServiceUtil.addColumn(expandoTable.getTableId(), columnName,
						ExpandoColumnConstants.STRING_ARRAY, new String[]{"good","bad","queen"});
				UnicodeProperties typeSettings = exandoColumn.getTypeSettingsProperties();
				typeSettings.put(ExpandoColumnConstants.PROPERTY_DISPLAY_TYPE, ExpandoColumnConstants.PROPERTY_DISPLAY_TYPE_SELECTION_LIST);
				typeSettings.put(ExpandoColumnConstants.PROPERTY_VISIBLE_WITH_UPDATE_PERMISSION, "1");
				typeSettings.put(ExpandoColumnConstants.PROPERTY_HIDDEN, "0");
				
				ExpandoColumnLocalServiceUtil.updateTypeSettings(exandoColumn.getColumnId(), typeSettings.toString());
				
			}

		} catch (SystemException | PortalException e) {
			LOGGER.error(e);
		}
		LOGGER.info("Expando Column==>" + exandoColumn.getColumnId());
		return exandoColumn;
	}
}
