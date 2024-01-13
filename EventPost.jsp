<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="EventPostServlet">
	Event ID: <input type="text" name="eid"><br><br>
	Event name: <input type="text" name="ename"><br><br>
	Event Vacancy: <input type="text" name="evac"><br><br>
	Hours: <input type="text" name="hours"><br><br>
	Location: <input type="text" name="loc"><br><br>
	Description: <input type="text" name="desc"><br><br>
	<input type="submit" value="Post">
	</form>
</body>
</html>