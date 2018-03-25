
<%@ include file="/init.jsp" %>

<%
	ResultRow row = (ResultRow) request.getAttribute(WebKeys.SEARCH_CONTAINER_RESULT_ROW);
	Faq faq = (Faq) row.getObject();
	long faqId = faq.getEntryId();
	String redirect = PortalUtil.getCurrentURL(renderRequest);
%>


<liferay-ui:icon-menu direction="left-side" markupView="lexicon">
<%-- 	<c:if test="<%= FaqPermission.contains(permissionChecker, faqId, ActionKeys.UPDATE) %>"> --%>
		<portlet:renderURL var="editFaqURL" >
			<portlet:param name="mvcRenderCommandName" value="/faq/edit" />
			<portlet:param name="redirect" value="<%= currentURL %>" />
			<portlet:param name="faqId" value="<%= String.valueOf(faqId) %>"/>
		</portlet:renderURL>
		
		<liferay-ui:icon
			message="edit"
			url="<%= editFaqURL %>"
		/>
<%--  	</c:if> --%>

<%-- 	<c:if test="<%= FaqPermission.contains(permissionChecker, faqId, ActionKeys.DELETE) %>"> --%>
		<portlet:actionURL var="deleteURL" name="/faq/delete_faq">
			<portlet:param name="faqId" value="<%= String.valueOf(faqId) %>" />
			<portlet:param name="redirect" value="<%= redirect %>"/>
		</portlet:actionURL>
		
		<liferay-ui:icon-delete url="<%= deleteURL.toString() %>" />
		
<%--  	</c:if> --%>
	
<%-- 	<c:if test="<%=  FaqPermission.contains(permissionChecker, faqId, ActionKeys.PERMISSIONS) %>"> --%>
		<liferay-security:permissionsURL
			modelResource="<%= Faq.class.getName() %>"
			modelResourceDescription="<%= faq.getQuestion() %>"
			resourcePrimKey="<%= String.valueOf(faqId) %>"
			windowState="<%= LiferayWindowState.POP_UP.toString() %>"
			var="permissionsURL" />

		<liferay-ui:icon
			message="permissions"
			method="get"
			url="<%= permissionsURL %>"
			useDialog="<%= true %>"
		/>
<%--  	</c:if> --%>
</liferay-ui:icon-menu>