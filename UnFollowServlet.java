package com.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Connection.VolunteerDao;

/**
 * Servlet implementation class UnFollowServlet
 */
public class UnFollowServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String username = (String) session.getAttribute("uname");	
		System.out.println(username);
		String orgid = req.getParameter("orgid");
		VolunteerDao vd = new VolunteerDao();
		vd.unfollow(username, orgid);
	}
}
