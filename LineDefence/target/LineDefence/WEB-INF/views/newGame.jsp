<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<html>
 
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Game Registration Form</title>
 
<style>
 
    .error {
        color: #ff0000;
    }
</style>
 
</head>
 
<body>
 
    <h2>Registration Form</h2>
  
    <form:form method="POST" modelAttribute="game">
        <form:input type="hidden" path="id" id="id"/>
        <table>
            <tr>
                <td><label for="TeamA1">TeamA1: </label> </td>
                <td><form:input path="TeamA1" id="TeamA1"/></td>
                <td><form:errors path="TeamA1" cssClass="error"/></td>
            </tr>
            
            <tr>
                <td><label for="TeamA2">TeamA2: </label> </td>
                <td><form:input path="TeamA2" id="TeamA2"/></td>
                <td><form:errors path="TeamA2" cssClass="error"/></td>
            </tr>
            
            <tr>
                <td><label for="TeamB1">TeamB1: </label> </td>
                <td><form:input path="TeamB1" id="TeamB1"/></td>
                <td><form:errors path="TeamB1" cssClass="error"/></td>
            </tr>
            
            <tr>
                <td><label for="TeamB2">TeamB2: </label> </td>
                <td><form:input path="TeamB2" id="TeamB2"/></td>
                <td><form:errors path="TeamB2" cssClass="error"/></td>
            </tr>
         
            <tr>
                <td><label for="PlayDate">PlayDate: </label> </td>
                <td><form:input path="PlayDate" id="PlayDate"/></td>
                <td><form:errors path="PlayDate" cssClass="error"/></td>
            </tr>
     
            <tr>
                <td><label for=Score>Score: </label> </td>
                <td><form:input path="Score" id="Score"/></td>
                <td><form:errors path="Score" cssClass="error"/></td>
            </tr>
     
            
     
            <tr>
                <td colspan="3">
                    <c:choose>
                        <c:when test="${edit}">
                            <input type="submit" value="Update"/>
                        </c:when>
                        <c:otherwise>
                            <input type="submit" value="Register"/>
                        </c:otherwise>
                    </c:choose>
                </td>
            </tr>
        </table>
    </form:form>
    <br/>
    <br/>
    Go back to <a href="<c:url value='/listGames' />">List of All Games</a>
</body>
</html>