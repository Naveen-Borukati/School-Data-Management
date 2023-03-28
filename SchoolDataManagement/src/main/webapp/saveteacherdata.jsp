<%@page import="schooldataclasses.Teacher"%>
<%@page import="service.TeacherServiceImp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
    .a{
  position:absolute;
  left:50%;
}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
//id, name, email, cont, sub, class_teacher, sal, add, pass, uname
Teacher teacher = new Teacher();

teacher.setName(request.getParameter("name"));
teacher.setEmail(request.getParameter("email"));
teacher.setContact(request.getParameter("cont"));
teacher.setSubject(request.getParameter("sub"));
teacher.setClassteacher(request.getParameter("clstech"));
teacher.setSalary(request.getParameter("sal"));
teacher.setAddress(request.getParameter("add"));
teacher.setPassword(request.getParameter("pass"));
teacher.setUsername(request.getParameter("uname"));

     String result = new TeacherServiceImp().saveTeacher(teacher);
     if(result.equals("0")){
%>
<h1 align="center">plese enter valid details try again</h1>
<%}else{ %>
     <h1 align="center">your details sucessfully submit</h1>
<%} %>
 <a href="adminmenu.jsp"><input type="button"  value="Back" class="a"></a>
</body>
</html>