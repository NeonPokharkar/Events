<%@ page language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="utf-8">
<title>homepage</title>
    <style>
      table,
      th,
      td {
        padding: 10px;
        border: 1px solid black;
        border-collapse: collapse;
      }
    </style>
</head>

<body>
    Welcome ${name}<br>
	Bookings
	<table>
	        <tr>
	            <th>Event</th>
	            <th>Venue</th>
	            <th>Payment Mode</th>
	            <th>Date</th>
	            <th>Delete</th>
	        </tr>
	    <c:forEach items="${bookingsList}" var="item">
	        <tr>
	            <td>${item.event}</td>
	            <td>${item.venue}</td>
	            <td>${item.paymentmode}</td>
	            <td>${item.date}</td>
	            <td>
	                <form action="deleteBooking" method="post">
	                    <input type="hidden" name="id" value="${item.id}">
	                    <input type="hidden" name="from" value="user">
	                    <input type="submit" value="Delete">
	                </form>
	            </td>
	        </tr>
	    </c:forEach>
	</table>
	<form action="booking">
		<input type="submit" value="Book an event">
	</form>
	<form action="dashboard" method="post">
		<input type="submit" value="Log out">
	</form>
</body>
</html>