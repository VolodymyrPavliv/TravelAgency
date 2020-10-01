<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8"%>
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
    <h1 class="text-center">Enter the date</h1>

    <h3 class="text-left text-info">${message}</h3>
    <c:if test="${message==null}">
        <form method="get" action="">
            <label for="checkIn" class="form-label"><b>Check in</b></label>
            <input name="from"
                   type="date"
                   class="form-control"
                   id="checkIn"
            />
            <label for="checkOut" class="form-label"><b>Check out</b></label>
            <input name="until"
                   type="date"
                   class="form-control"
                   id="checkOut"
            /><br>
            <button class="btn btn-info" type="submit">Submit</button>
        </form>
    </c:if>
</div>
</body>
</html>
