<%@ page contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Home page</title>
    <link href="/resources/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<jsp:include page="parts/navbar.jsp"/>
<div class="container">
    <h1 class="text-center">Hotels
        <c:if test="${not empty param.country}">
            in ${param.country}
        </c:if>
    </h1>

    <form action=""  method="get" >
        <select class="form-select" name="country">
            <c:forEach items="${countries}" var="country">
                <option value="${country.name}">${country.name}</option>
            </c:forEach>
        </select>
        <button class="btn btn-info" type="submit">Find</button>
    </form>

    <c:choose>
        <c:when test="${empty hotels}">
            <h4>There are no hotels</h4>
        </c:when>
        <c:otherwise>
            <c:forEach items="${hotels}" var="hotel">
                <div class="alert alert-info mt-2">
                    <h1>${hotel.country}</h1>
                    <c:if test="${hotel.filename != null}">
                        <img src="/images/${hotel.filename}"/>
                    </c:if>
                    <p>${hotel.name}</p>
                    <p>${hotel.description}</p>
                    <a href="<c:url value="/booking/${hotel.id}"/>" class="btn btn-outline-dark">Rooms</a>
                </div>
            </c:forEach>
        </c:otherwise>
    </c:choose>
</div>
</body>
</html>