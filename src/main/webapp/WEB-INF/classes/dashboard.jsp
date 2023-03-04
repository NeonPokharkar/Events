<%@ page language="java"%>
<html>
<head>
<meta charset="utf-8">
<title>homepage</title>
</head>

<body>
    Welcome ${name}
	<form action="booking">
		<input type="submit" value="Book an event">
	</form>
	<form action="dashboard" method="post">
		<input type="submit" value="Log out">
	</form>
</body>
</html>