<%--
  Created by IntelliJ IDEA.
  User: marcuma
  Date: 10/18/21
  Time: 11:09 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Checkout</title>
</head>
<style>
  table, th, td {
    border: 1px solid gray;
  }
</style>
<body>
<h3>You are purchasing the following flights</h3>
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
  <td>${flight.source}</td>
  <td>${flight.destination}</td>
  <td>${flight.airline}</td>
  <td><fmt:formatNumber value = "${flight.price}" type = "currency"/></td>
  </tr>
</c:forEach>
</table>
<h3>Please enter your details</h3>
<form action="pay" method="post">
<table>
  <tr>
    <td>First Name:<td>
    <td><input type="text" name="firstName" value=""/></td>
  </tr>
  <tr>
    <td>Last Name:<td>
    <td><input type="text" name="lastName" value=""/></td>
  </tr>
  <tr>
    <td>Address:<td>
    <td><input type="text" name="address" value=""/></td>
  </tr>
  <tr>
    <td>City:<td>
    <td><input type="text" name="city" value=""/></td>
  </tr>
  <tr>
    <td>State:<td>
    <td><input type="text" name="state" value=""/></td>
  </tr>
  <tr>
    <td>Zip Code:<td>
    <td><input type="text" name="zip" value=""/></td>
  </tr>
  <tr>
    <td>Credit Card Number:<td>
    <td><input type="text" name="cc" value=""/></td>
  </tr>
</table>
  <input type="submit" name="Pay Now"/>
</form>
</body>
</html>
