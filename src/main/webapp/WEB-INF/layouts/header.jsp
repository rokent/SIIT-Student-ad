<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<html>
<body>
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#myNavbar">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<!---<a class="navbar-brand" href="#"><img src ="/img/logo.png" width ="100px" height = "30px"/></a> -->
				<a class="navbar-brand" href="#">Logo</a>
			</div>
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav">
					<li class="active"><a href="/">Home</a></li>
					<li><a href="/">About</a></li>
					<sec:authorize access="hasRole('ROLE_ADMIN')">
					<li><a href="/">Projects</a></li>
					</sec:authorize>
					<li><a href="/">Contact</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<sec:authorize access="!isAuthenticated()">
						<li><a href="/login"><span
								class="glyphicon glyphicon-log-in"></span> Login</a></li>
						<li><a href="/signup"><span
								class="glyphicon glyphicon-sign-up"></span> SignUp</a></li>
					</sec:authorize>
					<sec:authorize access="isAuthenticated()">
						<li><a href="/logout"><span
								class="glyphicon glyphicon-log-out"></span> Logout</a></li>
					</sec:authorize>

				</ul>
			</div>
		</div>
	</nav>
</body>
</html>
