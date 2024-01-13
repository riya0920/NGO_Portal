<%@page import="java.io.FileOutputStream"%>
<%@page import="java.io.InputStream"%>
<%@ page import="java.sql.*" 
import = "java.io.ByteArrayOutputStream"
import = "java.io.IOException"
import = "java.io.OutputStream"
import ="java.util.Base64"
%>

<% Class.forName("com.mysql.cj.jdbc.Driver"); %>

<HTML>
    <HEAD>
        <TITLE>Selecting Publishers From a Database</TITLE>
    </HEAD>

    <BODY>
        <% 
        Connection conn = null;
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ngo", "root", "root");

       
            Statement statement = conn.createStatement() ;
            ResultSet rs = statement.executeQuery("select * from EVENTS") ; 
            int x = 0;
            String username = (String)session.getAttribute("uname");
        %>
       	<% out.print(username);%> 
       	<a href="Follow.jsp"><input type="button" value="Follow!"></a>
   			<form action="FilteredHoursServlet">
   				<table>
   				<tr>
   					<td></td>
   					<td></td>
   					<td></td>
   					<td>Min hrs <input type="text" name="min_hrs"></td>
   				</tr>
   				<tr>
   					<td></td>
   					<td></td>
   					<td></td>
   					<td>Max hrs <input type="text" name="max_hrs"></td>
   				</tr>
   				<tr>
   					<td></td>
   					<td></td>
   					<td></td>
   					<td><input type="submit" value="Apply!!"></td>
   				</tr>
   			</table>
   			</form>
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
    </BODY>
    
</HTML>