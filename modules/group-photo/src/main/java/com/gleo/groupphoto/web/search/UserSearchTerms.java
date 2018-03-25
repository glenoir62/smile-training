
package com.gleo.groupphoto.web.search;

import com.liferay.portal.kernel.dao.search.DAOParamUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.workflow.WorkflowConstants;

import javax.portlet.PortletRequest;

/**
 * @author guillaumelenoir
 */
public class UserSearchTerms extends UserDisplayTerms {

    public UserSearchTerms(PortletRequest portletRequest) {
	super(portletRequest);

	emailAddress = DAOParamUtil.getString(portletRequest, EMAIL_ADDRESS);
	firstName = DAOParamUtil.getString(portletRequest, FIRST_NAME);
	lastName = DAOParamUtil.getString(portletRequest, LAST_NAME);
	middleName = DAOParamUtil.getString(portletRequest, MIDDLE_NAME);
	organizationId = ParamUtil.getLong(portletRequest, ORGANIZATION_ID);
	screenName = DAOParamUtil.getString(portletRequest, SCREEN_NAME);
	status = ParamUtil.getInteger(
		portletRequest, STATUS, WorkflowConstants.STATUS_APPROVED);
	userGroupId = ParamUtil.getLong(portletRequest, USER_GROUP_ID);
    }

}
