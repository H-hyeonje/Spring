<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
<head>
<link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
<meta charset="UTF-8">
<title>도서 등록</title>
</head>
<body>
<!-- 	<nav class="navbar navbar-expand navbar-dark bg-dark">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" href="<c:url value='/home'/>">HOME</a>
				<a class="navbar-brand" href="<c:url value='/books'/>">책 목록</a>
			</div>
		</div>
	</nav>
	
		<div class="jumbotron">
		<div class="container">
			<h1 class="display-3">
			<spring:message code="addBook.form.title.label"/>
			</h1>
		</div>
	</div> -->	
	
	<div>
		<div>
			<form:form action="${pageContext.request.contextPath}/logout" method="post">
				<input type="submit" class="btn btn-sm btn-success" value="Logout"/>
			</form:form>
		</div>
	</div>
		<div class="float-right" style="padding-right:30px">
			<a href="?language=ko">Korean</a> / <a href="?language=en">English</a>
		</div>
	
	<br></br>
	<div class="container">
		<form:form modelAttribute="book" class="form-horizontal" action="./add?${_csrf.parameterName}=${_csrf.token}"
			enctype="multipart/form-data">
			
		<fieldset>
		<legend><spring:message code="addBook.form.subtitle.label"/></legend>
			<div class="form-group row">
				<label class="col-sm-2 control-laberl"><spring:message code="addBook.form.bookId.label"/></label>
				<div class="col-sm-3">
					<form:input path="bookId" class="form-control"/>
				</div>
				<div class="col-sm-6">
					<form:errors path="bookId" Class="text-danger"/>
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2 control-laberl"><spring:message code="addBook.form.name.label"/></label>
				<div class="col-sm-3">
					<form:input path="name" class="form-control"/>
				</div>
			</div>
				<div class="col-sm-6">
					<form:errors path="name" Class="text-danger"/>
				</div>
			
            <div class="form-group row">
				<label class="col-sm-2 control-laberl"><spring:message code="addBook.form.unitPrice.label"/></label>
				<div class="col-sm-3">
					<form:input path="unitPrice" class="form-control"/>
				</div>
			</div>
			<div class="col-sm-6">
					<form:errors path="unitPrice" Class="text-danger"/>
				</div>
			<div class="form-group row">
				<label class="col-sm-2 control-laberl"><spring:message code="addBook.form.author.label"/></label>
				<div class="col-sm-3">
					<form:input path="author" class="form-control"/>
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2 control-laberl"><spring:message code="addBook.form.description.label"/></label>
				<div class="col-sm-5">
					<form:textarea path="description" cols="50" rows="2" class="form-control"/>
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2 control-laberl"><spring:message code="addBook.form.publisher.label"/></label>
				<div class="col-sm-3">
					<form:input path="publisher" class="form-control"/>
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2 control-laberl"><spring:message code="addBook.form.category.label"/></label>
				<div class="col-sm-3">
					<form:input path="category" class="form-control"/>
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2 control-laberl"><spring:message code="addBook.form.unitsInStok.label"/></label>
				<div class="col-sm-3">
					<form:input path="unitsInStock" class="form-control"/>
				</div>
			</div>
				<div class="col-sm-6">
					<form:errors path="unitsInStock" Class="text-danger"/>
				</div>
			<div class="form-group row">
				<label class="col-sm-2 control-laberl"><spring:message code="addBook.form.releaseDate.label"/></label>
				<div class="col-sm-3">
					<form:input path="releaseDate" class="form-control"/>
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2 control-laberl"><spring:message code="addBook.form.codition.label"/></label>
				<div class="col-sm-3">
					<form:radiobutton path="condition" value="New"/>New
					<form:radiobutton path="condition" value="Old"/>Old
					<form:radiobutton path="condition" value="E-Book"/>E-Book
				</div>
			</div>
			<div class="form-group row">
				<label class="col-sm-2 control-label"><spring:message code="addBook.form.bookImage.label"/></label>
				<div class="col-sm-7">
					<form:input path="bookImage" type="file" class="form-control"/>
				</div>
			</div>
			
			<div class="form-group row">
				<div class="col-sm-offset-2 col-sm-10">
					<input type="submit" class="btn btn-primary" value="<spring:message code="addBook.form.button.label"/>"/>
				</div>
			</div>
		</fieldset>
		</form:form>
	<!-- 	<hr>
		<footer>
			<p>&copy; BookMarket</p>
		</footer> -->
	</div>
</body>
</html>