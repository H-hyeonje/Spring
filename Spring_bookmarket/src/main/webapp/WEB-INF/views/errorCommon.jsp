<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
<meta charset="UTF-8">
<title>Insert title here</title>
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
			<h2 class="alert alert-danger">
			해당 도서가 존재 하지 않습니다.<br>
			도서ID : ${invalidBookId}
			</h2>
		</div>
	</div>
	<div class="container">
		<p>${exception}</p>
	</div>
	<div class="container">
		<p>
			<a href="/Spring_bookmarket/books" class="btn btn-secondary">도서목록 &raquo;</a>
		</p>
	</div>
	
</body>
</html>