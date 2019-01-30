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
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/7.33.1/sweetalert2.css">
    <link rel="stylesheet" href="https://cdn.datatables.net/1.10.19/css/dataTables.bootstrap4.min.css">
    
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
		      <a class="nav-link"><%= request.getSession().getAttribute("email") %></a>
		    </li>
		    <li class="nav-item">
		      <a href="<%=request.getContextPath()%>/logout" class="nav-link"><i class="fa fa-sign-out fa-fw" aria-hidden="true"></i> Logout</a>
		    </li>
		  </ul>
	  </div>
	</div> 
  </nav>
  	<section>
  		<div class="container">
  			<div class="row">
  				<div class="col">
  					<h1 class="animated fadeIn welcome-text-tile">Detail of Users <small class="slug-help-block"> profile of ${USERS_DATA.firstname} ${USERS_DATA.lastname}</small></h1>
  				</div>
  			</div>
  			<div class="row">
		  		<div class="col">
		  			<div class="wrapper-table">
		  				<table class="table">
		  					<tr>
		  						<td>Full Name</td>
		  						<td>:</td>
		  						<td>${USERS_DATA.firstname} ${USERS_DATA.lastname}</td>
		  					</tr>
		  					<tr>
		  						<td>Email</td>
		  						<td>:</td>
		  						<td>${USERS_DATA.email}</td>
		  					</tr>
		  					<tr>
		  						<td>Phone</td>
		  						<td>:</td>
		  						<td>${USERS_DATA.phone}</td>
		  					</tr>
		  				</table>
		  			</div>
		  		</div>
		  </div>
  		</div>
  	</section>
	
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/limonte-sweetalert2/7.33.1/sweetalert2.all.js"></script>
    <script type="text/javascript" src="https://cdn.datatables.net/1.10.19/js/jquery.dataTables.min.js"></script>
    <script type="text/javascript" src="https://cdn.datatables.net/1.10.19/js/dataTables.bootstrap4.min.js"></script>
  </body>
</html>