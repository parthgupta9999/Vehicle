<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%
         Date dNow = new Date( );
         SimpleDateFormat ft = 
         new SimpleDateFormat ("yyyy-MM-dd");
       String date=ft.format(dNow);
      
      %>
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
          <!--  any pre head  -->
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
             
              <li><a href="about.html">About</a>
              
              
              
              <li><a href="contact.html">contact us</a>

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
          <h2 class="page-title">Register New Vehicle</h2>
          <ol class="page-list">
            <li><a href="index.html"><i class="fa fa-home"></i> Home</a></li>
            <li>Rent Home</li>
            <li>Renting Form</li>
          </ol>
        </div>
      </div>
    </div>
  </section>
  <!-- inner-apge-banner end -->

  <!-- registration-section start -->
  <section class="registration-section pt-120 pb-120">
    <div class="container">
      <div class="row">
        <div class="col-lg-12">
          <div class="registration-block text-center">
            <div class="registration-block-inner">
              <h3 class="title">Renting Form</h3>
              <form class="registration-form" action="VRent.jsp" method="post">
                <div class="frm-group">
                  <input type="Text" name="rnum" value="<%=request.getParameter("regno") %>" size="50" readonly/>
                </div>
                <div class="frm-group">
                  <input type="date" min="<%=date %>" max="2025-06-10" name="date"  size="50" >
                </div>
                <div class="frm-group">
               
                  Start Time <input type="time" name="Stime" placeholder="Start Time">
                </div>
                <div class="frm-group">
                
                 End Time <input type="time" name="Etime" placeholder="End Time">
                </div>
                <div class="frm-group">
                  <input type="text" name="add" placeholder="ADDRESS">
                </div>
                
                <div class="frm-group">
                  <select name="city">
                    <option value="1" selected>Choose Your City</option>
                    <option value="Indore">Indore</option>
                    <option value="Ujjain">Ujjain</option>
                    <option value="Bhopal">Bhopal</option>
                     
                     </select>
  <br>
                </div>
               
                <div class="frm-group">
               <br>
                  <input type="number" name="bfare" placeholder="Base Fare">
                </div>
                <div class="frm-group">
                  <input type="number" name="kfare" placeholder="Per Km fare">
                </div>
                <div class="frm-group">
                  <input type="number" name="mread" placeholder="Odometer Reading">
                </div>
                <div class="frm-group">
                  <input type="submit" value="Rent Vehicle">
                </div>
               
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
  </section>
  <!-- registration-section end -->

  <!-- footer-section start -->
  <footer class="footer-section">
    <div class="footer-top pt-120 pb-120">
      <div class="container">
        <div class="row">
          <div class="col-lg-4 col-sm-8">
            <div class="footer-widget widget-about">
              <div class="widget-about-content">
                <a href="index.html" class="footer-logo"><img src="assets/images/logo1.png" alt="logo"></a>
                <p>Created By Parth Web Services </p>
                
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