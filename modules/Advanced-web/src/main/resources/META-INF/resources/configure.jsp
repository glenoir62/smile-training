<%@ include file="init.jsp"%>

<liferay-portlet:actionURL portletConfiguration="<%=true%>"
	var="configurationActionURL" />
	
<liferay-ui:error key="city-errors" message="fr.smile.training.web.advanced.configuration.error"/>

<aui:form action="${configurationActionURL}" method="post" name="fm">
	<aui:input name="<%=Constants.CMD%>" type="hidden"
		value="<%=Constants.UPDATE%>" />
	<aui:fieldset>
		<aui:input name="preferences--city--" type="text" value="${advancedPortletInstanceConfiguration.city()}" >
			<aui:validator name="required"/>
			<aui:validator name="alphanum"/>
		</aui:input>
	</aui:fieldset>
	<aui:button-row>
		<aui:button cssClass="btn-lg" type="submit" />
	</aui:button-row>
</aui:form>