<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Create Patient</title>
        <meta charset="utf-8">
        <style>
            body
            {
                background-color:#87CEFA;
                height:100%;
                width:100%;
            }
            #top
            {
                background-image: linear-gradient(black,navy,darkblue,mediumblue,blue,dodgerblue,#DCDCDC);
                margin:-8px; 
                height:150px;"
            }
            .parent
            {
                display:flex;
                flex-direction: row;
                justify-content: center;
                margin-left:135px;
            }
            .parent img
            {
                width:54px;
                height:54px;
                margin-top:10px;
            }
            .menu-bar
            {
                text-align:center;
                margin:-8px;
            }   
            .menu-bar ul
            {
                display:inline-flex;
                list-style-type: none;
                color:white;
            }
            .menu-bar ul li
            {
                width: 100px;
                margin-bottom:-5px;
                margin-left:25px;
                padding: 15px;
                font-size: 15px;
                font-family: sans-serif;
                background-color:#000080;
                border-radius: 3px;
            }
            .menu-bar ul li a
            {
                text-decoration: none;
                color:white;
            }
            .menu-bar ul li:hover,.button:hover,#get:hover
            {
                background-color:#426775;
                cursor:pointer;
                border-radius:3px;
            }
            .sub1
            {
                display:none;
            }
            .menu-bar ul li:hover .sub1
            {
                display:block;
                position: absolute;
                background:#426775 ;
                margin-top:16px;
                margin-left: -15px;
                z-index:20;
            }
            .menu-bar ul li:hover .sub1 ul
            {
                display:block;
                margin:10px;
    
            }
            .menu-bar ul li:hover .sub1 ul li
            {
                width:150px;
                padding:10px;
                border-bottom: 1px dotted white;
                background:transparent;
                border-radius:0;
                text-align: left;
                margin-left:-30px;
            }
            .menu-bar ul li:hover .sub1 ul li:last-child
            {
                border-bottom:none;
            }
            .menu-bar ul li:hover .sub1 ul li a:hover
            {
                color:#000080;
            }
            .con1{
               
                display:flex;
                flex-direction: row;
                justify-content: center;
                margin-left:10px;
            }
            .container{
                width:auto;
                height:auto;
                display:flex;
                flex-direction: row;
                justify-content: space-around;
                position:relative;
                margin-left: 70px;
            }.container img
            { 
                position:absolute;
                width:500px;
                height:480px;
                top:0; 
                z-index:9;
                opacity:0.25;
            }
            #para
            {
                margin:2px;
                width:600px;
                height:300px;
                box-sizing:border-box;
                z-index:10;
                position: absolute;
                margin-left: -200px;
            }
            #point
            {
                color:red;
            }
            .button
            {
                height:40px; 
                width:100px;
                color:white;
                background-color:#000080;
                border-radius: 5px;
                margin-left:40px;
            }
        </style>
    </head>
    <body>
        <a href="logout" style="float: right; margin-right:20px;color: white;font-size:17px;cursor: pointer;"><b>👥 logout</b></a>
        <div id="top"><br>
            <div class="parent">
            <img src="plus-sign-icon.png" alt="logo">
            <h2 style=" color:white;">ABC Hospital Management System</h2>
            </div>
        <div class="menu-bar">
        <ul align="center">
            <div class="con1">
            <li><a href="#">Patient</a>
                <div class="sub1">
                    <ul>
                        <li><a href="create.jsp">create</a></li>
                        <li><a href="update.jsp">update</a></li>
                        <li><a href="search.jsp">view</a></li>
                        <li><a href="delete.jsp">delete</a></li>
                        <li><a href="#">billing</a></li>
                    </ul>
                </div>
            </li>
            <li><a href="#"></a>Pharmacy</a>
                <div class="sub1">
                    <ul>
                        <li><a href="#">previous medicine</a></li>
                        <li><a href="#">new medicine</a></li>
                    </ul>
                </div>
            </li>
            <li><a href="#"></a>Diagnostics</a>
                <div class="sub1">
                    <ul>
                        <li><a href="#">previous test</a></li>
                        <li><a href="#">new test</a></li>
                    </ul>
                </div>
            </li>
            </div>
        </ul>
        </div>
    </div>
        <div class="container">
            <img src="medical-logo-png-23.png" alt="">
        <form action ="insert" method = "post">
        <div id="para">
            <h4 style="margin-left:100px;font-size:20px;"><b>Patient Registration</b></h4>
            <label >Patient SSN Id<span style="color:red">*</span></label><input id="id0" "type="number" name ="ssnid" placeholder="Enter Id" style="margin-left:59px" required><br></br>
            <label>Patient Name<span style="color:red">*</span></label><input type="text" name ="name" onkeypress="return(event.charCode > 64 && event.charCode < 91) || (event.charCode > 96 && event.charCode < 123)" placeholder="Enter Name"style="margin-left:66px"required><br></br>
            <label>Patient Age<span style="color:red">*</span></label><input id="id1" type="number" name = "age" min="1" max="100" placeholder="Enter age" style="margin-left:80px;"required><br></br>
            <label>Date of Admission<span style="color: red">*</span></label><input  type="date"  name = "date" style="margin-left:30px;"required><br></br>
            <label>Type of bed<span style="color:red">*</span></label>
            <select id="bed" name="bedtype" style="margin-left:70px;" required>
                <option name="bedtype" value="">Select</option>
                <option name="bedtype" value="General ward">General ward</option>
                <option name="bedtype" value="semi sharing">semi sharing</option>
                <option name="bedtype" value="single room">single room</option>
            </select><br></br>
            <label>Address<span style="color:red">*</span></label><input type="text" name="address"  placeholder="Enter Address" style="margin-left:100px;"required><br></br>
            <label>State<span style="color:red">*</span></label>
            <select id="state" name="state" style="margin-left:115px;" required>
                <option name="state" value="">Select</option>
                <option name="state" value="TamilNadu">TamilNadu</option>
                <option name="state" value="Kerala">Kerala</option>
                <option name="state" value="Karnataka">Karnataka</option>
            </select><br></br>
            <label>City<span style="color:red">*</span></label>
            <select id="city" name="city" style="margin-left:118px;" required>
                <option name="city" value="">Select</option>
                <option name="city" value="Salem">Salem</option>
                <option name="city" value="Chennai">Chennai</option>
                <option name="city" value="Coimbatore">Coimbatore</option>
            </select>
            <p id="point">*Mandatory</p>
            <button type="submit"value="submit" class="button" onclick="fun()">submit</button>
            <input type="reset" class="button">
        </div>
    </form>
    </div>
    </body>
</html>
<script src="create.js"></script>