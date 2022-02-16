<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    	<link rel="icon" type="image/x-icon" href="favicon.ico">
    	<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    	<style><%@ include file="/static/css/style.css"%></style>
		<title>Dashboard</title>
	</head>
	<body class="bg-dark">
  		<nav class="navbar navbar-expand-lg navbar-dark bg-dark py-3">
        	<div class="container-fluid">
            	<a href="#" class="navbar-brand mx-4 font-italic">
            		<h2>
            			<span class="text-warning">Andersen Intensive </span> 
            		</h2>
            		<a href="apply?command=get_all_users&page=1" class="nav-link">
            			<h2>Dashboard <i class="fa fa-cogs"></i></h2>
            		</a>
            	</a>
            	<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navigation-menu"> 
                	<span class="navbar-toggler-icon"></span>
            	</button>
            	<div class="collapse navbar-collapse mx-4" id = "navigation-menu">
                	<ul class="navbar-nav ms-auto">
                		<li class="nav-item mx-4">
                			<button class="btn btn-warning btn-lg" data-bs-toggle="modal" data-bs-target="#addUserModal">Add New User<i class="fa fa-users"></i></button>
                    	</li>
                    	<li class="nav-item">
                    	</li>
                    	<li class="nav-item">
                        	<a href="apply?command=empty_command" class="nav-link"><h3>Back to main<i class="fas fa-sign-out-alt grid-icon"></i></h3></a>
                    	</li>
                	</ul>
            	</div>
        	</div>
    	</nav>
		<nav class="navbar navbar-expand-lg navbar-dark bg-dark py-3">
			<div class="pagination" id="pagination"></div>
		</nav>
  		<footer id="sticky-footer" class="flex-shrink-0 py-5 bg-dark text-white-50 fixed-bottom">
    		<div class="container text-center">
      		<small>Developer &copy; Doge programmer</small>
    		</div>
  		</footer>
    	<div class="modal fade bg-dark" id="addUserModal" tabindex="-1" aria-labelledby="addUserModal" aria-hidden="true">
      		<div class="modal-dialog">
        		<div class="modal-content bg-warning text-black">
          			<div class="modal-header">
            			<h5 class="modal-title" id="enrollLabel">Add New User</h5>
            			<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
          			</div>
          			<div class="modal-body">
            			<p class="lead">Fill out this form and save user info in our database</p>
            			<form method="POST" action="apply?command=add_user">
              				<div class="mb-3">
                				<label for="username" class="col-form-label">Username:</label>
                				<input type="text" class="form-control" id="username" name="username" />
              				</div>
              				<div class="mb-3">
                				<label for="firstName" class="col-form-label">First Name:</label>
                				<input type="text" class="form-control" id="firstName" name="firstName"/>
              				</div>

              				<div class="mb-3">
                				<label for="lastName" class="col-form-label">Last Name:</label>
                				<input type="text" class="form-control" id="lastName" name="lastName"/>
              				</div>
              				<div class="mb-3">
                				<label for="email" class="col-form-label">Email</label>
                				<input type="text" class="form-control" id="email" name="email"/>
              				</div>             				
          					<div class="modal-footer">
            					<button type="button" class="btn btn-dark" data-bs-dismiss="modal">Close</button>
            					<button type="submit" class="btn btn-success">Add</button>
          					</div>
          				</form>
        			</div>
        		</div>
      		</div>
    	</div>
    	<h2>
    		<a href="apply?command=get_all_users&page=1" class="nav-link text-warning message">
    			<c:out value='${message}'/>
    		</a> 
    	</h2>
  		<script type="text/javascript">
  			let pages = "<c:out value='${numberOfPages}'/>";
  			let pageSelectorCounter = "<c:out value='${numberOfPages}'/>";
  			<%@ include file="/static/js/page-navigator.js"%>
  		</script>
    	<script src="<c:url value='https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js'/>" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
	</body>