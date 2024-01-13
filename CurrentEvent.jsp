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

       
            Statement statement = conn.createStatement() ;
            int x = 0;
            String eid = null;
            String username = (String)session.getAttribute("org_uname");
            ResultSet rs = statement.executeQuery("select PRESENT_EVENT FROM ORGANIZATIONS WHERE USERNAME='"+username+"'") ; 
            while(rs.next()){
            	eid = rs.getString(1);
            }
            out.println(eid);
            out.print(username);
            rs = statement.executeQuery("SELECT * FROM EVENTS WHERE EID = '"+eid+"';");
       	while(rs.next()){%>
            <TABLE border="1">
            <TR >
                <TD> <%= rs.getString(1) %></td><br>
                <TD> <%= rs.getString(2) %></TD><br>
                <TD> <%= rs.getString(3) %></TD><br>
                <TD> <%= rs.getInt(4) %></TD><br>
                <TD> <%= rs.getString(5) %></TD><br>
                <TD> <%= rs.getString(6) %></TD><br>
               <td> <% int phase = rs.getInt(7); 
                	if (phase == 1){
                		out.println("In Volunteer Gathering phase!!");
                	}
                	else if (phase == 2){
                		out.println("In field work!!");
                	}
                	else{
                		out.println("Certification phase!!");
                	}%></td>
             </TR>
              </TABLE>
              
            <%}%>
          <form action="PhaseEditServlet">
            
            To edit the phase manually insert the phase number in the box!! 
            <input type="text" name="phase_edit">
            <input type="hidden" name="eid" value="<%=eid%>">
            <input type="submit" value="Done!">
          </form>
</body>
</html>