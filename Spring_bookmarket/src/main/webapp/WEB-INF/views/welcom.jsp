<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link href="./resources/css/bootstrap.min.css" rel="stylesheet">
<meta charset="UTF-8">
<title>Welcom</title>
</head>
<body>
<!--	<nav class="navbar navbar-expand navbar-dark bg-dark">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" href="<c:url value='/home'/>">Home</a>
				<a class="navbar-brand" href="<c:url value='/books/all'/>">책 목록</a>
			</div>
		</div>
	</nav>
	<div class="jumbotron">
		<div class ="container">
			<h1 class="display-3">${greeting}</h1>
		</div>
	</div>-->
	<div class="container">
		<div class="text-center">
			<h3>${strapline}</h3>
		</div>
	</div>
	
	<!-- <footer class="container">
		<hr>
		<p>&copy; WebMarket</p>
	</footer> -->
</body>
</html>