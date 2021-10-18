<%--
  Created by IntelliJ IDEA.
  User: marcuma
  Date: 10/13/21
  Time: 10:09 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error</title>
</head>
<body>
<% String message = (String) request.getParameter("message"); %>
<h2 style="align-content: center"><%= message %></h2>
</body>
</html>
