<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Delete Patient</title>
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
                height:150px;
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
                margin-top:10px;
                margin-left: -15px;
                z-index:30;
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
				margin:55px;
                margin-left: 90px;
				<!--border:5px solid black;-->
            }
			.conta{
				margin:-8px; 
                height:150px;
                width:auto;
                height:auto;
                display:flex;
                flex-direction: row;
                justify-content: space-around;
                position:relative;
				margin:35px;
                margin-left: 120px;
				border:5px solid black;
            }
            .container img
            { 
                position:absolute;
                width:500px;
                height:480px;
                top:0; 
                z-index:19;
                opacity:0.25;
            }
            #para
            {
                margin:2px;
                width:500px;
                height:300px;
                box-sizing:border-box;
                z-index:20;
                position: absolute;
                margin-top:-40px;
            }
            #get
            {
                height:30px; 
                color:white;
                background-color: #000080;
                border-radius: 5px; 
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
                margin-left:150px;
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
            <img src="medical-logo-png-23.png" alt="log">
        <div id="para">
            <h4 style="margin-left:150px;font-size:20px;"><b>Delete Patient</b></h4>
            <form action="delete" method="post">
            	<input type="hidden" name="status" value="get">
				<label >Patient Id<span style="color:red">*</span></label><input id="id0" name = "pid" value="${lb.getPatientId()}" type="number" placeholder="Enter Id" style="margin-left:50px" required>
				<button id="get" type="submit" value="Get" onclick="read()" >Get</button><br></br>
				<!-- <button id="get"type="button" value="Get" onclick="read()" >Get</button><br></br>-->
            </form>
			<form action="delete" method="post">
				<input type="hidden" name="status" value="delete">
				<label>Patient Name</label><input type="text" name= "name" value="${lb.getPatientName()}" onkeypress="return(event.charCode > 64 && event.charCode < 91) || (event.charCode > 96 && event.charCode < 123)" placeholder="Enter Name"style="margin-left:66px"required><br></br>
				<label>Patient Age</label><input id="id1" type="number" name="age" value= "${lb.getAge()}" min="1" max="100" placeholder="Enter age" style="margin-left:80px;"required><br></br>
				<label>Date of Admission</span></label><input  type="date" name="date" value="${lb.getDateOfAdmission()}"  style="margin-left:30px;"required><br></br>
				<label>Type of bed</label>
				<input type="text" id="bed" name="bedtype" style="margin-left:70px;" value="${lb.getTypeOfBed()}" required>
				<br></br>
				<label>Address</label><input type="text" placeholder="Enter Address" name="address" value = "${lb.getAddress()}" style="margin-left:100px;"required><br></br>
				<label>State</label>
				<input type="text" id="state" name="state" style="margin-left:115px;" value="${lb.getState()}" required>
				<br></br>
				<label>City</label>
				<input type="text" id="city" name="city" style="margin-left:118px;" value="${lb.getCity()}" required>
				<p id="point">*Mandatory</p>
				<button type="submit" value="delete" class="button" onclick="fun()">Delete</button>
		</form>
		</div>
		</div>
    </body>
</html>
<script src="update.js"></script>
