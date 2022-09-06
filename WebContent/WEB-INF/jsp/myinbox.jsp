<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.happylife.pojo.Messages, com.happylife.pojo.User, java.util.*"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib uri = "http://java.sun.com/jsp/jstl/functions" prefix = "fn" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>My Inbox - My Profile</title>

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

		<div class="tab-content">

			<!-- home tab -->

			<div id="howilook" class="tab-pane fade in active">
				<br>
				
				
				<div class="resultBox col-8">
					<ul id="search-li" class="col-8">
						
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
						  	List<Messages> inboxList = (List<Messages>)request.getAttribute("inboxList");
							List<User> sendersList = (List<User>)request.getAttribute("sendersList");
							int i = 0;
							System.out.println("Senders list =" + sendersList.size());
					  		System.out.println("Messages list =" + inboxList.size());
						  	for(Messages m: inboxList){
						  		User pu = sendersList.get(i++);
						 %>
						 	<tbody>
							    <tr>
							    	<th scope="row"><%=i%></th>
							    	<td><%=pu.getUsername()%></td>
							     	<td><a href="/HappyLife/sendmessageto?=<%=m.getSenderId()%>"><%=m.getMsgContent().substring(0,19)%></a></td>
							    	<td><%=m.getTime()%></td>
							    </tr>
					    	</tbody>
						<%
								
							}
						%>
							
						</table>
						<%-- <c:forEach items="${inboxList}" var="message">
							<li class="col-1">${message.messageId}</li>
							<li class="col-1">${message.senderId}</li>
							<c:set var = "content" value = "${message.msgContent}"/>
							<li class="col-3"><a href="${pageContext.request.contextPath}/candid?=">${fn:substring(content, 0, 10)}</a></li>
							<li class="col-2">${message.time}</li>
					    	<br>
					    </c:forEach> --%>
					</ul>
				</div>
				
				
				<hr>
				
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