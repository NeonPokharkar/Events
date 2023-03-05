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
	            <th>User</th>
	            <th>Event</th>
	            <th>Venue</th>
	            <th>Payment Mode</th>
	            <th>Date</th>
	            <th>Delete</th>
	        </tr>
	    <c:forEach items="${bookingsList}" var="item">
	        <tr>
	            <td>${item.user}</td>
	            <td>${item.event}</td>
	            <td>${item.venue}</td>
	            <td>${item.paymentmode}</td>
	            <td>${item.date}</td>
	            <td>
	                <form action="deleteBooking" method="post">
	                    <input type="hidden" name="id" value="${item.id}">
	                    <input type="hidden" name="from" value="admin">
	                    <input type="submit" value="Delete">
	                </form>
	            </td>
	        </tr>
	    </c:forEach>
	</table>
	<form action="createEvent" method="post">
		Name <input type="text" name="name">
		Description <input type="text" name="description">
		Price <input type="text" name="price">
		<input type="submit" value="Create Event">
	</form>
	Events
	<table>
	        <tr>
	            <th>Event</th>
	            <th>Description</th>
	            <th>Price</th>
	            <th>Delete</th>
	        </tr>
	    <c:forEach items="${eventList}" var="item">
	        <tr>
	            <td>${item.name}</td>
	            <td>${item.description}</td>
	            <td>${item.price}</td>
	            <td>
	                <form action="deleteEvent" method="post">
	                    <input type="hidden" name="id" value="${item.id}">
	                    <input type="submit" value="Delete">
	                </form>
	            </td>
	        </tr>
	    </c:forEach>
	</table>
	<form action="createVenue" method="post">
		Name <input type="text" name="name">
		Address <input type="text" name="address">
		<input type="submit" value="Create Venue">
	</form>
	Venues
	<table>
	        <tr>
	            <th>Venue</th>
	            <th>Address</th>
	            <th>Delete</th>
	        </tr>
	    <c:forEach items="${venueList}" var="item">
	        <tr>
	            <td>${item.name}</td>
	            <td>${item.address}</td>
	            <td>
	                <form action="deleteVenue" method="post">
	                    <input type="hidden" name="id" value="${item.id}">
	                    <input type="submit" value="Delete">
	                </form>
	            </td>
	        </tr>
	    </c:forEach>
	</table>
	<form action="dashboard" method="post">
		<input type="submit" value="Log out">
	</form>
</body>
</html>