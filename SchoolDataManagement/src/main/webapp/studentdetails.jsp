<%@page import="schooldataclasses.Student"%>
<%@page import="service.StudentServiceImp"%>
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
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<table align="center">
 <tr>

    <td><h2 align="center">Id</h2></td>
    <td><h2 align="center">Name</h2></td>
    <td><h2 align="center">Email</h2></td>
    <td><h2 align="center">Standard</h2></td>
    <td><h2 align="center">Section</h2></td>
    <td><h2 align="center">Percentage</h2></td>
    <td><h2 align="center">Geneder</h2></td>
    <td><h2 align="center">Contact</h2></td>
     <td><h2 align="center">Remarks</h2></td>
    <td><h2 align="center">Address</h></td>
 </tr>
<% 
TeacherServiceImp tech= new TeacherServiceImp();
StudentServiceImp stud =new StudentServiceImp();
 List<Student> list=stud.getAllStudents();
 if(list==null) {
%>
  <h1>no teacher data is available empty</h1>
 <%}else{
 for(Student te :list){
 
 %>
<tr>
    <td><h3 align="center"><%=te.getId()%></h3></td>
    <td><h3 align="center"><%=te.getName()%></h3></td>
    <td><h3 align="center"><%=te.getEmail()%></h3></td>
    <td><h3 align="center"><%=te.getStandard()%></h3></td>
    <td><h3 align="center"><%= te.getSection()%></h3></td>
    <td><h3 align="center"><%=te.getPercentage()%></h3></td>
    <td><h3 align="center"><%=te.getGender()%></h3></td>
    <td><h3 align="center"><%=te.getContact()%></h3></td>
     <td><h3 align="center"><%=te.getRemarks()%></h3></td>
    <td><h3 align="center"><%=te.getAddress()%></h3></td>
   
  
</tr>

<%}
 }%>
</table>
 <a href="adminmenu.jsp"><input type="button"  value="Back" class="a"></a>
</body>
</html>