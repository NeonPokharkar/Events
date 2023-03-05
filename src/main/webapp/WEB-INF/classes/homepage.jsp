<%@ page language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<title>homepage</title>
</head>

<body>
	ANEvents
	:Users : ${users}
	<form action="login">
	    <input type="submit" value="Login">
	</form>
	<form action="signup">
        <input type="submit" value="SignUp">
	</form>
</body>
</html>
