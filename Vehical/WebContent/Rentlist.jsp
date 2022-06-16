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
<h1 style="text-align:center;" >Rent Details</h1>
	
	<div class="limiter">
		<div class="container-table100">
			<div class="wrap-table100">
				
					

					
				<div class="table100 ver2 m-b-110">
					<div class="table100-head">
						<table>
							<thead>
								<tr class="row100 head">
									<th class="cell100 column1">Name</th>
									<th class="cell100 column2">Email</th>
									<th class="cell100 column2">DETAILS</th>
									
								</tr>
							</thead>
						</table>
					</div>

					<div class="table100-body js-pscroll">
						<table>
							<tbody>
							


<%
Dao d=new Dao();
HttpSession s=request.getSession();
s.invalidate();
try{	
List<Rent> al=d.RentDetails("VERIFIED");

for(Rent h:al)
{

	%>



								<tr class="row100 body">
									<td class="cell100 column1"><%=h.getName() %></td>
									<td class="cell100 column2"><%=h.getEmail() %></td>
									<td class="cell100 column3"><a href="RShowL.jsp?email=<%=h.getEmail() %>" class="cmn-btn">Show Details</a></td>
									
								</tr>
<%
}
}catch(Exception e)
{
	e.printStackTrace();
}

%>
								
							</tbody>
						</table>
					</div>
				</div>

	<a href="admhome.jsp">Go Back</a>			
				
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

