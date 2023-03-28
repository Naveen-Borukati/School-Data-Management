package servletclass;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import schooldataclasses.Student;
import service.StudentServiceImp;

@WebServlet("/student")
public class StudentData extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
        String uname = request.getParameter("uname");
		
		String password = request.getParameter("pass");
		
	  
		StudentServiceImp stu = new StudentServiceImp();
		Student studentLogin = stu.studentLogin(uname, password);
		if(studentLogin == null) {
			PrintWriter writer = response.getWriter();
			writer.println("<br><br><br><br><br><br><br><br><br><br>");
			writer.println("<h1 align='center'>please enter the valid user name and password</h1>");
		}else {
			
		   HttpSession ses = request.getSession();
		   ses.setAttribute("id", studentLogin.getId());
		   response.sendRedirect("studentmenu.jsp");
		}
	}

}
