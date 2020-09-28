<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="d-flex flex-column flex-md-row align-items-center p-3 px-md-4 mb-3 bg-white border-bottom shadow-sm">
    <h5 class="my-0 mr-md-auto font-weight-normal">Travel Agency</h5>
    <nav class="my-2 my-md-0 mr-md-3">
        <a class="p-2 text-dark" href="<c:url value="/"/>">Home</a>
        <c:if test="${pageContext.request.isUserInRole('MANAGER')}">
            <a class="p-2 text-dark" href="<c:url value="/hotels"/>">Management</a>
            <a class="p-2 text-dark" href="<c:url value="/users"/>">User List</a>
        </c:if>
        <a class="p-2 text-dark" href="<c:url value="/logout"/>">Logout</a>
    </nav>
</div>
