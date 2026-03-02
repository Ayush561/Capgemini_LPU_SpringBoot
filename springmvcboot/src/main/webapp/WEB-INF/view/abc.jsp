<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
Login
</head>

<body>
<c:forEach  var="name" items = "${msg}">
<h1> ${name} Welcome to Spring Boot</h1>

</c:forEach>
</body>

</html>