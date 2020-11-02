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

	<h3>Add new ad</h3>
	<form:form commandName="ad">
		<div class="row">
			<div class="col-md-4 col-md-offset-4">
				<div class="form-group">
					<div>
						<form:textarea path="title" name="title" rows="1" cols="50"></form:textarea>
					</div>
					<div>
						<form:textarea path="adBody" name="adBody" rows="10" cols="50"></form:textarea>
					</div>
				</div>
				<input type="submit" name="submit" value="Add Status" />
			</div>
		</div>

	</form:form>
	<div class="row">
		<div class="col-md-8 col-md-offset-2">
			<div class="panel panel-default">

				<div class="panel-heading">
					<div class="panel-title">
						Last Ad added on
						<fmt:formatDate pattern="EEEE d MMMM y 'at' HH:mm:s"
							value="${latestAd.addDate.getTime()}" />
					</div>
				</div>
				<div class="panel-body">${latestAd.adBody}</div>
			</div>
		</div>
	</div>
</body>
</html>