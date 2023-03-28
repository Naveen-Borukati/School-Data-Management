
<%@page import="schooldataclasses.Admin"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
 input{
    position:absolute;
    left:46%;
    padding:10px 20px;
    color:white;
    border: none;
    border-radius: 10px;
    background-color:black; 
    font-weight: 500;
    font-size: 15px;
    letter-spacing: 3px;
 }
 
</style>
</head>
<body>
<br><br><br><br><br><br><br><br><br>
<% Admin a =(Admin) session.getAttribute("adminlogin");
  String name= a.getUsername();
%>
<h1 align="center"><%= "Welocome "+name %></h1>
<br><br><br><br>
<form action="">
  <a href="saveadmin.html"><input type="button"  value="Get Teachers"></a>
  <a href="saveadmin.html"><input type="button"  value="Create New Teacher"></a>
  <a href="saveadmin.html"><input type="button"  value="Get Teacher By Id"></a>
</form>
</body>
</html>