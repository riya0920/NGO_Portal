<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<H1>This is the login volunteers page!!</H1>
	<form action="LoginVolServlet">
		UserName: <input type="text" name="uname"><br><br>
		Password: <input type="text" name="pass"><br><br>
				  <input type="submit" value="Login!"><br><br>
		<a href="SignupVol.jsp"><input type="button" value="Signup for free!!"></a>
	</form>
</body>
</html>