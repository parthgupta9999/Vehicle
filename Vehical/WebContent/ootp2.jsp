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

String otp=(String)s.getAttribute("otp");

String eotp=request.getParameter("eotp");


 if(eotp.equals(otp))
{
	response.sendRedirect("bill.jsp");
}
else
{
	 RequestDispatcher rd=request.getRequestDispatcher("otp2.jsp");
	 rd.include(request,response);
	
	out.println("\n"+"<script>window.alert('Wrong OTP !! Please Enter Correct Otp');</script>");
}



%>


</body>
</html>