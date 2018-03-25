
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://liferay.com/tld/ddm" prefix="liferay-ddm" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/frontend" prefix="liferay-frontend" %>

<%@page import="com.gleo.groupphoto.web.search.UserDisplayTerms"%>

<%@page import="com.liferay.portal.kernel.util.PortletKeys"%>
<%@page import="com.liferay.document.library.kernel.util.DLUtil"%>
<%@page import="com.liferay.document.library.kernel.model.DLFileShortcut"%>
<%@page import="com.liferay.portal.kernel.util.PortalUtil"%>

<%@page import="javax.portlet.WindowState"%>

<liferay-theme:defineObjects />
<portlet:defineObjects />