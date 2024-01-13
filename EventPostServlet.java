package com.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Connection.EventBean;
import com.Connection.OrganizationDao;

/**
 * Servlet implementation class EventPostServlet
 */
public class EventPostServlet extends HttpServlet {
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String uname = null;
		String eid = req.getParameter("eid");
		String ename = req.getParameter("ename");
		String evac = req.getParameter("evac");
		String hours_str = req.getParameter("hours");
		int hours = Integer.parseInt(hours_str);
		String loc = req.getParameter("loc");
		String desc = req.getParameter("desc");
		HttpSession session = req.getSession();
	    uname= (String) session.getAttribute("org_uname");
	    System.out.println(uname);
		OrganizationDao od = new OrganizationDao();
		EventBean eb = new EventBean(eid,loc,desc,hours,ename,evac);
		od.addEvent(eb,uname);
	}
}