<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>FlyAway Travel</title>
</head>
<body>


<br/>
<a href="AdminLogin.jsp">Admin Login</a>
<br/>
<h3>Search for a flight</h3>
<form action="findFlights" method="post">
<table>
    <tr>
        <td><label>Date of Travel</label></td>
        <td><input type="date" name="date"></td>
    </tr>
    <tr>
        <td><label>Airline</label></td>
        <td>
            <select name="airline">
                <option></option>
                <c:forEach items="${airlines}" var="airline">
                    <option value="${airline.airlineName}">
                            ${airline.airlineName}
                    </option>
                </c:forEach>
            </select>
        </td>
    </tr>
    <tr>
        <td><label>Source</label></td>
        <td>
            <select name="source">
                <option></option>
                <c:forEach items="${airports}" var="airport">
                    <option value="${airport.airportName}">
                        ${airport.airportName}
                    </option>
                </c:forEach>
            </select>
        </td>
    </tr>
    <tr>
        <td><label>Destination</label></td>
        <td>

            <select name="destination">
                <option></option>
                <c:forEach items="${airports}" var="airport">
                    <option value="${airport.airportName}">
                            ${airport.airportName}
                    </option>
                </c:forEach>
            </select>
        </td>
    </tr>
</table>
<button type="submit">Find Flights</button>
</form>
</body>
</html>