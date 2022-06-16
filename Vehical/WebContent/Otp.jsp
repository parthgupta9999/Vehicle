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
HttpSession s=request.getSession();
String email=(String)s.getAttribute("email");
String otp=(String)s.getAttribute("otp");

String eotp=request.getParameter("eotp");

out.println(otp);
out.println(eotp);
 if(eotp.equals(otp))
{
	response.sendRedirect("adhr.html");
}
else
{
	 RequestDispatcher rd=request.getRequestDispatcher("Otp.html");
	 rd.include(request,response);
	
	out.println("\n"+"<script>window.alert('Wrong OTP !! Please Enter Correct Otp');</script>");
}



%>


</body>
</html>