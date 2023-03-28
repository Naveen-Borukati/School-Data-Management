<%@page import="service.TeacherServiceImp"%>
<%@page import="schooldataclasses.Teacher"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<% String id =request.getParameter("id"); 
    TeacherServiceImp tech = new  TeacherServiceImp();
    Teacher result = tech.deleteTeacherById(Integer.parseInt(id));
    if( result==null){
%>
<h1 align="center">Please Enter The Valid Id Number</h1>
<%} else {%>
<h1 align="center">SucessFully Deleted </h1>
<%} %>
</body>
</html>