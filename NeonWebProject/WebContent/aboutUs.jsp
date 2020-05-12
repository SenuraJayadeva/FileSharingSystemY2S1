<%@page import="com.neon.mainServices.InterfaceServicesReviewCustomer"%>
<%@page import="com.neon.mainServices.serviceDataReviewCustomer"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.neon.model.Review"%>



<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<link href="css/footer.css" rel="stylesheet">
<!-- Custom Stylesheet -->
<link href="css/about.css" rel="stylesheet">
<!--Google Icons-->
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
	


</head>

<body>

	<!--*******************
        Preloader start
    ********************-->
	<div id="preloader">
		<div class="loader">
			<svg class="circular" viewBox="25 25 50 50"> <circle
				class="path" cx="50" cy="50" r="20" fill="none" stroke-width="3"
				stroke-miterlimit="10" /> </svg>
		</div>
	</div>
	<!--*******************
        Preloader end
    ********************-->


	<!--**********************************
        Main wrapper start
    ***********************************-->
	<div id="main-wrapper">

		<!--**********************************
            Nav header start
        ***********************************-->
		<div class="nav-header" style="background-color: rgb(8, 73, 73);">
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

					<li><a href="Contact.jsp" aria-expanded="false"> <i
							class="material-icons">email</i><span class="nav-text">Contact</span>
					</a></li>


				</ul>
			</div>
		</div>
		<!--**********************************
            Sidebar end
        ***********************************-->
        
        <!--  ****************************************

    		Content Body Start
		*********************************************-->



		  <!--**********************************
            Content body start
        ***********************************-->
<div class="content-body">

            <div class="container-fluid mt-3">
                <div class="row">
                    <div class="col-lg-3 col-sm-6">
                        <div class="card gradient-7">
                            <div class="card-body">
                                <img src="./images/b.png" width="200px" height="150px">
                                <div style="margin-top: 20px;">
                                    <center>
                                        <h3 style="color: azure; font-family: cursive;">
                                            <b>
                                                FASTER THAN EVER
                                            </b>
                                        </h3>
                                    </center>

                                </div>
                            </div>
                        </div>
                    </div>

                    <div class="col-lg-3 col-sm-6">
                        <div class="card gradient-3">
                            <div class="card-body">
                                <img src="./images/c.png" width="200px" height="150px">
                                <div style="margin-top: 20px;">

                                    <center>
                                        <h3 style="color: azure; font-family: cursive;">
                                            <b>
                                                MORE CONVINIENT
                                            </b>
                                        </h3>
                                    </center>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-3 col-sm-6">
                        <div class="card gradient-2">
                            <div class="card-body">
                                <img src="./images/d.png" width="200px" height="150px">
                                <div style="margin-top: 20px;">

                                    <center>
                                        <h3 style="color: azure; font-family: cursive;">
                                            <p>
                                                MORE SECURED THAN EVER
                                            </p>
                                        </h3>

                                    </center>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-3 col-sm-6">
                        <div class="card gradient-9">
                            <div class="card-body">
                                <img src="./images/f.png" width="150px" height="150px">
                                <div style="margin-top: 20px;">

                                    <center>
                                        <h3 style="color: azure; font-family: cursive;">
                                            <b>
                                                MULTIPLE PLATFORMS
                                            </b>
                                        </h3>
                                    </center>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-lg-12">
                        <div class="row">
                            <div class="col-12">
                                <div class="card">
                                    <div class="bodAbout1">
                                        <div style="float: left;">
                                            <img src="images/g.png" width="400px" style="margin-left: 50px;margin-top: 50px;" alt="LOGO">
                                        </div>
                                        <div>
                                            <center>
                                                <h1><b>WHO ARE WE?</b></h1>
                                            </center>
                                            <p>
                                                We are a boutique digital transformation consultancy and software development company that provides cutting edge engineering solutions, helping Fortune 500 companies and enterprise clients untangle complex issues that always emerge during their digital
                                                evolution journey. Since 2007 we have been a visionary and a reliable software engineering partner for world-class brands.
                                            </p>
                                            <p>
                                                Lorem ipsum dolor sit amet consectetur adipisicing elit. Vitae laboriosam, dicta ex sed perspiciatis nesciunt rem, soluta, quod debitis animi itaque fugiat placeat voluptate assumenda architecto minima aspernatur veritatis? Iusto!
                                            </p>
                                            <center>
                                                <h1><b>WHY CHOOSE US?</b></h1>
                                            </center>
                                            <UL>
                                                <li>We are a software operating since 2007</li>
                                                <li>We offer a variaty of services from Web application development and software development to online marketing</li>
                                                <li>We are a client forcused company with 100% user satisfaction</li>
                                                <li>More than 50,000 companies use software sollutions made by us</li>
                                            </UL>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>




                <div class="row" style="margin-top:80px ; margin-left: 10px; margin-right: 10px; margin-bottom: 100px;">
                    <div class="col-lg-3 col-sm-6">
                        <div class="box">

                            <div class="card gradient-9" style="box-shadow: 10px 5px 10px rgba(110, 107, 107, 0.548);">

                                <div class="card-body">
                                    <div class="text-center">
                                        <img src="./images/AV1.jpg" width="100px" class="rounded-circle" alt="">
                                        <h5 class="mt-3 mb-1">Lasal Hettiarachchi</h5>
                                        <p class="m-0">Developer</p>


                                        <p style="text-align: center">
                                            <b>"The only thing worse than being blind , is having sight but no vision."</b>
                                        </p>

                                        <div>


                                            <a href="https://www.facebook.com"><img id="fb" class="iconF" alt="Facebook" src="images/facebookA.png" onmouseout="this.src='images/facebookA.png'" onmouseover="this.src='images/facebookO.png'"></a>
                                            <a href="https://www.youtube.com"><img id="yt" class="iconF" alt="YouTube" src="images/youtubeA.png" onmouseover="this.src='images/youtubeO.png'" onmouseout="this.src='images/youtubeA.png'"></a>
                                            <a href="https://twitter.com"><img id="tw" class="iconF" alt="Twitter" src="images/twitterA.png" onmouseover="this.src='images/twitterO.png'" onmouseout="this.src='images/twitterA.png'"></a>
                                            <a href="https://www.instagram.com"><img id="in" class="iconF" alt="Instagram" src="images/instagramA.png" onmouseover="this.src='images/instagramO.png'" onmouseout="this.src='images/instagramA.png'"></a>

                                        </div>

                                        <!-- <a href="javascript:void()" class="btn btn-sm btn-warning">Send Message</a> -->
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-3 col-sm-6">
                        <div class="box">

                            <div class="card gradient-3" style="box-shadow: 10px 5px 10px rgba(110, 107, 107, 0.548);">
                                <div class="card-body">


                                    <div class="text-center">
                                        <img src="./images/AV2.jpg" width="100px" class="rounded-circle" alt="">
                                        <h5 class="mt-3 mb-1">Senura Jayadeva</h5>
                                        <p class="m-0">Developer</p>


                                        <p style="text-align: center">
                                            <b>"Time is the scarest resource and unless it is managed"</b>
                                        </p>

                                        <div>


                                            <a href="https://www.facebook.com"><img id="fb" class="iconF" alt="Facebook" src="images/facebookA.png" onmouseout="this.src='images/facebookA.png'" onmouseover="this.src='images/facebookO.png'"></a>
                                            <a href="https://www.youtube.com"><img id="yt" class="iconF" alt="YouTube" src="images/youtubeA.png" onmouseover="this.src='images/youtubeO.png'" onmouseout="this.src='images/youtubeA.png'"></a>
                                            <a href="https://twitter.com"><img id="tw" class="iconF" alt="Twitter" src="images/twitterA.png" onmouseover="this.src='images/twitterO.png'" onmouseout="this.src='images/twitterA.png'"></a>
                                            <a href="https://www.instagram.com"><img id="in" class="iconF" alt="Instagram" src="images/instagramA.png" onmouseover="this.src='images/instagramO.png'" onmouseout="this.src='images/instagramA.png'"></a>

                                        </div>

                                        <!-- <a href="javascript:void()" class="btn btn-sm btn-warning">Send Message</a> -->
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-3 col-sm-6">
                        <div class="box">

                            <div class="card gradient-9" style="box-shadow: 10px 5px 10px rgba(110, 107, 107, 0.548);">

                                <div class="card-body">
                                    <div class="text-center">
                                        <img src="./images/AV3.jpg" width="100px" class="rounded-circle" alt="">
                                        <h5 class="mt-3 mb-1">Dilmi Palliyaguruge</h5>
                                        <p class="m-0">Developer</p>


                                        <p style="text-align: center">
                                            <b>"The only thing worse than being blind , is having sight but no vision."</b>
                                        </p>

                                        <div>


                                            <a href="https://www.facebook.com"><img id="fb" class="iconF" alt="Facebook" src="images/facebookA.png" onmouseout="this.src='images/facebookA.png'" onmouseover="this.src='images/facebookO.png'"></a>
                                            <a href="https://www.youtube.com"><img id="yt" class="iconF" alt="YouTube" src="images/youtubeA.png" onmouseover="this.src='images/youtubeO.png'" onmouseout="this.src='images/youtubeA.png'"></a>
                                            <a href="https://twitter.com"><img id="tw" class="iconF" alt="Twitter" src="images/twitterA.png" onmouseover="this.src='images/twitterO.png'" onmouseout="this.src='images/twitterA.png'"></a>
                                            <a href="https://www.instagram.com"><img id="in" class="iconF" alt="Instagram" src="images/instagramA.png" onmouseover="this.src='images/instagramO.png'" onmouseout="this.src='images/instagramA.png'"></a>

                                        </div>

                                        <!-- <a href="javascript:void()" class="btn btn-sm btn-warning">Send Message</a> -->
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-3 col-sm-6">
                        <div class="box">

                            <div class="card gradient-3" style="box-shadow: 10px 5px 10px rgba(110, 107, 107, 0.548);">

                                <div class="card-body">
                                    <div class="text-center">
                                        <img src="./images/AV4.jpg" width="100px" class="rounded-circle" alt="">
                                        <h5 class="mt-3 mb-1">Ayodhya Bhanuka</h5>
                                        <p class="m-0">Developer</p>


                                        <p style="text-align: center">
                                            <b>"The only thing worse than being blind , is having sight but no vision."</b>
                                        </p>

                                        <div>


                                            <a href="https://www.facebook.com"><img id="fb" class="iconF" alt="Facebook" src="images/facebookA.png" onmouseout="this.src='images/facebookA.png'" onmouseover="this.src='images/facebookO.png'"></a>
                                            <a href="https://www.youtube.com"><img id="yt" class="iconF" alt="YouTube" src="images/youtubeA.png" onmouseover="this.src='images/youtubeO.png'" onmouseout="this.src='images/youtubeA.png'"></a>
                                            <a href="https://twitter.com"><img id="tw" class="iconF" alt="Twitter" src="images/twitterA.png" onmouseover="this.src='images/twitterO.png'" onmouseout="this.src='images/twitterA.png'"></a>
                                            <a href="https://www.instagram.com"><img id="in" class="iconF" alt="Instagram" src="images/instagramA.png" onmouseover="this.src='images/instagramO.png'" onmouseout="this.src='images/instagramA.png'"></a>

                                        </div>

                                        <!-- <a href="javascript:void()" class="btn btn-sm btn-warning">Send Message</a> -->
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                </div>



 		<%
 		InterfaceServicesReviewCustomer intersda =  new serviceDataReviewCustomer();
        %>
                <div class="row" style="margin-bottom: 100px;">
                    <div class="col-lg-12">
                        <div class="card gradient-2" style="    box-shadow: 10px 5px 10px rgba(110, 107, 107, 0.548);">
                            <div class="card-body">
                                <div class="active-member">
                                    <div class="table-responsive">
                                        <table class="table table-xs mb-0" style="color: black;">
                                            <thead>
                                                <h1>
                                                    <a style="color: black;">
                                                Customer reviews
                                                </a>
                                                </h1>
                                            </thead>
                                            <thead>
                                                <tr>
                                                    <th>#</th>
                                                    <th>Customers</th>
                                                    <th>Country</th>
                                                    <th>Review</th>
                                                    <th>Rating</th>
                                                </tr>
                                            </thead>
                                            <tbody>
                                             <%
                                            
                                             
                                            ArrayList<Review> revDetails = intersda.getReviewList();
                                            
                                            
                                            int i = 1;
            								for(Review rev : revDetails){

                                            %>
                                            
                                            
                                           <tr>
                                                <th scope="col"><%=i%></th>
                                        
                                                <th scope="col"><%=rev.getName()%></th>
                                                <th scope="col"><%=rev.getCountry()%></th>
                                                <th scope="col"><%=rev.getMessage()%></th>
                                                <th scope="col"><%=rev.getRating()%></th>
                                            	
                                            </tr>
                                            
                                            
                                            
                                            
                                            
                                            
                                            
                                            
                                            
                                            
                                            
                                            
                                            
                                            <%-- 
                                             <c:forEach  var = "rev" items="${reviewdtls}">
                                                <tr>
                                                
                                                    <td>${rev.Name}</td>
                                                    <td>
                                                        <span>${rev.Country}</span>
                                                    </td>
                                                    <td>${rev.message}</td>
                                                    <td>
                                                        <div>
                                                            <div class="progress" style="height: 6px">
                                                                <div class="progress-bar bg-success" style="width: 50%"></div>
                                                            </div>
                                                        </div>
                                                    </td>

                                                </tr>
                  								</c:forEach> --%>
                  							<%} %>
                                            </tbody>
                                        </table>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>



                <div class="row">
                    <div class="col-lg-12">
                        <div class="row">
                            <div class="col-12">
                                <div class="card">
                                    <div class="bodAbout1">
                                        <div style="float: left;">
                                            <img src="images/i.png" width="500px" style="margin-left: 50px;margin-top: 50px;" alt="LOGO">
                                        </div>
                                        <div>
                                            <center>

                                                <h1><b>Give us a review</b></h1>
                                                <div style="margin-top: 30px;">
                                                    <form method="POST" action="InsertReview" enctype='multipart/form-data'>
                                                        <input class="Contact_inputBox" type="text" id="name" placeholder="Name" name="name">
                                                        <p class="error"></p>
                                                        <input class="Contact_inputBox" type="text" id="country" placeholder="Country" name="Country">
                                                        <p class="error"></p>
                                                        <input class="Contact_inputBox" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.+[a-z].{2,}$" type="text" id="email" placeholder="Email" name="email">
                                                        <p class="error"></p>
                                                        <textarea class="Contact_inputBox" id="textArea_Message" type="text" placeholder="Message" name="message"></textarea>
                                                        <p class="error"></p>
                                                        <p>Rate our service</p>
                                                        <div style="background-color: #F50057;width: 350px;border-radius: 10px;">
                                                            <input class="Contact_inputBox" type="range" id="rating" placeholder="Rate between 0-5" min="0" max="5" name="rating">
                                                            <p class="error"></p>
                                                        </div>

                                                        <button class="Contact_bnSubmit" id="bnSubmit" type="submit" name="button">Submit</button>
                                                    </form>
                                                </div>

                                            </center>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
        </div>
        </div>
        <!--**********************************
            Content body end
        ***********************************-->
    

    
        <!--**********************************
            Content body end
        ***********************************-->
      <br><br>

		<!--**********************************
            Footer start
        ***********************************-->
		<div class="footer">
			<footer>
			<div class="foot">
				<div>
					<div class="allrights">
						<h3 id="Foot_copyright" style="display: inline">All Rights
							Reserved</h3>
						<img class="iconF1" src="images/footer/callBlue.png"
							style="display: inline">
						<p class="linkF" style="display: inline">01123423453</p>
						<img class="iconF1" src="images/footer/webBlue.png"
							style="display: inline">
						<p class="linkF" style="display: inline">www.mesh.lk</p>
						<img class="iconF1" src="images/footer/placeBlue.png"
							style="display: inline">
						<p class="linkF" style="display: inline">Malabe</p>
					</div>

				</div>

				<div>

					<div>

						<a href="https://www.facebook.com"><img id="fb" class="iconF"
							alt="Facebook" src="images/footer/facebook.png"
							onmouseout="this.src='images/footer/facebook.png'"
							onmouseover="this.src='images/footer/facebookO.png'"></a> <a
							href="https://www.youtube.com"><img id="yt" class="iconF"
							alt="YouTube" src="images/footer/youtube.png"
							onmouseover="this.src='images/footer/youtubeO.png'"
							onmouseout="this.src='images/footer/youtube.png'"></a> <a
							href="https://twitter.com"><img id="tw" class="iconF"
							alt="Twitter" src="images/footer/twitter.png"
							onmouseover="this.src='images/footer/twitterO.png'"
							onmouseout="this.src='images/footer/twitter.png'"></a> <a
							href="https://www.instagram.com"><img id="in" class="iconF"
							alt="Instagram" src="images/footer/instagram.png"
							onmouseover="this.src='images/footer/instagramO.png'"
							onmouseout="this.src='images/footer/instagram.png'"></a>
					</div>

				</div>


			</div>
			</footer>
		</div>
		<!--**********************************
            Footer end
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