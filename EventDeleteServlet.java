package com.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Connection.OrganizationDao;

/**
 * Servlet implementation class EventDeleteServlet
 */
public class EventDeleteServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String eid = req.getParameter("eid");
		OrganizationDao od = new OrganizationDao();
		HttpSession session = req.getSession();
	    String org_uname = (String)session.getAttribute("org_uname");
		od.deleteEvent(eid,org_uname);
	}
}
