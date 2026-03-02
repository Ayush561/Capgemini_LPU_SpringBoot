<html>
<body>

<h2>Update Employee</h2>

<form action="/update-employee" method="post">

    Email (Cannot Change): <br>
    <input type="text" name="email" value="${emp.email}" readonly> <br><br>

    Name: <br>
    <input type="text" name="name" value="${emp.name}"> <br><br>

    Role: <br>
    <input type="text" name="role" value="${emp.role}"> <br><br>

    Salary: <br>
    <input type="number" name="salary" value="${emp.salary}"> <br><br>

    <button type="submit">Update</button>

</form>

</body>
</html>