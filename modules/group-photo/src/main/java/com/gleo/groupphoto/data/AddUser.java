package com.gleo.groupphoto.data;

import com.liferay.counter.kernel.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.model.Group;
import com.liferay.portal.kernel.model.GroupConstants;
import com.liferay.portal.kernel.model.Role;
import com.liferay.portal.kernel.model.RoleConstants;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.search.Indexer;
import com.liferay.portal.kernel.search.IndexerRegistryUtil;
import com.liferay.portal.kernel.service.GroupLocalServiceUtil;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.LocaleUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.Date;
import java.util.Locale;
import java.util.UUID;

import javax.portlet.ActionRequest;

public class AddUser {

    public static void main() throws PortalException {

	int userToCreate = 1;

	String groupKey = GroupConstants.GUEST;
	
	ActionRequest actionRequest = null;
	
	@SuppressWarnings("null")
	ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
	long companyId = themeDisplay.getCompanyId();
	Group group = GroupLocalServiceUtil.getGroup(companyId, groupKey);

	for (int i = 0; i < userToCreate; i++) {
	    insertUserGroup(actionRequest, group, themeDisplay, companyId);
	}

    }

    /**
     * Insert User Group
     * 
     * @param actionRequest
     * @param group
     * @param themeDisplay
     * @param companyId
     * @return
     * @throws PortalException
     * @throws SystemException
     */
    private static User insertUserGroup(ActionRequest actionRequest, Group group, ThemeDisplay themeDisplay,
	    long companyId) throws PortalException, SystemException {


	
	long creatorUserId = CounterLocalServiceUtil.increment(User.class.getName());
	UserLocalServiceUtil.createUser(creatorUserId);
	
	long facebookId = 0;
	String openId = null;
	String password1 = "test";
	String password2 = "test";
	int suffixId = 234;
	String jobTitle = "DEV";
	String emailAddress="administrator"+ creatorUserId +"@liferay.com";
	
	String lastName = "DEV "+ creatorUserId;
	
	User user = null;

	Date date = new Date();
	ServiceContext serviceContext = new ServiceContext();
	serviceContext.setUuid(UUID.randomUUID().toString());
	serviceContext.setCreateDate(date);
	serviceContext.setModifiedDate(date);
	
	
	boolean autoPassword = false;
	boolean autoScreenName = false;
	boolean male = true;
	boolean sendEmail = false;
	int prefixId = 1;
	int birthdayMonth = 1;
	int birthdayDay = 1;
	int birthdayYear = 1970;
	String screenName = "Test_DLC" + creatorUserId;

	long[] groupIds = null;

	long[] organizationIds = null;

	long[] userGroupIds = null;

	String firstName = "Test";


	Locale locale = LocaleUtil.getDefault();
	Role rolePu = RoleLocalServiceUtil.getRole(companyId, RoleConstants.POWER_USER);
	long[] roleIds = null;
	
	 user = UserLocalServiceUtil.addUserWithWorkflow(0, companyId, autoPassword, password1,
		password2, autoScreenName, screenName, emailAddress, facebookId, openId, locale, firstName, "", lastName,
		prefixId, suffixId, male, birthdayMonth, birthdayDay, birthdayYear, jobTitle, groupIds, organizationIds,
		roleIds, userGroupIds, sendEmail, serviceContext);


	RoleLocalServiceUtil.addUserRole(user.getUserId(), rolePu.getRoleId());
	GroupLocalServiceUtil.addUserGroup(user.getUserId(), group);

	Indexer<User> userIndexer = IndexerRegistryUtil.nullSafeGetIndexer(User.class);
	userIndexer.reindex(user);
	
	return user;

    }

}
