<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Find a Player</title>
</head>
<body>
<form action="findplayer" method="post">
    <h1>Search for a Player by FirstName</h1>
    <p>
        <label for="firstname">FirstName</label>
        <input id="firstname" name="firstname" value="${fn:escapeXml(param.firstname)}">
    </p >
    <p>
        <input type="submit" value="Search">
        <br/><br/><br/>
        <span id="responseMessage"><b><c:out value="${messages['response']}" /></b></span>
    </p >
</form>

<h1>Matching Player</h1>
<table border="1">
    <tr>
        <th>Email</th>
        <th>FirstName</th>
        <th>LastName</th>
        <th>Character</th>
        <th>Update Player</th>
    </tr>
    <c:forEach items="${players}" var="player" >
        <tr>
            <td><c:out value="${player.getEmail()}" /></td>
            <td><c:out value="${player.getFirstName()}" /></td>
            <td><c:out value="${player.getLastName()}" /></td>

            <!-- Character column: a link to character detail page -->
            <td>
			<a href="characters?email=${player.email}">Character</a>
            </td>
            <!-- Update actions -->
            <td><a href="playerupdate?email=${player.email}">Update</a ></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>