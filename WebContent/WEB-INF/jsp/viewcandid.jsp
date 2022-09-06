<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.happylife.pojo.User, com.happylife.DoMath"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>View Profile</title>
	
	<!-- Bootstrap core CSS -->
	<!--link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet"-->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap337.min.css">
	<!-- specific -->
	
	<link href="${pageContext.request.contextPath}/css/grid.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/css/profile.css" rel="stylesheet">
	
	<meta name="viewport" content="width=device-width, initial-scale=1">
	
	<!-- Side navigation menu -->
	<link href="${pageContext.request.contextPath}/css/sidnavpush.css" rel="stylesheet">
	
	<!-- for responsive tabs -->
	<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/bootstrap337.min.js"></script>
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/actions.js"></script>
	
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/jquery-ui.css">
	<script src="${pageContext.request.contextPath}/js/jquery-1.12.4.js"></script>
	<script src="${pageContext.request.contextPath}/js/jquery-ui.js"></script>
	
	<script type="text/javascript" src="http://code.jquery.com/jquery-latest.min.js"></script>
	<script>
			function add2fav(id){
				var boolAdded = false;
				id =id.split("_")[1];
				
				$.ajax({
					url : "${pageContext.request.contextPath}/add2fav",
					type : "get",
					data : "candid="+id,
					
					success: alert("Profile added to my favorites Successfully."),
					error: function(error){
						alert("Some issue");
					}
				});
			}
		</script>
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
		<a href="#">Contact</a>
	</div>
	
	<br>
	<br>
		
	<br><br>
	<div class="container">
		<ul class="nav nav-tabs">
			<li><a href="/HappyLife/myprofile">Home</a></li>
			<li><a href="/HappyLife/pinfo">My Profile</a></li>
			<li><a href="/HappyLife/search">Search</a></li>
			<li><a href="#menu3">Marriage Advice</a></li>
		</ul>
		<%User candidate = (User) request.getAttribute("candidate"); %>
		<div class="tab-content">
			<div id="home" class="tab-pane fade in active">
				<div id="user-block" class="grid-container container">
					<div class="row">
						<div class="profile-image col-xs-12 col-md-2">
							<div>
								<!-- src="http://placehold.it/119/00F/FFF" -->
								<p>
									<a id="mainfullimage" href="http://placehold.it/400/00F/FFF"><img
										src="${pageContext.request.contextPath}/publicphotos/<%=candidate.getPublicPhoto() %>.JPG"
										alt="click to see larger photo"
										title="click to see larger photo"></a>
								</p>No of Photo uploaded<p>
								</p>
							</div>
							<!-- <div><p><a href="#createphotoprofilepage"><button>Change Photo</button></a></p></div> -->
						</div>
						<% DoMath doM = new DoMath(); %>
						<div class="item3 col-xs-12 col-md-5">
							<ul class="summary">
								<li><label>Username: <%=candidate.getUsername() %></label></li>
								<li><label>Age: <%=doM.getAge(candidate.getDob()) %></label></li>
								<li><label>Location: ${candidate.lookingIn}</label></li>
								<li><label>Last Login: ${candidLastLogin}</label></li>
							</ul>
						</div>
						<div class="item4 col-xs-12 col-md-5">
							<ul class="primary">
								<li id="morelikeli"><a href="/HappyLife/morelike?=<%=candidate.getUserId()%>">More Like <%=candidate.getUsername() %></a></li>
								<li id="messagetoli"><a href="/HappyLife/sendmessageto?=<%=candidate.getUserId()%>">Send a message </a></li>
								<li id="deladdfavli"><a id="addfav_${candidate.userId}" onclick="add2fav(this.id)">
									<c:choose>
										<c:when test="${foundInMyFavList=='No'}">Add to My Favourites</c:when>
										<c:when test="${foundInMyFavList=='Yes'}">Remove from My Favourites</c:when>
										
    								</c:choose>
								</a></li>
								<li id="photoli"><a href="#lookingforme.php">Ask to exchange Photos</a></li>
								<li id="nudgeli"><a href="#favourites.php">Invite to view my Profile</a></li>
								<li id="yournotesli"><a href="#favourites.php">Your notes on them</a></li>
								<li id="historyli"><a href="#favourites.php">Your history with them</a></li>
								<li id="dontshowmeli"><a href="#favourites.php">Don't show me again</a></li>
								<li id="blockedli"><a href="" target="_blank">Block <%=candidate.getUsername() %></a></li>
							</ul>
						</div>
					</div>
					<!-- END .row -->
				</div>
				<!-- user-block -->
				<br>
				<div id="myIdeal" class="grid-container">
					
					<table class="table table-dark">
						<tbody>
							<tr>
								<th class="col-md-4">About myself</th>
							</tr>
							<tr>
								<th><c:if test="${not empty candidate.aboutMe}">
									<p>${candidate.aboutMe}</p>
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
			      				<td class="col-md-3">Profile posted by: ${candidate.profilePostedBy}</td>
			      				<td class="col-md-3">Pray: 
			      					<c:choose>
										<c:when test="${candidate.pray=='5'}">Always Pray </c:when>
										<c:when test="${candidate.pray=='4'}">Sometimes miss Fajr and make Qadah</c:when>
										<c:when test="${candidate.pray=='3'}">Rarely miss a prayer and make Qadah</c:when>
										<c:when test="${candidate.pray=='2'}">Sometimes Pray</c:when>
										<c:when test="${candidate.pray=='1'}">Intend to start praying</c:when>
    								</c:choose>	
    							</td>
			      			</tr>
			      			<tr>
			      				<td class="col-md-3">Residency Status: ${candidate.residencyStatus}</td>
			      				<td class="col-md-3">Sect: ${candidate.sect}</td>
			      			</tr>
			      			<tr>
			      				<td class="col-md-3">Are you Willing to relocate: </td>
			      				<td class="col-md-3">Marital Status:
			      					<c:choose>
										<c:when test="${candidate.maritalStatus=='NM'}">Never Married</c:when>
										<c:otherwise>${candidate.maritalStatus}</c:otherwise>
    								</c:choose>
			      				</td>
			      			</tr>
			      			<tr>
			      				<td class="col-md-3">Ethnic Origin: ${candidate.ethnicOrigin}</td>
			      				<td class="col-md-3">Children: ${candidate.children}</td>
			      			</tr>
			      			<tr>
			      				<td class="col-md-3">My Religious History: ${candidate.religiousHistory}</td>
			      				<td class="col-md-3">Physical Disability: </td>
			      			</tr>
			      			<tr>
			      				<td class="col-md-3"></td>
			      				<td class="col-md-3">Like to have children: ${candidate.likeToHaveChildren}</td>
			      			</tr>
			      			<tr>
			      				<td class="col-md-3"></td>
			      				<td class="col-md-3">Polygamy: </td>
			      			</tr>
			      			<tr>
			      				<td class="col-md-3"></td>
			      				<td class="col-md-3">Languages: ${candidate.languages}</td>
			      			</tr>
			      			<tr>
			      				<th class="col-md-3">Appearance </th>
			      				<th class="col-md-3">Education/Career</th>
			      			</tr>
			      			<tr>
			      				<td class="col-md-3">Hair Color: ${candidate.hairColor}</td>
			      				<td class="col-md-3">Profession: ${candidate.profession}</td>
			      			</tr>
			      			<tr>
			      				<td class="col-md-3">Body Type: ${candidate.bodyType}</td>
			      				<td class="col-md-3">Highest Qualification: ${candidate.highestQual}</td>
			      			</tr>
			      			<tr>
			      				<td class="col-md-3">
			      					<c:if test="${candidate.gender=='M'}">
										Beard: ${candidate.hijabBeard}
									</c:if>
									<c:if test="${candidate.gender=='F'}">
										Hijab: ${candidate.hijabBeard}
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
								<th><c:if test="${not empty candidLookingfor.lookingFor}">
									<p>${candidLookingfor.lookingFor}</p>
								</c:if></th>
							</tr>
							
						</tbody>
					</table>
					
					<table class="table table-dark">
	      				<tbody>
		      				<tr>
      							<th class="col-md-3">Looking In: ${candidLookingfor.lookingIn}</th>
	      						<th class="col-md-3">Age: from ${candidLookingfor.ageL} to ${candidLookingfor.ageH}</th>
			      			</tr>
			      			<tr>
			      				<th class="col-md-3">Profile Basics</th>
			      				<th class="col-md-3">Lifestyle / Current status</th>
			      			</tr>
			      			<tr>
								<td class="col-md-3">Residency Status: ${candidLookingfor.residencyStatus}</td>
								<td class="col-md-3"> Pray: 
									<c:choose>
										<c:when test="${candidLookingfor.pray=='5'}">Always Pray </c:when>
										<c:when test="${candidLookingfor.pray=='smissfajr'}">Sometimes miss Fajr and make Qadah</c:when>
										<c:when test="${candidLookingfor.pray=='rmissprayer'}">Rarely miss a prayer and make Qadah</c:when>
    								</c:choose>
								</td>
			      			</tr>
			      			<tr>
			      				<td class="col-md-3">Are you Willing to relocate: ${sessionLookingFor.willingToRelocate}</td>
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
			      					<c:choose><c:when test="${candidLookingfor.religiousHistory=='dontmind'}">
									        		don't mind
									          </c:when>
									          <c:when test="${candidLookingfor.religiousHistory=='BM'}">
									        		Muslim since Birth
									          </c:when>
											  <c:otherwise> Revert Muslim </c:otherwise>
    								</c:choose>
    							</td>
			      				<td class="col-md-3">Has Children: ${candidLookingfor.hasChildren}</td>
			      			</tr>
			      			<tr>
			      				<td class="col-md-3">Living with in-laws: ${candidLookingfor.livingWithInLaws}</td>
			      				<td class="col-md-3">Has physical disability: ${candidLookingfor.hasPDisability}</td>
			      			</tr>
			      			<tr>
			      				<td class="col-md-3"></td>
			      				<td class="col-md-3">Like to have children: ${candidLookingfor.likeToHaveChildren}</td>
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
			      				<td class="col-md-3">Body type: ${candidLookingfor.bodyType}</td>
			      				<td class="col-md-3">Profession: ${candidLookingfor.profession}</td>
			      			</tr>
			      			<tr>
			      				<td class="col-md-3">
									<c:if test="${sessionUser.gender=='F'}">
										Beard: ${candidLookingfor.hijabBeard}
									</c:if>
									<c:if test="${sessionUser.gender=='M'}"> Hijab: 
										<c:choose>
											<c:when test="${candidLookingfor.hijabBeard=='withniqab'}">Always with Niqab </c:when>
											<c:when test="${candidLookingfor.hijabBeard=='dontmind'}">don't mind</c:when>
											<c:otherwise>Always</c:otherwise>
	    								</c:choose>
									</c:if>
								</td>
			      				<td class="col-md-3">Minimum Qualification: ${candidLookingfor.minimumQual}</td>
			      			</tr>
			      			<tr>
			      				<td class="col-md-3">
			      					Height: from ${candidLookingfor.heightL} to${candidLookingfor.heightH} 
			      				</td>
			      				<td class="col-md-3"></td>
			      			</tr>
		      			</tbody>
	      			</table>
				</div>
				<br>
				
				<br> <br>
			</div>
			<!-- home tab -->

			<!-- I want to take this away -->

			<div id="menu3" class="tab-pane fade">
				<h3>Menu 3</h3>
				<p>Eaque ipsa quae ab illo inventore veritatis et quasi
					architecto beatae vitae dicta sunt explicabo.</p>
			</div>
		</div>


	</div>
	<!-- container close -->
	
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/actions.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/opennav.js"></script>	
</body>
</html>