package com.log.logger;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ResourceBundle;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;




public class Login extends HttpServlet {
	static Logger logger=Logger.getLogger(Login.class);

	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException 
			{

		logger.info("checking");
		
		ServletContext ctx = request.getServletContext();
		ResourceBundle resource = (ResourceBundle) ctx.getAttribute("file");
		String name = request.getParameter("username");
		String pwd1 = request.getParameter("pwd");
		logger.info("session created here");
		HttpSession session = request.getSession(true);
		session.setAttribute("name1", name);
		
		if (name == null || resource.containsKey(name)) {

			if (resource.getString(name).equals(pwd1))
			{
				logger.info("user enterd into application");
				response.sendRedirect("List.html");
			}

		} else {
			
			RequestDispatcher rd = request.getRequestDispatcher("login.html");
			PrintWriter out = response.getWriter();
			out.println("<font color=red>Either user name or password is wrong.</font>");
			rd.include(request, response);
		}
			}
}
