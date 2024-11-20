<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List"%>
<%@page import="com.springmvc.dto.*" %>
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
			<%
				List<Book> bb=(List<Book>)request.getAttribute("bookList");
				if(bb !=null){
				for(Book book:bb){
				if(book.getBookImage()==null){
			    %>
				<div class="col-md-4">
				   <img src="/Spring_bookmarket/resources/images/<%=book.getBookId()%>.png" style="width:60%"/>
					
					<%}else {%>
					<img src="/Spring_bookmarket/resources/images/<%=book.getBookImage().getOriginalFilename()%>}" style="width:60%"/>
					<%} %>
					<h3><%=book.getName()%></h3>
					<p><%=book.getAuthor() %>
					<br><%=book.getPublisher()%>| <%=book.getReleaseDate()%>
					<p align="left"><%=book.getDescription()%>...</p>
					<p><%=book.getUnitPrice()%> 원</p>
					<p><a href="/Spring_bookmarket/books/book?id=<%=book.getBookId()%>" class="btn btn-primary" role="button" >
					상세정보 &raquo;</a>
				</div>
				
				<%}} %>
		</div>
		<hr>
		<footer>
			<p>&copy; BookMarket</p>
		</footer>
	</div>
</body>
</html>