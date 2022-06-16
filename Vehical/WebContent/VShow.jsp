<%@page import="Veh.Vehicle"%>
<%@page import="Veh.Rent"%>
<%@page import="java.util.List"%>
<%@page import="Veh.Dao"%>
<%@page import="Veh.Hire"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<title>Table V04</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
<!--===============================================================================================-->	
	<link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
	
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/select2/select2.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/perfect-scrollbar/perfect-scrollbar.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="css/util.css">
	<link rel="stylesheet" type="text/css" href="css/main.css">
<!--===============================================================================================-->
</head>
<body>
 <a href="index.html" ><img src="assets/images/logo1.png" width=10%   style="vertical-align:middle"> </a>
 <p style="color:red;text-align:center; font-size: 230%;">GO RENT ADMIN BLOCK </p>
 <br>
 <br>
<h1 style="text-align:center;" >Pending Verification</h1>
	
	<div class="limiter">
		<div class="container-table100">
		
			<div class="wrap-table100">
				
					

					
				<div class="table100 ver2 m-b-110">
					<div class="table100-head">
						<table>
							<thead>
								<tr class="row100 head">
									
									
									
								</tr>
							</thead>
						</table>
					</div>

					<div class="table100-body js-pscroll">
						<table>
							<tbody>
							


<%
Dao d=new Dao();
String id=request.getParameter("rc");

try{	

Vehicle h=d.VVDetails(id);



	%>

<tr class="row100 body">	
								<td class="cell100 column2"><a><img src="<%=h.getVpic() %>" style="width:70%"></a></td>
								<td class="cell100 column2"><a><img src="<%=h.getRcpic() %>" style="width:70%"></a></td>	
									
									
								</tr>
								<tr class="row100 body">
								<td class="cell100 column1">RC Number</td>
									<td class="cell100 column2"><%=h.getRcnum()%></td>
									</tr>

								<tr class="row100 body">
								<td class="cell100 column1">Name</td>
									<td class="cell100 column1"><%=h.getVname() %></td>
									</tr>
									<tr class="row100 body">
								<td class="cell100 column1">MODEL</td>
									<td class="cell100 column2"><%=h.getVmod()%></td>
									</tr>
									<tr class="row100 body">
								<td class="cell100 column1">email</td>
									<td class="cell100 column3"><a href="RShowL.jsp?email=<%=h.getEmail() %>" class="cmn-btn"><%=h.getEmail() %></a></td>
									</tr>
									
									<tr class="row100 body">
								<td class="cell100 column1">GPS</td>
									<td class="cell100 column2"><%=h.getGps()%></td>
									</tr>
									<tr class="row100 body">
								<td class="cell100 column1">Fuel Type</td>
									<td class="cell100 column2"><%=h.getVfuel()%></td>
									</tr>
									<tr class="row100 body">
								<td class="cell100 column1">Vehicle Type</td>
									<td class="cell100 column2"><%=h.getVtype() %></td>
									</tr>
									<tr class="row100 body">
								<td class="cell100 column1">Odometer Reading</td>
									<td class="cell100 column2"><%=h.getMread() %></td>
									</tr>
									
			                         <tr class="row100 body">
			                         <td class="cell100 column1"><form action="VrejSer" method="post">
			                         <input type="hidden" name="id" value="<%=h.getEmail() %>" >
			                         <input type="hidden" name="rc" value="<%=h.getRcnum() %>" >
			                         <input type="submit" value="Reject" style="color:red">
			                         </form></td>
		       						<td class="cell100 column1">
		       						<form action="VverifySer" method="post">
			                         <input type="hidden" name="id" value="<%=h.getEmail() %>" >
			                         <input type="hidden" name="rc" value="<%=h.getRcnum() %>" >
			                         <input type="submit" value="Accept" style="color:green">
			                         </form></td>
									
									</tr>
	<%
								

}catch(Exception e)
{
	e.printStackTrace();
}

%>
								
							</tbody>
						</table>
					</div>
				</div>

				<a href="Vpending.jsp">Go Back</a>
				
			</div>
		</div>
	</div>


<!--===============================================================================================-->	
	<script src="vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/bootstrap/js/popper.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/perfect-scrollbar/perfect-scrollbar.min.js"></script>
	<script>
		$('.js-pscroll').each(function(){
			var ps = new PerfectScrollbar(this);

			$(window).on('resize', function(){
				ps.update();
			})
		});
			
		
	</script>
<!--===============================================================================================-->
	<script src="js/main.js"></script>

</body>
</html>

