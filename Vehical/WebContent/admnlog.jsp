<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String id=request.getParameter("id");

String pass=request.getParameter("pass");

if((id.equals("parth"))&pass.equals("gupta"))
response.sendRedirect("admhome.jsp");

else
{	RequestDispatcher rd=request.getRequestDispatcher("adminlog.jsp");
rd.include(request,response);
out.println("\n"+"<script>window.alert('Login First');</script>");

}
%>
</body>
</html>