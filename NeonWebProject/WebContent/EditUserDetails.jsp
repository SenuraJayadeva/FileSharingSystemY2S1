<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page import="com.neon.mainServices.CustomerServices" %>
<%@ page import="com.neon.mainServices.CustomerServicesInterface" %>
<%@ page import="com.neon.model.Customer" %>
<%@page import="java.util.ArrayList"%>


<%@ page language="java" import="java.sql.*"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width,initial-scale=1">
<title>Neon</title>
<!-- Favicon icon -->
<link rel="icon" type="image/png" sizes="16x16"
	href="images/favicon.png">
<!-- Pignose Calender -->
<link href="./plugins/pg-calendar/css/pignose.calendar.min.css"
	rel="stylesheet">
<!-- Chartist -->
<link rel="stylesheet" href="./plugins/chartist/css/chartist.min.css">
<link rel="stylesheet"
	href="./plugins/chartist-plugin-tooltips/css/chartist-plugin-tooltip.css">
<!-- Custom Stylesheet -->
<link href="css/style.css" rel="stylesheet">
<!-- Custom Stylesheet -->
<link href="css/index.css" rel="stylesheet">
<!-- Custom Stylesheet -->
<link href="css/footer.css" rel="stylesheet">
<!--Google Icons-->
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
 <link href="cssD/styleD.css" rel="stylesheet">	


</head>
<body>

	


	<!--**********************************
        Main wrapper start
    ***********************************-->
	<div id="main-wrapper">

		<!--**********************************
            Nav header start
        ***********************************-->
		<div class="nav-header">
			<div class="brand-logo">
				<a href="index.html"> <b class="logo-abbr"><img
						src="images/logo.png" alt=""> </b> <span class="logo-compact">
						<img src="./images/logo-compact.png" alt="">
				</span> <span class="brand-title"> <img  style="width:170px; height: 45px;" src="images/neon.png" alt="">

				</span>
				</a>
			</div>
		</div>
		<!--**********************************
            Nav header end
        ***********************************-->

		<!--**********************************
            Header start
        ***********************************-->
		<div class="header">
			<div class="header-content clearfix">

				<div class="nav-control">
					<div class="hamburger">
						<span class="toggle-icon"><i class="icon-menu"></i></span>
					</div>
				</div>
				<div class="header-left">
					<div class="input-group icons">
						<div class="input-group-prepend">
							<span
								class="input-group-text bg-transparent border-0 pr-2 pr-sm-3"
								id="basic-addon1"><i class="mdi mdi-magnify"></i></span>
						</div>
						
						

						<form action="#">
						<input type="search" class="form-control" id="searchEmail" name ="searchEmail"
							placeholder="Search People" aria-label="Search Dashboard">
						</form>
						<div class="drop-down animated flipInX d-md-none">
							<form action="#">
								<input type="text" id="searchEmail" name ="searchEmail" class="form-control" placeholder="Search">
							</form>
						</div>
					</div>
				</div>
				<div class="header-right">
					<ul class="clearfix">
							
							
	
						<%
							//int userID = (Integer) session.getAttribute("userID");
							String userName = (String) session.getAttribute("userName");
							//get fileName attribute in audio table using session from audioInsertController 
							String path = (String) session.getAttribute("path");

							if (userName == null) {
						%>
						
						
						<li class="icons dropdown d-none d-md-flex"><a
							href="signup.jsp" class="log-user"> <i
								class="fa fa-user f-s-14" aria-hidden="true"></i><span>Sign Up</span>
						</a></li>

						<li class="icons dropdown d-none d-md-flex"><a
							href="login.jsp" class="log-user"> <i
								class="fa fa-user f-s-14" aria-hidden="true"></i><span>Log In</span>
						</a></li>


						<%
							} else {
						%>


						<li class="icons dropdown d-none d-md-flex"><a
							href="user" class="log-user"><span style="color:#06575B; font-weight:bold;"><%=userName%></span>
						</a></li>

						<li class="icons dropdown">
							<div class="user-img c-pointer position-relative"
								data-toggle="dropdown">
								<span class="activity active"></span> 
								
								<img src="images/<%=path%>" height="40" width="40" alt="">
								
							</div>
							<div
								class="drop-down dropdown-profile animated fadeIn dropdown-menu">
								<div class="dropdown-content-body">
									<ul>
										<li><a href="app-profile.html"><i class="icon-user"></i>
												<span>Profile</span></a></li>
										

										<hr class="my-2">

										<li><a href="logout.jsp"><i class="icon-key"></i> <span>Logout</span></a></li>
									</ul>
								</div>
							</div>
						</li>

						<%
							}
						%>


					</ul>
				</div>
			</div>
		</div>
		<!--**********************************
            Header end ti-comment-alt
        ***********************************-->

		<!--**********************************
            Sidebar start
        ***********************************-->
		<div class="nk-sidebar">
			<div class="nk-nav-scroll">
				<ul class="metismenu" id="menu">


					<li><a href="index.jsp" aria-expanded="false"> <i
							class="material-icons">home</i><span class="nav-text">Home</span>
					</a></li>

					<li><a href="aboutUs.jsp" aria-expanded="false"> <i
							class="material-icons">supervisor_account</i><span
							class="nav-text">About Us</span>
					</a></li>

					<li><a href="ContactUs.jsp" aria-expanded="false"> <i
							class="material-icons">email</i><span class="nav-text">Contact</span>
					</a></li>


				</ul>
			</div>
		</div>
		<!--**********************************
            Sidebar end
        ***********************************-->
        
        
         <!--**********************************
            Content body start
        ***********************************-->
        <div class="content-body">

            <div class="row page-titles mx-0">
                <div class="col p-md-0">
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item"><a href="javascript:void(0)">Dashboard</a></li>
                        <li class="breadcrumb-item active"><a href="javascript:void(0)">Home</a></li>
                    </ol>
                </div>
            </div>
            <!-- row -->
            
            <%
		
				
            CustomerServicesInterface customerServices = new CustomerServices();
				ArrayList<Customer> arrayList = customerServices.getCustomerDetails(userName);
				for(Customer customer : arrayList){
				
		%>

            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12">
                        <div class="card">
                            <div class="card-body">
                                <div class="basic-form">
                                    <form action="updateUserDetails" method="POST" >
                                        <div class="form-group">
                                        
                                        	User ID<input type="text" class="form-control input-flat"  name="Email" value="<%=customer.getEmail() %>" readonly><br/>
                                            First Name<input type="text" class="form-control input-flat"  name="FirstName" value="<%=customer.getFirstName() %>"><br/>
                                            Last Name<input type="text" class="form-control input-flat"  name="LastName" value="<%=customer.getLastName() %>"><br/>
                                            Password<input type="text" class="form-control input-flat"  name="NewPassword" value="<%=customer.getPassword() %>"><br/>
                           					
                           
                                        </div>
                                        <input type="submit" class = "button2" id="button2" name="button2"  value="Change">
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                    
                   
                   
						<%
							}
						%>
                   
                   
                    
                         
        <!--**********************************
            Content body end
        ***********************************-->
        

	</div>
	<!--**********************************
        Main wrapper end
    ***********************************-->

	<!--**********************************
        Scripts
    ***********************************-->
	<script src="plugins/common/common.min.js"></script>
	<script src="js/custom.min.js"></script>
	<script src="js/settings.js"></script>
	<script src="js/gleek.js"></script>
	<script src="js/styleSwitcher.js"></script>

	<!-- Chartjs -->
	<script src="./plugins/chart.js/Chart.bundle.min.js"></script>
	<!-- Circle progress -->
	<script src="./plugins/circle-progress/circle-progress.min.js"></script>
	<!-- Datamap -->
	<script src="./plugins/d3v3/index.js"></script>
	<script src="./plugins/topojson/topojson.min.js"></script>
	<script src="./plugins/datamaps/datamaps.world.min.js"></script>
	<!-- Morrisjs -->
	<script src="./plugins/raphael/raphael.min.js"></script>
	<script src="./plugins/morris/morris.min.js"></script>
	<!-- Pignose Calender -->
	<script src="./plugins/moment/moment.min.js"></script>
	<script src="./plugins/pg-calendar/js/pignose.calendar.min.js"></script>
	<!-- ChartistJS -->
	<script src="./plugins/chartist/js/chartist.min.js"></script>
	<script
		src="./plugins/chartist-plugin-tooltips/js/chartist-plugin-tooltip.min.js"></script>



	<script src="./js/dashboard/dashboard-1.js"></script>

</body>
</html>