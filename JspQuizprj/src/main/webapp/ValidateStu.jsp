<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<sql:setDataSource 
driver="com.mysql.jdbc.Driver" 
url="jdbc:mysql://localhost:3306/qzstudent?characterEncoding=latin1" 
user="root"
password="tiger" var="a"/>

<sql:query dataSource="${a}" var="result">
	select * from studt where sname=? and spassword=?
	<sql:param value="${param.t1}"/>
	<sql:param value="${param.t2}"/>
</sql:query>


<!--<core:forEach items="${result.rows}" var="row">
	Hi Valid User
</core:forEach>-->

<core:choose>
	<core:when test="${result.rowCount == 0 }">
		Invalid User
	</core:when>
	<core:otherwise>
		welcome!!!!
		<a href="Quizimg.html">click here to take quiz</a>
	</core:otherwise>
</core:choose>

</body>
</html>