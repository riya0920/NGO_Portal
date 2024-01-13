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
 * Servlet implementation class EventsApplyServlet
 */
public class EventsApplyServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String eid = req.getParameter("eid");
		HttpSession session = req.getSession();
		String org_uname = (String)session.getAttribute("org_uname");
		OrganizationDao od = new OrganizationDao();
		od.applyEvent(eid,org_uname);
		RequestDispatcher rd = req.getRequestDispatcher("EventsVol.jsp");
		rd.forward(req, resp);
	}

}
