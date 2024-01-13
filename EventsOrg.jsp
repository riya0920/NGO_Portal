<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%String org_uname = (String)session.getAttribute("org_uname");
	out.println(org_uname);
	out.println();%>
	<a href="EventPost.jsp"><input type="button" value="Post an event"><br><br></a>
	<a href="EventDelete.jsp"><input type="button" value="Delete an event"><br><br></a>
	<a href="CurrentEvent.jsp">Show current event!</a>
</body>
</html>