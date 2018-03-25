package com.gleo.groupphoto.web.portlet;

import com.gleo.groupphoto.web.constants.GroupPhotoPortletKeys;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

import javax.portlet.Portlet;

import org.osgi.service.component.annotations.Component;

/**
 * @author guillaumelenoir
 *
 */
@Component(immediate = true, property = {
	"com.liferay.portlet.css-class-wrapper=user-details-portlet",
	"com.liferay.portlet.display-category=category.hidden",
	"com.liferay.portlet.header-portlet-css=/userdetails/css/main.css",
	"com.liferay.portlet.icon=/userdetails/icons/groupphoto.png",
	"com.liferay.portlet.render-weight=50",
	"com.liferay.portlet.scopeable=true",
	"com.liferay.portlet.use-default-template=true",
	"com.liferay.portlet.system=true",
	"com.liferay.portlet.add-default-resource=true",
	"javax.portlet.display-name=user details",
	"javax.portlet.expiration-cache=0",
	"javax.portlet.init-param.always-display-default-configuration-icons=true",
	"javax.portlet.init-param.template-path=/",
	"javax.portlet.name=" + GroupPhotoPortletKeys.USER_DETAILS,
	"javax.portlet.resource-bundle=content.Language",
	"javax.portlet.security-role-ref=power-user,user",
	"javax.portlet.supports.mime-type=text/html"
}, service = Portlet.class)
public class UserDetailsPortlet extends MVCPortlet {

}
