package com.vl.main;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vl.resources.PropertyLoader;
public class Login extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}
	protected void processRequest(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException {
//		Properties prop=PropertyLoader.getInstance();
		PrintWriter out=response.getWriter();
		ServletContext context=request.getServletContext();
		Properties prop=(Properties) context.getAttribute("prop");
		String name=request.getParameter("uname");
		String pwd=request.getParameter("pwd");
		String val=prop.getProperty(name);
		if(val!=null){

			String value[]=prop.getProperty(name).split(",");
			for(int i=0;i<value.length;i++){
				System.out.println(value[i]);
			}
			if(value[2].equals(pwd)){
				HttpSession hp=request.getSession();
				hp.setAttribute("uname", name);
				response.sendRedirect("home.html");
				System.out.println("matches");
			}
			else {
				out.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\"><html><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\"><title>Login</title><link href=\"style2.css\" rel=\"stylesheet\" type=\"text/css\"></link><script > window.location.hash=\"no-back-button\"; window.location.hash=\"Again-No-back-button\"; window.onhashchange=function(){window.location.hash=\"no-back-button\";} </script></head><body><table border=\"1\" width=\"1000\" align=\"center\"><tr height=\"200\"><td>Header</td></tr><tr height=\"50\"><td>menu</td></tr><tr height=\"500\"><td><form action=\"./Login\" method=\"post\"><table align=\"center\"><caption  id=\"caption\">Login</caption><tr><td colspan=\"3\"><h4 id=\"notMatch\">*Username or Password not matched</h4></td></tr><tr><td>Username</td><td>:</td><td><input type=\"text\" name=\"uname\"></td></tr><tr><td>Password</td><td>:</td><td><input type=\"password\" name=\"pwd\"></td></tr><tr><td colspan=\"3\" align=\"center\"><input type=\"submit\" value=\"Login\"></td></tr></table></form></td></tr><tr height=\"50\"><td>footer</td></tr></table></body></html>");
				System.out.println("not matches");
			}
		}
		else {
			out.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\"><html><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\"><title>Login</title><link href=\"style2.css\" rel=\"stylesheet\" type=\"text/css\"></link><script > window.location.hash=\"no-back-button\"; window.location.hash=\"Again-No-back-button\"; window.onhashchange=function(){window.location.hash=\"no-back-button\";} </script></head><body><table border=\"1\" width=\"1000\" align=\"center\"><tr height=\"200\"><td>Header</td></tr><tr height=\"50\"><td>menu</td></tr><tr height=\"500\"><td><form action=\"./Login\" method=\"post\"><table align=\"center\"><caption  id=\"caption\">Login</caption><tr><td colspan=\"3\"><h4 id=\"notMatch\">*Username or Password not matched</h4></td></tr><tr><td>Username</td><td>:</td><td><input type=\"text\" name=\"uname\"></td></tr><tr><td>Password</td><td>:</td><td><input type=\"password\" name=\"pwd\"></td></tr><tr><td colspan=\"3\" align=\"center\"><input type=\"submit\" value=\"Login\"></td></tr></table></form></td></tr><tr height=\"50\"><td>footer</td></tr></table></body></html>");
			System.out.println("not matches");
		}
	}

}
