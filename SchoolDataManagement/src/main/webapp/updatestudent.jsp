<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registration Form</title>
    <style>
        *{
            margin: 0px;
            padding: 0px;
            box-sizing: border-box;
            outline: none;
        }
        body{
            width: 100%;
            height: 100vh;
            background-color: rgba(0, 0, 0, 0.795);
            display: flex;
            justify-content: center;
            align-items: center;
            padding: 20px;
            font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        }
        .container{
            background-image: linear-gradient(135deg,orange,yellow);
            width: 900000px;
            height: 90%;
            border-radius: 20px;
            padding: 40px;
            margin-top: 50px;
        }
        .container .tittle{
            font-size: 30px;
            font-weight: 600;
            margin-bottom: 10px;
            margin-top: 10px;
            position: relative;
            display: flex;
            justify-content: center;
        }
        font{
            color: red;
        }
        .container .tittle::before{
            content: "";
            width: 90%;
            height: 4px;
            background-image: linear-gradient(135deg,blue,red);
            position: absolute;
            bottom: -10px;
        }
      .container .user-details{
        display: flex;
        flex-wrap: wrap;
        margin-top: 30px;
        margin-left: 150px;
        
      }
      .container .user-details .input-box{
        width: calc(100% / 2 - 20px);
        height: 70px;
        margin-bottom: 50px;
      }
      .input-box{
        display: flex;
        flex-direction: column;
      }
      form .user-details .input-box input{
        
        padding: 20px 20px 20px 20px;
        border: none;
        border-radius: 10px;
        width: 70%;
      }
      
      form .button{
        width: 200px;
        height: 100px;
        text-align: center;
        margin-left: 40%;
      }
      form .button input{
        padding: 10px 20px 10px 20px;
        border: none;
        border-radius: 10px;
        width: 100%;
        height: 40px;
        background-image: linear-gradient(135deg,red,rgb(0, 157, 255));
        color: white;
        font-size: 15px;
        font-weight: 200;
        letter-spacing: 3px;
      }
      form .button input:hover{
        background-image: linear-gradient(-135deg,red,rgb(0, 157, 255));
        box-shadow: 0 0 10px black;
      }
    </style>
</head>
<body>
<%String id =request.getParameter("id"); %>
    <div class="container">
        <div class="tittle"><font>U</font>pdate Details</div>
        <form action="updatestudent" method="post">
            <div class="user-details">
              <div class="input-box">
                        <label for="">Id</label>
                        <input type="text"  id="uname" required placeholder="enter your Name"  name="id"  value=<%=id %> readonly>
                </div>
                    <div class="input-box">
                        <label for="">Name</label>
                        <input type="text"  id="uname" required placeholder="enter your Name"  name="name" >
                </div>
                  <div class="input-box">
                    <label for="">Email</label>
                    <input type="text"  id="num" required placeholder="enter your Email" name="email">
                </div>
               
                  <div class="input-box">
                    <label for="">Contact</label>
                    <input type="text"  id="contact" required placeholder="enter your  contact numbre" name="cont">
                </div>
                  <div class="input-box">
                    <label for="">Section</label>
                    <input type="text"  id="address" required placeholder="enter your Section" name="sec">
                </div>
         
                   <div class="input-box">
                        <label for="">Address</label>
                        <input type="text"  id="uname" required placeholder="enter your Address"  name="add">
                </div>
                 <div class="input-box">
                    <label for="">Percentage</label>
                    <input type="text"  id="address" required placeholder="enter your Percentage" name="per">
                </div>
         
                   <div class="input-box">
                        <label for="">Remarks</label>
                        <input type="text"  id="uname" required placeholder="enter Remarks"  name="rem">
                </div>
                
                 
        </div>
        <div class="button"><input type="submit" value="Submit"  id="button12"></div>
    </form>
 </div>
</body>
</html>