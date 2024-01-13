<%@page import="java.io.FileOutputStream"%>
<%@page import="java.io.InputStream"%>
<%@ page import="java.sql.*" 
import = "java.io.ByteArrayOutputStream"
import = "java.io.IOException"
import = "java.io.OutputStream"
import ="java.util.Base64"
%>
<% Class.forName("com.mysql.cj.jdbc.Driver"); %>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

 <% 
        Connection conn = null;
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ngo", "root", "root");
       String username = (String)session.getAttribute("uname");

      Statement statement = conn.createStatement() ;
      String min_hours = (String)request.getAttribute("min_hrs");
	  String max_hours = (String)request.getAttribute("max_hrs");
	  int max_hrs = Integer.parseInt(max_hours);
	  int min_hrs = Integer.parseInt(min_hours);
      ResultSet rs = statement.executeQuery("SELECT * from EVENTS WHERE EVENT_HOURS BETWEEN "+ min_hrs + " AND " + max_hrs+";") ; %>
	  <% while(rs.next()){%>
            <TABLE border="1">
            <TR >
                <TD> <%= rs.getString(1) %></td><br>
                <TD> <%= rs.getString(2) %></TD><br>
                <TD> <%= rs.getString(3) %></TD><br>
                <TD> <%= rs.getInt(4) %></TD><br>
                <TD> <%= rs.getString(5) %></TD><br>
                <TD> <%= rs.getString(6) %></TD><br>
                <TD><a href="EventsApplyServlet?eid=<%= rs.getString(1) %>"><input type="button" value="Apply"></a></TD>
             </TR>
              </TABLE>
              
            <%}%>
</body>
</html>