<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<body>

<h2>All Employees</h2>

<form action="/delete-selected" method="post">

<table border="1" cellpadding="10">
    <tr>
        <c:if test="${isAdmin}">
            <th>Select</th>
        </c:if>

        <th>Name</th>
        <th>Email</th>
        <th>Role</th>
        <th>Salary</th>

        <c:if test="${isAdmin}">
            <th>Update</th>
        </c:if>
    </tr>

    <c:forEach var="e" items="${employees}">
        <tr>

            <c:if test="${isAdmin}">
                <td>
                    <input type="checkbox" name="selectedEmails" value="${e.email}">
                </td>
            </c:if>

            <td>${e.name}</td>
            <td>${e.email}</td>
            <td>${e.role}</td>
            <td>${e.salary}</td>

            <c:if test="${isAdmin}">
                <td>
                    <a href="/update/${e.email}">
                        <button type="button">Update</button>
                    </a>
                </td>
            </c:if>

        </tr>
    </c:forEach>
</table>

<br>

<c:if test="${isAdmin}">
    <button type="submit">Delete Selected</button>
</c:if>

</form>

</body>
</html>