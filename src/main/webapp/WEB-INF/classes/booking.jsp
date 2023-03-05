<%@ page language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="utf-8">
<title>homepage</title>
</head>

<body>
	<form action="booking" method="post">
		Events
        <select name="event">
            <c:forEach items="${eventList}" var="items">
                <option value=${items.id}>${items.name}</option>
            </c:forEach>
        </select>
        Venues
        <select name="venue">
            <c:forEach items="${venueList}" var="items">
                <option value=${items.id}>${items.name}</option>
            </c:forEach>
        </select>
		Payment mode
		<select name="paymentmode">
			<option value=0>Online</option>
			<option value=1>Offline</option>
		</select>
		Date
		<input type="date" name="date">
		<input type="submit">
	</form>
</body>
</html>