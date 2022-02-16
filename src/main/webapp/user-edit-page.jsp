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
		<title>User Info</title>
	</head>
	<body class="bg-dark">
  		<nav class="navbar navbar-expand-lg navbar-dark bg-dark py-3">
        	<div class="container-fluid">
            	<a href="#" class="navbar-brand mx-4 font-italic">
            		<h2>
            			<span class="text-warning">Andersen Intensive </span> 
            		</h2>
            		<span class="text-white">
            			<a href="apply?command=get_all_users&page=1" class="nav-link">
            				<h2>
            					Dashboard <i class="fa fa-cogs"></i>
            				</h2>
            			</a>
            		</span>
            	</a>
            	<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navigation-menu"> 
                	<span class="navbar-toggler-icon"></span>
            	</button>
            	<div class="collapse navbar-collapse mx-4" id = "navigation-menu">
                	<ul class="navbar-nav ms-auto">
                    	<li class="nav-item">
                        	
                    	</li>
                    	<li class="nav-item">
                        	<a href="apply?command=empty_command" class="nav-link"><h3>Back to main<i class="fas fa-sign-out-alt grid-icon"></i></h3></a>
                    	</li>
                	</ul>
            	</div>
        	</div>
    	</nav>
    	<div class="container rounded-1 bg-warning p-2 col-sm-5">
		<form method="POST" class="text-black" role="form" action='apply?command=update_user'>
  			<div class="form-group p-2">
    			<label for="username">Username:</label>
    			<input type="text" class="form-control" id="username" name="username" aria-describedby="userNameHelp" value='<c:out value="${user.userName}"/>'>
  			</div>
  			<div class="form-group p-2">
    			<label for="firstName">First Name:</label>
    			<input type="text" class="form-control sm" id="firstName" name="firstName" value='<c:out value="${user.firstName}"/>'>
  			</div>
  			<div class="form-group p-2">
    			<label for="lastName">Last Name:</label>
    			<input type="text" class="form-control" id="lastName" name="lastName" value='<c:out value="${user.lastName}"/>'>
  			</div>
  			<div class="form-group p-2">
    			<label for="email">Email address</label>
    			<input type="email" class="form-control" id="email" name="email" aria-describedby="emailHelp" value='<c:out value="${user.emailAddress}"/>'>
  			</div> 
  			<div class="form-group p-2">
    			<label for="role">Role:</label>
    			<input type="text" class="form-control" id="role" name="role" value='<c:out value="${user.userRole}"/>'>
  			</div>     
  			<input type="hidden" class="form-control" id="old_username" name="old_username" aria-describedby="userNameHelp" value='<c:out value="${username_old}"/>'>  			
  			<input type="submit" class="btn btn-success py-3 px-5 mx-2" value="Submit">
  			<a class="btn btn-danger py-3 px-5 mx-2" href="apply?command=get_all_users&page=1">Cancel</a>
		</form>
		</div>
  		<footer id="sticky-footer" class="flex-shrink-0 py-5 bg-dark text-white-50 fixed-bottom">
    		<div class="container text-center">
      		<small>Developer &copy; Doge programmer</small>
    		</div>
  		</footer>
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