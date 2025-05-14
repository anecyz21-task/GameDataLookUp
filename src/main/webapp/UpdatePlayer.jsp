<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Update player information</title>
</head>
<body>
    <h1>Update player information</h1>
    <form action="playerupdate" method="post">
        <p>
            <label for="email">Email</label>
            <input id="email" name="email" value="${fn:escapeXml(player.email)}" readonly>
        </p>
        <p>
            <label for="firstname">New firstname</label>
            <input id="firstname" name="firstname" value="${fn:escapeXml(player.firstName)}">
        </p>
        <p>
            <label for="lastname">New lastname</label>
            <input id="lastname" name="lastname" value="${fn:escapeXml(player.lastName)}">
        </p>
        <p>
            <input type="submit" value="Update">
        </p>
    </form>
    <br/><br/>
    <p>
        <span id="successMessage"><b>${messages.success}</b></span>
    </p>
    <br/>
    <a href="findplayer">Return to find player</a>
</body>
</html>