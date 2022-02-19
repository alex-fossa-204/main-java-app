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
            	<a href="#" class="navbar-brand font-italic">
            		<h2> Reports table for: 
            			<span class="text-warning"><c:out value="${currentUserName}"/></span> 
            		</h2>
            	</a>
            	<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navigation-menu"> 
                	<span class="navbar-toggler-icon"></span>
            	</button>
            	<div class="collapse navbar-collapse mx-4" id = "navigation-menu">
            	    <ul class="navbar-nav ms-auto">
                    	<li class="nav-item">
                    		<a href="apply?command=get_all_users&page=1" class="nav-link">
            					<h2>Dashboard <i class="fa fa-cogs"></i></h2>
            				</a>
                    	</li>
                    	<li class="nav-item">
                        	<a href="apply?command=empty_command" class="nav-link"><h2>Back to main<i class="fas fa-sign-out-alt grid-icon"></i></h2></a>
                    	</li>
                	</ul>
            	</div>
        	</div>
    	</nav>
    	<c:if test="${list.size() < 1}">
    		<c:if test='${message.equalsIgnoreCase("You Dont Have Any Reports. Press Here To Continue")}'>
    			<h2>
    		    	<a href="" class="nav-link text-warning message" data-bs-toggle="modal" data-bs-target="#addReportModal">
    					<c:out value='${message}'/>
    				</a>
    			</h2>
    		</c:if>
    		<c:if test='${message.equalsIgnoreCase("You Dont Have Any Reports During This Period Message")}'>
    			<h2>
    				<a href='apply?command=show_user_reports&username=<c:out value="${currentUserName}&page=1"/>' class="nav-link text-warning message">
    					<c:out value='${message}'/>
    				</a> 
    			</h2>
    		</c:if>
    		<c:if test='${message.equalsIgnoreCase("Report Added Successfully. Press Here To Continue")}'>
    			<h2>
    				<a href='apply?command=show_today_user_reports&currentUserName=<c:out value="${currentUserName}&page=1"/>' class="nav-link text-warning message">
    					<c:out value='${message}'/>
    				</a> 
    			</h2>
    		</c:if>    		
    		<h2>
    			<a href="apply?command=get_all_users&page=1" class="nav-link text-white message">
    				Back to Dashboard
    			</a> 
    		</h2>
  		</c:if>
  		<c:if test="${list.size() != 0}">
  			<h2>
    			<a href='apply?command=show_today_user_reports&currentUserName=<c:out value="${currentUserName}&page=1"/>' class="nav-link text-warning message">
    				<c:out value='${message}'/>
    			</a> 
    		</h2>
  		</c:if>
  		<c:if test="${list.size() > 0}">
    	<div class="container-fluid">
    	  <nav class="navbar navbar-expand-lg navbar-dark bg-dark py-3">
    	     <div class="navbar-brand">
            	<h2>Reports for: <span class="text-warning"><c:out value="${reportDate}"/></span></h2>
           	</div>
			<ul class="navbar-nav ms-auto">
				<c:if test="${numberOfPages >= 1}">
					<li class="nav-item mx-4">
                		<button class="btn btn-warning btn-lg" data-bs-toggle="modal" data-bs-target="#dateFilterReportModal">Date Filter <i class="far fa-calendar-alt"></i></button>
                	</li>
                	<li class="nav-item mx-4">
                		<a class="btn btn-warning btn-lg text-black" href='apply?command=show_today_user_reports&currentUserName=<c:out value="${currentUserName}&page=1"/>'>Reset Filter</a>
                	</li>
                	<li class="nav-item mx-4">
                		<a class="btn btn-warning btn-lg text-black" href='apply?command=show_user_reports&currentUserName=<c:out value="${currentUserName}&page=1"/>'>Show All</a>
                	</li>
					<li class="nav-item mx-4">
                		<button class="btn btn-success btn-lg" data-bs-toggle="modal" data-bs-target="#addReportModal">Add Report<i class="fa fa-users"></i></button>
                	</li>
                </c:if>
			</ul>
		</nav>
    	<table class="table table-hover table-dark mb-0">
  			<thead>
     			<tr>
      				<th scope="col"><h4>Report Title</h4></th>
      				<th scope="col"><h4>Report Date</h4></th>
      				<th scope="col"><h4>Time Costs</h4></th>
      				<th scope="col"><h4>Details:</h4></th>
    			</tr>
  			</thead>

  			<tbody>
  			<c:forEach var="report" items="${list}">
    			<tr>
      				<td scope="col" class="py-3"><c:out value="${report.reportTitle}"/></td>
      				<td scope="col" class="py-3"><c:out value="${report.reportDate}"/></td>
      				<td scope="col" class="py-3"><c:out value="${report.laborCost}"/></td>
      				<td scope="col" class="py-3"><c:out value="${report.reportBody}"/></td>
      				<td scope="col" class="py-3">
      					<a class="btn btn-warning" href='apply?command=show_edit_report_form&username=<c:out value="${currentUserName}"/>&reportId=<c:out value="${report.id}"/>'>Update</a>
      				</td>
      				<td scope="col" class="py-3">
      					<form method="POST" action="apply?command=delete_report&reportId=<c:out value='${report.id}'/>">
      						<button type="submit" class="btn btn-danger">Delete</button>
      					</form>
      				</td>
    			</tr>
    		</c:forEach>		    						    						  						
  			</tbody>
		</table> </div>
		</c:if>
		<c:if test="${numberOfPages > 1}">
		<nav class="navbar navbar-expand-lg navbar-dark bg-dark py-3">
			<div class="pagination" id="pagination"></div>
		</nav>
		</c:if>
  		<footer id="sticky-footer" class="flex-shrink-0 py-5 bg-dark text-white-50 fixed-bottom">
    		<div class="container text-center">
      		<small>Developer &copy; Doge programmer</small>
    		</div>
  		</footer>
    	<div class="modal fade bg-dark" id="addReportModal" tabindex="-1" aria-labelledby="addReportModal" aria-hidden="true">
      		<div class="modal-dialog">
        		<div class="modal-content bg-warning text-black">
          			<div class="modal-header">
            			<h5 class="modal-title" id="enrollLabel">Add New Report</h5>
            			<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
          			</div>
          			<div class="modal-body">
            			<p class="lead">Fill out this form and save report info in our database</p>
            			<form method="POST" action="apply?command=add_report">
              				<div class="mb-3">
                				<label for="username" class="col-form-label">Report Title:</label>
                				<input type="text" class="form-control" id="reprtTitle" name="reportTitle" />
              				</div>
              				<div class="mb-3">
                				<label for="reportBody" class="col-form-label">Report Body:</label>
                				<textarea class="form-control" id="reportBody" name="reportBody" rows="5"></textarea>
              				</div>

              				<div class="mb-3">
                				<label for="laborCosts" class="col-form-label">Time Сosts(hours):</label>
                				<input type="text" class="form-control" id="laborCosts" name="laborCosts"/>
              				</div>     				
          					<div class="modal-footer">
            					<button type="button" class="btn btn-dark" data-bs-dismiss="modal">Close</button>
            					<button type="submit" class="btn btn-success">Add</button>
          					</div>
          					<input type="hidden" class="form-control" id="currentUserName" name="username" aria-describedby="userNameHelp" value='<c:out value="${currentUserName}"/>'> 
          				</form>
        			</div>
        		</div>
      		</div>
    	</div>
    	<div class="modal fade" id="dateFilterReportModal" tabindex="-1" aria-labelledby="dateFilterReportModal" aria-hidden="true">
      		<div class="modal-dialog">
        		<div class="modal-content bg-warning text-black">
          			<div class="modal-header">
            			<h5 class="modal-title" id="enrollLabel">Reports List Filter By Date</h5>
            			<button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
          			</div>
          			<div class="modal-body">
            			<p class="lead">Check Date To Make Filter By Date</p>
            			<form method="GET" action='apply'>
            				<input type="hidden" class="form-control" id="command" name="command" aria-describedby="commandHelp" value="show_user_reports_by_date"> 
            			     <div class="mb-3">
                				<label for="filterDate" class="col-form-label">Date:</label>
                				<input type="date" class="form-control" id="filterDate" name="filterDate"/>
              				</div>
              				<input type="hidden" class="form-control" id="currentUserName" name="currentUserName" aria-describedby="userNameHelp" value='<c:out value="${currentUserName}"/>'> 				
          					<div class="modal-footer">
            					<button type="button" class="btn btn-dark" data-bs-dismiss="modal">Close</button>
            					<button type="submit" class="btn btn-success">Add</button>
          					</div>
          				</form>
        			</div>
        		</div>
      		</div>
    	</div>

  		<script type="text/javascript">
  			let date = "<c:out value="${reportDate}"/>";
  			console.log('date declaration' + date);
  			let commandBody = "<c:out value="${command}"/>";
  			let recordsPerPage = "<c:out value="${recordsPerPage}"/>";
  			let username = "<c:out value="${currentUserName}"/> "; username.trim();
  			let pages = "<c:out value='${numberOfPages}'/>";
  			let pageSelectorCounter = "<c:out value='${numberOfPages}'/>";
  			<%@ include file="/static/js/reports-page-navigator.js"%>
  		</script>
    	<script src="<c:url value='https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js'/>" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
	</body>