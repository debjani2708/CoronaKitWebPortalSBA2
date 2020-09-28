<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Corona Kit Checkout</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>
</head>
<body class="view" style="background-image: url('https://thedealsforyou.com/wp-content/uploads/2020/01/33400.jpg'); height=100%;
 background-repeat: no-repeat; background-size: cover; background-position: center center;">
<div>
</div>
<nav class="navbar navbar-expand-md bg-dark navbar-dark">
<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
    <span class="navbar-toggler-icon"></span>
  </button>
 <div class="collapse navbar-collapse" id="collapsibleNavbar">
 	<ul class="navbar-nav">
 		<li class="nav-item">
	        <a class="nav-link" href="${pageContext.request.contextPath }/user/home">USER DASHBOARD</a>
	      </li> 
		<li class="nav-item">
	        <a class="nav-link" href="${pageContext.request.contextPath }/user/show-list">Products List</a>
	     </li>
	     <li class="nav-item">
	      	  <a class="nav-link" href="${pageContext.request.contextPath }/logout">Log Out</a>
	      	</li>	     
	 </ul> 
	 </div>
	 </nav>

 <section class="container-fluid p-4">
 <div class="p-3 mb-2 bg-info text-white">
	<h3>Please Enter your Delivery Address and details</h3>
	</div>
 <div class="col-sm-4">   
	<form:form action="${pageContext.request.contextPath }/user/finalize" method="post" modelAttribute="Address">
		
		
		<div class="form-group">  
            <form:label path="Address1">Address Line1:</form:label>  
            <form:input type="text" path="Address1" class="form-control"/>
            <form:errors path="Address1" class="alert alert-warning"/>   
        </div> 
        
        <div class="form-group">  
            <form:label path="Address2">Address Line2:</form:label>  
            <form:input type="text" path="Address2" class="form-control"/>
            <form:errors path="Address2" class="alert alert-warning"/>   
        </div>
       
        <div class="form-group">  
            <form:label path="City">City :</form:label>  
            <form:input type="text" path="City" class="form-control"/> 
            <form:errors path="City" class="alert alert-warning"/>  
        </div>
        
        <div class="form-group">  
            <form:label path="State">State :</form:label>  
            <form:input type="text" path="State" class="form-control"/>  
            <form:errors path="State" class="alert alert-warning"/> 
        </div>
        
        <div class="form-group text-right"> 
        <button class="btn pull-right btn-primary">Finalize Order</button>
        </div>
</form:form>
</div>
</section>
</body>
</html>