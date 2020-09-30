<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Edit hotel</title>
    <link href="/resources/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<jsp:include page="parts/navbar.jsp"/>
<div class="container">
    <h1 class="text-center">Edit ${hotel.name} hotel</h1>
    <form:form method="post" modelAttribute="hotel" enctype="multipart/form-data">
        <form:hidden path="id" />
        <label for="hotelName" class="form-label"><b>Hotel name</b></label>
        <form:input path="name" type="text" class="form-control" id="hotelName" placeholder="Enter hotel name"/>
        <div class="invalid-feedback d-block">
            <form:errors path="name" />
        </div>
        <label for="hotelDescription" class="form-label"><b>Hotel description</b></label>
        <form:textarea path="description" class="form-control" id="hotelDescription" rows="3" placeholder="Description"></form:textarea>

        <label for="hotelCountry" class="form-label"><b>Hotel country</b></label>
        <form:input path="country" class="form-control " list="datalistOptions" id="hotelCountry" placeholder="Enter the country" />
        <datalist id="datalistOptions">
            <c:forEach items="${countries}" var="country">
                <option value="${country.name}"/>
            </c:forEach>
        </datalist>
        <div class="invalid-feedback d-block">
            <form:errors path="country" />
        </div>
        <input type="file" name="file" class="form-control"/>
        <h5 class="text-left text-danger">${fileError}</h5>
        <button class="btn btn-info" type="submit">Submit changes</button>
    </form:form>
</div>
</body>
</html>
