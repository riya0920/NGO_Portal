package com.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Connection.VolunteerBean;
import com.Connection.VolunteerDao;

/**
 * Servlet implementation class SignUpVolServlet
 */
public class SignUpVolServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String fname = req.getParameter("fname");
		String uname = req.getParameter("uname");
		String pass = req.getParameter("pass");
		VolunteerBean vb = new VolunteerBean(fname,uname,pass);
		VolunteerDao vd = new VolunteerDao();
		vd.addVolunteer(vb);
		RequestDispatcher rd =req.getRequestDispatcher("LoginVol.jsp");
		rd.forward(req, resp);
	}
}
