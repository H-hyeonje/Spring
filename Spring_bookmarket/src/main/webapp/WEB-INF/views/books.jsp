<%@page import="java.util.ArrayList"%>
<%@page import="java.awt.print.Book"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
<meta charset="UTF-8">
<title>도서 목록</title>
</head>
<body>
	<nav class="navbar navbar-expand navbar-dark bg-dark">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" href="<c:url value='/home'/>">HOME</a>
				<a class="navbar-brand" href="<c:url value='/books/all'/>">책 목록</a>
				<a class="navbar-brand" href="<c:url value='/books/add'/>">책 등록</a>
			</div>
		</div>
	</nav>
	
	<div class="jumbotron">
		<div class="container">
			<h1 class="display-3">도서목록</h1>
		</div>
	</div>
	
	<div class="container">
		<div class="row" align="center">
			<c:forEach items="${bookList}" var="book">
				<div class="col-md-4">
				 	<% ArrayList<book> book =(ArrayList<book>)request.getAttribute("bookList");
				 	for(book.)
				 	if(==null){%>
				   <img src="/Spring_bookmarket/resources/images/${book.bookId}.png" style="width:60%"/>
					
					<%}else {%>
					<img src="/Spring_bookmarket/resources/images/${book.getBookImage().getOriginalFilename()}" style="width:60%"/>
					<%} %>
					<h3>${book.name}</h3>
					<p>${book.author}
					<br>${book.publisher}| ${book.releaseDate}
					<p align="left">${fn:substring(book.description,0,100) }...</p>
					<p>${book.unitPrice} 원</p>
					<p><a href="<c:url value="/books/book?id=${book.bookId}"/>"
					class="btn btn-primary" role="button">상세정보 &raquo;</a>
				</div>
			</c:forEach>
		</div>
		<hr>
		<footer>
			<p>&copy; BookMarket</p>
		</footer>
	</div>
</body>
</html>