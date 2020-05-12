<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

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
    <script>
        var a = 0;
        function readMore(){
            if(a == 0){
                document.getElementById("Contact_readMore").style.display = "inline";
                document.getElementById("Contact_bnFAQ").innerHTML="Read Less";
                a=1;
            }
            else{
                document.getElementById("Contact_readMore").style.display="none";
                document.getElementById("Contact_bnFAQ").innerHTML="Read More";

                a=0;
            }
        }

        function enablebutton(){
            if(document.getElementById("btn1").click)
            {
                alert("Open the call app!");
                return true;
            }
        }

    </script>
</head>
<body>

 
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
										<li><a href="userProfile.jsp"><i class="icon-user"></i>
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
            <center>
            <h1>Get in touch</h1>
                <p>Want to get in touch? We'd love to hear from you.Here's how you can reach us...</p>
            </center>
            <div class="container-fluid">
                <div class="row">
                    <div class="col">
                        <div class="card">
                            <div class="card-body">
                               <center> <h3><font face="Calibri">Talk to Sales</font></h3></center>
                                <p>Interested in Neon software? Just pick up the phone to chat with a member of our sales team.</p>
                                <center><input type="button" id="btn1" class="button1" onclick="enablebutton()" value="Make a call"></center>
                            </div>
                        </div>
                    </div>
                    <div class="col">
                        <div class="card">
                            <div class="card-body">
                                <center><h3><font face="Calibri">Contact Customer Support</font></h3></center>
                                <p>Sometimes you need a little help from your friends or a Neon support rep. Don't worry...we're here for you.</p>
                                <center><a href="form1.jsp"><input type="button" class ="button1" id="btn2" value="Get support"></a></center>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="container-fluid">
                <div class="row">
                    <div class="col">
                        <div class="card">
                            <div class="card-body">
                                <p align ="left" class ="Contact_faqTitle">FAQ...</p><br>
                                <p class="Contact_faq" align="left">
                                    1) How can I view the profile?<br>
                                     You have to enter your username and password to login to the website.Then you can go User Profile.<br><br>
                                    2) How can I download the files?<br>
                                    Go to user profile.Click on the relavant file and click download.<br><br>

                                    <span id="Contact_readMore" style="display:inline">
                                        3) Can we share files upto 100MB?<br>
                                        No, the maximum size you can share is 50MB.<br><br>
                                        4) Can we update our details after registering to the site?<br>
                                        Yes, you can update the details from the user profile.<br><br>
                                        5) Can we see other user's profile?<br>
                                        No, you cannot.But you can view the files you have shared with the other user.<br><br>

                                    </span>
                                </p>
                                <button onclick="readMore()" id="Contact_bnFAQ" class="button1">Read Less</button>
                           
                                </p>
                                
                            </div>
                        </div>
                    </div>
                    <img src="images/contact-us1.png" width=450px height=535px>
             
             </div>
             </div>
            <!-- #/ container -->
        </div>
        <!--**********************************
            Content body end
        ***********************************-->
 
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