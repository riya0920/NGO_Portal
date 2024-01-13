package com.Connection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class VolunteerDao {

	public void addVolunteer(VolunteerBean vb) {
		String insertQ = "INSERT INTO VOLUNTEERS VALUES ('"+vb.getFname()+"','"+vb.getUname()+"','"+vb.getPass()+"','','','')";
		Connection conn = DbConnection.getDbConnection();
		Statement stmt = null;
		int rows = 0;
		if (conn != null)
		{
			try {
				stmt = conn.createStatement();
				rows = stmt.executeUpdate(insertQ);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Error caught");
			}
		
			
		}
		System.out.println("IN addOrg!");
		System.out.println(rows);
		}

	public void follow(String username,String Orgid) {
		String updateQ = "UPDATE VOLUNTEERS SET FOLLOW = CONCAT(FOLLOW,"+"' ','" +Orgid+"') WHERE USERNAME = " + "'" + username + "'";
		Connection conn = DbConnection.getDbConnection();
		Statement stmt = null;
		int rows = 0;
		if (conn != null)
		{
			try {
				stmt = conn.createStatement();
				rows = stmt.executeUpdate(updateQ);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Error caught");
			}
		
			
		}
		System.out.println("IN updateFollow!!");
		System.out.println(rows);
	}
	
	public void unfollow(String username,String orgid) {
		String updateQ = "SELECT FOLLOW FROM VOLUNTEERS WHERE USERNAME = " + "'" + username + "'";
		Connection conn = DbConnection.getDbConnection();
		Statement stmt = null;
		String orgs;
		StringBuilder neworgs = new StringBuilder(" ");
		String orgIDS[] = {" "};
		int rows = 0;
		if (conn != null)
		{
			try {
				stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(updateQ);
				while (rs.next()) {
	                
	                /*Retrieve one employee details 
	                and store it in employee object*/
	                orgs = rs.getString(1);
	                orgIDS = orgs.split("\\s");	  
	                System.out.println(rs.getString(1));
			}
				
				String newOrg[] = new String[orgIDS.length - 1];
				// Copy the elements of the original array into the new array, skipping the removed element
				for (int i = 0, k = 0; i < orgIDS.length; ++i) {
				    if (orgIDS[i].equals(orgid)) {
				        continue;
				    }
				    else
				    {
				    	newOrg[k] = orgIDS[i];
				    	++k;
				    }
				}
				for(int i=0;i<newOrg.length;++i) {
					neworgs = neworgs.append(" "+newOrg[i]);
					System.out.println(neworgs.toString());
				}
				for (int i = 0;i<newOrg.length;++i) {
					System.out.println(newOrg[i]);
				}
				
				String updateQ1 = "UPDATE VOLUNTEERS SET FOLLOW = '"+neworgs.toString()+"' WHERE USERNAME = " + "'" + username + "'";
				if (conn != null)
				{
					try {
						stmt = conn.createStatement();
						rows = stmt.executeUpdate(updateQ1);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						System.out.println("Error caught");
					}
				
					
				}
				System.out.println("IN unFollow!!");
				System.out.println(rows);
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("Error caught");
			}
		
			
		}
//		System.out.println("IN unFollow!!");
//		System.out.println(rows);
	}
	
	public boolean checkLogin(String uname, String pass) {

		String dispQ = "SELECT * FROM VOLUNTEERS WHERE USERNAME = "+ "'"+uname+"'" + "AND PASSWORD = "+"'"+pass+"'";
		Connection conn = DbConnection.getDbConnection();
		Statement stmt = null;
		String username = null, password = null;
//		List<Employeebean> list = new ArrayList<Employeebean>();
		int rows = 0;
		if (conn != null)
		{
			try {
				stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(dispQ);
				while (rs.next()) {
	                
	                /*Retrieve one employee details 
	                and store it in employee object*/
	                username = rs.getString("USERNAME");
	                password = rs.getString("PASSWORD");
	                //add each employee to the list
//	                list.add(eb);
				
			} }catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			System.out.println(username);
//			System.out.println(uname);
			if (uname.equals(username) && pass.equals(password)) {
				return true;
			}
			else
			{
				return false;
			}
		
			
		}
		System.out.println("IN checkLogin!");
		return false;
	}

}
