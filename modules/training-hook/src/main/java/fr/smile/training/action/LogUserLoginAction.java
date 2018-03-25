package fr.smile.training.action;

import org.osgi.service.component.annotations.Component;

import com.liferay.expando.kernel.model.ExpandoColumn;
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
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.service.ClassNameLocalServiceUtil;
import com.liferay.portal.kernel.util.PortalUtil;

@Component(
		immediate = true, property = {
			"key=login.events.post"
		}, service = LifecycleAction.class
)
public class LogUserLoginAction implements LifecycleAction {

	private static final Log LOGGER = LogFactoryUtil.getLog(LogUserLoginAction.class);
	
	@Override
	public void processLifecycleEvent(LifecycleEvent lifecycleEvent) throws ActionException {
		
		
		try {
			User user = PortalUtil.getUser(lifecycleEvent.getRequest());
			long classNameId = ClassNameLocalServiceUtil.getClassNameId(User.class.getName());
			try {
				ExpandoTable table = ExpandoTableLocalServiceUtil.getTable(user.getCompanyId(),
						classNameId, ExpandoTableConstants.DEFAULT_TABLE_NAME);
				ExpandoColumn existingEc = ExpandoColumnLocalServiceUtil.getColumn(table.getTableId(), "user-type");
				ExpandoValue expandoValue = ExpandoValueLocalServiceUtil.getValue(table.getTableId(), existingEc.getColumnId(), user.getUserId());
				
				LOGGER.info("user-type = " + expandoValue.getData());
				//LOGGER.info("user-type" + GetterUtil.getString(user.getExpandoBridge().getAttribute("user-type") ));
			} catch (Exception e) {
				e.printStackTrace();
				LOGGER.error("Unable to createOrGetCustomTable : " + e.getMessage());
			}
			
		} catch (PortalException e) {
			LOGGER.info(e);
		} catch (Exception e) {
			LOGGER.info(e);
		}
	}

}
