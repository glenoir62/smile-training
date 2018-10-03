package com.gleo.module.remove.menu.context.contributor;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.security.permission.PermissionChecker;
import com.liferay.portal.kernel.template.TemplateContextContributor;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.WebKeys;

/**
 * @author guillaumelenoir
 */
@Component(
		immediate = true,
		property = {
				"type=" + TemplateContextContributor.TYPE_THEME
				},
		service = TemplateContextContributor.class)
public class RemoveMenuTemplateContextContributor implements TemplateContextContributor {

	private final static Log LOG = LogFactoryUtil.getLog(RemoveMenuTemplateContextContributor.class);

	@Override
	public void prepare(Map<String, Object> contextObjects, HttpServletRequest request) {

		boolean isShowMenu = isShowMenu(request);

		if (!isShowMenu) {
			String cssClass = GetterUtil.getString(
					contextObjects.get("bodyCssClass"));

			contextObjects.put("bodyCssClass", StringUtil.removeFromList(cssClass, "has-control-menu", " "));
		}
		
		
		LOG.debug("isShowMenu = " + isShowMenu);
		contextObjects.put("is_show_menu", isShowMenu);
	}

	/**
	 * @param request
	 * @return
	 */
	protected boolean isShowMenu(HttpServletRequest request) {
		ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		PermissionChecker permissionChecker = themeDisplay.getPermissionChecker();

		if (themeDisplay.isImpersonated()) {
			return true;
		}

		if (themeDisplay.isSignedIn() && (permissionChecker.isOmniadmin())) {
			return true;
		}

		User user = themeDisplay.getUser();

		if (!user.isSetupComplete()) {
			return false;
		}

		return false;
	}

}