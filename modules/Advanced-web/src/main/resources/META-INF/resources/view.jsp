<%@ include file="/init.jsp"%>
<p>
	<portlet:renderURL var="nextViewURL">
		<portlet:param name="mvcRenderCommandName" value="Next" />
	</portlet:renderURL>
	<a href="${nextViewURL}">Click here for next page</a>
</p>

<h1>
city : ${advancedPortletInstanceConfiguration.city()}
</h1>