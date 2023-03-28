package servletclass;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import reposirtyimplemantation.AdminRepoImp;
import schooldataclasses.Admin;

@WebServlet("/saveadmin")
public class SaveAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String password = request.getParameter("pass");
		
			AdminRepoImp admin = new AdminRepoImp();
			Admin a = new Admin();
			a.setUsername(name);
			a.setPassword(password);
			String saveAdmin = admin.saveAdmin(a);
			PrintWriter w = response.getWriter();
			w.println("<br><br><br><br><br><br><br><br><br>");
			if(saveAdmin == null) {
				w.println("<h1 align='center'>User name is already exists please enter the another user name</h1>");
			}else {
				
				w.println("<h1 align='center'>Details will be sucessfully Inserted</h1>");
			}
	}

}
