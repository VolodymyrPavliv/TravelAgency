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

    <title>Rooms</title>
    <link href="/resources/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<jsp:include page="parts/navbar.jsp"/>
<div class="container">
    <h1 class="text-center">Rooms</h1>
    <form:form action="/rooms" method="post" modelAttribute="newRoom">
        <form:hidden path="hotelId"  />
        <label for="roomNumber" class="form-label"><b>Room number</b></label>
        <form:input path="roomNumber" type="text" class="form-control" id="roomNumbe"  placeholder="Enter room number"/>
        <div class="invalid-feedback d-block">
            <form:errors path="roomNumber" />
        </div>
        <label for="roomType" class="form-label"><b>Room type</b></label>
        <form:input path="type" type="text" class="form-control" id="roomType" placeholder="Enter room type"/>
        <div class="invalid-feedback d-block">
            <form:errors path="type" />
        </div>
        <label for="roomPrice" class="form-label"><b>Room price</b></label>
        <form:input path="price" type="text" class="form-control" id="roomPrice" placeholder="Enter room price"/>
        <div class="invalid-feedback d-block">
            <form:errors path="price" />
        </div>
        <button class="btn btn-info" type="submit">Add room</button>
    </form:form>

    <c:choose>
        <c:when test="${empty rooms}">
            <h4>There are no rooms</h4>
        </c:when>
        <c:otherwise>
            <c:forEach items="${rooms}" var="room">
                <div class="alert alert-info mt-2">
                    <p><b>Room number: </b>${room.roomNumber}</p>
                    <p><b>Room type: </b>${room.type}</p>
                    <p><b>Room price: </b>${room.price}</p>
                    <p>
                        <a href="<c:url value="/rooms/delete/${room.id}"/>"
                           class="btn btn-danger btn-sm">Delete</a>
                    </p>
                </div>
            </c:forEach>
        </c:otherwise>
    </c:choose>
</div>
</body>
</html>