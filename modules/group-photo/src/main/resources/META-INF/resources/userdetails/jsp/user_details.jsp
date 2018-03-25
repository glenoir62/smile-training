<%@ include file="/init.jsp" %>

<div class="container">
	<div class="row column-1">
		<div class="col-xs-offset-1 col-xs-4">
			<div class="section entry-card lfr-asset-item">
			<%@ include file="/userdetails/jsp/user/details.jspf" %>
			</div>
			<div class="section">
			<%@ include file="/userdetails/jsp/user/phone_numbers.jspf" %>
			</div>
			<div class="section">
			<%@ include file="/userdetails/jsp/user/instant_messenger.jspf" %>
			</div>
			<div class="section">
			<%@ include file="/userdetails/jsp/user/social_network.jspf" %>
			</div>
			<div class="section">
			<%@ include file="/userdetails/jsp/user/sms.jspf" %>
			</div>
			<div class="section">
			<%@ include file="/userdetails/jsp/user/comments.jspf" %>
			</div>
		</div>
		<div class="col-xs-6">
			<div class="section">
			<%@ include file="/userdetails/jsp/user/addresses.jspf" %>
			</div>
			<div class="section">
			<%@ include file="/userdetails/jsp/user/common/additional_email_addresses.jspf" %>
			</div>
			<div class="section">
			<%@ include file="/userdetails/jsp/user/common/websites.jspf" %>
			</div>
		</div>
	</div>
</div>