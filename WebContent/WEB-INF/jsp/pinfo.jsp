<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>How I Look - My Profile</title>
	
	<!-- Bootstrap core CSS -->
	<!--link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet"-->
   	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap337.min.css">
   	<!-- specific -->
   	
   	<link href="${pageContext.request.contextPath}/css/grid.css" rel="stylesheet">
   	<link href="${pageContext.request.contextPath}/css/profile.css" rel="stylesheet">
   	
   	<meta name="viewport" content="width=device-width, initial-scale=1">
 		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap337.min.css">
   	
   	<!-- Side navigation menu -->
   	<link href="${pageContext.request.contextPath}/css/sidnavpush.css" rel="stylesheet">
	
	<!-- for responsive tabs -->
	<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/bootstrap337.min.js"></script>
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/actions.js"></script>
	
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/jquery-ui.css">
	<script src="${pageContext.request.contextPath}/js/jquery-1.12.4.js"></script>
 	<script src="${pageContext.request.contextPath}/js/jquery-ui.js"></script>
 	<script src="${pageContext.request.contextPath}/js/checkFileType.js"></script>
</head>
<body>
	<% response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");%>
	<% if(session.getAttribute("username")==null) response.sendRedirect("/HappyLife");%>
	<header>
		<!-- Fixed navbar -->
		<nav class="navbar navbar-inverse navbar-fixed-top">
			<div class="container">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#navbar" aria-expanded="false"
						aria-controls="navbar">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
					<a class="navbar-brand" href="javascript:void(0)"
						style="cursor: pointer;" id="nav_title" onclick="openNav()">&#9776;
						Happy Life</a>
				</div>
				<div id="navbar" class="navbar-collapse collapse">
					<ul class="nav navbar-nav navbar-right">
						<li><a>welcome ${username}</a></li>
						<li class="active"><a href="${pageContext.request.contextPath}/logout">Logout</a></li>
					</ul>
				</div>
				<!--/.nav-collapse -->
			</div>
		</nav>
	</header>
	
	<div id="mySidenav" class="sidenav">
		<a href="/HappyLife/myinbox">Inbox</a>
		<a href="#">Sent</a>
		<a href="#">Search</a>
		<a href="#">My Favorites</a>
	</div>

	<br>
	<br>

	<br>
	<br>
	<div class="container">
		<ul class="nav nav-tabs">
			<li><a href="/HappyLife/myprofile">Home</a></li>
			<li class="active"><a href="/HappyLife/pinfo">My Profile</a></li>
			<li><a href="/HappyLife/search">Search</a></li>
			<li><a href="#menu3">Marriage Advice</a></li>
		</ul>

		<div class="tab-content">

			<!-- home tab -->

			<div id="howilook" class="tab-pane fade in active">
				<br>
				<p>edit</p>
				<ul class="nav nav-pills updateProfile">
					<li><a href="${pageContext.request.contextPath}/aboutme&lookingfor">About Me / Looking for</a></li>
					<li><a>My Photo <form action="uploadphoto" method="post" enctype="multipart/form-data">
										<input type="file" id="uploadFile" name="photo" multiple>
										<input type="submit" name="save" onclick="CheckFileName();">
									</form></a></li>
					<li><a href="#myQuestions">My Questions</a></li>
				</ul>
				<hr>
				<p>How others see me</p>

				<br>
				<div id="user-block" class="grid-container container">
					<div class="row">
						<div class="profile-image col-xs-12 col-md-2">
							<div>
								<!-- src="http://placehold.it/119/00F/FFF" -->
								<p>
									<a id="mainfullimage" href="http://placehold.it/400/00F/FFF">
										<img src="${pageContext.request.contextPath}/publicphotos/${publicPhoto}" alt="click to see larger photo"
										title="click to see larger photo">
									</a>
								</p>
								<p>
									<a href="#createphotoprofilepage"><button>Change Photo</button></a>
								</p>
							</div>
							<!-- <div><p><a href="#createphotoprofilepage"><button>Change Photo</button></a></p></div> -->
						</div>

						<div class="item3 col-xs-12 col-md-5">
							<ul class="summary">
								<li><label>Age: ${myAge}</label></li>
								<li><label>Location:</label></li>
								<li><label>Last Login: now</label></li>
								<li><label>I am currently available for communication:</label></li>
								<li><label>Message response rate:</label></li>
							</ul>
						</div>
						<div class="item4 col-xs-12 col-md-5">
							<ul class="primary">
								<li id="morelikeli"><a href="#prfprofile.php">More like ${username}</a></li>
								<li id="messagetoli"><a href="#purematches.php">send them a message </a></li>
								<li id="addfavli"><a href="#bestmatch.php">Add them to My Favourites</a></li>
								<li id="inviteli"><a href="#lookingforme.php">Invite them to view my profile</a></li>
								<li id="myfavli"><a href="#favourites.php">Your notes on them</a></li>
								<li id="historyli"><a href="" target="_blank">Your history with them</a></li>
								<li id="dontshowmeli"><a href="" target="_blank">Don't show me again</a></li>
								<li id="blockedli"><a href="" target="_blank">Block them</a></li>
							</ul>
						</div>
					</div>
					<!-- END .row -->
				</div>
				<!-- user-block -->
				<br>
				
				<form action="${pageContext.request.contextPath}/aboutme&lookingfor" method="POST">
				<div id="" class="grid-container">
					<!-- <h3 class="">Profile</h3> -->
					<table class="table table-dark">
						<tbody>
							<tr>
								<th class="col-md-4">Profile</th>
							</tr>
							<tr>
								<th><c:if test="${not empty aboutMeInfo}">
									<p>${aboutMeInfo}</p>
								</c:if></th>
							</tr>
							
						</tbody>
					</table>
					
      				<table class="table table-dark">
	      				<tbody>
		      				<tr>
      							<th class="col-md-3">Profile Basics</th>
	      						<th class="col-md-3">Lifestyle / Current Status</th>
			      			</tr>
			      			<tr>
			      				<td class="col-md-3">Profile posted by: ${sessionUser.profilePostedBy}</td>
			      				<td class="col-md-3">Pray: 
			      					<c:choose>
										<c:when test="${sessionUser.pray=='5'}">Always Pray </c:when>
										<c:when test="${sessionUser.pray=='4'}">Sometimes miss Fajr and make Qadah</c:when>
										<c:when test="${sessionUser.pray=='3'}">Rarely miss a prayer and make Qadah</c:when>
										<c:when test="${sessionUser.pray=='2'}">Sometimes Pray</c:when>
										<c:when test="${sessionUser.pray=='1'}">Intend to start praying</c:when>
    								</c:choose>
								</td>
			      			</tr>
			      			<tr>
			      				<td class="col-md-3">Residency Status: ${sessionUser.residencyStatus}</td>
			      				<td class="col-md-3">Sect: ${sessionUser.sect}</td>
			      			</tr>
			      			<tr>
			      				<td class="col-md-3">Are you Willing to relocate: </td>
			      				<td class="col-md-3">Marital Status: 
			      					<c:choose>
										<c:when test="${sessionUser.maritalStatus=='NM'}">Never Married</c:when>
										<c:otherwise>${sessionUser.maritalStatus}</c:otherwise>
    								</c:choose>
			      				</td>
			      			</tr>
			      			<tr>
			      				<td class="col-md-3">Ethnic Origin: ${sessionUser.ethnicOrigin}</td>
			      				<td class="col-md-3">Children: ${sessionUser.children}</td>
			      			</tr>
			      			<tr>
			      				<td class="col-md-3">My Religious History: 
			      					<c:choose><c:when test="${sessionUser.religiousHistory=='dontmind'}">
									        		don't mind
									          </c:when>
									          <c:when test="${sessionUser.religiousHistory=='BM'}">
									        		Muslim since Birth
									          </c:when>
											  <c:otherwise> Revert Muslim </c:otherwise>
    								</c:choose>
    							</td>
			      				<td class="col-md-3">Physical Disability: </td>
			      			</tr>
			      			<tr>
			      				<td class="col-md-3"></td>
			      				<td class="col-md-3">Like to have children: ${sessionUser.likeToHaveChildren}</td>
			      			</tr>
			      			<tr>
			      				<td class="col-md-3"></td>
			      				<td class="col-md-3">Polygamy: </td>
			      			</tr>
			      			<tr>
			      				<th class="col-md-3">Appearance </th>
			      				<td class="col-md-3">Languages: ${sessionuser.languages}</td>
			      			</tr>
			      			<tr>
			      				<td class="col-md-3">Hair Color: ${sessionUser.hairColor}</td>
			      				<th class="col-md-3">Education/Career</th>
			      			</tr>
			      			<tr>
			      				<td class="col-md-3">Body Type: ${sessionUser.bodyType}</td>
			      				<td class="col-md-3">Profession: ${sessionuser.profession}</td>
			      			</tr>
			      			<tr>
			      				<td class="col-md-3">Height: ${sessionUser.height}</td>
			      				<td class="col-md-3">Highest Qualification: ${sessionuser.highestQual}</td>
			      			</tr>
			      			<tr>
			      				<td class="col-md-3">
			      					<c:if test="${sessionUser.gender=='M'}">
										Beard: ${sessionUser.hijabBeard}
									</c:if>
									<c:if test="${sessionUser.gender=='F'}"> Hijab: 
										<c:choose>
											<c:when test="${sessionUser.hijabBeard=='withniqab'}">Always with Niqab </c:when>
											<c:when test="${sessionUser.hijabBeard=='dontmind'}">don't mind</c:when>
											<c:otherwise>Always</c:otherwise>
	    								</c:choose>
									</c:if>
			      				</td>
			      				<td class="col-md-3"></td>
			      			</tr>
		      			</tbody>
	      			</table>
				</div>

				<br>
				<div id="" class="grid-container">
					<!-- <h3 class="">Looking For</h3> -->
					<table class="table table-dark">
						<tbody>
							<tr>
								<th class="col-md-4">Looking For</th>
							</tr>
							<tr>
								<th><c:if test="${not empty sessionLookingFor.lookingFor}">
									<p>${lookingForInfo}</p>
								</c:if></th>
							</tr>
							
						</tbody>
					</table>
					<table class="table table-dark">
	      				<tbody>
		      				<tr>
      							<th class="col-md-3">Looking In: ${sessionLookingFor.lookingIn}</th>
	      						<th class="col-md-3">Age: from ${sessionLookingFor.ageL} to ${sessionLookingFor.ageH}</th>
			      			</tr>
			      			<tr>
			      				<th class="col-md-3">Profile Basics</th>
			      				<th class="col-md-3">Lifestyle / Current status</th>
			      			</tr>
			      			<tr>
								<td class="col-md-3">Residency Status: 
									<c:choose>
										<c:when test="${sessionLookingFor.residencyStatus=='dontmind'}">don't mind</c:when>
										<c:when test="${sessionLookingFor.residencyStatus=='dc'}">Definitely Consider </c:when>
										<c:when test="${sessionLookingFor.residencyStatus=='mc'}">May Consider</c:when>
										<c:when test="${sessionLookingFor.residencyStatus=='wc'}">Would not Consider</c:when>
    								</c:choose>
								</td>
								<td class="col-md-3"> Pray: 
									<c:choose>
										<c:when test="${sessionLookingFor.pray=='dontmind'}">don't mind</c:when>
										<c:when test="${sessionLookingFor.pray=='AP'}">Always Pray </c:when>
										<c:when test="${sessionLookingFor.pray=='smissfajr'}">Sometimes miss Fajr and make Qadah</c:when>
										<c:when test="${sessionLookingFor.pray=='rmissprayer'}">Rarely miss a prayer and make Qadah</c:when>
    								</c:choose>
								</td>
			      			</tr>
			      			<tr>
			      				<td class="col-md-3">Are you Willing to relocate: 
			      					<c:choose>
										<c:when test="${sessionLookingFor.willingToRelocate=='dontmind'}">don't mind</c:when>
										<c:when test="${sessionLookingFor.willingToRelocate=='Yes'}">Yes</c:when>
										<c:when test="${sessionLookingFor.willingToRelocate=='No'}">No</c:when>
    								</c:choose>
			      				</td>
			      				<td class="col-md-3">What sect you wish to marry from: ${sessionLookingFor.sect}</td>
			      			</tr>
			      			<tr>
								<td class="col-md-3">Ethnic Origin: ${sessionLookingFor.ethnicOrigin}</td>
								<td class="col-md-3">Marital Status: 
									<c:choose>
										<c:when test="${sessionLookingFor.maritalStatus=='NM'}">Never Married</c:when>
										<c:otherwise>${sessionLookingFor.maritalStatus}</c:otherwise>
    								</c:choose>
								</td>
			      			</tr>
			      			<tr>
			      				<td class="col-md-3">Candidate Religious History: 
			      					<c:choose><c:when test="${sessionLookingFor.religiousHistory=='dontmind'}">
									        		don't mind
									          </c:when>
									          <c:when test="${sessionLookingFor.religiousHistory=='BM'}">
									        		Muslim since Birth
									          </c:when>
											  <c:otherwise> Revert Muslim </c:otherwise>
    								</c:choose>
    							</td>
			      				<td class="col-md-3">Has Children: ${sessionLookingFor.hasChildren}</td>
			      			</tr>
			      			<tr>
			      				<td class="col-md-3">Living with in-laws: 
			      					<c:choose><c:when test="${sessionLookingFor.livingWithInLaws=='dontmind'}">
									        		don't mind
									          </c:when>
									          <c:when test="${sessionLookingFor.livingWithInLaws=='dc'}">
									        		Definitely Consider
									          </c:when>
									          <c:when test="${sessionLookingFor.livingWithInLaws=='mc'}">
									        		May Consider
									          </c:when>
											  <c:otherwise>Would not Consider </c:otherwise>
    								</c:choose>
			      				</td>
			      				<td class="col-md-3">Has physical disability: ${sessionLookingFor.hasPDisability}</td>
			      			</tr>
			      			<tr>
			      				<td class="col-md-3"></td>
			      				<td class="col-md-3">Like to have children: ${sessionLookingFor.likeToHaveChildren}</td>
			      			</tr>
			      			<tr>
			      				<td class="col-md-3"></td>
			      				<td class="col-md-3">Polygamy: </td>
			      			</tr>
			      			<tr>
			      				<th class="col-md-3">Appearance </th>
			      				<th class="col-md-3">Education/Career</th>
			      			</tr>
			      			<tr>
			      				<td class="col-md-3">Body type: ${sessionLookingFor.bodyType}</td>
			      				<td class="col-md-3">Profession: ${sessionLookingFor.profession}</td>
			      			</tr>
			      			<tr>
			      				<td class="col-md-3">
									<c:if test="${sessionUser.gender=='F'}">
										Beard: ${sessionLookingFor.hijabBeard}
									</c:if>
									<c:if test="${sessionUser.gender=='M'}"> Hijab: 
										<c:choose>
											<c:when test="${sessionLookingFor.hijabBeard=='withniqab'}">Always with Niqab </c:when>
											<c:when test="${sessionLookingFor.hijabBeard=='dontmind'}">don't mind</c:when>
											<c:otherwise>Always</c:otherwise>
	    								</c:choose>
									</c:if>
								</td>
			      				<td class="col-md-3">Minimum Qualification: ${sessionLookingFor.minimumQual}</td>
			      			</tr>
			      			<tr>
			      				<td class="col-md-3">
			      					Height: from ${sessionLookingFor.heightL} to${sessionLookingFor.heightH} 
			      				</td>
			      				<td class="col-md-3"></td>
			      			</tr>
		      			</tbody>
	      			</table>
				</div>
				</form>
				<br>
			</div>


		</div>

	</div>
	<!-- container -->


	<script type="text/javascript" src="${pageContext.request.contextPath}/js/actions.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/opennav.js"></script>
	
</body>
</html>