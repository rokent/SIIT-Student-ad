<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>


<style>
.sidenav {
	padding-top: 2cm;
}

.spacefromtop {
	padding-top: 2cm;
}
</style>

<div class="container-fluid text-center">

	<div class="row content">
		<div class="sidenav">
			<div class="btn-group-vertical" role="group" aria-label="...">
				<a class="btn btn-primary" href="/addad" role="button">Post	new ad.</a>
				<a href="/inbox" class="btn btn-default" role="button">Inbox</a> 
				<a href="/myads" class="btn btn-default" role="button">My posted ads.</a> 
				<a href="/viewads" class="btn btn-default" role="button">View all active ads.</a>
			</div>
		</div>
	</div>
</div>
