package help.portlet;

import java.io.IOException;
import java.util.List;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.asset.kernel.model.AssetEntry;
import com.liferay.asset.kernel.model.AssetTag;
import com.liferay.asset.kernel.service.AssetEntryLocalServiceUtil;
import com.liferay.asset.kernel.service.AssetTagLocalServiceUtil;
import com.liferay.asset.kernel.service.persistence.AssetEntryQuery;
import com.liferay.document.library.kernel.model.DLFileEntry;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Layout;
import com.liferay.portal.kernel.model.LayoutTypePortlet;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;

import help.constants.HelpPortletKeys;

/**
 * @author guillaumelenoir
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true", "javax.portlet.display-name=help Portlet",
		"javax.portlet.init-param.template-path=/", "javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + HelpPortletKeys.Help, "javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class HelpPortlet extends MVCPortlet {

	protected static Log LOGGER = LogFactoryUtil.getLog(HelpPortlet.class);

	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {

		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

		Layout layout = themeDisplay.getLayout();
		LayoutTypePortlet layoutTypePortlet = (LayoutTypePortlet) layout.getLayoutType();
		List<String> actualPortletList = layoutTypePortlet.getPortletIds();

		for (String portletId : actualPortletList) {
			LOGGER.info("portletId " + portletId);
		}

		String tag = "pageTest";

		AssetTag testTag = null;
		try {
			testTag = AssetTagLocalServiceUtil.getTag(themeDisplay.getScopeGroupId(), tag);
		} catch (PortalException e) {
			LOGGER.error(e);
		}

		if (testTag != null) {
			AssetEntryQuery assetEntryQuery = new AssetEntryQuery();
			assetEntryQuery.setGroupIds(new long[] { themeDisplay.getScopeGroupId() });
			assetEntryQuery.setAnyTagIds(new long[] { testTag.getTagId() });
			List<AssetEntry> assetEntries = AssetEntryLocalServiceUtil.getEntries(assetEntryQuery);
			for (AssetEntry assetEntry : assetEntries) {

				if (assetEntry.getClassName().equals(DLFileEntry.class.getName())) {
					LOGGER.info("assetEntry " + assetEntry);
				}

			}
		}

		super.doView(renderRequest, renderResponse);
	}

}