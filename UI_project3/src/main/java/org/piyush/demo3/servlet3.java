package org.piyush.demo3;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
@WebServlet("/actionPerformed")

	public class servlet3 extends GenericServlet {

		@Override
		public void service(ServletRequest req,ServletResponse resp)throws IOException, ServletException
		{
			// TODO Auto-generated method stub
			String name=req.getParameter("nm");
			String place=req.getParameter("pl");
			String Phoneno = req.getParameter("pno");
					
					PrintWriter out = resp.getWriter();
			out.println("<html><body bgcolor='yellow'>"
					+"<h1>Welcome " +name+ "form " +place+ "phone no" + Phoneno +"</h1>"
					+"</body></html>");
			
			out.close();
		}

	}
