<%@page import="Veh.Dao"%>
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
Dao d=new Dao();
int z=d.VDuplicate(request.getParameter("rnum"));
if(z==2)
{
HttpSession s=request.getSession();
s.setAttribute("Rnum",request.getParameter("rnum"));
s.setAttribute("GPS",request.getParameter("gps"));
s.setAttribute("Type",request.getParameter("vtype"));
s.setAttribute("Vname",request.getParameter("vname"));
s.setAttribute("Vmod",request.getParameter("mod"));
s.setAttribute("Vfuel",request.getParameter("vfuel"));
s.setAttribute("Mread",request.getParameter("mread"));
response.sendRedirect("Rc.html");
}
else
{
	%>
	<script LANGUAGE='JavaScript'>
    window.alert('Vehicle Already registered');
    window.location.href='addvehicle.html';
    </script>
	<% 
}
%>
</body>
</html>