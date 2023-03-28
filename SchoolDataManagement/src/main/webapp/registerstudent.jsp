<%@page import="java.io.PrintWriter"%>
<%@page import="service.StudentServiceImp"%>
<%@page import="schooldataclasses.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
Student student = new Student();
//id, name, email, stad, sec, per, gender, cont, remarks, add, pass, uname
student.setName(request.getParameter("name"));
student.setEmail(request.getParameter("email"));
student.setStandard(request.getParameter("sta"));
student.setSection(request.getParameter("sec"));
student.setPercentage(request.getParameter("per"));
student.setGender(request.getParameter("gen"));
student.setContact(request.getParameter("con"));
student.setRemarks(request.getParameter("rem"));
student.setAddress(request.getParameter("add"));
student.setPassword(request.getParameter("pass"));
student.setUsername(request.getParameter("uname"));
 StudentServiceImp serviceImp = new StudentServiceImp();
 String saveStudent = serviceImp.saveStudent(student);
PrintWriter writer = response.getWriter();
writer.println("<br><br><br><br><br><br><br><br><br><br>");
if(saveStudent.equals("0")) {
	writer.println("<h1 align='center'>please enter the valid details</h1>");
	writer.println(saveStudent+" - "+student.getAddress()+" - "+student.getEmail()+"- -"+student.getName());
	
}
else {
	writer.println("<h1 align='center'>your details sucessfully submited</h1>");
}


%>
</body>
</html>