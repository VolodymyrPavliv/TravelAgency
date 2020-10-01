<%@ page contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
    <h1 class="text-center">Orders of ${user.name}</h1>
    <c:choose>
        <c:when test="${empty orders}">
            <h4>User has no orders</h4>
        </c:when>
        <c:otherwise>
            <c:forEach items="${orders}" var="order">
                <div class="alert alert-info mt-2">
                    <p>
                        <b>Name: </b> <i>${order.room.hotel.name}</i> &nbsp;
                        <a href="/rooms/${order.room.hotel.id}"
                           class="btn btn-sm btn-outline-dark">Hotel rooms
                        </a>
                    </p>
                    <p>
                        <b>Room Number: </b>${order.room.roomNumber}
                    </p>
                    <p><b>Check in: </b>${order.checkIn}</p>
                    <p><b>Check out: </b>${order.checkOut}</p>
                </div>
            </c:forEach>
        </c:otherwise>
    </c:choose>
</div>
</body>
</html>