<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Renten - Car Rental Service HTML Template</title>
  <!-- site favicon -->
  <link rel="shortcut icon" type="image/png" href="assets/images/favicon.jpg"/>
  <!-- fontawesome css link -->
  <link rel="stylesheet" href="assets/css/fontawesome.min.css">
  <!-- bootstrap css link -->
  <link rel="stylesheet" href="assets/css/bootstrap.min.css">
  <!-- lightcase css link -->
  <link rel="stylesheet" href="assets/css/lightcase.css">
  <!-- animate css link -->
  <link rel="stylesheet" href="assets/css/animate.css">
  <!-- nice select css link -->
  <link rel="stylesheet" href="assets/css/nice-select.css">
  <!-- datepicker css link -->
  <link rel="stylesheet" href="assets/css/datepicker.min.css">
  <!-- wickedpicker css link -->
  <link rel="stylesheet" href="assets/css/wickedpicker.min.css">
  <!-- jquery ui css link -->
  <link rel="stylesheet" href="assets/css/jquery-ui.min.css">
  <!-- owl carousel css link -->
  <link rel="stylesheet" href="assets/css/owl.carousel.min.css">
  <!-- main style css link -->
  <link rel="stylesheet" href="assets/css/main.css">
</head>
<body>

  <!-- preloader start -->
  <div id="preloader"></div>
  <!-- preloader end -->   

  <!--  header-section start  -->
  <header class="header-section">
    <div class="header-top">
      <div class="container">
        <div class="row align-items-center">
          
          <div class="col-lg-6">
            <ul class="header-info d-flex justify-content-center">
              
              
            </ul>
          </div>
          <div class="col-lg-3">
            <div class="header-action d-flex align-items-center justify-content-end">
              
              
            </div>
          </div>
        </div>
      </div>
    </div>
    <div class="header-bottom">
      <div class="container">
        <nav class="navbar navbar-expand-lg p-0">
          <a class="navbar-brand" href="index.html"><img src="assets/images/logo1.png" width=100%  alt="site-logo"><span class="logo-icon"><i class="flaticon-fire"></i></span></a>
          <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
          <span class="menu-toggle"></span>
          </button>
          <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav main-menu mr-auto">
              <li ><a href="#0">Home</a>
                
            
             <li><a href="onrent.jsp">On Rent</a>
              <li><a href="myrent.jsp">My Rent</a>
               <li><a href="about.html">About</a>
              <li><a href="contact.html">contact us</a></li>
            </ul>
          </div>
        </nav>
      </div>
    </div><!-- header-bottom end -->
  </header>
  <!--  header-section end  -->

  <!-- inner-apge-banner start -->
  <section class="inner-page-banner bg_img overlay-3" data-background="assets/images/inner-page-bg.jpg">
    <div class="container">
      <div class="row">
        <div class="col-md-12">
          <h2 class="page-title">Rent </h2>
          <ol class="page-list">
            <li><a href="index.html"><i class="fa fa-home"></i> Home</a></li>
           
          
          </ol>
        </div>
      </div>
    </div>
  </section>
  <!-- inner-apge-banner end -->

  <!-- car-search-section start -->
  <section class="car-search-section pt-120 pb-120">
    <div class="container">
      <div class="row">
        <div class="col-lg-12">
          <div class="car-search-filter-area">
            <div class="car-search-filter-form-area">
              
              
            </div>
            <div class="view-style-toggle-area">
              <button class="view-btn list-btn"><i class="fa fa-bars"></i></button>
              <button class="view-btn grid-btn active"><i class="fa fa-th-large"></i></button>
            </div>
          </div>
        </div>
      </div>
      <div class="row mt-70">
        <div class="col-lg-8">
          <div class="car-search-result-area grid--view row mb-none-30">
  
      <%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@page import="Veh.Dao" %>
<%@page import="Veh.Vehicle" %>
<%@page import="Veh.Rent" %>
<%
HttpSession s=request.getSession();
String name=(String)s.getAttribute("name");
String id=(String)s.getAttribute("email");

%>



<%
Dao d=new Dao();
Rent r=d.RDetails(id);
try{
	
List<Vehicle> al=d.VehicleDetails(id);
if(al.isEmpty())
{
%>
<p style="font-weight: bold;">YOU HAVE NOT ADDED ANY VEHICAL. PLEASE ADD VEHICAL TO RENT.</p>
<br>
<br>
<br>
<% 	
}
for(Vehicle v:al)
{

	%>
	
      
            <div class="col-md-6 col-12">
              <div class="car-item">
                <div class="thumb bg_img" data-background="<%=v.getVpic() %>"> </div>
                <div class="car-item-body">
                  <div class="content">
                    <h4 class="title"><%=v.getVname() %></h4>
                    <br>
                   <i >&#9981;</i><%=" "+v.getVfuel()%>
                   <br>
                    <a href="Renting.jsp?regno=<%=v.getRcnum() %>" class="cmn-btn" >PUT ON RENT</a>
                  </div>
                  <div class="car-item-meta">
                    <ul class="details-list">
                      <li><i class="fa fa-car"></i>model <%=v.getVmod() %></li>
                      <li><i class="fa fa-tachometer"></i><%=v.getMread() %></li>
                     
                    </ul>
                  </div>
                </div>
              </div>
            </div>
           
                  
                 
          
                <!-- car-item end -->
     
            <!-- add-item end -->
   <%
	
	
}
%> 
             <div class="col-md-6 col-12">
              <div class="car-item car-item--style2">
                <div class="thumb bg_img" data-background="assets/images/addV.png"></div>
                <div class="car-item-body">
                  <div class="content">
                    <h4 class="title">ADD VEHICLE</h4>
                    
                    
                    <a href="addvehicle.html" class="cmn-btn">+</a>
                  </div>
                  <div class="car-item-meta">
                   <p style="text = bold"> Add More Vehicle and Start Renting</p>
                  </div>
                </div>
              </div>
            </div><!-- car-item end -->
            <!-- car-item end -->
          </div>
          
        </div>
        <div class="col-lg-4">
          <aside class="sidebar">
            
            <div class="widget widget-reservation text-center">
              <h4 class="widget-title">User</h4>
              <div class="widget-body">
                <i class="fa fa-user-circle" style="font-size: 750%;"></i><br><br><p style="font-size : 20px"><%=r.getName() %></p>
               <br>
               <i class="fa fa-phone" style="font-size:20px"><%=" "+r.getMobileNumber()%></i>
               <br> <br>
               <i class="fa fa-trophy" style="font-size:20px"><%=" "+r.getRentDone()%></i>
              <br> <br>
               <i  style="font-size:20px">&#8377; <%=" "+r.getEarn()+" Earned"%></i>
               <br><br>
                <a href="logout.jsp" class="cmn-btn">Log Out</a>
               
              </div>
            </div>
            
                
            
          </aside>
        </div>
      </div>
    </div>
  </section>

  
             

         
                      
                     
                      
                       
                 
      
<% 
}
catch(Exception e)
{
	e.printStackTrace();
}

%>    
        
             
            <!-- widget end -->
        
  <!-- car-search-section end -->

  <!-- footer-section start -->
  <footer class="footer-section">
    <div class="footer-top pt-120 pb-120">
      <div class="container">
        <div class="row">
          <div class="col-lg-4 col-sm-8">
            <div class="footer-widget widget-about">
              <div class="widget-about-content">
                <a href="index.html" class="footer-logo"><img src="assets/images/logo1.png" alt="logo"></a>
                <p>Handel By Parth Web Services </p>
                
              </div>
            </div>
          </div>
          </div>
        </div>
      </div>
    </footer>
  <!-- footer-section end -->
  
  <!-- scroll-to-top start -->
  <div class="scroll-to-top">
    <span class="scroll-icon">
      <i class="fa fa-rocket"></i>
    </span>
  </div>
  <!-- scroll-to-top end -->

  <!-- jquery js link -->
  <script src="assets/js/jquery-3.3.1.min.js"></script>
  <!-- jquery migrate js link -->
  <script src="assets/js/jquery-migrate-3.0.0.js"></script>
  <!-- bootstrap js link -->
  <script src="assets/js/bootstrap.min.js"></script>
  <!-- lightcase js link -->
  <script src="assets/js/lightcase.js"></script>
  <!-- wow js link -->
  <script src="assets/js/wow.min.js"></script>
  <!-- nice select js link -->
  <script src="assets/js/jquery.nice-select.min.js"></script>
  <!-- datepicker js link -->
  <script src="assets/js/datepicker.min.js"></script>
  <script src="assets/js/datepicker.en.js"></script>
  <!-- wickedpicker js link -->
  <script src="assets/js/wickedpicker.min.js"></script>
  <!-- owl carousel js link -->
  <script src="assets/js/owl.carousel.min.js"></script>
  <!-- jquery ui js link -->
  <script src="assets/js/jquery-ui.min.js"></script>
  <!-- main js link -->
  <script src="assets/js/main.js"></script>
</body>

</html>


