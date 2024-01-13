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
<BODY>
        <% 
        Connection conn = null;
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/ngo", "root", "root");
        boolean flag = false;

       
            Statement statement = conn.createStatement() ;
         // Get the current session
            // Get a session attribute
            String username = (String) session.getAttribute("uname");
            String[] OrgIDs = {" "};
            ResultSet rs = statement.executeQuery("select FOLLOW from VOLUNTEERS WHERE USERNAME = '"+username+"'") ; 
            while(rs.next()){
            	
                String adc = rs.getString(1);
           		OrgIDs = adc.split("\\s");
            }
            int x = 0;
        %>
       <form action="FollowServlet">
       	<% out.print(username);%> 
       	<% ResultSet rs1 = statement.executeQuery("SELECT * FROM ORGANIZATIONS;"); %>
            <% while(rs1.next()){%>
            <TABLE border="1">
            <TR >
                <TD> <%= rs1.getString(2) %></td><br>
                <TD> <%= rs1.getString(4) %></TD><br>
                <TD> <% for (int i=0;i<(OrgIDs.length);++i){
                	if(rs1.getString(1).equals(OrgIDs[i])){%>
                		<a href="UnFollowServlet?orgid=<%= rs1.getString(1)%>"><input type="button" value="Unfollow!"></a>
                	<% flag = true;}
                	}
                	if (flag == false){%>
       			<a href="FollowServlet?orgid=<%= rs1.getString(1)%>"><input type="button" value="Follow!"></a></TD>
       			<%} 
       			flag = false;%>
                	
             </TR>
              </TABLE>
              
            <%}%>
        
       </form>
    </BODY>
</html>