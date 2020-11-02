<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib tagdir="/WEB-INF/tags/" prefix="btc"%>


<c:url var="url" value="/viewads" />


<div class="row">

	<div class="col-md-8 col-md-offset-2">

		<btc:pagination url="${url}" page="${page}" size="10" />

		<c:forEach var="ad" items="${page.content}">

			<c:url var="newmessage" value="/newmessage?id=${ad.id }" />

			<div class="panel panel-default">
				<div class="panel-heading">
					<div class="panel-title">
						<div>${ad.title}</div>

					</div>
				</div>
				<div class="panel-body">
					<div>${ad.adBody}</div>
					<div class="edit-links pull-right">
						<a onclick="return confirm('Do you wish to send a message to ad owner?');"
							href="${newmessage}">Send Message</a>
					</div>
				</div>
			</div>

		</c:forEach>
	</div>
</div>