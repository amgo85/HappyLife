<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" 
		 import="com.happylife.pojo.User, java.util.*, com.happylife.DoMath"%>
		 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>More Like </title>
	
	<!-- Bootstrap core CSS -->
	<!--link href="${pageContext.request.contextPath}/css/bootstrap.min.css" rel="stylesheet"-->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap337.min.css">
	<!-- specific -->
	
	<link href="${pageContext.request.contextPath}/css/grid.css" rel="stylesheet">
	<link href="${pageContext.request.contextPath}/css/profile.css" rel="stylesheet">
	
	<meta name="viewport" content="width=device-width, initial-scale=1">
	
	<!-- Side navigation menu -->
	<link href="${pageContext.request.contextPath}/css/sidnavpush.css" rel="stylesheet">
	<!-- only for Search -->
	<link href="${pageContext.request.contextPath}/css/searchtable.css" rel="stylesheet">
	
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
	<% if(session==null) response.sendRedirect("/HappyLife");%>
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
    		<li  class="active"><a href="/HappyLife/search">Search</a></li>
    		<li><a data-toggle="tab" href="#menu3">Marriage Advice</a></li>
 			</ul>
		<div class="tab-content">
			<div id="menu2" class="tab-pane fade in active">
				
				<form action="${pageContext.request.contextPath}/search" method="GET">
				<div class="row">
					<br>
					<div class="column" style="background-color:#33b5e5;">
						<ul>
	    					<li id="idmatch" >Ideal Match <input type="checkbox" id="idealcb" name="select" value="idealcb"></li>
	    					
	    					<li id="lookingFor">Whom I'm looking for <input type="checkbox" id="" name="lfselect" value="ilookfcb"></li>
	    					<li id="lookingForMe">who's looking for me <input type="checkbox" id="" name="lfmselect" value="lookformecb"></li>
	    					<li id="onlineNow">on-Line Now <input type="checkbox" id="" name="select" value="online"></li>
	    					<li id="photosUploaded">Photos uploaded <input type="checkbox" id="" name="select" value="photoupl"></li>
	    					<li id="hvntviewed">only those I haven't viewed <input type="checkbox" id="" name="select" value="notviewed"></li>
	    					<li id="hvntmessgd">only those I haven't messaged <input type="checkbox" id="" name="select" value="notmsged"></li>
	    					<li id="age-select"><div class="">Aged from 
	    						<select class="" name="agel">
	    							<option value="Any">Any</option>
									<option value="18">18</option>
									<option value="19">19</option>
									<option value="20">20</option>
									<option value="21">21</option>
									<option value="22">22</option>
									<option value="23">23</option>
									<option value="24">24</option>
									<option value="25">25</option>
									<option value="26">26</option>
									<option value="27">27</option>
									<option value="28">28</option>
									<option value="29">29</option>
									<option value="30">30</option>
									<option value="31">31</option>
									<option value="32">32</option>
									<option value="33">33</option>
									<option value="34">34</option>
									<option value="35">35</option>
									<option value="36">36</option>
									<option value="37">37</option>
									<option value="38">38</option>
									<option value="39">39</option>
									<option value="40">40</option>
									<option value="41">41</option>
									<option value="42">42</option>
									<option value="43">43</option>
									<option value="44">44</option>
									<option value="45">45</option>
									<option value="46">46</option>
									<option value="47">47</option>
									<option value="48">48</option>
									<option value="49">49</option>
									<option value="50">50</option>
									<option value="51">51</option>
									<option value="52">52</option>
									<option value="53">53</option>
	    						</select>
	    					</div></li>
	    					<li>to 
	    						<select class="" name="ageh">
	    							<option value="Any">Any</option>
									<option value="53">53</option>
									<option value="52">52</option>
									<option value="51">51</option>
									<option value="50">50</option>
									<option value="49">49</option>
									<option value="48">48</option>
									<option value="47">47</option>
									<option value="46">46</option>
									<option value="45">45</option>
									<option value="44">44</option>
									<option value="43">43</option>
									<option value="42">42</option>
									<option value="41">41</option>
									<option value="40">40</option>
									<option value="39">39</option>
									<option value="38">38</option>
									<option value="37">37</option>
									<option value="36">36</option>
									<option value="35">35</option>
									<option value="34">34</option>
									<option value="33">33</option>
									<option value="32">32</option>
									<option value="31">31</option>
									<option value="30">30</option>
									<option value="29">29</option>
									<option value="28">28</option>
									<option value="27">27</option>
									<option value="26">26</option>
									<option value="25">25</option>
									<option value="24">24</option>
									<option value="23">23</option>
									<option value="22">22</option>
									<option value="21">21</option>
									<option value="20">20</option>
									<option value="19">19</option>
									<option value="18">18</option>
	    						</select>
	    					</li>
	    					<li id="selectContainer"><div>In 
	    						<select name="country" id="inputCountry" class="">
	    							<option value="Any" selected="selected">Select place</option>
									<option value="Sudan">Sudan</option>
									<option value="Yemen">Yemen</option>
									<option value="India">India</option>
								</select>
	    					</div></li>
	    					<li><input class="btn btn-lg btn-primary btn-block" type="submit" value="Findamatch"></li>
		  				</ul>
					 </div>
					 
					 <div class="column2">
					   <ul id="search-li" class="col-8">
					   		<table class="table table-dark">
				  			<%
				  				List<User> moreLikeCandidList = (List<User>)request.getAttribute("moreLikeCandidList");
				  				for(User u: moreLikeCandidList){
				  			%>
				  				<tbody>
				  					<tr>
			    						<th class="col-md-2">
			    							<%=u.getUsername()%><br>
			    							<a href="${pageContext.request.contextPath}/candid?=<%=u.getUserId()%>">
			    								<img src="${pageContext.request.contextPath}/publicphotos/<%=u.getPublicPhoto() %>.JPG">
			    							</a>
			    							<%-- <a ><%=u.getUsername()%></a> --%>
			    							<br>
			    						</th>
			    						<td><br><a href="${pageContext.request.contextPath}/sendmessageto?=<%=u.getUserId()%>">Send Message</a><br>
			    							<a>Add to my favorites</a><br>
			    							<a>Ask to exchange Photos</a><br>
			    							<a>invite to view my profile</a><br>
			    							<a>Your notes on them</a><br>
			    							<%	DoMath doM = new DoMath();
			    								String lastLogin = doM.getLastLogin(u.getLastLogin());
			    								System.out.println("Last login time of "+u.getUsername()+" in search.jsp is: " + lastLogin);
			    							%>
			    							<%if(lastLogin.equals("Online")){%>
			    							<p>Online</p> 
			    							<% } %>
			    						</td>
			    					</tr>
			    				</tbody>
			    			<% 
			    				} 
			    			%>
			    			</table>
	    				</ul>
					 </div>
				</div>
				</form>
			</div>
			
			
			
			<div id="menu3" class="tab-pane fade">
		      	<h3>Menu 3</h3>
		      	<p>Eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo.</p>
		    </div>
		</div>
	
	
	</div><!-- container close -->
		
		
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/actions.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/opennav.js"></script>
</body>
</html>