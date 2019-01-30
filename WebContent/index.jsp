<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<!-- Custom CSS -->
	<link rel="stylesheet" href="<%=request.getContextPath()%>/css/additional.css">
	<link rel="stylesheet" href="<%=request.getContextPath()%>/css/animate.css">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <title>RMS</title>
  </head>
  <body>
  <nav class="navbar navbar-expand-lg custom-navbar">
	<div class="container-fluid">
		 <a class="navbar-brand" href="index.jsp">RMS</a>
	  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
	    <span class="navbar-toggler-icon"></span>
	  </button>
	
	  <div class="collapse navbar-collapse" id="navbarSupportedContent">
	  
		  <ul class="navbar-nav ml-auto">
		    <li class="nav-item">
		      <a href="login" class="nav-link">Login</a>
		    </li>
		    <li class="nav-item">
		      <a class="nav-link">Link</a>
		    </li>
		  </ul>
	  </div>
	</div> 
  </nav>
  <section class="welcome-section h-100">
  		<div class="container h-100">
		  <div class="row h-100 justify-content-center align-items-center">
		   	<h1 class="animated fadeIn text-center welcome-text">Welcome to RMS Case Study <small class="slug-help-block">This application is made by JSP and Servlet under tomcat 7 build on Maven </small></h1>  
		  </div>
		</div>
  </section>

    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
  </body>
</html>