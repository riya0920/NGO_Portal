package com.Controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.Connection.OrganizatioBean;
import com.Connection.OrganizationDao;

/**
 * Servlet implementation class SignUpOrgServlet
 */
public class SignUpOrgServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String orgId = request.getParameter("orgId");
		String orgName = request.getParameter("orgname");
		String username = request.getParameter("uname");
		String password = request.getParameter("pass");
		OrganizatioBean ob = new OrganizatioBean(orgId,orgName,username,password);
		OrganizationDao od = new OrganizationDao();
		od.addOrg(ob);
		RequestDispatcher rd =request.getRequestDispatcher("LoginOrg.jsp");
		rd.forward(request, response);
	}

}
