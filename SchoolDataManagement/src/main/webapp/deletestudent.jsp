<%@page import="schooldataclasses.Student"%>
<%@page import="service.StudentServiceImp"%>
<%@page import="service.TeacherServiceImp"%>
<%@page import="schooldataclasses.Teacher"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>

.a{
position:absolute;
left:50%;
padding:10px 20px;
color:white;
border: none;
border-radius: 10px;
background-color:black; 
font-weight: 500;
font-size: 15px;
letter-spacing: 3px;
margin:50px;
}

</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% String id =request.getParameter("id"); 
 
    StudentServiceImp stude= new StudentServiceImp();
     Student result= stude.deleteStudentById(Integer.parseInt(id));

    if( result==null){
%>
<h1 align="center">Please Enter The Valid Id Number</h1>
<a href="teachermenu.jsp"><input type="button" value="Back" class="a"></a>
<%} else {%>
<h1 align="center">SucessFully Deleted </h1>
<a href="teachermenu.jsp"><input type="button" value="Back" class="a"></a>
<%} %>
</body>
</html>