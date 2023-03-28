package servletclass;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import schooldataclasses.Teacher;
import service.TeacherServiceImp;

@WebServlet("/updateteacher")
public class UpdateTeacherDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Teacher teacher = new Teacher();
		teacher.setId(request.getParameter("id"));
		teacher.setName(request.getParameter("name"));
		teacher.setContact(request.getParameter("cont"));
		teacher.setClassteacher(request.getParameter("clstech"));
		teacher.setSalary(request.getParameter("sal"));
		teacher.setAddress(request.getParameter("add"));
		TeacherServiceImp tech = new TeacherServiceImp();
		Teacher updatetech = tech.updateTeacherById(teacher);
		PrintWriter writer = response.getWriter();
		writer.println("<br><br><br><br><br><br><br><br><br>");
		if(updatetech==null) {
		    writer.println("<h1 align='center'>please enter the valid details</h1>");	
		}else {
			  writer.println("<h1 align='center'>Yours details will be sucessfully Updated</h1>");
		}
	}

}
