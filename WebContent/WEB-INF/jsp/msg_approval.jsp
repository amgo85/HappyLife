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
	<title>Admin - My Profile</title>

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
			<li><a href="/HappyLife/pinfo">Approved</a></li>
			<li><a href="/HappyLife/search">Blocked</a></li>
			<li><a href="#menu3">Marriage Advice</a></li>
		</ul>
		<br/>
		<div class="tab-content">
			
			<!-- home tab -->

			<div id="howilook" class="tab-pane fade in active">
				
				<div class="resultBox col-8">
					<%
							Messages m = (Messages)application.getAttribute("chat");
		 					List<User> chatList = (List<User>)application.getAttribute("chatList");
				  			//Messages m = (Messages)request.getAttribute("chat");
				 			//List<User> chatList = (List<User>)request.getAttribute("chatList");
							int i = 0;
					%>
					<form action="${pageContext.request.contextPath}/msgtoapprove?id=<%=m.getMessageId() %>" method="POST">
						<table class="table table-dark">
						 	<tbody>
						 		
							    <tr>
							    	<th scope="row">From <%=m.getSenderId() %></th>
							    	<td><%=m.getMsgContent()%></td>
							    	<td><%=m.getTime()%></td>
							    </tr>
							    <tr>
							    	<th scope="row"></th>
								    <td></td>
								   	<td></td>
								</tr>
							    <%-- <c:forEach items="${mlist}" var="message">
								    <tr>
								    	<th scope="row">From ${m.senderId}</th>
								    	<td>${m.msgContent}</td>
								    </tr>
							    </c:forEach> --%>
					    	</tbody>
							
						</table>
						<table class="table table-dark">
							<tbody>
								<tr>
							    	<td class="col-md-2">
							    		<input type="radio" id="approve" name="approve" value="Yes">
										<label for="approve">Yes</label>
									</td>
							    	<td>
							    		<input type="radio" id="block" name="approve" value="No">
										<label for="block">No</label>
							    	</td>
							    	<td></td>
							    	<td><input type="submit" name="approve"></td>
							    </tr>
							</tbody>
						</table>
					</form>
				</div>
				
				<!-- user-block -->
				<br>
				
				<br>
			</div>
			
		</div>


	</div>
	<!-- container close -->


	<script type="text/javascript" src="${pageContext.request.contextPath}/js/actions.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/opennav.js"></script>
</body>
</html>