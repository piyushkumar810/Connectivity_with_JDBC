package org.piyush.serveApp;
import java.io.*;

import javax.servlet.*;

public class first_servlet extends GenericServlet {

	@Override
	public void service(ServletRequest req,ServletResponse resp)throws IOException, ServletException
	{
		// TODO Auto-generated method stub
		String name=req.getParameter("nm");
		String place=req.getParameter("pl");
				
				PrintWriter out = resp.getWriter();
		out.println("<html><body bgcolor='yellow'>"
				+"<h1>Welcome " +name+ "form " +place+"</h1>"
				+"</body></html>");
		
		out.close();
	}

}
