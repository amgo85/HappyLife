<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %> --%>
    
<!DOCTYPE html>
<html>
<head>
	<head>
		<jsp:include page="/WEB-INF/jsp/header.jspf"></jsp:include>
		<title>Admin Sign Up Here</title>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<meta charset="utf-8">
    	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    	<meta name="description" content="">
    	<meta name="author" content="">
    	<link rel="icon" href="/ico/favicon.ico">
		
   	 	<!-- Custom styles for this template -->
	    <link href="${pageContext.request.contextPath}/css/floating-labels.css" rel="stylesheet">
	</head>
</head>
<body>
	<form action="${pageContext.request.contextPath}/adminsignup" method="post" commandName="user" class="form-signup" style="box-shadow: 0 0 black;">
		    
			<div class="col-md-12 col-md-push-3">
				<div class="text-center mb-4">
		    		<h1 class="h3 mb-3 font-weight-normal">Admin Sign up or <a class="demo" href="${pageContext.request.contextPath}/adminlogin">Login Here</a></h1>
		    		<br>
		    		<h3 class="h3 mb-3 font-weight-normal">${errorMsg}</h3>
		    	</div>
		    	
		    	<div class="row">
		    		<div class="form-group col-md-6">
	       				<input type="text" name="fname" id="inputFirstName" value="" class="form-control" placeholder="First Name" required="" autofocus="">
		    		</div>
		    		
		    		<div class="form-group col-md-6">
	       				<input type="text" name="lname" id="inputLastName" value="" class="form-control" placeholder="Last Name" required="" autofocus="">
		    		</div>
	     		</div>
				
	      		<div class="row">
	      			<div class="form-group col-md-12">
	        			<input type="email" name="email" id="inputEmail" value="" class="form-control" placeholder="Email address" required="" autofocus="">
	      			</div>
	      		</div>
	      		
	      		<div class="row">
	      			<div class="form-group col-md-6">
	        			<input type="text" name="username" id="inputUserName" class="form-control" placeholder="Username" required="" autofocus="">
	      			</div>
	      		</div>
	
	      		<div class="row">
	      			<div class="form-group col-md-6">
		        		<input type="password" name="password" id="inputPassword" class="form-control" placeholder="Password" required="">
		      		</div>
		      		<!-- <label for="inputPassword">Password</label>
		        	<input type="password" path="password" name="password" id="inputPassword" class="form-control" placeholder="Password" required=""/> -->
		      		
		      		<div class="form-group col-md-6">
		        		<input type="password" name="repassword" id="inputRePassword" class="form-control" placeholder="re-Password" required=""/>
		      		</div>
		      	</div>
		      	
		      	<div class="row">
		        	<div class="form-group col-md-6">
		        		<input type="radio" name="sex" id="inputMale" class="left" value="M" required=""/>
		        		<label for="inputMale">Male</label>
	        		</div>
	        		<div class="form-group col-md-6">
		        		<input type="radio" name="sex" id="inputFemale" class="right" value="F" required=""/>
		        		<label class="right" for="inputFemale">Female</label>
		        	</div>
		      	</div>
		      	
		      	
		      	
		      	<div class="row">
		        	<div class="form-group col-md-12">
		        		<input type="text" name="phone" id="inputPhone" class="form-control" placeholder="phone" required=""/>
		        	</div>
		      	</div>
		      	
		      	<div class="row">
		        	<div class="form-group col-md-12">
		        		<input type="date" name="dob" id="dateOfBirth" class="form-control" placeholder="Date" required=""/>
		        	</div>
		      	</div>
		      	
		      	<!-- <div class="row">
		      		<div class="form-group col-md-12">
			        	<label for="inputImage">Image</label>
			        	<input type="file" name="image" id="inputImage" class="form-control" placeholder="select image" required=""/>
		        	</div>
		      	</div> -->
		      	
		      	<button class="btn btn-lg btn-primary btn-block" type="submit" value="Signup">Sign up</button>
		      	<p class="mt-5 mb-3 text-muted text-center">© 2017-2018</p>
		      	  	
			</div>
	      	<hr>
    	</form>
</body>
</html>