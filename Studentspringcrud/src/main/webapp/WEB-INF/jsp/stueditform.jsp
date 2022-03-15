<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html>
<html>
<head>
<meta  http-equiv="Content-Type" content="text/html; charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1> Edit Student Information </h1>
<form:form method="post" action="/editsave">
sid: <form:hidden path="sid"/> <br>
sname: <form:input path="sname"/> <br>
semail: <form:input path="semail"/> <br>
spassword: <form:input path="spassword"/> <br>
<input type="submit" value="Save changes">
</form:form>
</body>
</html>