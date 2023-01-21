<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Review</title>

<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="../js/app.js"></script>

</head>
<body>
	<div class="container justify-content-center align-items-center bg-light rounded mt-5 p-5 shadow">
		<div class="row justify-content-center ">
			<div class="navbar w-75">
				<h1><c:out value="${review.title}"/></h1>
				<p><a href="/dashboard">Back to the shelves</a></p>
			</div>
		</div>
		<c:if test="${review.user.id == currentUser}">
			<div class="row">
				<div class="row">
					<h2><span class="text-danger">You</span> read <span class="text-info"><c:out value="${review.title}"/></span> by <span class="text-success"><c:out value="${review.author}"/></span></h2>
					<p>Here is your review:</p>
				</div>
			</div>
		</c:if>
		<c:if test="${review.user.id != currentUser}">
			<div class="row">
				<div class="row">
					<h2><span class="text-danger"><c:out value="${review.user.name}"/></span> read <span class="text-info"><c:out value="${review.title}"/></span> by <span class="text-success"><c:out value="${review.author}"/></span></h2>
					<p>Here is the review by <c:out value="${review.user.name}"/>:</p>
				</div>
			</div>
		</c:if>
		<div class="row justify-content-center">
			<div class="border-top border-bottom border-solid border-dark w-75 d-flex justify-content-center align-items-center my-5 p-5">
				<p class="blockquote m-0"><c:out value="${review.myThoughts}"/></p>
			</div>
		</div>
		<div class="d-flex justify-content-center">
		<c:if test="${review.user.id == currentUser}">
			<div class="d-flex justify-content-between w-25">
				<p class="btn btn-primary"><a href="/review/${review.id}/update" class="text-decoration-none text-light">Edit</a></p>
				<form:form action="/review/${review.id}/delete" method="POST">
					<input type="hidden" name="_method" value="DELETE"/>
					<button class="btn btn-danger">Delete</button>
				</form:form>
			</div>
		</c:if>
		</div>
	</div>
</body>
</html>