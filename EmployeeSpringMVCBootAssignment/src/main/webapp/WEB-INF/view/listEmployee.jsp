<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Employee List</title>
</head>

<body>

<h2>Employee List</h2>

<c:forEach var="emp" items="${msg}">
    <p>
        Name: ${emp.name} <br>
        Email: ${emp.email} <br>
        Role: ${emp.role}
    </p>
    <hr>
</c:forEach>

</body>
</html>