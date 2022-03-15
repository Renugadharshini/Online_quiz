<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>Student List</h1>
	<table border="2" >
	<tr><th>Student Id</th><th>Student Name</th><th>Student Email</th><th>Student Password</th><th>Edit</th><th>Delete</th></tr>
    <c:forEach var="stu" items="${stuList}"> 
    Student
    <tr>
    <td>${stu.sid}</td>
    <td>${stu.sname}</td>
    <td>${stu.semail}</td>
    <td>${stu.spassword}</td>
    <td><a href="editepro/${stu.sid}">Edit</a></td>
    <td><a href="deletepro/${stu.sid}">Delete</a></td>
    </tr>
    </c:forEach>
    </table>
    <br/>
    <a href="stuform">Add New Student</a>
    
    
</body>
</html>