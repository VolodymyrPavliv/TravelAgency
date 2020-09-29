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

    <title>Management</title>
    <link href="/resources/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<jsp:include page="parts/navbar.jsp"/>
<div class="container">
    <div class="row m-2">
        <h1 class="text-center">Add new hotel</h1>
    </div>
    <form:form action="/hotels/add" method="post" modelAttribute="hotel" enctype="multipart/form-data">
        <label for="hotelName" class="form-label"><b>Hotel name</b></label>
        <form:input path="name" type="text" class="form-control" id = "hotelName" placeholder="Enter hotel name"/>
        <div class="invalid-feedback d-block">
            <form:errors path="name" />
        </div>
        <label for="hotelDescription" class="form-label"><b>Hotel description</b></label>
        <form:textarea path="description"
                       class="form-control"
                       rows="3"
                       id="hotelDescription"></form:textarea>
        <label for="hotelCountry" class="form-label"><b>Hotel country</b></label>
        <form:input path="country" class="form-control" list="datalistOptions" id= "hotelCountry" placeholder="Enter the country" />
        <datalist id="datalistOptions">
            <c:forEach items="${countries}" var="country">
            <option value="${country.name}">
                </c:forEach>
        </datalist>
        <div class="invalid-feedback d-block">
            <form:errors path="country" />
        </div>
        <input type="file" name="file" class="form-control"/>
        <h5 class="text-left text-danger">${fileError}</h5>
        <button class="btn btn-info" type="submit">Add Hotel</button>
    </form:form>
    <div class="row m-2">
        <h1 class="text-center">Hotels</h1>
    </div>
    <c:forEach items="${hotels}" var="hotel">
        <div class="alert alert-info mt-2">
            <h1>${hotel.country}</h1>
            <c:if test="${hotel.filename != null}">
                <img src="/images/${hotel.filename}"/>
            </c:if>
            <p>${hotel.name}</p>
            <p>${hotel.description}</p>
            <p>
                <a href="<c:url value="/rooms/${hotel.id}"/>"
                   class="btn btn-outline-dark btn-sm">Rooms</a>
                <a href="<c:url value="/hotels/edit/${hotel.id}"/>"
                   class="btn btn-info btn-sm">Edit</a>
                <a href="<c:url value="/hotels/delete/${hotel.id}"/>"
                   class="btn btn-danger btn-sm">Delete</a>
            </p>
        </div>
    </c:forEach>
</div>
</body>
</html>