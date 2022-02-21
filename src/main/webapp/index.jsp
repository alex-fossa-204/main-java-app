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
		<title>Intensive Task</title>
	</head>
	<body class="bg-dark">
  		<nav class="navbar navbar-expand-lg navbar-dark bg-dark py-3 fixed-top">
        	<div class="container-fluid">
            	<a href="#" class="navbar-brand mx-4 font-italic"><h2><span class="text-warning">Andersen Intensive</span></h2></a>
            	<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navigation-menu"> 
                	<span class="navbar-toggler-icon"></span>
            	</button>
            	<div class="collapse navbar-collapse mx-4" id = "navigation-menu">
                	<ul class="navbar-nav ms-auto">
                    	<li class="nav-item">
                        	<a href="apply?command=get_all_users&page=1" class="nav-link"><h3>Dashboard <i class="fa fa-cogs"></i></h3></a>
                    	</li>
                	</ul>
            	</div>
        	</div>
    	</nav>
		<section class="doge-bg text-light p-5 text-center text-sm-start">
        	<div class="container-fluid">
            	<div class="d-sm-flex align-items-center justify-content-between">
                	<div>
                    	<h1>Even <span class="text-warning">Doge!</span></h1>
                    	<p class="lead my-4">Uses Jenkins with GitHub hook trigers.</p>
                	</div>
                	<img class="img-fluid d-none d-sm-block doge my-4" src='<c:url value="/static/img/doge-cool.jpg"></c:url>' alt="">
            	</div>
        	</div>
    	</section>
    	<section class="bg-dark text-light p-5">
        	<div class="container-fluid">
            	<div class="d-md-flex justify-content-center align-items-center">
                	<h4 class="mb-3 mb-md-0">
                    	<span class="title text-warning">We Used The Most Actual technologies:</span>
                	</h4>
            	</div>
        	</div>
    	</section>
    	<section class="doge-bg p-5">
        	<div class="container">
            	<div class="row text-center g-4">
                	<div class="col-md">
                    	<div class="card bg-dark text-light">
                        	<div class="card-body text-center">
                            	<div class="h1 mb-3">
                                	<i class="bi bi-laptop"></i>
                            	</div>
                            	<h3 class="card-title mb-3">Java EE <i class="fab fa-java white"></i></h3>
                            	<p class="card-text">
                                	Java Enterprise Edition - best variant to create high-performance server applications.
                            	</p>
                        	</div>
                    	</div>
                	</div>
                	<div class="col-md">
                    	<div class="card bg-dark text-light">
                        	<div class="card-body text-center">
                            	<div class="h1 mb-3">
                                	<i class="bi bi-laptop"></i>
                            	</div>
                            	<h3 class="card-title mb-3">JDBC <i class="fas fa-server"></i></h3>
                            	<p class="card-text">
                                	We connect to our databases using this perfect Java specification! Enjoy performance.
                            	</p>
                        	</div>
                    	</div>
                	</div>
                	<div class="col-md">
                    	<div class="card bg-dark text-light">
                        	<div class="card-body text-center">
                            	<div class="h1 mb-3">
                                	<i class="bi bi-laptop"></i>
                            	</div>
                            	<h3 class="card-title mb-3">PostgreSQL <i class="fas fa-database"></i></h3>
                            	<p class="card-text">
                                	We use one of the most popular database management system! PostgreSQL - choice of professionals.
                            	</p>
                        	</div>
                    	</div>
                	</div>
                	<div class="col-md">
                    	<div class="card bg-dark text-light">
                        	<div class="card-body text-center">
                            	<div class="h1 mb-3">
                                	<i class="bi bi-laptop"></i>
                            	</div>
                            	<h3 class="card-title mb-3">JSP <i class="fas fa-file-code"></i></h3>
                            	<p class="card-text">
                                	Java Server Pages - one of the most controversial web tech, but Java Integration - our advantage.
                            	</p>
                        	</div>
                    	</div>
                	</div>             
           		</div>
        	</div>
    	</section>
  		<footer id="sticky-footer" class="flex-shrink-0 py-4 bg-dark text-white-50">
    		<div class="container text-center">
      		<small>Developer &copy; Doge programmer</small>
    		</div>
  		</footer>
    	<script src="<c:url value='https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js'/>" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
	</body>