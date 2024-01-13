package com.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class FilteredHoursServlet
 */
public class FilteredHoursServlet extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String min_hours = req.getParameter("min_hrs");
		String max_hours = req.getParameter("max_hrs");
		HttpSession session = req.getSession();
		String username = (String)session.getAttribute("uname");
		System.out.println(username + "FilteredHourServlet");
		int min_h = Integer.parseInt(min_hours);
		int max_h = Integer.parseInt(max_hours);
		req.setAttribute("max_hrs", max_hours);
		req.setAttribute("min_hrs", min_hours);
		RequestDispatcher rd = req.getRequestDispatcher("FilteredHours.jsp");
		rd.forward(req, resp);
	}
}
