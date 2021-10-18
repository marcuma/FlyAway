<%--
  Created by IntelliJ IDEA.
  User: marcuma
  Date: 10/18/21
  Time: 3:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Flights</title>
</head>
<style>
  table, th, td {
    border: 1px solid gray;
  }
</style>
<body>
<table>
  <tr>
    <th>Date</th>
    <th>From</th>
    <th>To</th>
    <th>Airline</th>
    <th>Price</th>
  </tr>
  <c:forEach items="${flights}" var="flight">
    <tr>
      <fmt:parseDate value="${flight.date}" type="date" pattern="yyyy-MM-dd" var="parsedDate"/>
      <td><fmt:formatDate pattern="MM/dd/yyyy" value="${parsedDate}"/></td>
      <td>${flight.source.airportName}</td>
      <td>${flight.destination.airportName}</td>
      <td>${flight.airline.airlineName}</td>
      <td><fmt:formatNumber value = "${flight.price}" type = "currency"/></td>
    </tr>
  </c:forEach>
</table>
<a href="./AdminHome.jsp">Admin Home</a>
</body>
</html>
