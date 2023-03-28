
<%@page import="schooldataclasses.Admin"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
          body{
            width: 80%;
            height: 70vh;
            display: flex;
            justify-content: center;
            align-items: center;
            padding: 80px;
            flex-wrap:wrap;
            
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
.box{
   display:flex;
    flex-wrap:wrap;
   justify-content: center;
}
 
</style>
</head>
<body>
<% Admin a =(Admin) session.getAttribute("adminlogin");
  String name= a.getUsername();
%>

<form action="">
   <div class="box">
  <a href="teacherdetails.jsp"><input type="button"  value="Get Teachers"></a>
  <a href="saveteacher.jsp"><input type="button"  value="Create New Teacher"></a>
  <a href="getteacherbyidform.html"><input type="button"  value="Get Teacher By Id"></a>
  <a href="studentdetails.jsp"><input type="button"  value="View Students"></a>
  <a href="loginpage.html"><input type="button"  value="Back"></a>
  
   </div>
   
</form>
</body>
</html>