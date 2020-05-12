<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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
<!--Google Icons-->
<link rel="stylesheet"
	href="https://fonts.googleapis.com/icon?family=Material+Icons">
	

<!-- Donut Chart Styles -->
<style>
#chartdiv {
  width: 100%;
  height: 380px;
}

</style> 

<!--Donut pie chart  Resources -->
<script src="https://www.amcharts.com/lib/4/core.js"></script>
<script src="https://www.amcharts.com/lib/4/charts.js"></script>
<script src="https://www.amcharts.com/lib/4/themes/material.js"></script>
<script src="https://www.amcharts.com/lib/4/themes/animated.js"></script>
      
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
							href="javascript:void(0)" class="log-user"> <i
								class="fa fa-user f-s-14" aria-hidden="true"></i><span>Sign Up</span>
						</a></li>

						<li class="icons dropdown d-none d-md-flex"><a
							href="javascript:void(0)" class="log-user"> <i
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
								<c:forEach  var = "cus" items="${customerDetails}">
								<img src="images/${cus.fileName}" height="40" width="40" alt="">
								</c:forEach>
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

			<div class="container-fluid mt-3">
				<div class="row">


				


					<div class="col-lg-3 col-sm-6">
						<a href="upload.jsp">
							<div class="card section1 gradient-1">
								<div class="card-body">
									<h3 class="card-title text-white">Upload Files</h3>
									<div class="d-inline-block">
										<h2 class="text-white">upload</h2>
										<p class="text-white mb-0">at maximum speed</p>
									</div>
									<span class="float-right display-5 opacity-5"><i
										class="fa fa-cloud-upload"></i></span>
								</div>
							</div>
						</a>
					</div>

					<div class="col-lg-3 col-sm-6">
						<a href="sharedStorage.jsp">
							<div class="card section1 gradient-2">
								<div class="card-body">
									<h3 class="card-title text-white">Shared Storage</h3>
									<div class="d-inline-block">
										<h2 class="text-white">single</h2>
										<p class="text-white mb-0">that is shared</p>
									</div>
									<span class="float-right display-5 opacity-5"><i
										class="fa fa-cloud"></i></span>
								</div>
							</div>
						</a>
					</div>

					<div class="col-lg-3 col-sm-6">
						<a href="EditUserDetails.jsp">
							<div class="card section1 gradient-3">
								<div class="card-body">
									<h3 class="card-title text-white">Edit Profile</h3>
									<div class="d-inline-block">
										<h2 class="text-white">Edit</h2>
										<p class="text-white mb-0">basic info</p>
									</div>
									<span class="float-right display-5 opacity-5"><i
										class="fa fa-users"></i></span>
								</div>
							</div>
						</a>
					</div>
					
						<div class="col-lg-3 col-sm-6">
						<a href="#">
							<div class="card section1 gradient-4">
								<div class="card-body">
									<h3 class="card-title text-white">Help</h3>
									<div class="d-inline-block">
										<h2 class="text-white">Questions ?</h2>
										<p class="text-white mb-0">Chat with Us</p>
									</div>
									<span class="float-right display-5 opacity-5"><i
										class="fa fa-question-circle"></i></span>
								</div>
							</div>
						</a>
					</div>
					

				</div>
				
				
				<!-- *******************************************************************
				
									PIE CHART JAVA SCRIPT
		             ****************************************************************** -->
		            
		             
					<!-- Chart code -->
					<script>
					am4core.ready(function() {

				    // Themes begin
					am4core.useTheme(am4themes_material);
					am4core.useTheme(am4themes_animated);
					// Themes end

					var chart = am4core.create("chartdiv", am4charts.PieChart3D);
					chart.hiddenState.properties.opacity = 0; // this creates initial fade-in

					chart.legend = new am4charts.Legend();

					chart.data = [
  					{
	  					FileType: "Audio",
	 					count: ${audioDetails.size()}
  					},
  					{
	 					FileType: "Video",
	  					count: ${videoDetails.size()}
  					},
  					{
	  					FileType: "Image",
	  					count: ${photoDetails.size()}
  					},
  					{
	  					FileType: "Document",
	  					count: ${documentDetails.size()}
  					}

					];

					chart.innerRadius = 80;

					var series = chart.series.push(new am4charts.PieSeries3D());
					series.dataFields.value = "count";
					series.dataFields.category = "FileType";

					}); // end am4core.ready()
					</script>


				<!--End of  Pie Char  JAVA SCRIPT -->
			 

				<!--*****************************
                        End of 1st Section
                    *****************************-->
				
				
				


				<div class="row">
				
						<!-- *******************************************************************
				
									PIE CHART 
		             ****************************************************************** -->
				
					<div class="col-lg-8 col-md-6">
						<div class="card card-widget">
							<div class="card-body">
								<h5 class="text-muted">Storage Overview</h5>
									<span>Create, collaborate, and organize all your work in
									one place</span>
								
				  					<!-- HTML -->
									<div id="chartdiv"></div>
     			 
     			 			</div>
     					 </div>
     			 	</div>
     			 	
     			 	<!--End of  Pie Char  -->
	
					<div class="col-lg-4 col-md-6">
						<div class="card card-widget">
							<div class="card-body">
								<h5 class="text-muted">Remaining Storage Overview</h5>

								<span>Create, collaborate, and organize all your work in
									one place</span>
			     

								<!--  **********************************************
                                           Image Storage Details
                                           ********************************************** -->

										
								<c:forEach  var = "pic" items="${photoDetails}" varStatus="status">
								
								</c:forEach>
							

								<div class="mt-4">
									<h4>${photoDetails.size()}
										out of 12
									</h4>
									<h6>
										Image <span class="pull-right"><fmt:formatNumber value="${photoDetails.size() / 12 * 100}" minFractionDigits="0" maxFractionDigits="0"/>%</span>
									</h6>
									<div class="progress mb-3" style="height: 7px">
										<div class="progress-bar bg-primary"
											style="width:${photoDetails.size() / 12 * 100}% " role="progressbar">
											<span class="sr-only">30% Order</span>
										</div>
									</div>
								</div>
							

								

								<!-- *****************************************************************
                               
                               		End of image storage details
                               		********************************************************************* -->


								<!--  **********************************************
                                           Document Storage Details
                                           ********************************************** -->

								<c:forEach  var = "doc" items="${documentDetails}" varStatus="status">
									
								</c:forEach>
							

								<div class="mt-4">
									<h4>${documentDetails.size()}
										out of 12
									</h4>
									<h6>
										Document <span class="pull-right"><fmt:formatNumber value="${documentDetails.size() / 12 * 100}" minFractionDigits="0" maxFractionDigits="0"/>%</span>
									</h6>
									<div class="progress mb-3" style="height: 7px">
										<div class="progress-bar bg-success"
											style="width:${documentDetails.size() / 12 * 100}% " role="progressbar">
											<span class="sr-only">30% Order</span>
										</div>
									</div>
								</div>
							


				

								<!-- *****************************************************************
                               
                               		End of Document storage details
                               		********************************************************************* -->







								<!--  **********************************************
                                            audio Details
                                           ********************************************** -->

								<c:forEach  var = "aud" items="${audioDetails}" varStatus="status">
										
								</c:forEach>
							

								<div class="mt-4">
									<h4>${audioDetails.size()}
										out of 12
									</h4>
									<h6>
										Audio <span class="pull-right"><fmt:formatNumber value="${audioDetails.size() / 12 * 100}" minFractionDigits="0" maxFractionDigits="0"/>%</span>
									</h6>
									<div class="progress mb-3" style="height: 7px">
										<div class="progress-bar bg-success"
											style="width:${audioDetails.size() / 12 * 100}% " role="progressbar">
											<span class="sr-only">30% Order</span>
										</div>
									</div>
								</div>
								
									
								<!-- *****************************************************************
                               
                               		End of audio storage details
                               		********************************************************************* -->




								<!--  **********************************************
                                            Video Details
                                           ********************************************** -->
									<c:forEach  var = "aud" items="${videoDetails}" varStatus="status">
									
								</c:forEach>
							

								<div class="mt-4">
									<h4>${videoDetails.size()}
										out of 12
									</h4>
									<h6>
										Video <span class="pull-right"><fmt:formatNumber value="${videoDetails.size() / 12 * 100}" minFractionDigits="0" maxFractionDigits="0"/>%</span>
									</h6>
									<div class="progress mb-3" style="height: 7px">
										<div class="progress-bar bg-warning"
											style="width:${videoDetails.size() / 12 * 100}% " role="progressbar">
											<span class="sr-only">30% Order</span>
										</div>
									</div>
								</div>

							

								<!-- *****************************************************************
                               
                               		End of Video storage details
                               		********************************************************************* -->




							</div>
						</div>

					</div>


				</div>

				<!--******************************************
                    Images File
                **********************************************-->

				<h1>Images</h1>
				<hr>
				<div class="row">

							<c:forEach  var = "pic" items="${photoDetails}">

					<div class="col-lg-4 col-sm-6">
						<div class="card">
							<div class="card-body">
								<div class="text-center">
								
								
								   
								   <img src ="Storage/${pic.filename}" height="250" width="220">
						

									<h5 class="mt-3 mb-1">${pic.name}</h5>
									<p class="m-0">${pic.description}</p>
									<br> <a href="sharePhotosFile.jsp?photoID=${pic.photoID}" class="btn btn-sm btn-outline-success">Share</a> 
									<a href="updatePhoto.jsp?photoID=${pic.photoID}" class="btn btn-sm btn-outline-warning">Update</a> 
									<a  href="deletePhotos?photoID=${pic.photoID}&userID=${pic.userID}&fileName=${pic.filename}" class="btn btn-sm btn-outline-danger">Delete</a> 
									<a href="downloadAudio?fileName=${pic.filename}" class="btn btn-sm btn-outline-primary">Download</a>
									
									
								
									
								</div>
							</div>
						</div>
					</div>

				</c:forEach>



				</div>

				<!--******************************************************
                        End of Images File
                    **************************************************-->

		

				
				<!--******************************************************
                        Document File
                    **************************************************-->

				<h1>Documents</h1>
				<hr>

				<div class="row">
				<c:forEach  var = "doc" items="${documentDetails}">
					<div class="col-lg-4 col-sm-6">
						<div class="card">
							<div class="card-body">
								<div class="text-center">

									<iframe src="Storage/${doc.filename}" height="300" width="220"></iframe>

									<h5 class="mt-3 mb-1">${doc.name}</h5>
									<p class="m-0">${doc.description}</p>
									<a href="shareDocument.jsp?docID=${doc.docId}"  class="btn btn-sm btn-outline-success">Share</a>
									<a href="updateDocument.jsp?docID=${doc.docId}" class="btn btn-sm btn-outline-warning">Update</a> 
									<a href="deleteDocument?docId=${doc.docId}"  class="btn btn-sm btn-outline-danger">Delete</a> 
									<a href="downloadAudio?fileName=${doc.filename}" class="btn btn-sm btn-outline-primary">Download</a>
								</div>
							</div>
						</div>
					</div>
				</c:forEach>
					
				</div>
				
				<!--*****************************************
                    End of Document File
                ******************************************-->

				<!--***************************************
                    Audio Files
                ******************************************-->

				
				<h1>Audio</h1>
				<hr>



				<div class="row">
				
				<c:forEach  var = "aud" items="${audioDetails}">

					<div class="col-lg-4 col-sm-6">
						<div class="card">
							<div class="card-body">
								<div class="text-center">

									<audio controls style="width: 300px;"> <source
										src="Storage/${aud.filename}"
										type="audio/ogg"> <source
										src="Storage/<${aud.filename}"
										type="audio/mpeg"></audio>

									<h5 class="mt-3 mb-1">${aud.name}</h5>
									<p class="m-0">${aud.description}</p>
									<br> <a href="shareAudioFile.jsp?audioID=${aud.audioID}" class="btn btn-sm btn-outline-success">Share</a> 
									<a href="updateAudio.jsp?audioID=${aud.audioID}" class="btn btn-sm btn-outline-warning">Update</a> 
									<a  href="deleteAudio?audioID=${aud.audioID}&userID=${aud.userID}&fileName=${aud.filename}" class="btn btn-sm btn-outline-danger">Delete</a> 
									<a href="downloadAudio?fileName=${aud.filename}" class="btn btn-sm btn-outline-primary">Download</a>
									
									
								
									
								</div>
							</div>
						</div>
					</div>

				</c:forEach>



				</div>

				<!--*********************************************
                        End of audio files
                    ***********************************************-->

				<!--***************************************
                      video Files
                     ******************************************-->
				<h1>Video</h1>
				<hr>

				<div class="row">

				<c:forEach  var = "vid" items="${videoDetails}">

					<div class="col-lg-4 col-sm-6">
						<div class="card">
							<div class="card-body">
								<div class="text-center">

									<video controls style="width: 300px;"> <source
										src="Storage/${vid.filename}"
										type="audio/ogg"> <source
										src="Storage/<${aud.filename}"
										type="audio/mpeg"></video>

									<h5 class="mt-3 mb-1">${vid.name}</h5>
									<p class="m-0">${vid.description}</p>
									<br> <a href="shareVideoFile.jsp?videoID=${vid.videoID}" class="btn btn-sm btn-outline-success">Share</a> 
									<a href="updateVideo.jsp?videoID=${vid.videoID}" class="btn btn-sm btn-outline-warning">Update</a> 
									<a  href="deleteVideo?videoID=${vid.videoID}&userID=${vid.userID}&fileName=${vid.filename}" class="btn btn-sm btn-outline-danger">Delete</a> 
									<a href="downloadAudio?fileName=${vid.filename}" class="btn btn-sm btn-outline-primary">Download</a>
									
									
								
									
								</div>
							</div>
						</div>
					</div>

				</c:forEach>



				</div>

				<!--*********************************************
                    End of Video files
                ***********************************************-->
                
                <hr>
					<!-- ************************************************************************
				      Share Files
				     ************************************************************************** -->
					
		
				<div class="row">
					<div class="col-lg-12">
						<div class="card">
							<div class="card-body">
							<h4 class="card-title">Shared Files</h4>
								<div class="active-member">
									<div class="table-responsive">
										<table class="table table-xs mb-0">
											<thead>
												<tr>
													<th>Sender</th>
													<th>Title</th>
													<th>Description</th>
													<th>File Name</th>
												
												</tr>
											</thead>
											<tbody>



												<c:forEach  var = "sf" items="${shareFileDetails}">

												<tr>
													<td><img
														src="images/${sf.senderImagePath}"
														class=" rounded-circle mr-3" alt="">${sf.senderUserID}</td>
													<td>${sf.name}</td>
													<td><span>${sf.description}</span>
													</td>
													<td><span>${sf.filename}</span>
													</td>

													<td>
														<a href="downloadAudio?fileName=${sf.filename}">
														<button class="btn btn-primary">
															<span>Download</span>
														</button>
														</a>
														
													</td>
												</tr>
												
												
												</c:forEach>



											</tbody>
										</table>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				
				<!-- ************************************************************************
				     End of Share Files
				     ************************************************************************** -->
     
		
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