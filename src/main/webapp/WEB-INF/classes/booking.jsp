<%@ page language="java"%>
<html>
<head>
<meta charset="utf-8">
<title>homepage</title>
</head>

<body>
	<form>
		Events
        <select name="event">
            <c:forEach items="${events}" var="event">
                <option value=${event.id}>${event.name}</option>
            </c:forEach>
        </select>
        Venues
        <select name="event">
            <c:forEach items="${venues}" var="venue">
                <option value=${venue.id}>${venue.name}</option>
            </c:forEach>
        </select>
		Payment mode
		<select>
			<option value=0>Online</option>
			<option value=1>Offline</option>
		</select>
		Date
		<input type="date">
		<input type="submit">
	</form>
</body>
</html>