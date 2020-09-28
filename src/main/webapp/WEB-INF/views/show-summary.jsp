<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Corona Kit Order Summary</title>
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
<nav class="navbar navbar-expand-md bg-dark navbar-dark">
<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
    <span class="navbar-toggler-icon"></span>
  </button>
 <div class="collapse navbar-collapse form-group text-right" id="collapsibleNavbar">
 <ul>   
	     <li class="nav-item">
	      	  <a class="nav-link" href="${pageContext.request.contextPath }/logout">Log Out</a>
	      	</li>  
	 </ul> 
	 </div>
	 </nav>
<h1 class="p-3 mb-2 bg-info text-white" align="center">ORDER SUMMARY</h1>

<div class="alert alert-success">
<h2 align="center">Congratulations!! Your Order has been Submitted Successfully.</h2>
<h2 align="center">Your Order ID is : ${OrderID} </h2>
</div>
<div class="alert alert-info">
<h3>CUSTOMER DETAILS</h3>
</div>
 <section class="container-fluid p-4">
<div>User name : ${ username}</div>
<div>Email Id : ${ email}</div>
<div>Contact Number : ${ contactnumber}</div>
<div>Address1 :${ Address1 }</div>
<div>Address2 :${ Address2 }</div>
<div>City : ${ City}</div>
<div>State : ${ State}</div>
</section>
<div class="alert alert-info">
<h3>Product Summary</h3>
</div>
            <table class="table table-striped table-hover">  
                <tr>  
                    <th>Corona Kit ID#</th>  
                    <th>Product ID</th>  
                    <th>Product Name</th>  
                    <th>Quantity</th>  
                    <th>Cost</th>   
                    
                                        
                </tr>  
                <c:forEach items="${kitdetails}" var="kitdetail">  
                    <tr>  
                        <td>${kitdetail.coronaKitId }</td>  
                        <td>${kitdetail.productId}</td>  
                        <td>${kitdetail.productFullName}</td>  
                        <td>${kitdetail.quantity }</td>  
                        <td>${kitdetail.amount}</td>               
                       
                 
                    </tr>  
                </c:forEach>  
            </table> 

<div class="p-3 mb-2 bg-info text-white">
<h3  align="center"><b>TOTAL COST: ${Totalamount} INR</b></h3>
</div>
<br/>

<br/>
</body>
</html>