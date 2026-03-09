<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TaskTrack - Task List</title>
</head>

<body>

<h1>To-Do List</h1>

<a href="/tasks/new">Add Task</a>

<br><br>

<table border="1">

<tr>
<th>Image</th>
<th>Title</th>
<th>Description</th>
<th>Due Date</th>
<th>Priority</th>
<th>Status</th>
<th>Actions</th>
</tr>

<c:forEach var="task" items="${taskList}">

<tr>

<td>

<c:choose>

<c:when test="${task.imageData != null}">
<img src="/tasks/image/${task.id}" width="60" height="60"/>
</c:when>

<c:otherwise>
No Image
</c:otherwise>

</c:choose>

</td>

<td>${task.title}</td>

<td>${task.description}</td>

<td>${task.dueDate}</td>

<td>${task.priority}</td>

<td>${task.status}</td>

<td>

<a href="/tasks/toggle/${task.id}">Toggle</a>

|

<a href="/tasks/delete/${task.id}">Delete</a>

</td>

</tr>

</c:forEach>

</table>

</body>
</html>