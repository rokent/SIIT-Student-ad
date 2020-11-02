<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<style>
.col-md-4 {
	padding-top: 2cm;
}


</style>
<c:url var="loginUrl" value="/login" />

<div class="row">
	<div class="col-md-4 col-md-offset-4">

		
		<c:if test="${param.error != null }">
			<div class="login-error">Incorect user or password</div>
		</c:if>


		<div class="panel panel-default">

			<div class="panel-heading">
				<h3 class="panel-title">Please login</h3>
			</div>
			<div class="panel-body">
				<form method="post" action="${loginUrl}" class="login-form">

					<input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" />
					<fieldset>
						<div class="form-group">
							<input class="form-control" placeholder="Username"
								name="username" type="text">
						</div>
						<div class="form-group">
							<input class="form-control" placeholder="Password"
								name="password" type="password" value="">
						</div>

						<input class="btn btn-lg btn-success btn-block" type="submit"
							value="Login">
					</fieldset>
				</form>
			</div>
		</div>
	</div>
</div>
