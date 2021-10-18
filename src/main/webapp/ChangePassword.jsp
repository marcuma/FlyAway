<%--
  Created by IntelliJ IDEA.
  User: marcuma
  Date: 10/14/21
  Time: 7:29 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Change Password</title>
</head>
<body>
<h3 style="color: darkred">${errorMessage}</h3>
<form action="changePassword" method="post">
    <input type="hidden" name="id" value="${id}"
  <label for="newPassword">Enter new password</label>
  <input id="newPassword" type="password" name="newPassword"/>
    <button type="submit">Change Password</button>
</form>
</body>
</html>
