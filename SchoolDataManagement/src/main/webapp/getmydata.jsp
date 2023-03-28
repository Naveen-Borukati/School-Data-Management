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

<table align="center" >
 
<% 
String id =request.getParameter("id");
TeacherServiceImp tech= new TeacherServiceImp();
Teacher te =tech.getTeacherByd(Integer.parseInt(id));

 if(te==null) {
%>
<br><br><br><br><br>
  <h1 align="center">please enter the valid id number</h1>
 <%}else{%>
 <tr>
    <td><h2 align="center">Id</h2></td>
    <td><h2 align="center">Nmae</h2></td>
    <td><h2 align="center">Email</h2></td>
    <td><h2 align="center">Contact</h2></td>
    <td><h2 align="center">Subject</h2></td>
    <td><h2 align="center">Class Teacher</h2></td>
    <td><h2 align="center">Salary</h2></td>
    <td><h2 align="center">Address</h2></td>
   
 </tr>
<tr>
    <td><h3 align="center"><%=te.getId()%></h3></td>
    <td><h3 align="center"><%=te.getName()%></h3></td>
    <td><h3 align="center"><%=te.getEmail()%></h3></td>
    <td><h3 align="center"><%=te.getContact()%></h3></td>
    <td><h3 align="center"><%=te.getSubject()%></h3></td>
    <td><h3 align="center"><%=te.getClassteacher()%></h3></td>
    <td><h3 align="center"><%=te.getSalary()%></h3></td>
    <td><h3 align="center"><%=te.getAddress()%></h3></td>
</tr>

<%}%>
</table>
 <a href="teachermenu.jsp"><input type="button"  value="Back" class="a"></a>
</body>
</html>