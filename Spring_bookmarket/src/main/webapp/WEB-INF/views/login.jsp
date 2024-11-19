<%@page import="javax.security.auth.message.callback.PrivateKeyCallback.Request"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
	<nav class="navbar navbar-expand navbar-dark bg-dark">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" href="/home">HOME</a>
			</div>
		</div>
	</nav>
	
	<div class="jumbotron">
		<div class="container">
			<h1 class="display-3">로그인</h1>
		</div>
	</div>
	
	<div class="container col-md-4">
		<div class="text-center">
			<h3 class="form-signin-heading">Please login</h3>
		</div>
	</div>
	<% if(request.getAttribute("error")!=null && request.getAttribute("error").equals("true")) {%>
		<div class="alert alert-danger">
			UserName과 Password가 올바르지 않습니다.<br />
		</div>
	<% }%>
	<form class="form-signin" action="login" method="post">
		<div class="form-grop row">
			<input type="text" name="username" class="form-control" placeholder="User Name" required autofocus/>
		</div>
		
		<div class="form-grop row">
			<input type="password" name="password" class="form-control" placeholder="Password" required/>
		</div>
		
		<div class="form-grop row">
			<button class="btn btn-lg btn-success btn-block" type="submit">로그인</button>
			<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">
		</div>
	</form>
		
		
</body>
</html>