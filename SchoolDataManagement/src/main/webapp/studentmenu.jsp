
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

<%  HttpSession ses = request.getSession();
String url ="http://localhost:8080/SchoolDataManagement/studentdatabyid.jsp?id="+ses.getAttribute("id");
%>

<form action="">
   <div class="box">
  <a href="studentteacharlist.jsp"><input type="button"  value="Get Teachers"></a>
  <a href=<%=url%>><input type="button"  value="Get My Data"></a>
  <a href="getteacherbysubject.jsp"><input type="button"  value="Get Teacher By Subject"></a>
  <a href="loginpage.html"><input type="button"  value="Back"></a>
  
   </div>
   
</form>
</body>
</html>