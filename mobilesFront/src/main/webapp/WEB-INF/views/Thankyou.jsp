<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src = "https://ajax.googleapis.com/ajax/libs/angularjs/1.3.14/angular.min.js"></script>

<title>ThankYou</title>
<style>
.background
{
   height: 800px;
   background-image: url("resources/images/thank.jpg");
   background-repeat: no-repeat;
   background-size: 100%;
}
.style
{
   text-align:center;
   position: relative;
   top: 20%;
}
</style>
</head>
<body>
<%@include file="HeaderPage.jsp"%>
<div class="background">
   <div class="style">
   <h2>THANK YOU<h2>
   <h3>your good time starts here...<h3>
   <h4>Visit our website again!!<h4>
   </div>
</div>
<%@ include file="Footer.jsp" %>

</body>
</html>
