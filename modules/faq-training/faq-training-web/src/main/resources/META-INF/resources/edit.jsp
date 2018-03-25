<%@ include file="/init.jsp" %>

<liferay-ui:header
	backURL='${redirect}'
	title='${title}'
/>

<portlet:actionURL name="/faq/add_faq" var="addFaqURL" />
<portlet:actionURL name="/faq/edit_faq" var="editTypeURL" />

<portlet:renderURL var="redirect"/>

<aui:model-context bean="${faq}" model="<%= Faq.class %>" />

<aui:form action="${faq != null ? editTypeURL :addFaqURL}" cssClass="container-fluid-1280" method="POST" name="fm">
	<aui:input type="hidden" value="${faq.entryId}" name="faqId"/>
	
	<div class="lfr-form-content">
		<aui:fieldset-group markupView="lexicon">
			<aui:input name="question">
				<aui:validator name="required"/>
			</aui:input>
			<aui:input name="answer">
				<aui:validator name="required"/>
			</aui:input>
		</aui:fieldset-group>
	</div>
		<aui:button-row>
			<aui:button cssClass="btn-lg" type="submit" />
	
			<aui:button cssClass="btn-lg" type="cancel"  onClick="${redirect}" />
		</aui:button-row>
</aui:form>
