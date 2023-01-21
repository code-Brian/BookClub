<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

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
	<div class="row d-flex justify-content-center align-items-center">
		<div class="navbar w-75">
			<h1>Add a Book to Your Shelf.</h1>
			<p><a href="/dashboard">Back to the shelves</a></p>
		</div>
	</div>
	<div class="row d-flex justify-content-center align-items-center">
		<form:form action="/review/create" method="POST" modelAttribute="review" class="form w-75">
			<div>
				<form:input path="user" value="${user.id}" type="hidden"/>
			</div>
			<div>
				<form:label path="title" class="form-label">Title</form:label>
				<form:input path="title" class="form-control"/>
				<form:errors path="title"/>
			</div>
			<div>
				<form:label path="author" class="form-label">Author</form:label>
				<form:input path="author" class="form-control"/>
				<form:errors path="author"/>
			</div>
			<div>
				<form:label path="myThoughts" class="form-label">My Thoughts</form:label>
				<form:textarea path="myThoughts" class="form-control"/>
				<form:errors path="myThoughts"/>
			</div>
			<button class="btn btn-success mt-3">Create Book</button>
		</form:form>
	</div>
</body>
</html>