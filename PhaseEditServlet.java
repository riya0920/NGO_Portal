package com.Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.Connection.OrganizationDao;

/**
 * Servlet implementation class PhaseEditServlet
 */
public class PhaseEditServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		String org_name = (String)session.getAttribute("org_name");
		String eid = (String) req.getParameter("eid");
		System.out.println(eid);
		String p = (String)req.getParameter("phase_edit");
		System.out.println(p);
		int phase = Integer.parseInt(p);
		OrganizationDao od = new OrganizationDao();
		od.changePhase(phase,eid);
	}
}
