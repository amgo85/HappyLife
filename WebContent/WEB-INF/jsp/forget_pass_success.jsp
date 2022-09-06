<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
	    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	    <meta name="description" content="">
	    <meta name="author" content="">
	    <link rel="icon" href="/ico/favicon.ico">
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	    <title>Forgot password</title>
	
	    <!-- Bootstrap core CSS -->
	    <link href="./css/bootstrap.min.css" rel="stylesheet">
	
	    <!-- Custom styles for this template -->
	    <link href="./css/floating-labels.css" rel="stylesheet">
	</head>
	<body>
		<form action="reset" method="post"  class="form-signin" style="box-shadow: 0 0 black;">
	    	<div class="text-center mb-4">
		        <h6 class="h3 mb-3 font-weight-normal">Resetting Password</h6>
	    	</div>
	
		    <div class="form-label-group">
		        <p class="text-center">A link has been sent to your email.<p>
		        <p class="text-center">click <a href="/HappyLife/resetlink?=<%=request.getAttribute("resetLink")%>">here</a> to reset</p>
		   	</div>
		   
		    <input type="hidden" name="login" value="login">
		    
	      	<p class="mt-5 mb-3 text-muted text-center">© 2017-2018</p>
    	</form>	
	</body>
</html>