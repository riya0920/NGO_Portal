package com.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Connection.OrganizationDao;

/**
 * Servlet implementation class LoginOrgServlet
 */
public class LoginOrgServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname = request.getParameter("uname");
		String pass = request.getParameter("pass");
		OrganizationDao od = new OrganizationDao();
		HttpSession session = request.getSession();
	    session.setAttribute("org_uname", uname);
		RequestDispatcher rd = null;
		if (od.checkLogin(uname,pass)) {
			rd = request.getRequestDispatcher("EventsOrg.jsp");
		}
		else
		{
			rd = request.getRequestDispatcher("LoginOrg.jsp");
		}
		rd.forward(request, response);
	}
}
