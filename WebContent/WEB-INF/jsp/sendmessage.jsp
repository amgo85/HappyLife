<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.happylife.pojo.Messages, com.happylife.pojo.User, java.util.*"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Send message</title>

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

	<br>
	<br>
	<div class="container">
		<ul class="nav nav-tabs">
			<li><a href="/HappyLife/myprofile">Home</a></li>
			<li><a href="/HappyLife/pinfo">My Profile</a></li>
			<li><a href="/HappyLife/search">Search</a></li>
			<li><a href="#menu3">Marriage Advice</a></li>
		</ul>

		<div class="tab-content">

			<!-- home tab -->

			<div id="howilook" class="tab-pane fade in active">
				<br>
				<hr>

				<div id="" class="grid-container">
					<form action="${pageContext.request.contextPath}/sendmessageto?=${candidId}" method="POST">
						<table class="table table-dark">
							<tbody>
								<tr>
									<th class="col-md-4">message to ${candidName}</th>
								</tr>
								<tr>
									<td class="col-md-4">
										<textarea class="form-control" name="message" id="profiletextarea"
											  rows="7" cols="100"></textarea>
									</td>
								</tr>
								<tr>
									<td>
										<input type="submit" name="submit" value="submit">
									</td>
								</tr>
							</tbody>
						</table>
						<br>
					</form>
				</div>
				<hr>
				<div class="resultBox col-8">
					<ul id="message-li" class="col-8">
						<table class="table table-dark">					
						 	<tbody>
						 		<%
						  			List<Messages> mlist = (List<Messages>)request.getAttribute("mlist");
						 			List<User> chatList = (List<User>)request.getAttribute("chatList");
									int i = 0;
							  		System.out.println("Messages list from sendmessage.jsp= " + mlist.size());
						  			for(Messages m: mlist){
						  				User pu = chatList.get(i++);
						 		%>
								    <tr>
								    	<th scope="row">From <%=pu.getUsername() %></th>
								    	<td><%=m.getMsgContent()%></td>
								    	<td><%=m.getTime()%></td>
								    </tr>
							    <%
							    	}
						  		%>
							    
							    <%-- <c:forEach items="${mlist}" var="message">
								    <tr>
								    	<th scope="row">From ${m.senderId}</th>
								    	<td>${m.msgContent}</td>
								    </tr>
							    </c:forEach> --%>
					    	</tbody>
							
						</table>
					</ul>
				</div>
				
				<!-- user-block -->
				<br>
				
				<br>
			</div>


		</div>

	</div>
	<!-- container -->
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/actions.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/opennav.js"></script>		
</body>
</html>