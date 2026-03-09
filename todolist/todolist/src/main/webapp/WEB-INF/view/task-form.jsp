<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Task</title>
</head>

<body>

<h1>Add New Task</h1>

<form:form action="/tasks/save" method="post"
modelAttribute="task"
enctype="multipart/form-data">

Title
<br>

<form:input path="title"/>
<br>

<form:errors path="title" cssStyle="color:red"/>

<br><br>

Description
<br>

<form:textarea path="description"/>
<br>

<form:errors path="description" cssStyle="color:red"/>

<br><br>

Due Date
<br>

<form:input path="dueDate" type="date"/>
<br>

<form:errors path="dueDate" cssStyle="color:red"/>

<br><br>

Priority
<br>

<form:select path="priority">

<form:option value="">Select Priority</form:option>

<form:option value="LOW">LOW</form:option>

<form:option value="MEDIUM">MEDIUM</form:option>

<form:option value="HIGH">HIGH</form:option>

</form:select>

<br>

<form:errors path="priority" cssStyle="color:red"/>

<br><br>

Upload Image
<br>

<input type="file" name="imageFile"/>

<br><br>

<input type="submit" value="Save Task"/>

<a href="/tasks">Cancel</a>

</form:form>

</body>

</html>