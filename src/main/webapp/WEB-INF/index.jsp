<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>

<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="../js/app.js"></script>

<meta charset="ISO-8859-1">
<title>Dashboard</title>
</head>
<body>
	<div class="row d-flex flex-column justify-content-center align-items-center bg-light">
		<div class="navbar w-75">
			<div class="col-3">
				<h1>Hello, <c:out value="${user.name}"/>!</h1>
			</div>
			<div class="col-1 align-self-end">
				<p class="btn btn-warning"><a href="/logout" class="text-decoration-none text-light">Logout</a></p>
			</div>
		</div>
		<div class="navbar w-75">
			<p>Books from Everyone's shelves</p>
			<p><a href="/review/create">Add a book to my Shelf!</a></p>
		</div>
	</div>
	<div class="row d-flex justify-content-center bg-light">
		<div class="row w-75">
			<table class="table table-striped">
				<thead>
					<tr>
						<td>ID</td>
						<td>Title</td>
						<td>Author Name</td>
						<td>Posted By</td>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="review" items="${allReviews}">
						<tr>
							<td>${review.id}</td>
							<td><a href="review/${review.id}">${review.title}</a></td>
							<td>${review.author}</td>
							<td>${review.user.name}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>