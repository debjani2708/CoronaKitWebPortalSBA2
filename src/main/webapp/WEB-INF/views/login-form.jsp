<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="spring-form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Corona Kit Log In</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

</head>
<body class="view" style="background-image: url('https://i.pinimg.com/originals/59/6f/92/596f926d27722a72567f001eccc01221.jpg'); height=100%;
 background-repeat: no-repeat; background-size: cover; background-position: center center;">
<h2 class="p-3 mb-2 bg-info text-white">Log In Page</h2>
 <br>
<section class="container-fluid p-4">
<form action="${pageContext.request.contextPath}/login" method="POST">
			<c:if test="${param.error ne null}">
				Invalid Credentials! Access Denied!
			</c:if>
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
			<div class="form-group">
			<label class="text-white">UserName: <input type="text" name="unm" class="form-control"/></label>
			</div>
			<div class="form-group">
			<label class="text-white">Password: <input type="password" name="pwd" class="form-control"/></label>
			</div>
			<div class="form-group">
			<button class="btn pull-right btn-primary">Log In</button>
			</div>			
		</form>
</section>
<jsp:include page="/footer" />
</body>
</html>