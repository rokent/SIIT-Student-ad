<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib tagdir="/WEB-INF/tags/" prefix="btc"%>


<c:url var="url" value="/inbox" />


<div class="row">

	<div class="col-md-8 col-md-offset-2">

		<btc:pagination url="${url}" page="${page}" size="10" />

		<c:forEach var="message" items="${page.content}">



			<div class="panel panel-default">
				<div class="panel-heading">
					<div class="panel-title">
						<div>${message.messageTitle}</div>

					</div>
				</div>
				<div class="panel-body">
					<div>${message.messageBody}</div>

				</div>
			</div>

		</c:forEach>
	</div>
</div>
