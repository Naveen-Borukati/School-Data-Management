package servletclass;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import schooldataclasses.Student;
import service.StudentServiceImp;
@WebServlet("/updatestudent")
public class UpdateStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Student teacher = new Student();
		teacher.setId(request.getParameter("id"));
		teacher.setName(request.getParameter("name"));
		teacher.setContact(request.getParameter("cont"));
		teacher.setEmail(request.getParameter("email"));
		teacher.setSection(request.getParameter("sec"));
		teacher.setAddress(request.getParameter("add"));
		teacher.setPercentage(request.getParameter("per"));
		teacher.setRemarks(request.getParameter("rem"));
		StudentServiceImp serviceImp = new StudentServiceImp();
		Student studentById = serviceImp.updateStudentById(teacher);
		PrintWriter writer = response.getWriter();
		writer.println("<br><br><br><br><br><br><br><br><br>");
		if(studentById==null) {
		    writer.println("<h1 align='center'>please enter the valid details</h1>");	
		}else {
			  writer.println("<h1 align='center'>Yours details will be sucessfully Updated</h1>");
		}
	}

}
