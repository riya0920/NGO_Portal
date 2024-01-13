package com.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Connection.OrganizationDao;
import com.Connection.VolunteerDao;/**
 * Servlet implementation class LoginVolServlet
 */
public class LoginVolServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uname = req.getParameter("uname");
		String pass = req.getParameter("pass");
		// Get the current session
		HttpSession session = req.getSession();
		// Set a session variable
		session.setAttribute("uname", uname);
//		req.setAttribute("uname", uname);
		VolunteerDao vd = new VolunteerDao();
		System.out.println(uname + "Login Servlet");  
		RequestDispatcher rd = null;
		if (vd.checkLogin(uname,pass)) {
			rd = req.getRequestDispatcher("EventsVol.jsp");
		}
		else
		{
			rd = req.getRequestDispatcher("LoginVol.jsp");
		}
		rd.forward(req, resp);
	}

}
