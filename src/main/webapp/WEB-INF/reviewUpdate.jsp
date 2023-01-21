<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Review | Update</title>

<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="../js/app.js"></script>

</head>
<body>
	<div class="row d-flex justify-content-center align-items-center">
		<div class="navbar w-75">
			<h1>Edit <c:out value="${review.title}"/>.</h1>
			<p><a href="/dashboard">Back to the shelves</a></p>
		</div>
	</div>
	<div class="row d-flex justify-content-center align-items-center">
	<form:form action="/review/${review.id}/update" method="POST" modelAttribute="review" class="form w-75">
		<input type="hidden" name="_method" value="PUT">
			<div>
				<form:input path="user" value="${user.id}" type="hidden"/>
			</div>
			<div>
				<form:label path="title" class="form-label">Title</form:label>
				<form:input path="title" class="form-control" value="${review.title}"/>
				<form:errors path="title"/>
			</div>
			<div>
				<form:label path="author" class="form-label">Author</form:label>
				<form:input path="author" class="form-control" value="${review.author}"/>
				<form:errors path="author"/>
			</div>
			<div>
				<form:label path="myThoughts" class="form-label">My Thoughts</form:label>
				<form:textarea path="myThoughts" class="form-control" value="${review.myThoughts}"/>
				<form:errors path="myThoughts"/>
			</div>
			<button class="btn btn-success mt-3">Save Changes</button>
		</form:form>
	</div>
</body>
</html>