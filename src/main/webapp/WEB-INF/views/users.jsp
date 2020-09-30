<%@ page contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01
Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Users</title>
    <link href="/resources/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<jsp:include page="parts/navbar.jsp"/>
<div class="container">
    <h1 class="text-center">Users</h1>
    <c:forEach items="${users}" var="user">
        <div class="alert alert-info mt-2">
            <h2>${user.name}</h2>
            <p>${user.email}</p>
            <p>
                <a href="<c:url value="/users/orders/${user.id}"/>" class="btn btn-outline-dark btn-sm">Orders</a>
                <a href="<c:url value="/users/edit/${user.id}"/>" class="btn btn-info btn-sm">Edit status</a>
                <a href="<c:url value="/users/delete/${user.id}"/>" class="btn btn-danger btn-sm">Delete</a>
            </p>
        </div>
    </c:forEach>
</div>
</body>
</html>