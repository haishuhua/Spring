<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<jsp:include page="header.jsp" />

<body>
	<div class="container" style="text-align: center">
		<h2>New Game Form</h2>

		<form method="POST" action="/LineDefence/newGame">
			<table>
				<tr>
					<td><label for="TeamA1">TeamA1: </label></td>
					<td><form:select path="playersNames" name="TeamA1">
							<form:options items="${playersNames}" />
						</form:select></td>
				</tr>
				<tr>
					<td colspan="2"><br /></td>
				</tr>
				<tr>
					<td><label for="TeamA2">TeamA2: </label></td>
					<td><form:select path="playersNames" name="TeamA2">
							<form:options items="${playersNames}" />
						</form:select></td>
				</tr>
				<tr>
					<td colspan="2"><br /></td>
				</tr>
				<tr>
					<td><label for="TeamB1">TeamB1: </label></td>
					<td><form:select path="playersNames" name="TeamB1">
							<form:options items="${playersNames}" />
						</form:select></td>
				</tr>
				<tr>
					<td colspan="2"><br /></td>
				</tr>
				<tr>
					<td><label for="TeamB2">TeamB2: </label></td>
					<td><form:select path="playersNames" name="TeamB2">
							<form:options items="${playersNames}" />
						</form:select></td>
				</tr>
				<tr>
					<td colspan="2"><br /></td>
				</tr>
				<tr>
					<td><label for="PlayDate">PlayDate: </label></td>
					<td><input name="PlayDate" id="PlayDate" type="text" ></td>
				</tr>
				<tr>
					<td colspan="2"><br /></td>
				</tr>
				<tr>
					<td><label for=Score>Score: </label></td>
					<td><input name="Score" id="Score" /></td>
				</tr>
				<tr>
					<td colspan="2"><br /></td>
				</tr>


				<tr>
					<td colspan="3"><c:choose>
							<c:when test="${edit}">
								<input type="submit" value="Update" />
							</c:when>
							<c:otherwise>
								<input type="submit" value="Register" />
							</c:otherwise>
						</c:choose></td>
				</tr>
			</table>
		</form>
		<br /> <br /> Go back to <a href="<c:url value='/listGames' />">List
			of All Games</a>
	</div>
</body>
</html>