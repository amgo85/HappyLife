<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>About Me - My Profile</title>
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
		<a href="#">My Favorites</a>
	</div>

	<br>
	<br>

	<br>
	<br>
	
	<div class="container">
		<ul class="nav nav-tabs">
			<li><a href="/HappyLife/myprofile">Home</a></li>
			<li class="active"><a data-toggle="tab" href="#howilook">My Profile</a></li>
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
					<li><a href="#myPhoto">My Photo</a></li>
					<li><a href="#myQuestions">My Questions</a></li>
				</ul>
				<hr>

				<div id="" class="grid-container">
					<form action="${pageContext.request.contextPath}/aboutme&lookingfor" method="POST">
						<div class="row">
							<table class="table table-dark">
								<tbody>
									<tr>
										<th class="col-md-4">About myself</th>
									</tr>
									<tr>
										<td class="col-md-4">
											<textarea class="form-control" name="AboutMe" id="profiletextarea"
													  rows="7" cols="100">${aboutMeInfo}</textarea>
										</td>
									</tr>
									
								</tbody>
							</table>
						</div>
						
						<br>
						<div class="row">
			      			<table class="table table-dark">
			      				<tbody>
			      					<tr>
			      						<th class="col-md-2">Availability Status</th>
			      						<td class="col-md-4">
			      							<select name="profilestatus" id="" class="form-control">
												<option value="P">Prefer not to say</option>
												<option value="Available" selected="selected">I am currently available for communication</option>
												<option value="NA">I am currently available for communication</option>
												<option value="Meeting">I am currently meeting another member</option>
											</select>
			      						</td>
			      						<td class="col-md-3"></td>
			      						<td class="col-md-3"></td>
			      					</tr>
			      				</tbody>
			      			</table>
			      			<table class="table table-dark">
			      				<tbody>
								    <tr>
								    	<th scope="col" class="col-md-2">Location</th>								    	
								    	<th scope="col" class="col-md-2">Country</th>
								    	<th scope="col" class="col-md-2">State</th>
								    	<th scope="col" class="col-md-2">Town/City</th>
								    	<th class="col-md-4"></th>
								    </tr>
								    <tr>
								    	<td scope="row"></td>
								    	<td scope="row">
								    		<select name="country" id="" class="form-control" required="">
								    			<option value="${sessionUser.lookingIn}" selected="selected">${sessionUser.lookingIn}</option>
								    			
												<option value="Sudan">Sudan</option>
												<option value="Yemen">Yemen</option>
												<option value="India">India</option>
											</select>
								    	</td>
								    	<td scope="row">
								    		<select name="state" id="" class="form-control">
												<option value=""></option>
												<option value="" selected="selected"></option>
												<option value=""></option>
											</select>
								    	</td>
								    	<td scope="row">
								    		<select name="citytown" id="" class="form-control">
												<option value=""></option>
												<option value="" selected="selected"></option>
												<option value=""></option>
											</select>
								    	</td>
								    	<td></td>
								    </tr>
					    	</tbody>
			      			</table>
		      			</div>
		      			<br>
		      			<div class="row">
		      				<table class="table table-dark">
		      					<tbody>
		      						<tr>
		      							<th class="col-md-2">Languages spoken</th>
		      							<td scope="row" class="col-md-2">
											<input type="checkbox" id="arabic" name="language" value="arabic">
											<label for="arabic"> Arabic</label><br>
								    	</td>
								    	<td class="col-md-2">
								    		<input type="checkbox" id="english" name="language" value="english">
											<label for="english">English</label><br>
								    	</td>
								    	<td class="col-md-2">
								    		<input type="checkbox" id="other" name="language" value="other">
											<label for="other">Other</label><br>
								    	</td>
								    	<td class="col-md-6"></td>
		      						</tr>
		      					</tbody>
		      				</table>
		      			</div>
		      			<br>
		      			<div class="row">
		      				<table class="table table-dark">
		      					<tbody>
		      						<tr>
		      							<th class="col-md-2">Profile created by:</th>
		      							<td class="col-md-2">
			      							<select name="pcreatedby" id="" class="form-control" required="">
			      								<option value="${sessionUser.profilePostedBy}" selected="selected">${sessionUser.profilePostedBy}</option>
												<option value="Self">Self</option>
												<option value="Parent">Parent</option>
												<option value="BS">Brother/Sister</option>
												<option value="Family">Family/Relative</option>
												<option value="Cousine">Cousine</option>
												<option value="Guardian">Guardian</option>
												<option value="Friend">Friend</option>
											</select>
			      						</td>
			      						<td class="col-md-4"></td>
			      						<td class="col-md-4"></td>
		      						</tr>
		      					</tbody>
		      				</table>
		      			</div>
		      			<br>
		      			<div class="row">
		      				<table class="table table-dark">
		      					<tbody>
		      						<tr>
		      							<th class="col-md-2">Residency Status</th>
		      							<td class="col-md-2">
			      							<select name="residencystatus" id="" class="form-control" required="">
			      								<option value="">select</option>
			      								<option value="${sessionUser.residencyStatus}" selected="selected">${sessionUser.residencyStatus}</option>
												<option value="Citizen">Citizen</option>
												<option value="PR">Permanent Resident</option>
												<option value="svisa">Student Visa</option>
												<option value="tvisa">Temporary Visa</option>
												<option value="wpermit">Work Permit</option>
												<option value="guardian">Guardian</option>
												<option value="other">Other</option>
											</select>
			      						</td>
			      						<td class="col-md-4"></td>
			      						<td class="col-md-4"></td>
		      						</tr>
		      					</tbody>
		      				</table>
		      			</div>
		      			<br>
		      			<div class="row">
		      				<table class="table table-dark">
		      					<tbody>
		      						<tr>
		      							<th class="col-md-2">Are you willing to relocate for marriage</th>
		      							<td class="col-md-2">
		      								<select name="relocate" id="" class="form-control">
			      								<option value="">select</option>
												<option value="Yes">Yes</option>
												<option value="No">No</option>
											</select>
		      							</td>
		      							<td class="col-md-4"></td>
			      						<td class="col-md-4"></td>
		      						</tr>
		      					</tbody>
		      				</table>
		      			</div>
		      			<br>
		      			<div class="row">
		      				<table class="table table-dark">
		      					<tbody>
		      						<tr>
		      							<th class="col-md-2">What is your ethnic origin</th>
		      							<td class="col-md-2">
		      								<select name="ethnic" id="" class="form-control" required="">
			      								<option value="">select</option>
			      								<option value="${sessionUser.ethnicOrigin}" selected="selected">${sessionUser.ethnicOrigin}</option>
												<option value="Arab">Arab</option>
												<option value="Asian">Asian</option>
												<option value="African">African</option>
											</select>
		      							</td>
		      							<td class="col-md-4"></td>
			      						<td class="col-md-4"></td>
		      						</tr>
		      					</tbody>
		      				</table>
		      			</div>
		      			<br>
		      			<div class="row">
		      				<table class="table table-dark">
		      					<tbody>
		      						<tr>
		      							<th class="col-md-2">Religious History</th>
		      							<td class="col-md-2">
		      								<select name="rhistory" id="" class="form-control" required="">
			      								<option value="">select</option>
			      								<option value="${sessionUser.religiousHistory}" selected="selected">${sessionUser.religiousHistory}</option>
												<option value="BM">Muslim since birth</option>
												<option value="RM">Revert Muslim</option>
											</select>
		      							</td>
		      							<td class="col-md-4"></td>
			      						<td class="col-md-4"></td>
		      						</tr>
		      					</tbody>
		      				</table>
		      			</div>
		      			<br>
		      			<div class="row">
		      				<table class="table table-dark">
		      					<tbody>
		      						<tr>
		      							<th class="col-md-2">Do you pray?</th>
		      							<td class="col-md-4">
		      								<select name="pray" id="" class="form-control" required="">
			      								<option value="">select</option>
			      								<option value="${sessionUser.pray}" selected="selected">${sessionUser.pray}</option>
												<option value="AP">Always Pray</option>									<!-- 5 AP -->
												<option value="smissfajr">Sometimes miss Fajr and make Qadah</option>	<!-- 4 smissfajr -->
												<option value="rmissprayer">Rarely miss a prayer and make Qadah</option><!-- 3 rmissprayer -->
												<option value="spray">Sometimes Pray</option>							<!-- 2 spray -->
												<option value="itostart">Intend to start praying</option>				<!-- 1 itostart-->
											</select>
		      							</td>
		      							<td class="col-md-2"></td>
			      						<td class="col-md-4"></td>
		      						</tr>
		      					</tbody>
		      				</table>
		      			</div>
		      			<br>
		      			<div class="row">
		      				<table class="table table-dark">
		      					<tbody>
		      						<tr>
		      							<th class="col-md-2">What Sect are you?</th>
		      							<td class="col-md-2">
		      								<select name="sect" id="" class="form-control" required="">
			      								<option value="">select</option>
			      								<option value="${sessionUser.sect}" selected="selected">${sessionUser.sect}</option>
												<option value="preferN">Prefer not to say</option>
												<option value="SS">Sunni Salafi</option>
												<option value="Sunni">Sunni</option>
												<option value="Soufi">Soufi</option>
											</select>
		      							</td>
		      							<td class="col-md-4"></td>
			      						<td class="col-md-4"></td>
		      						</tr>
		      					</tbody>
		      				</table>
		      			</div>
		      			<br>
		      			<div class="row">
		      				<table class="table table-dark">
		      					<tbody>
		      						<tr>
		      							<th class="col-md-2">Marital Status</th>
		      							<td class="col-md-2">
		      								<select name="mstatus" id="" class="form-control" required="">
			      								<option value="">select</option>
			      								<option value="${sessionUser.maritalStatus}" selected="selected">${sessionUser.maritalStatus}</option>
												<option value="NM">Never Married</option>
												<option value="Divorced">Divorced</option>
												<option value="Widowed">Widowed</option>
												<option value="Other">Other</option>
											</select>
		      							</td>
		      							<td class="col-md-4"></td>
			      						<td class="col-md-4"></td>
		      						</tr>
		      					</tbody>
		      				</table>
		      			</div>
		      			<br>
		      			<div class="row">
		      				<table class="table table-dark">
		      					<tbody>
	      							<tr>
		      							<th class="col-md-2">Do You have Children</th>
		      							<td class="col-md-2">
		      								<select name="havekids" id="" class="form-control" required="">
			      								<option value="">select</option>
			      								<option value="${sessionUser.children}" selected="selected">${sessionUser.children}</option>
			      								<option value="None">None</option>
												<option value="One">One</option>
												<option value="Two">Two</option>
												<option value="more">Three or more</option>
											</select>
		      							</td>
		      							<td class="col-md-4"></td>
			      						<td class="col-md-4"></td>
		      						</tr>
		      					</tbody>
		      				</table>
		      			</div>
		      			<br>
		      			<div class="row">
		      				<table class="table table-dark">
		      					<tbody>
		      						<tr>
		      							<th class="col-md-2">Do you have any physical disability?</th>
		      							<td class="col-md-1">
		      								<select name="pdisability" id="" class="form-control">
			      								<option value="">select</option>
												<option value="Yes">Yes</option>
												<option value="No">No</option>
											</select>
		      							</td>
		      							<td class="col-md-5"></td>
			      						<td class="col-md-4"></td>
		      						</tr>
		      					</tbody>
		      				</table>
		      			</div>
		      			<br>
		      			<div class="row">
		      				<table class="table table-dark">
		      					<tbody>
		      						<tr>
		      							<th class="col-md-2">Like to have Children</th>
		      							<td class="col-md-1">
		      								<select name="liketohavekids" id="" class="form-control" required="">
			      								<option value="">select</option>
			      								<option value="${sessionUser.likeToHaveChildren}" selected="selected">${sessionUser.likeToHaveChildren}</option>
												<option value="Yes">Yes</option>
												<option value="No">No</option>
											</select>
		      							</td>
		      							<td class="col-md-5"></td>
			      						<td class="col-md-4"></td>
		      						</tr>
		      					</tbody>
		      				</table>
		      			</div>
		      			<br>
		      			<div class="row">
		      				<table class="table table-dark">
		      					<tbody>
		      						<tr>
		      							<th class="col-md-2">Polygamy</th>
		      						</tr>
		      					</tbody>
		      				</table>
		      			</div>
		      			<br>
		      			<div class="row">
		      				<table class="table table-dark">
		      					<tbody>
		      						<tr>
		      							<th class="col-md-2">Your body type</th>
		      							<td class="col-md-2">
		      								<select name="bodytype" id="" class="form-control" required="">
			      								<option value="">select</option>
			      								<option value="${sessionUser.bodyType}" selected="selected">${sessionUser.bodyType}</option>
												<option value="preferN">Prefer not to say</option>
												<option value="Slim">Slim</option>
												<option value="Average">Average</option>
												<option value="Athletic">Athletic</option>
												<option value="Muscular">Muscular</option>
												<option value="Heavyset">Heavyset</option>
											</select>
		      							</td>
		      							<td class="col-md-4"></td>
			      						<td class="col-md-4"></td>
		      						</tr>
		      					</tbody>
		      				</table>
		      			</div>
		      			<br>
		      			<div class="row">
		      				<table class="table table-dark">
		      					<tbody>
		      						<tr>
		      							<th class="col-md-2">What is your hair color?</th>
		      							<td class="col-md-2">
		      								<select name="haircolor" id="" class="form-control" required="">
			      								<option value="">select</option>
			      								<option value="${sessionUser.hairColor}" selected="selected">${sessionUser.hairColor}</option>
												<option value="Black">Black</option>
												<option value="Blonde">Blonde</option>
												<option value="darkb">Dark brown</option>
												<option value="Grey">Grey</option>
												<option value="Anyother">Any other</option>
											</select>
		      							</td>
		      							<td class="col-md-4"></td>
			      						<td class="col-md-4"></td>
		      						</tr>
		      					</tbody>
		      				</table>
		      			</div>
		      			<br>
		      			<div class="row">
		      				<table class="table table-dark">
		      					<tbody>
		      						<tr>
		      							<c:if test="${sessionUser.gender=='M'}">
											<th class="col-md-2">Do you keep beard?</th>
											<td class="col-md-1">
		      								<select name="hijaborbeard" id="" class="form-control" required="">
			      								<option value="">select</option>
			      								<option value="${sessionUser.hijabBeard}" selected="selected">${sessionUser.hijabBeard}</option>
												
												<option value="preferN">Prefer not to say</option>
												<option value="Yes">Yes</option>
												<option value="No">No</option>
											</select>
			      							</td>
			      							<td class="col-md-5"></td>
				      						<td class="col-md-4"></td>
										</c:if>
		      							<c:if test="${sessionUser.gender=='F'}">
											<th class="col-md-2">Do you wear Hijab?</th>
											<td class="col-md-2">
			      								<select name="hijaborbeard" id="" class="form-control" required="">
				      								<option value="">select</option>
				      								<option value="${sessionUser.hijabBeard}" selected="selected">${sessionUser.hijabBeard}</option>
													<option value="preferN">Prefer not to say</option>
													<option value="Always">Always</option>
													<option value="withniqab">Always with Niqab</option>
													<option value="Sometimes">Sometimes</option>
													<option value="Never">Never</option>
												</select>
			      							</td>
			      							<td class="col-md-4"></td>
				      						<td class="col-md-4"></td>
										</c:if>
		      						</tr>
		      					</tbody>
		      				</table>
		      			</div>
		      			<br>
		      			<div class="row">
		      				<table class="table table-dark">
		      					<tbody>
		      						<tr>
		      							<th class="col-md-2">Height</th>
		      							<td class="col-md-2">
		      								<select name="height" id="" class="form-control" required="">
			      								<option value="">select</option>
			      								<option value="${sessionUser.height}" selected="selected">${sessionUser.height}</option>
												<option value="preferN">Prefer not to say</option>
												<option value="134">134</option>
												<option value="137">137</option>
												<option value="139">139</option>
												<option value="141">141</option>
												<option value="144">144</option>
												<option value="147">147</option>
												<option value="149">149</option>
												<option value="151">151</option>
												<option value="153">153</option>
												<option value="155">155</option>
												<option value="157">157</option>
												<option value="159">159</option>
												<option value="162">162</option>
												<option value="164">164</option>
												<option value="166">166</option>
												<option value="168">168</option>
												<option value="170">170</option>
												<option value="173">173</option>
												<option value="176">176</option>
												<option value="178">178</option>
												<option value="180">180</option>
												<option value="182">182</option>
												<option value="184">184</option>
												<option value="186">186</option>
												<option value="189">189</option>
												<option value="191">191</option>
												<option value="193">193</option>
												<option value="195">195</option>
												<option value="198">198</option>
												<option value="200">200</option>
												<option value="202">202</option>
												<option value="204">204</option>
												<option value="206">206</option>
												<option value="208">208</option>
												<option value="210">210</option>
												<option value="212">212</option>
											</select>
		      							</td>
		      							<td class="col-md-4"></td>
			      						<td class="col-md-4"></td>
		      						</tr>
		      					</tbody>
		      				</table>
		      			</div>
		      			<br>
		      			<div class="row">
		      				<table class="table table-dark">
		      					<tbody>
		      						<tr>
		      							<th class="col-md-2">Your current profession</th>
											<td class="col-md-2">
		      								<select name="profession" id="" class="form-control" required="">
			      								<option value="">select</option>
			      								<option value="${sessionUser.profession}" selected="selected">${sessionUser.profession}</option>
												<option value="Accountant">Accountant</option>
												<option value="Architect">Architect</option>
												<option value="Banker">Banker</option>
												<option value="Doctor">Doctor</option>
												<option value="Engineer">Engineer</option>
												<option value="Farmer">Farmer</option>
												<option value="gemployee">Government Employee</option>
												<option value="Journalist">Journalist</option>
												<option value="Laborer">Laborer</option>
												<option value="Lawyer">Lawyer</option>
												<option value="Lecturer">Lecturer</option>
												<option value="militant">Militant Officer</option>
												<option value="Nurse">Nurse</option>
												<option value="itprofessional">IT Professional</option>
												<option value="Optician">Optician</option>
												<option value="Professor">Professor</option>
												<option value="Pharmacist">Pharmacist</option>
												<option value="Psychologist">Psychologist</option>
												<option value="semployed">Self-employed Person</option>
												<option value="sales">Sales Person</option>
												<option value="Supervisor">Supervisor</option>
												<option value="Student">Student</option>
												<option value="sconsultant">Software Consultant</option>
												<option value="Teacher">Teacher</option>
												<option value="Other">Other</option>
											</select>
			      							</td>
			      							<td class="col-md-4"></td>
				      						<td class="col-md-4"></td>
		      						</tr>
		      					</tbody>
		      				</table>
		      			</div>
		      			<br>
		      			<div class="row">
		      				<table class="table table-dark">
		      					<tbody>
		      						<tr>
		      							<th class="col-md-2">Highest Qualification</th>
		      							<td class="col-md-2">
		      								<select name="hqual" id="" class="form-control" required="">
			      								<option value="">select</option>
			      								<option value="${sessionUser.highestQual}" selected="selected">${sessionUser.highestQual}</option>
												<option value="preferN">Prefer not to say</option>
												<option value="gcse">GCSE</option>
												<option value="diploma">Diploma</option>
												<option value="gcse">GCSE</option>
												<option value="degree">Degree</option>
												<option value="masters">Masters</option>
												<option value="phd">PhD/Doctoral</option>
											</select>
		      							</td>
		      							<td class="col-md-4"></td>
			      						<td class="col-md-4"></td>
		      						</tr>
		      					</tbody>
		      				</table>
		      			</div>
		      			<br>
						<div class="row">
							<table class="table table-dark">
								<tbody>
									<tr>
										<th class="col-md-4">Looking for</th>
									</tr>
									<tr>
										<td class="col-md-4">
											<textarea class="form-control" name="LookingFor" id="profiletextarea"
													  rows="7" cols="100">${sessionLookingFor.lookingFor}</textarea>
										</td>
									</tr>
									
								</tbody>
							</table>
						</div>
						<br>
						<div class="row">
		      				<table class="table table-dark">
		      					<tbody>
		      						<tr>
		      							<th class="col-md-2">Age range</th>
		      							<td class="col-md-1">
		      								<select name="agefrom" id="" class="form-control">
		      									<option value="${sessionLookingFor.ageL}">${sessionLookingFor.ageL}</option>
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
		      							</td>
		      							<td class="col-md-1">to</td>
		      							<td class="col-md-1">
		      								<select name="ageto" id="" class="form-control">
		      									<option value="${sessionLookingFor.ageH}">${sessionLookingFor.ageH}</option>
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
		      							</td>
			      						<td class="col-md-7"></td>
		      						</tr>
		      					</tbody>
		      				</table>
		      			</div>
		      			<br>
		      			<div class="row">
		      				<table class="table table-dark">
			      				<tbody>
								    <tr>
								    	<th scope="col" class="col-md-2">Location</th>								    	
								    	<th scope="col" class="col-md-2">Country</th>
								    	<th scope="col" class="col-md-2">State</th>
								    	<th scope="col" class="col-md-2">Town/City</th>
								    	<th class="col-md-4"></th>
								    </tr>
								    <tr>
								    	<td scope="row"></td>
								    	<td scope="row">
								    		<select name="candidcountry" id="" class="form-control">
								    			<option value="${sessionLookingFor.lookingIn}" selected="selected">${sessionLookingFor.lookingIn}</option>
								    			
								    			<option value="dontmind">don't mind</option>
												<option value="Sudan">Sudan</option>
												<option value="Yemen">Yemen</option>
												<option value="India">India</option>
											</select>
								    	</td>
								    	<td scope="row">
								    		<select name="candidstate" id="" class="form-control">
												<option value=""></option>
												<option value="" selected="selected"></option>
												<option value=""></option>
											</select>
								    	</td>
								    	<td scope="row">
								    		<select name="candidcitytown" id="" class="form-control">
												<option value=""></option>
												<option value="" selected="selected"></option>
												<option value=""></option>
											</select>
								    	</td>
								    	<td></td>
								    </tr>
					    		</tbody>
			      			</table>
		      			</div>
		      			<br>
		      			<div class="row">
		      				<table class="table table-dark">
		      					<tbody>
		      						<tr>
		      							<th class="col-md-2">Residency Status</th>
		      							<td class="col-md-2">
		      								<select name="candidrs" id="" class="form-control">
		      									<option value="${sessionLookingFor.residencyStatus}" selected="selected">${sessionLookingFor.residencyStatus}</option>
		      									
			      								<option value="dontmind">don't mind</option>
												<option value="Citizen">Citizen</option>
												<option value="svisa">Student Visa</option>
												<option value="wpermit">Work Permit</option>
												<option value="president">Permanent Resident</option>
												<option value="Other">Other</option>
											</select>
		      							</td>
		      							<td class="col-md-4"></td>
			      						<td class="col-md-4"></td>
		      						</tr>
		      					</tbody>
		      				</table>
		      			</div>
		      			<br>
		      			<div class="row">
		      				<table class="table table-dark">
		      					<tbody>
		      						<tr>
		      							<th class="col-md-2">Are you willing to relocate?</th>
		      							<td class="col-md-2">
		      								<select name="candidrelocate" id="" class="form-control">
		      									<option value="${sessionLookingFor.willingToRelocate}" selected="selected">${sessionLookingFor.willingToRelocate}</option>
		      									
			      								<option value="dontmind">don't mind</option>
												<option value="Yes">Yes</option>
												<option value="No">No</option>
											</select>
		      							</td>
		      							<td class="col-md-4"></td>
			      						<td class="col-md-4"></td>
		      						</tr>
		      					</tbody>
		      				</table>
		      			</div>
		      			<br>
		      			<div class="row">
		      				<table class="table table-dark">
		      					<tbody>
		      						<tr>
		      							<th class="col-md-2">Ethnic origin</th>
		      							<td class="col-md-2">
		      								<select name="candidethnic" id="" class="form-control">
		      									<option value="${sessionLookingFor.ethnicOrigin}" selected="selected">${sessionLookingFor.ethnicOrigin}</option>
		      									
			      								<option value="dontmind">don't mind</option>
												<option value="Arab">Arab</option>
												<option value="Asian">Asian</option>
												<option value="African">African</option>
											</select>
		      							</td>
		      							<td class="col-md-4"></td>
			      						<td class="col-md-4"></td>
		      						</tr>
		      					</tbody>
		      				</table>
		      			</div>
		      			<br>
		      			<div class="row">
		      				<table class="table table-dark">
		      					<tbody>
		      						<tr>
		      							<th class="col-md-2">Religious History</th>
		      							<td class="col-md-2">
		      								<select name="candidrh" id="" class="form-control">
		      									<option value="${sessionLookingFor.religiousHistory}" selected="selected">${sessionLookingFor.religiousHistory}</option>
			      								<option value="dontmind">don't mind</option>
												<option value="BM">Muslim since Birth</option>
												<option value="RM">Revert Muslim</option>
											</select>
		      							</td>
		      							<td class="col-md-4"></td>
			      						<td class="col-md-4"></td>
		      						</tr>
		      					</tbody>
		      				</table>
		      			</div>
		      			<br>
		      			<div class="row">
		      				<table class="table table-dark">
		      					<tbody>
		      						<tr>
		      							<th class="col-md-2">Living with in-Laws</th>
		      							<td class="col-md-2">
		      								<select name="candidlivewinlaws" id="" class="form-control">
		      									<option value="${sessionLookingFor.livingWithInLaws}" selected="selected">${sessionLookingFor.livingWithInLaws}</option>
		      									
			      								<option value="dontmind">don't mind</option>
												<option value="dc">Definitely Consider</option>
												<option value="mc">May Consider</option>
												<option value="wc">Would not Consider</option>
											</select>
		      							</td>
		      							<td class="col-md-4"></td>
			      						<td class="col-md-4"></td>
		      						</tr>
		      					</tbody>
		      				</table>
		      			</div>
		      			<br>
		      			<div class="row">
		      				<table class="table table-dark">
		      					<tbody>
		      						<tr>
		      							<th class="col-md-2">Pray?</th>
		      							<td class="col-md-4">
		      								<select name="candidpray" id="" class="form-control">
		      									<option value="${sessionLookingFor.pray}" selected="selected">${sessionLookingFor.pray}</option>
		      									
			      								<option value="dontmind">don't mind</option>
												<option value="AP">Always Pray</option>
												<option value="smissfajr">Sometimes miss Fajr and make Qadah</option>
												<option value="rmissprayer">Rarely miss a prayer and make Qadah</option>
											</select>
		      							</td>
		      							<td class="col-md-2"></td>
			      						<td class="col-md-4"></td>
		      						</tr>
		      					</tbody>
		      				</table>
		      			</div>
		      			<br>
		      			<div class="row">
		      				<table class="table table-dark">
		      					<tbody>
		      						<tr>
		      							<th class="col-md-2">What Sect are you looking for?</th>
		      							<td class="col-md-2">
		      								<select name="candidsect" id="" class="form-control">
		      									<option value="${sessionLookingFor.sect}" selected="selected">${sessionLookingFor.sect}</option>
		      									
			      								<option value="dontmind">don't mind</option>
												<option value="SS">Sunni Salafi</option>
												<option value="Sunni">Sunni</option>
												<option value="Soufia">Soufia</option>
											</select>
		      							</td>
		      							<td class="col-md-4"></td>
			      						<td class="col-md-4"></td>
		      						</tr>
		      					</tbody>
		      				</table>
		      			</div>
		      			<br>
		      			<div class="row">
		      				<table class="table table-dark">
		      					<tbody>
		      						<tr>
		      							<th class="col-md-2">Marital Status</th>
		      							<td class="col-md-2">
		      								<select name="candidmstatus" id="" class="form-control">
		      									<option value="${sessionLookingFor.maritalStatus}" selected="selected">${sessionLookingFor.maritalStatus}</option>
		      									
			      								<option value="dontmind">don't mind</option>
												<option value="NM">Never Married</option>
												<option value="Divorced">Divorced</option>
												<option value="Widowed">Widowed</option>
												<option value="Other">Other</option>
											</select>
		      							</td>
		      							<td class="col-md-4"></td>
			      						<td class="col-md-4"></td>
		      						</tr>
		      					</tbody>
		      				</table>
		      			</div>
		      			<br>
		      			<div class="row">
		      				<table class="table table-dark">
		      					<tbody>
		      						<tr>
		      							<th class="col-md-2">Do You have Children</th>
		      							<td class="col-md-2">
		      								<select name="candidhavekids" id="" class="form-control">
		      									<option value="${sessionLookingFor.hasChildren}" selected="selected">${sessionLookingFor.hasChildren}</option>
		      									
			      								<option value="dontmind">don't mind</option>
			      								<option value="None">None</option>
												<option value="One">One</option>
												<option value="Two">Two</option>
												<option value="More">Three or more</option>
											</select>
		      							</td>
		      							<td class="col-md-4"></td>
			      						<td class="col-md-4"></td>
		      						</tr>
		      					</tbody>
		      				</table>
		      			</div>
		      			<br>
		      			<div class="row">
		      				<table class="table table-dark">
		      					<tbody>
		      						<tr>
		      							<th class="col-md-2">Do you have any physical disability?</th>
		      							<td class="col-md-2">
		      								<select name="candidpdisability" id="" class="form-control">
		      									<option value="${sessionLookingFor.hasPDisability}" selected="selected">${sessionLookingFor.hasPDisability}</option>
		      									
			      								<option value="">don't mind</option>
												<option value="Yes">Yes</option>
												<option value="No">No</option>
											</select>
		      							</td>
		      							<td class="col-md-4"></td>
			      						<td class="col-md-4"></td>
		      						</tr>
		      					</tbody>
		      				</table>
		      			</div>
		      			<br>
		      			<div class="row">
		      				<table class="table table-dark">
		      					<tbody>
		      						<tr>
		      							<th class="col-md-2">Like to have Children</th>
		      							<td class="col-md-2">
		      								<select name="candidliketohavekids" id="" class="form-control">
		      									<option value="${sessionLookingFor.likeToHaveChildren}" selected="selected">${sessionLookingFor.likeToHaveChildren}</option>
		      									
			      								<option value="dontmind">don't mind</option>
												<option value="Yes">Yes</option>
												<option value="No">No</option>
											</select>
		      							</td>
		      							<td class="col-md-4"></td>
			      						<td class="col-md-4"></td>
		      						</tr>
		      					</tbody>
		      				</table>
		      			</div>
		      			<br>
		      			<div class="row">
		      				<table class="table table-dark">
		      					<tbody>
		      						<tr>
		      							<th class="col-md-2">Polygamy</th>
		      							<td class="col-md-4"></td>
		      							<td class="col-md-4"></td>
			      						<td class="col-md-4"></td>
		      						</tr>
		      					</tbody>
		      				</table>
		      			</div>
		      			<br>
		      			<div class="row">
		      				<table class="table table-dark">
		      					<tbody>
		      						<tr>
		      							<th class="col-md-2">Candidate body type</th>
		      							<td class="col-md-2">
		      								<select name="candidbodytype" id="" class="form-control" required="">
			      								<option value="${sessionLookingFor.bodyType}" selected="selected">${sessionLookingFor.bodyType}</option>
			      								
			      								<option value="">select</option>
			      								<option value="dontmind">don't mind</option>
												<option value="Slim">Slim</option>
												<option value="Average">Average</option>
												<option value="Athletic">Athletic</option>
												<option value="Muscular">Muscular</option>
												<option value="Heavyset">Heavyset</option>
											</select>
		      							</td>
		      							<td class="col-md-4"></td>
			      						<td class="col-md-4"></td>
		      						</tr>
		      					</tbody>
		      				</table>
		      			</div>
		      			<br>
						<div class="row">
		      				<table class="table table-dark">
		      					<tbody>
		      						<tr>
		      							<c:if test="${sessionUser.gender=='M'}">
											<th class="col-md-2">Wears Hijab?</th>
											<td class="col-md-2">
			      								<select name="candidhijaborbeard" id="" class="form-control">
			      									<option value="${sessionLookingFor.hijabBeard}" selected="selected">${sessionLookingFor.hijabBeard}</option>
			      									
				      								<option value="dontmind">don't mind</option>
													<option value="always">Always</option>
													<option value="withniqab">Always with Niqab</option>
												</select>
			      							</td>
			      							<td class="col-md-4"></td>
				      						<td class="col-md-4"></td>
										</c:if>
		      							<c:if test="${sessionUser.gender=='F'}">
											<th class="col-md-2">Keeps beard?</th>
											<td class="col-md-2">
		      								<select name="candidhijaborbeard" id="" class="form-control">
		      									<option value="${sessionLookingFor.hijabBeard}" selected="selected">${sessionLookingFor.hijabBeard}</option>
		      									
			      								<option value="dontmind">don't mind</option>
												<option value="Yes">Yes</option>
												<option value="No">No</option>
											</select>
			      							</td>
			      							<td class="col-md-4"></td>
				      						<td class="col-md-4"></td>
										</c:if>
		      						</tr>
		      					</tbody>
		      				</table>
		      			</div>
						<br>
						<div class="row">
		      				<table class="table table-dark">
		      					<tbody>
		      						<tr>
		      							<th class="col-md-2">Height</th>
		      							<td class="col-md-1">
		      								<select name="candidheightf" id="" class="form-control">
		      									<option value="${sessionLookingFor.heightL}" selected="selected">${sessionLookingFor.heightL}</option>
		      									
												<option value="Any">Any</option>
												<option value="134">134</option>
												<option value="137">137</option>
												<option value="139">139</option>
												<option value="141">141</option>
												<option value="144">144</option>
												<option value="147">147</option>
												<option value="149">149</option>
												<option value="151">151</option>
												<option value="153">153</option>
												<option value="155">155</option>
												<option value="157">157</option>
												<option value="159">159</option>
												<option value="162">162</option>
												<option value="164">164</option>
												<option value="166">166</option>
												<option value="168">168</option>
												<option value="170">170</option>
												<option value="173">173</option>
												<option value="176">176</option>
												<option value="178">178</option>
												<option value="180">180</option>
												<option value="182">182</option>
												<option value="184">184</option>
												<option value="186">186</option>
												<option value="189">189</option>
												<option value="191">191</option>
												<option value="193">193</option>
												<option value="195">195</option>
												<option value="198">198</option>
												<option value="200">200</option>
												<option value="202">202</option>
												<option value="204">204</option>
												<option value="206">206</option>
												<option value="208">208</option>
												<option value="210">210</option>
												<option value="212">212</option>
											</select>
		      							</td>
		      							<td class="col-md-1">to</td>
		      							<td class="col-md-1">
		      								<select name="candidheightto" id="" class="form-control">
		      									<option value="${sessionLookingFor.heightH}" selected="selected">${sessionLookingFor.heightH}</option>
		      									
												<option value="Any">Any</option>
												<option value="212">212</option>
												<option value="210">210</option>
												<option value="208">208</option>
												<option value="206">206</option>
												<option value="204">204</option>
												<option value="202">202</option>
												<option value="200">200</option>
												<option value="198">198</option>
												<option value="195">195</option>
												<option value="193">193</option>
												<option value="191">191</option>
												<option value="189">189</option>
												<option value="186">186</option>
												<option value="184">184</option>
												<option value="182">182</option>
												<option value="180">180</option>
												<option value="178">178</option>
												<option value="176">176</option>
												<option value="173">173</option>
												<option value="170">170</option>
												<option value="168">168</option>
												<option value="166">166</option>
												<option value="164">164</option>
												<option value="162">162</option>
												<option value="159">159</option>
												<option value="157">157</option>
												<option value="155">155</option>
												<option value="153">153</option>
												<option value="151">151</option>
												<option value="149">149</option>
												<option value="147">147</option>
												<option value="144">144</option>
												<option value="141">141</option>
												<option value="139">139</option>
												<option value="137">137</option>
												<option value="134">134</option>
											</select>
		      							</td>
			      						<td class="col-md-7"></td>
		      						</tr>
		      					</tbody>
		      				</table>
		      			</div>
		      			<br>
		      			<div class="row">
		      				<table class="table table-dark">
		      					<tbody>
		      						<tr>
		      							<th class="col-md-2">Profession</th>
										<td class="col-md-2">
	      								<select name="candidprofession" id="" class="form-control">
	      									<option value="${sessionLookingFor.profession}" selected="selected">${sessionLookingFor.profession}</option>
	      									
		      								<option value="dontmind">don't mind</option>
											<option value="Accountant">Accountant</option>
											<option value="Architect">Architect</option>
											<option value="Banker">Banker</option>
											<option value="Doctor">Doctor</option>
											<option value="Engineer">Engineer</option>
											<option value="Farmer">Farmer</option>
											<option value="gemployee">Government Employee</option>
											<option value="Journalist">Journalist</option>
											<option value="Laborer">Laborer</option>
											<option value="Lawyer">Lawyer</option>
											<option value="Lecturer">Lecturer</option>
											<option value="militant">Militant Officer</option>
											<option value="Nurse">Nurse</option>
											<option value="itprofessional">IT Professional</option>
											<option value="Optician">Optician</option>
											<option value="Professor">Professor</option>
											<option value="Pharmacist">Pharmacist</option>
											<option value="Psychologist">Psychologist</option>
											<option value="semployed">Self-employed Person</option>
											<option value="Supervisor">Supervisor</option>
											<option value="Student">Student</option>
											<option value="sconsultant">Software Consultant</option>
											<option value="Teacher">Teacher</option>
											<option value="Other">Other</option>
										</select>
		      							</td>
		      							<td class="col-md-4"></td>
			      						<td class="col-md-4"></td>
		      						</tr>
		      					</tbody>
		      				</table>
		      			</div>
		      			<br>
		      			<div class="row">
		      				<table class="table table-dark">
		      					<tbody>
		      						<tr>
		      							<th class="col-md-2">Minimum Qualification</th>
		      							<td class="col-md-2">
		      								<select name="candidhqual" id="" class="form-control">
		      									<option value="${sessionLookingFor.minimumQual}" selected="selected">${sessionLookingFor.minimumQual}</option>
		      									
												<option value="dontmind">don't mind</option>
												<option value="GCSE">GCSE</option>
												<option value="Diploma">Diploma</option>
												<option value="Degree">Degree</option>
												<option value="Masters">Masters</option>
												<option value="PhD">PhD/Doctoral</option>
											</select>
		      							</td>
		      							<td class="col-md-4"></td>
			      						<td class="col-md-4"></td>
		      						</tr>
		      					</tbody>
		      				</table>
		      			</div>
		      			<br>
						<table class="table table-dark">
							<tbody>
								<tr>
									<td>
										<input type="submit" name="submit" value="submit">
									</td>
								</tr>
							</tbody>
						</table>
					</form>
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