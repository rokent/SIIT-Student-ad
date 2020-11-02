<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<style>
.col-md-8 {
	padding-top: 2cm;
}
</style>
<html>
<head>
</head>
<body>

	<h3>Message</h3>
	<form:form commandName="message">

		<form:input type="hidden" path="sender" />
		<form:input type="hidden" path="reciver" />
		<form:input type="hidden" path="messageDate" />
		

		<div class="row">
			<div class="col-md-4 col-md-offset-4">
				<div class="form-group">
					<div>
						<form:textarea path="messageTitle" name="messageTitle" rows="1"
							cols="50"></form:textarea>
					</div>
					<div>
						<form:textarea path="messageBody" name="messageBody" rows="10"
							cols="50"></form:textarea>
					</div>
				</div>
				<input type="submit" name="submit" value="Send Message" />
			</div>
		</div>

	</form:form>

</body>
</html>