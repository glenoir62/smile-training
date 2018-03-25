<%@page import="com.liferay.portal.kernel.util.Constants"%>
<%@ include file="/init.jsp" %>

<liferay-portlet:actionURL portletConfiguration="<%= true %>" var="configurationActionURL"/>
<liferay-portlet:renderURL portletConfiguration="<%= true %>"
var="configurationRenderURL" />
<aui:form action="<%= configurationActionURL %>" method="post" name="fm">
<aui:input name="<%= Constants.CMD %>" type="hidden" value="<%= Constants.UPDATE %>" />
<aui:fieldset>
<aui:input name="preferences--city--" type="text"
value="${advancedPortletInstanceConfiguration.city()}" />
</aui:fieldset>
<aui:button-row>
<aui:button cssClass="btn-lg" type="submit" />
</aui:button-row>
</aui:form>