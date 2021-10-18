<%--
  Created by IntelliJ IDEA.
  User: marcuma
  Date: 10/18/21
  Time: 2:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
  <title>Airports</title>
</head>
<body>
<c:forEach items="${airports}" var="airport">
  <ul>
    <li>${airport.airportName}</li>
  </ul>
</c:forEach>
<a href="./AdminHome.jsp">Admin Home</a>
</body>
</html>
