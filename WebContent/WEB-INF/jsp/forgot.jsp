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
		        <h6 class="h3 mb-3 font-weight-normal">Type your Email to reset password</h6>
	    	</div>
	
		    <div class="form-label-group">
		        <label for="inputEmail">Type your Email address</label>
		        <input type="email" path="email" name="remail" id="inputEmail" class="form-control" placeholder="Email address" required="" autofocus=""/>
		        <br>
				
		   	</div>
		   
		    <input type="hidden" name="login" value="login">
		    <button class="btn btn-lg btn-primary btn-block" type="submit" name="reset" value="reset">Reset Password</button>
	      	<p class="mt-5 mb-3 text-muted text-center">© 2017-2018</p>
    	</form>	
	</body>
</html>