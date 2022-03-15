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

<h1>Register New Student</h1>
       <form:form method="post" action="save" modelAttribute="stu">  
      	<table >
      	<tr>  
          <td>sid : </td> 
          <td><form:input path="sid"  /></td>
         </tr>  
         <tr>  
          <td>SName : </td> 
          <td><form:input path="sname"  /></td>
         </tr>  
         <tr>  
          <td>Semail :</td>  
          <td><form:input path="semail" /></td>
         </tr> 
         <tr>  
          <td>Spassword :</td>  
          <td><form:input type="password" path="spassword" /></td>
         </tr> 
         <tr>  
          <td> </td>  
          <td><input type="submit" value="Save" /></td>  
         </tr>  
        </table>  
       </form:form>    
       
       
</body>
</html>