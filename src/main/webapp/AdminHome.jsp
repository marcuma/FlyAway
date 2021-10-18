<%--
  Created by IntelliJ IDEA.
  User: marcuma
  Date: 10/13/21
  Time: 10:44 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin Home</title>
</head>
<style>
    .ul {
        list-style-type: none;
        padding: 0;
        margin: 0;
    }
</style>
<body>
<% request.getSession().setAttribute("errorMessage", "");%>
<div style="text-align: center">
    <h3>Admin Options</h3>
    <ul class="ul">
        <li><a href="ChangePassword.jsp?${id}">Change Password</a></li>
        <li><a href="viewAirlines">View Airlines</a></li>
        <li><a href="viewAirports">View Airports</a></li>
        <li><a href="viewFlights">View Flights</a></li>
    </ul>
</div>
</body>
</html>
