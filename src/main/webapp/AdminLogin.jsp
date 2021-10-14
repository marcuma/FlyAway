<%--
  Created by IntelliJ IDEA.
  User: marcuma
  Date: 10/5/21
  Time: 2:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Admin Login Page</title>
</head>
<body>
<div style="text-align: center"><h2>Admin Login</h2></div>
<form type="submit" action="LoginServlet" method="post">
    <table>
        <tr>
            <td><label for="userName">UserName:</label></td>
            <td><input id="userName" type="text" name="userName"/></td>
        </tr>
        <tr>
            <td><label for="password">Password: </label></td>
            <td><input id="password" type="password" name="password"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="Log In"/></td>
        </tr>
    </table>
</form>
</body>
</html>
