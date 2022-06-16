<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@page import="Veh.Rent" %>
<%@page import="Veh.Dao" %>
<%
String id=request.getParameter("id");
String pass=request.getParameter("pass");
HttpSession s=request.getSession();

try{
	Dao d= new Dao();
Rent o=d.readRent(id, pass);
String name=o.getName();
String email=o.getEmail();
String per=o.getAproved();
if(id.equals("admin")&& pass.equals("admin"))
{
	RequestDispatcher rd=request.getRequestDispatcher("adminlog.jsp");
	rd.include(request,response);
  out.println("\n"+"<script>window.alert('Welcome To Admin Login ');</script>");
	
}
else
if(name.equals("nul"))
{ 
	RequestDispatcher rd=request.getRequestDispatcher("RentLog.jsp");
	rd.include(request,response);
  out.println("\n"+"<script>window.alert('Invalid Credentials');</script>");
}
else
	{if(per.equals("UNVERIFIED"))
{
		RequestDispatcher rd=request.getRequestDispatcher("RentLog.jsp");
		rd.include(request,response);
		out.println("\n"+"<script>window.alert('Your Request is Under Proccess.Please Wait or Write us at (parthwebservices@gmail.com)');</script>");
}
	
else
{ if(per.equals("VERIFIED"))
{
s.setAttribute("name",name);
s.setAttribute("email",email);
response.sendRedirect("RentHome.jsp");
}}}
}
catch(Exception e)
{
	out.println(e);
}%>

</body>
</html>