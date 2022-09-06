<%@page import="com.happylife.pojo.User"%>
<%@page import="java.awt.Graphics2D"%>
<%@page import="java.awt.image.BufferedImage"%>
<%@page import="javax.imageio.ImageIO"%>
<%@page import="java.io.*"%>
<%@page import="com.happylife.pojo.Messages, java.util.*" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Admin My Profile</title>

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
</head>
<body>
	<% response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); %>
	<% if(session.getAttribute("username")==null) response.sendRedirect("/HappyLife/adminlogin");%>
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
		<a href="/HappyLife/search">Search</a>
		<a href="/HappyLife/fav">My Favorites</a>
	</div>

	<br>
	<br>
		
	<br><br>
	<div class="container">
		<ul class="nav nav-tabs">
			<li class="active"><a href="/HappyLife/admin_profile">All Messages</a></li>
			<li><a href="/HappyLife/admin_approved">Approved</a></li>
			<li><a href="">Blocked</a></li>
			<li><a href="/HappyLife/onlineusers">Online users</a></li>
		</ul>
		
		<div class="tab-content">
			<div id="home" class="tab-pane fade in active">
				
				<!-- user-block -->
				<br>
				<div id="myIdeal" class="grid-container">
					
					
					<table class="table table-dark">
							<thead>
								<tr>
							    	<th scope="col">Message Id</th>
							    	<th scope="col">From</th>
							   		<th scope="col">Content</th>
							    	<th scope="col">Date</th>
							    </tr>
  							</thead>
  							
  							
						
						
						<%
						  	List<Messages> toApproveList = (List<Messages>)application.getAttribute("toApproveList");
							List<User> usersList = (List<User>)application.getAttribute("usersList");
							
							//List<Messages> toApproveList = (List<Messages>)request.getAttribute("toApproveList");
							//List<User> usersList = (List<User>)request.getAttribute("usersList");
							int i = 0;
							System.out.println("usersList list =" + usersList.size());
					  		System.out.println("Messages list =" + toApproveList.size());
						  	for(Messages m: toApproveList){
						  		User pu = usersList.get(i++);
						 %>
						 	<tbody>
							    <tr>
							    	<th scope="row"><%=i%></th>
							    	<td><%=pu.getUsername()%></td>
							     	<td><a href="/HappyLife/msgtoapprove?id=<%=m.getMessageId()%>"><%=m.getMsgContent().substring(0,19)%></a></td>
							    	<td><%=m.getTime()%></td>
							    </tr>
					    	</tbody>
						<%
								
							}
						%>
							
						</table>
					
				</div>

				<br>
				
				<br> <br>
			</div>
			<!-- home tab -->


			<!-- howilook taken from myprofile.jsp -->

			
		</div>


	</div>
	<!-- container close -->


	<script type="text/javascript" src="${pageContext.request.contextPath}/js/actions.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/opennav.js"></script>
</body>
</html>