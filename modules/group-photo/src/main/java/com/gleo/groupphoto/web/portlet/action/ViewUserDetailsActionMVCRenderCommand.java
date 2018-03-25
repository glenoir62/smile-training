/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.gleo.groupphoto.web.portlet.action;

import com.gleo.groupphoto.web.constants.GroupPhotoPortletKeys;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.Address;
import com.liferay.portal.kernel.model.Company;
import com.liferay.portal.kernel.model.Contact;
import com.liferay.portal.kernel.model.EmailAddress;
import com.liferay.portal.kernel.model.Organization;
import com.liferay.portal.kernel.model.Phone;
import com.liferay.portal.kernel.model.ThemeConstants;
import com.liferay.portal.kernel.model.User;
import com.liferay.portal.kernel.model.Website;
import com.liferay.portal.kernel.parsers.bbcode.BBCodeTranslatorUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCRenderCommand;
import com.liferay.portal.kernel.service.AddressServiceUtil;
import com.liferay.portal.kernel.service.CompanyLocalServiceUtil;
import com.liferay.portal.kernel.service.EmailAddressServiceUtil;
import com.liferay.portal.kernel.service.OrganizationLocalServiceUtil;
import com.liferay.portal.kernel.service.PhoneServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.service.WebsiteServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.FastDateFormatFactoryUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.WebKeys;

import java.text.Format;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author guillaumelenoir
 *
 */
@Component(property = { "auth.token.ignore.mvc.action=true",
			"javax.portlet.name=" + GroupPhotoPortletKeys.USER_DETAILS,
			"mvc.command.name=/",
			"portlet.add.default.resource.check.whitelist.mvc.action=true" 
			})
public class ViewUserDetailsActionMVCRenderCommand implements MVCRenderCommand {
 
    protected static Log LOGGER = LogFactoryUtil.getLog(ViewUserDetailsActionMVCRenderCommand.class);

    public static final String EMOTICONS = "/emoticons";

    @Override
    public String render(RenderRequest renderRequest, RenderResponse renderResponse) {

	long userId = ParamUtil.getLong(renderRequest, "userId");
	ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);

	String organizationsHTML = StringPool.BLANK;
	Contact contact = null;
	List<Organization> organizations = null;
	User user = null;
	Company company = null;
	Locale locale = themeDisplay.getLocale();

	String birthday = null;
	String jobTitle = null;
	String gender = null;
	String comments = null;

	// Get User
	if (userId > 0) {

	    try {
		user = UserLocalServiceUtil.getUser(userId);
		company = CompanyLocalServiceUtil.getCompany(user.getCompanyId());

	    } catch (PortalException e) {
		LOGGER.error(e);
	    }

	    if (user != null) {
		// Get Contact
		try {
		    contact = user.getContact();

		} catch (PortalException e) {
		    LOGGER.error(e);
		}

		// Get Organizations
		organizations = OrganizationLocalServiceUtil.getUserOrganizations(user.getUserId());
		StringBundler organizationsHTMLBundler = new StringBundler(organizations.size() * 2);

		if (!organizations.isEmpty()) {
		    organizationsHTMLBundler.append(organizations.get(0).getName());
		}

		for (int i = 1; i < organizations.size(); i++) {
		    organizationsHTMLBundler.append("<br/>");
		    organizationsHTMLBundler.append(organizations.get(i).getName());
		}
		organizationsHTML = organizationsHTMLBundler.toString();

		// Fields
		setFields(renderRequest, contact, user, company, locale, birthday, gender, jobTitle);

		// Contact
		String className = Contact.class.getName();
		long classPK = contact.getContactId();

		List<Address> personalAddresses = Collections.emptyList();
		List<Address> organizationAddresses = new ArrayList<Address>();
		List<EmailAddress> emailAddresses = Collections.emptyList();
		List<Website> websites = Collections.emptyList();
		List<Phone> personalPhones = Collections.emptyList();
		List<Phone> organizationPhones = new ArrayList<Phone>();

		if (classPK > 0) {
		    try {
			personalAddresses = AddressServiceUtil.getAddresses(className, classPK);
		    } catch (PortalException pe) {
			LOGGER.error(pe);
		    }

		    try {
			emailAddresses = EmailAddressServiceUtil.getEmailAddresses(className, classPK);
		    } catch (PortalException pe) {
			LOGGER.error(pe);
		    }

		    try {
			websites = WebsiteServiceUtil.getWebsites(className, classPK);
		    } catch (PortalException pe) {
			LOGGER.error(pe);
		    }
		    try {
			personalPhones = PhoneServiceUtil.getPhones(className, classPK);
		    } catch (PortalException pe) {
			LOGGER.error(pe);
		    }

		}

		for (int i = 0; i < organizations.size(); i++) {
		    try {
			organizationAddresses.addAll(AddressServiceUtil.getAddresses(Organization.class.getName(),
				organizations.get(i).getOrganizationId()));
		    } catch (Exception e) {
		    }
		}

		for (int i = 0; i < organizations.size(); i++) {
		    try {
			organizationPhones.addAll(PhoneServiceUtil.getPhones(Organization.class.getName(),
				organizations.get(i).getOrganizationId()));
		    } catch (Exception e) {
		    }
		}

		// Comments
		comments = user.getComments();
		
		if (comments != null && !comments.trim().equals(StringPool.BLANK)) {
		    comments = StringUtil.replace(BBCodeTranslatorUtil.getHTML(user.getComments()),
			    ThemeConstants.TOKEN_THEME_IMAGES_PATH + EMOTICONS,
			    themeDisplay.getPathThemeImages() + EMOTICONS);
		}

		renderRequest.setAttribute("organizationAddresses", organizationAddresses);
		renderRequest.setAttribute("personalAddresses", personalAddresses);
		renderRequest.setAttribute("emailAddresses", emailAddresses);
		renderRequest.setAttribute("organizationAddresses", organizationAddresses);
		renderRequest.setAttribute("websites", websites);
		renderRequest.setAttribute("personalPhones", personalPhones);
		renderRequest.setAttribute("organizationPhones", organizationPhones);

	    }
	}

	if (LOGGER.isDebugEnabled()) {
	    LOGGER.debug("userId =" + userId);
	    LOGGER.debug("birthday =" + birthday);
	    LOGGER.debug("gender =" + gender);
	    LOGGER.debug("jobTitle =" + jobTitle);
	    LOGGER.debug("comments =" + comments);
	}

	renderRequest.setAttribute("organizations", organizations);
	renderRequest.setAttribute("organizationsHTML", organizationsHTML);
	renderRequest.setAttribute("user2", user);
	renderRequest.setAttribute("contact", contact);
	renderRequest.setAttribute("languageUtil", LanguageUtil.getLanguage());
	renderRequest.setAttribute("locale", locale);
	renderRequest.setAttribute("comments", comments);
	renderRequest.setAttribute("htmlUtil", HtmlUtil.getHtml());

	return "/userdetails/jsp/user_details.jsp";
    }

    /**
     * Set fields
     * 
     * @param renderRequest
     * @param contact
     * @param user
     * @param company
     * @param locale
     * @param birthday
     * @param gender
     * @param jobTitle
     */
    private void setFields(RenderRequest renderRequest, Contact contact, User user, Company company, Locale locale,
	    String birthday, String gender, String jobTitle) {

	boolean isFieldEnableContactBirthday = PrefsPropsUtil.getBoolean(company.getCompanyId(),
		PropsKeys.FIELD_ENABLE_COM_LIFERAY_PORTAL_MODEL_CONTACT_BIRTHDAY);

	if (isFieldEnableContactBirthday) {
	    Format dateFormatDate = FastDateFormatFactoryUtil.getDate(locale);
	    try {
		birthday = dateFormatDate.format(user.getBirthday());
	    } catch (PortalException e) {
		LOGGER.error(e);
	    }
	}

	jobTitle = HtmlUtil.escape(contact.getJobTitle());

	boolean isFieldEnableContactMale = PrefsPropsUtil.getBoolean(company.getCompanyId(),
		PropsKeys.FIELD_ENABLE_COM_LIFERAY_PORTAL_MODEL_CONTACT_MALE);

	if (isFieldEnableContactMale) {
	    try {
		gender = LanguageUtil.get(locale, user.isMale() ? "male" : "female");
	    } catch (PortalException pe) {
		LOGGER.error(pe);
	    }
	}

	renderRequest.setAttribute("birthday", birthday);
	renderRequest.setAttribute("jobTitle", jobTitle);
	renderRequest.setAttribute("gender", gender);
    }

}