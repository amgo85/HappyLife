<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<jsp:include page="/WEB-INF/jsp/header.jspf"></jsp:include>
	<title>Welcome To Home</title>
	
	
</head>
<body>
	<header>
	      <nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
	      	<a class="navbar-brand" href="./login.html">Login</a>
        	<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarCollapse" aria-controls="navbarCollapse" aria-expanded="false" aria-label="Toggle navigation">
          		<span class="navbar-toggler-icon"></span>
        	</button>
	      	
	      	<div class="collapse navbar-collapse" id="navbarCollapse">
	        	<ul class="navbar-nav mr-auto">
	            	<li class="nav-item">
	              		<a class="nav-link" href="indexA.jsp">العربية</a>
	            	</li>
	            	<li class="nav-item">
	              		<a class="nav-link" href="#">Help</a>
	            	</li>
	             	<li class="nav-item">
	              		<a class="nav-link" href="#">About us</a>
	            	</li>
	          	</ul>
	        </div>
	      </nav>
	    </header>
	    
	    <br>
	    <br>
	    <br>
	    <br>
	    
	    <form action="signup.jsp" method="get">
	    	<div class="container">
				<h1>Grid</h1>
			  	<p>Find with us your true happiness.</p>      
			  	<p>Resize the browser window to see the effect.</p>      
			  	<div class="row">
			  		<div class="col-sm-3" style="background-color:yellow;">
				    	<label for="form-first-name">First Name</label>
				      	<input type="text" name="fname" id="inputFirstName" class="form-control" placeholder="First Name" required="" autofocus="">
				    </div>
				    
				    <div class="col-sm-3" style="background-color:pink;">
				    	<label for="form-last-name">Last Name</label>
				    	<input type="text" name="lname" id="inputLastName" class="form-control" placeholder="Last Name" required="" autofocus="">
				    </div>
				    <div class="col-sm-3" style="background-color:yellow;">
				    	<label for="form-email">Email</label>
				      	<input type="email" name="email" id="inputEmail" class="form-control" placeholder="Email address" required="" autofocus="">  
				    </div>
				    <div class="col-sm-3" style="background-color:pink;">
				      	<div>
							<label for="form-r-sex">I am seeking a ...</label>
							<div class="custom-select">
								<select name="sex" id="form-r-sex" class="has-custom-select has-tooltip" data-tooltip="Please tell us who you are." data-error="Please select if you are a man seeking a wife or a woman seeking a husband." data-validation="required"><option value="" selected="selected">Select here</option><option value="M">Wife</option><option value="F">Husband</option>
								</select> 
							</div>
						</div>    
				    </div>
				</div>
				<div><br></div>
				<div class="row">
					<input type="submit" name="submit" value="Find Your Pure Match" class="button submit" style="text-transform:none;" />
				</div>
			</div>
	    </form>
		
		<br>
	    <br>
	    <br>
	    <br>

      <!-- FOOTER -->
      <footer class="container">
        <p class="float-right"><a href="#">Back to top</a></p>
        <p>&copy; 2017 Company, Inc. &middot; <a href="#">Privacy</a> &middot; <a href="#">Terms</a></p>
      </footer>
    </main>

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script>window.jQuery || document.write('<script src="./js/jquery-slim.min.js"><\/script>')</script>
    <script src="./js/popper.min.js"></script>
    <script src="./js/bootstrap.min.js"></script>
    <!-- Just to make our placeholder images work. Don't actually copy the next line! -->
    <script src="./js/holder.min.js"></script>
	
</body>
</html>