<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>Character List</title>
</head>
<body>
  <h1>${messages.title}</h1>

  <table border="1">
    <tr>
      <%--<th>CharacterId</th>--%>
      <th>Email</th>
      <th>First Name</th>
      <th>Last Name</th>
      <th>Clan Name</th>
      <th>Statistics</th>
    </tr>

    <c:forEach var="c" items="${characters}">
      <tr>
        <%--<td>${c.characterId}</td>--%>
        <td>${messages.email}</td>
        <td>${c.firstName}</td>
        <td>${c.lastName}</td>
        <td>${c.clanName}</td>
        <td>
          <a href="statistics?characterid=${c.characterId}"> Statistics</a>
        </td>
      </tr>
    </c:forEach>
  </table>

  <br/>
  <a href="javascript:history.back()">Back To Player</a>
</body>
</html>
