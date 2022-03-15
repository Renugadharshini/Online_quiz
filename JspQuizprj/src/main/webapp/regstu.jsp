<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@page import="quizstudent.QzStudentDao"%>  
<jsp:useBean id="s" class="quizstudent.QzStudent"></jsp:useBean>  
<jsp:setProperty property="*" name="s"/>  

<%String nu=request.getParameter("numb");
int n=Integer.parseInt(nu);
s.setSid(n);
%>
<%  
int i=QzStudentDao.save(s);  
if(i>0){  
response.sendRedirect("regstu-success.jsp");  
}else{  
response.sendRedirect("regstu-error.jsp");  
}  
%>

</body>
</html>