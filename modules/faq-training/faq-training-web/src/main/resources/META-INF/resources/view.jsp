<%@page import="com.liferay.portal.kernel.language.LanguageUtil"%>
<%@ include file="/init.jsp" %>

<portlet:renderURL var="addEntryURL" >
		<portlet:param name="mvcRenderCommandName" value="/faq/edit" />
		<portlet:param name="redirect" value="<%= currentURL %>" />
</portlet:renderURL>
		
<aui:nav-bar cssClass="collapse-basic-search" markupView="lexicon">
	<aui:nav cssClass="navbar-nav">
		<aui:nav-item label="FAQ" selected="<%= true %>" />
	</aui:nav>
	<aui:nav cssClass="navbar-nav">
		<aui:nav-item href="${addEntryURL}" iconCssClass="icon-plus" label="add-faq" id="faq-button-add" />
	</aui:nav>
</aui:nav-bar>

<liferay-ui:error key="faq-answer-required" message="fr.smile.training.faq.message.answer.required"/>
<liferay-ui:error key="faq-question-required" message="fr.smile.training.faq.message.question.required"/>
<liferay-ui:success key="faq-deleted" message="fr.smile.training.faq.message.deleted"/>
<liferay-ui:success key="faq-updated" message="fr.smile.training.faq.message.updated"/>
<liferay-ui:success key="faq-added" message="fr.smile.training.faq.message.added"/>

<liferay-ui:search-container searchContainer="${faqSearchContainer}">
	<liferay-ui:search-container-results results="${faqSearchContainer.results}"/>
	
	<liferay-ui:search-container-row
		className="fr.smile.training.model.Faq"
		keyProperty="entryId"
		modelVar="faq" escapedModel="true" 
	>

		<liferay-ui:search-container-column-text
			name="groupId"
			property="groupId"
		/>
		
		<liferay-ui:search-container-column-text
			name="companyId"
			property="companyId"
		/>
		
		<liferay-ui:search-container-column-text
			name="question"
			property="question"
		/>
		
				
		<liferay-ui:search-container-column-text
			name="answer"
			property="answer"
		/>
		
		<liferay-ui:search-container-column-jsp
				align="right"
				name="actions"
				path="/action.jsp"
		/>
		
	</liferay-ui:search-container-row>

	<liferay-ui:search-iterator paginate="true" markupView="lexicon" searchContainer="${faqSearchContainer}"/>


</liferay-ui:search-container>