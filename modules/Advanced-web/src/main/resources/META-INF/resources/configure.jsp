<%@ include file="init.jsp"%>

<liferay-portlet:actionURL portletConfiguration="<%=true%>"
	var="configurationActionURL" />
	
<liferay-ui:error key="city-errors" message="fr.smile.training.web.advanced.configuration.error"/>

<aui:form action="${configurationActionURL}" method="post" name="fm">
	<aui:input name="<%=Constants.CMD%>" type="hidden"
		value="<%=Constants.UPDATE%>" />
	<aui:fieldset>
		<aui:input name="city" type="text" value="${advancedPortletInstanceConfiguration.city()}" >
			<aui:validator name="required"/>
			<aui:validator name="number"/>
		</aui:input>
	</aui:fieldset>
	<aui:button-row>
		<aui:button cssClass="btn-lg" type="submit" />
	</aui:button-row>
</aui:form>


<form id="myForm">

  <div class="form-group">
    <label class="control-label" for="name">Name:</label>
    <div class="controls">
      <input name="name" id="name" class="form-control" type="text">
    </div>
  </div>

  <div class="form-group">
    <label class="control-label" for="picture">Picture:</label>
    <div class="controls">
      <input name="picture" id="picture" class="form-control" type="file">
    </div>
  </div>

  <div class="form-group">
    <label class="control-label" for="email">E-mail:</label>
    <div class="controls">
      <input name="email" id="email" class="form-control" type="text">
    </div>
  </div>

  <div class="form-group">
    <label class="control-label" for="emailConfirmation">Confirm e-mail:</label>
    <div class="controls">
      <input name="emailConfirmation" id="emailConfirmation" class="form-control" type="text">
    </div>
  </div>

  <div class="form-group">
    <label class="control-label" for="url">Site URL:</label>
    <div class="controls">
      <input name="url" id="url" class="form-control" type="text">
    </div>
  </div>

  <input class="btn btn-info" type="submit" value="Submit">
  <input class="btn btn-primary" type="reset" value="Reset">

</form>

<aui:script>
YUI().use(
		  'aui-form-validator',
		  function(Y) {
		    var rules = {
		      email: {
		        email: true,
		        required: true
		      },
		      emailConfirmation: {
		        email: true,
		        equalTo: '#email',
		        required: true
		      },
		      gender: {
		        required: true
		      },
		      name: {
		        rangeLength: [2, 50],
		        required: true
		      },
		      picture: {
		        acceptFiles: 'jpg, gif, png',
		        required: true
		      },
		      url: {
		        url: true
		      }
		    };

		    var fieldStrings = {
		      email: {
		        required: 'Type your email in this field.'
		      },
		      name: {
		        required: 'Please provide your name.'
		      }
		    };

		    new Y.FormValidator(
		      {
		        boundingBox: '#myForm',
		        fieldStrings: fieldStrings,
		        rules: rules,
		        showAllMessages: true
		      }
		    );
		  }
		);
</aui:script>