<%@page import="java.util.List"%>
<%@page import="schooldataclasses.Teacher"%>
<%@page import="service.TeacherServiceImp"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
table{
 border-spacing:20px;
}
.a{
  position:absolute;
  left:50%;
}
input{
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

<table align="center">
 <tr>
    <td><h2 align="center">Id</h2></td>
    <td><h2 align="center">Nmae</h2></td>
    <td><h2 align="center">Email</h2></td>
    <td><h2 align="center">Contact</h2></td>
    <td><h2 align="center">Subject</h2></td>
    <td><h2 align="center">Class Teacher</h2></td>
    <td><h2 align="center">Salary</h2></td>
    <td><h2 align="center">Address</h2></td>
     <td><h2 align="center">Update</h2></td>
    <td><h2 align="center">Delete</h></td>
 </tr>
<% 
TeacherServiceImp tech= new TeacherServiceImp();
 List<Teacher> list=tech.getAllTeachers();
 if(list==null) {
%>
  <h1>no teacher data is available empty</h1>
 <%}else{
 for(Teacher te :list){
  String url1 = "http://localhost:8080/SchoolDataManagement/deleteteacher.jsp?id="+te.getId();
  String url2 ="http://localhost:8080/SchoolDataManagement/updateteacher.jsp?id="+te.getId();
 %>
<tr>
    <td><h3 align="center"><%=te.getId()%></h3></td>
    <td><h3 align="center"><%=te.getName()%></h3></td>
    <td><h3 align="center"><%=te.getEmail()%></h3></td>
    <td><h3 align="center"><%=te.getContact()%></h3></td>
    <td><h3 align="center"><%=te.getSubject()%></h3></td>
    <td><h3 align="center"><%=te.getClassteacher()%></h3></td>
    <td><h3 align="center"><%=te.getSalary()%></h3></td>
    <td><h3 align="center"><%=te.getAddress()%></h3></td>
     <td><a href=<%=url2%>><input type="button" value="Edit" ></a></td>
     <td><a href=<%=url1%>><input type="button" value="Delete" ></a></td>
  
</tr>

<%}
 }%>
</table>
<a href="adminmenu.jsp"><input type="button"  value="Back" class="a"></a>
</body>
</html>