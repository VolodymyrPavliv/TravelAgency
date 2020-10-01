<%@ page contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01
Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Book room</title>
    <link href="/resources/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<jsp:include page="parts/navbar.jsp"/>
<div class="container">
    <h1 class="text-center">Booking room</h1>
    <c:forEach items="${availableRooms}" var="room">
        <form:form action="/booking/${room.id}" modelAttribute="bookingRoom">
            <form:hidden path="from" />
            <form:hidden path="until" />
            <div class="alert alert-info mt-2">
                <p><b>Room number: </b>${room.roomNumber}</p>
                <p><b>Room type: </b>${room.type}</p>
                <p><b>Room price: </b>${room.price}</p>
                <button type="submit" class="btn btn-info btn-sm">Choose</button>
            </div>
        </form:form>
    </c:forEach>
</div>
</body>
</html>