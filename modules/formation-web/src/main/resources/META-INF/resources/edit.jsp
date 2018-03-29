<%@ include file="init.jsp" %>

<%-- show success message from Language Properties -> fr.smile.training.formation.web.edit.success --%>
<liferay-ui:success key="editValue-success" message="fr.smile.training.formation.web.edit.success"/>

<liferay-portlet:actionURL var="actionURL" />
<aui:form action="<%= actionURL %>" method="post" name="_fm">
	<aui:input name="editValue" type="text" value="${EDIT_VALUE}" label="fr.smile.training.formation.web.edit.label"/>
	<aui:button name="Save" type="submit"/>
</aui:form>