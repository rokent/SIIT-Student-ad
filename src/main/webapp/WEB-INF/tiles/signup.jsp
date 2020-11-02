<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt"%>

<html>
<body>
	<h3>Sigup</h3>
	<form:form commandName="siteUser">
		<table>
			<tr>
				<form:errors path="firstName" />
				<td><form:label path="firstName">First Name</form:label></td>
				<td><form:input path="firstName" /></td>
			</tr>
			<tr>
				<form:errors path="lastName" />
				<td><form:label path="lastName">Last Name</form:label></td>
				<td><form:input path="lastName" /></td>
			</tr>
			<tr>
				<form:errors path="email" />
				<td><form:label path="email">Email</form:label></td>
				<td><form:input path="email" /></td>
			</tr>
			<tr>
				<form:errors path="password" />
				<td><form:label path="password">Password</form:label></td>
				<td><form:input path="password" /></td>
			</tr>
			<tr>
				<form:errors path="gender" />
				<td><label>Gender : </label></td>
				<td><form:form action="" method="post">
					M <input type="radio" name="gender" value="MALE">
					F <input type="radio" name="gender" value="FEMALE">
				</form:form></td>
			</tr>

			<form:form method="post" action="">


				<td>Please enter your birthday:</td>
				<td><select name="month">
						<option value="Jan">January</option>
						<option value="Feb">February</option>
						<option value="Mar">March</option>
						<option value="Apr">April</option>
						<option value="May">May</option>
						<option value="Jun">June</option>
						<option value="Jul">July</option>
						<option value="Aug">August</option>
						<option value="Sep">September</option>
						<option value="Oct">October</option>
						<option value="Nov">November</option>
						<option value="Dec">December</option>
				</select> <select name="day">
						<c:forEach begin="1" end="31" var="day">
							<option><c:out value="${day}" /></option>
						</c:forEach>
				</select> <select name="year">
						<c:forEach begin="1930" end="2003" var="year">
							<option><c:out value="${year}" /></option>
						</c:forEach>
				</select></td>
			</form:form>
			<tr>
				<td><input type="submit" value="Submit" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>