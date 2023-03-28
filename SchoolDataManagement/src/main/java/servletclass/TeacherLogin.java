package servletclass;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import schooldataclasses.Teacher;

import service.TeacherServiceImp;

@WebServlet("/teacherlogin")
public class TeacherLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uname = request.getParameter("uname");
		
		String password = request.getParameter("pass");
		
		TeacherServiceImp tech = new TeacherServiceImp();
		 
		Teacher login = tech.teacherLogin(uname, password);
		
		if(login == null) {
			PrintWriter writer = response.getWriter();
			writer.println("<br><br><br><br><br><br><br><br><br><br>");
			writer.println("<h1 align='center'>please enter the valid user name and password</h1>");
			writer.println("");
		}else {
			 HttpSession ses = request.getSession();
			 ses.setAttribute("id",login.getId());
		   response.sendRedirect("teachermenu.jsp");
		}
	}

}
