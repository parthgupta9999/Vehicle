<%@page import="org.eclipse.jdt.internal.compiler.flow.FinallyFlowContext"%>
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
HttpSession s=request.getSession();
String id=(String)s.getAttribute("id");
Dao d=new Dao();
int a=d.delete("Rent",id);
if(a==1)
	{RequestDispatcher rd=request.getRequestDispatcher("Rpending.jsp");
rd.include(request,response);
out.println("\n"+"<script>window.alert('Request Rejected');</script>");
	}

else
{
	{RequestDispatcher rd=request.getRequestDispatcher("Rpending.jsp");
	rd.include(request,response);
	out.println("\n"+"<script>window.alert('ERROR Encountered');</script>");
		}

}
//s.invalidate();



%>
</body>
</html>