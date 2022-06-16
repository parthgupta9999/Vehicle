<!DOCTYPE html>
<html lang="en">
<%@page import="Veh.Hire" %>
<%@page import="Veh.Dao" %>
<%@page import="Veh.Rent" %>
<%@page import="Veh.Vrent" %>
<%@page import="Veh.Ongoing" %>
<%@page import="Veh.Vehicle" %>
<%
HttpSession s=request.getSession();
int total= (int)s.getAttribute("total");
String rc= (String)s.getAttribute("rc");
long time= (long)s.getAttribute("time");
String ss=Long.toString(time);
int add =0;
if(time>=0)
{
	add=0;
}
else
{ time=time*(-1);
	add=(int)time/15*100;
}


 total=total+add;
 Dao d= new Dao();
 Ongoing o=d.readOngoing(rc);
String hire=o.getHemail();
String rent=o.getRemail();
Hire h=d.HDetails(hire);
int a=d.Records(o,ss,total);
if(a==1)
{
	
	int due=h.getDue();
	due=due+total;
	h.setDue(due);
	int ride=h.getRidesDone();
	ride=ride+1;
	h.setRidesDone(ride);
	Rent r=d.RDetails(rent);
	int earn=r.getEarn();
	earn=earn+total;
	r.setEarn(earn);
	int rentd=r.getRentDone();
	rentd=rentd+1;
	r.setRentDone(rentd);
	
	int b=d.demonish(rc,h,r);
	

%>
 


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
                
            
              <li><a href="current.jsp">My Hire</a>
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
            <li> Bill</li>
           
          
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
      

	
      <% 
if(a==b)
{
String name=(String)s.getAttribute("name");
%>
<p Style=" font-size: 120%;">Thankyou <%=name%> for using Our Services. your Rent is Finished Successfully. </p>
<br>
<div Style=" font-size: 300%;">
<p Style=" font-size: 50%;">You have Traveled - <%=(Integer)s.getAttribute("travel") + " KM"%><p>
<br>
<br>
<br>
<p Style=" font-size: 50%;text-align:right">Rate per KiloMeter  - &nbsp;&nbsp;  <%= (Integer)s.getAttribute("rate")%> * <%=(Integer)s.getAttribute("travel") %></p>
<p Style=" font-size: 50%;text-align:right">Base price of Vehicle  -&nbsp;&nbsp;  + &nbsp;&nbsp;&nbsp;  <%=(Integer)s.getAttribute("base") %></p>
<p Style=" font-size: 50%;text-align:right">Time fees  - &nbsp;&nbsp;  + &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=add %></p>
<p Style=" font-size: 50%;text-align:right"> -----------------------------------------------------------------------</p>
<p Style=" font-size: 50%;text-align:right;color:green">Total &nbsp;&nbsp; &nbsp;&nbsp;                         <%=total %> </p>
<br>
<br>
<form action="https://paytm.com/">
<button type="submit" class="cmn-btn btn-radius" Style="align:right" >PAY NOW</button>
</form>
<br>
<br>
</div>
<p>If you find any Error or have any problem please contact us. Thankyou.</p>

<%
}
}
%>
          
           
                  
                 
          
                <!-- car-item end -->
     

<!-- car-item end -->
 
    </div>
  </section>

  
             

         
                      
                     
                      
                       
                 
      
    
        
             
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



	
	



