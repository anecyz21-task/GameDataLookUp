<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>Character Statistics</title>
</head>
<body>
  <h1>${messages.title}</h1>

  <table border="1">
    <tr><th>Statistic</th><th>Value</th></tr>
    <c:forEach var="s" items="${statistics}">
      <tr>
        <td>${s.statisticName}</td>
        <td>${s.value}</td>
      </tr>
    </c:forEach>
  </table>

  <br/>
  <a href="javascript:history.back()">Back To Character</a>
</body>
</html>
