<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
     <%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<sql:setDataSource var="con" 
	driver="com.mysql.jdbc.Driver"
	url="jdbc:mysql://localhost:3306/qzstudent?characterEncoding=latin1" 
	user="root" password="tiger"/>
	
	<sql:query dataSource="${con}" var="res">
		select * from stud
	</sql:query>
	
	<table border="1">
		<tr>
		    <th>Student Id</th>
			<th>Student Name</th>
			<th>Student email</th>
			<th>Student Password </th>
			
		</tr>
		<c:forEach items="${res.rows}" var="row">
			<tr><!--  Column names of table -->
			    <td><c:out value="${row.sid}"/></td>
				<td><c:out value="${row.sname}"/></td>
				<td><c:out value="${row.semail}"/></td>
				<td><c:out value="${row.spassword}"/></td>	
			</tr>
		</c:forEach>
		
	</table>
</body>
</body>
</html>