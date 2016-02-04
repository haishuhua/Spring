<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<jsp:include page="header.jsp"/>
<body>
	<div class="container">
		<center>

			<h1>List of All Games</h1>
			<h2>Line Defense Wins: ${win}</h2>
		<img src="<c:url value="/resources/core/images/foosball2.jpg"/>"/>
		<br/><br/><br/>
		</center>
		<table class="table">
			<tr>
				<td>ID</td>
				<td>Play Date</td>
				<td>Team A1</td>
				<td>Team A2</td>
				<td>Team B1</td>
				<td>Team B2</td>
				<td>Score</td>
			</tr>
			<c:forEach items="${games}" var="game">
				<tr>
					<td>${game.id}</td>
					<td>${game.getPlayDate()}</td>
					<td>${game.getTeamA1()}</td>
					<td>${game.getTeamA2()}</td>
					<td>${game.getTeamB1()}</td>
					<td>${game.getTeamB2()}</td>
					<td>${game.getScore()}</td>
				</tr>
			</c:forEach>

		</table>
		<br /> <a href="<c:url value='/newGame' />">Add New Game</a>
	</div>
	<spring:url value="/resources/core/css/hello.js" var="coreJs" />
	<spring:url value="/resources/core/css/bootstrap.min.js"
		var="bootstrapJs" />

	<script src="${coreJs}"></script>
	<script src="${bootstrapJs}"></script>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
</body>
</html>