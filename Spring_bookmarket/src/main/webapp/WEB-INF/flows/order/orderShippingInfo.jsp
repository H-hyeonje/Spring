<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- <nav class="navbar navbar-expand navbar-dark bg-dark">
		<div class="container">
			<div class="navbar-header">
				<a class="navbar-brand" href="<c:url value='/home'/>">HOME</a>
			</div>
		</div>
	</nav>
	
		<div class="jumbotron">
		<div class="container">
			<h1 class="display-3">배송정보</h1>
		</div>
	</div>
	 -->
	<div class="container">
		<form:form modelAttribute="order.shipping" class="form-horizontal">
			<fieldset>
				<legend>배송 세부 사항</legend>
				<div class="form-group row">
					<label class="col-sm-2 control-laberl">성명</label>
					<div class="col-sm-3">
				 		 <form:input path="name" class="form-control"/>
					</div>
				</div>
				
				<div class="form-group row">
					<label class="col-sm-2 control-label">배송일</label>
					<div class="col-sm-3">
				 		 <form:input path="date" class="form-control"/>(yyyy/mm/dd)
					</div>
					<div class="col-sm-6">
						<form:errors path="date" class="text-danger"/>
					</div>
				</div>
				
				<div class="form-group row">
					<label class="col-sm-2 control-label">국가명</label>
					<div class="col-sm-3">
				 		 <form:input path="address.country" class="form-control"/>
					</div>
				</div>
				
				<div class="form-group row">
					<label class="col-sm-2 control-label">우편 번호</label>
					<div class="col-sm-3">
				 		 <form:input path="address.zipCode" class="form-control"/>
					</div>
				</div>
				
				<div class="form-group row">
					<label class="col-sm-2 control-label">주소</label>
					<div class="col-sm-3">
				 		 <form:input path="address.addressName" class="form-control"/>
					</div>
				</div>
				
				<div class="form-group row">
					<label class="col-sm-2 control-label">세부주소</label>
					<div class="col-sm-3">
				 		 <form:input path="address.detailName" class="form-control"/>
					</div>
				</div>
				
				<input type="hidden" name="_flowExecutionKey" value="${flowExecutionKey}">
				<div class="form-group row">
					<div class="col-sm-offset-2 col-sm-10">
						<button class="btn btn-default" name="_eventId_backToCustomerInfo">이전</button>
						<input type="submit" class="btn btn-primary" value="등록" name="_eventId_shippingInfo"/> 
						<button class="btn btn-default" name="_eventId_cancel">취소</button>
					</div>
				</div>
			</fieldset>
		</form:form>
	</div>
</body>
</html>