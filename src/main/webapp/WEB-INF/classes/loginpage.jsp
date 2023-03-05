<%@ page language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="utf-8">
<title>homepage</title>
</head>

<body>
	<form action="login" method="post">
		Name <input type="text" name="name">
		Password <input type="password" name="password">
		<input type="submit" value="Login">
	</form>
</body>
</html>
