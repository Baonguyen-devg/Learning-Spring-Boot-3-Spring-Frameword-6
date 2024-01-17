<%@include file = "common/navigation.jspf" %>
<%@include file = "common/header.jspf" %>
		
<div class = "container">
	<h1>Enter Todo Details</h1>
	
	<form:form method = "POST" modelAttribute = "todo">
	
		<fieldset class = "mb-3">
			<form:label path = "description">Description</form:label>
			<form:input type = "Text" path = "description" required = "required"/>
			<form:errors path = "description" cssClass = "text-warning"/>				
		</fieldset>
		
		<fieldset class = "mb-3">
			<form:label path = "targetDate">Target date</form:label>
			<form:input type = "Text" path = "targetDate" required = "required"/>
			<form:errors path = "targetDate" cssClass = "text-warning"/>				
		</fieldset>
		
		<form:input type = "Hidden" path = "done"/>
		<form:input type = "Hidden" path = "id"/>
		<input type = "submit" class = "btn btn-success">
	</form:form>
</div>

<%@include file = "common/footer.jspf" %>

<script type = "text/javascript">
	$('#targetDate').datepicker({
	    format: 'yyyy-mm-dd'
	});
</script>
