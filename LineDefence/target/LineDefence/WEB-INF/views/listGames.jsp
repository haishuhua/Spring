<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>University Enrollments</title>
 
    <style>
        tr:first-child{
            font-weight: bold;
            background-color: #C6C9C4;
        }
    </style>
 
</head>
 
 
<body>
    <h2>List of Games</h2>  
    <table>
        <tr>
            <td>ID</td><td>Play Date</td><td>Team A1</td><td>Team A2</td><td>Team B1</td><td>Team B2</td><td>Score</td>
        </tr>
        <c:forEach items="${games}" var="game">
            <tr>
             <td>${game.id} ${game.TeamA1}</td>
            <td>${game.getPlayDate()}</td>
            <td>${game.getTeamA1()}</td>
            <td>${game.getTeamA2()}</td>
            <td>${game.getTeamB1()}</td>
            <td>${game.getTeamB2()}</td>
            <td>${game.getScore()}</td>
            </tr>
        </c:forEach>
       
    </table>
    <br/>
    <a href="<c:url value='/newGame' />">Add New Game</a>
</body>
</html>