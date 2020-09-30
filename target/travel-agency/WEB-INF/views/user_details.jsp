<%@ page contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01
Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>User details</title>
    <link href="/resources/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<jsp:include page="parts/navbar.jsp"/>
<div class="container">
    <h1 class="text-center">User details of ${user.name}</h1>
    <div class="alert alert-info mt-2">
        <p><b>Name: </b>${user.name}</p>
        <p><b>Email: </b>${user.email}</p>
        <p><b>Has management status: </b>&nbsp;
            <c:choose>
                <c:when test="${isManager == true}">
                    Yes
                </c:when>
                <c:otherwise>
                    No
                </c:otherwise>
            </c:choose>
        </p>
        <form action="" method="post">
            <button class="btn btn-info" type="submit">Change status</button>
        </form>
    </div>
</div>
</body>
</html>