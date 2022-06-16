package net.codejava.email;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Veh.Dao;
import Veh.Vrent;
import Veh.Ongoing;

/**
 * Servlet implementation class Finish
 */
@WebServlet("/Finish")
public class Finish extends HttpServlet {
	
	private String host;
private String port;
private String user;
private String pass;

public void init() {
  
	// reads SMTP server setting from web.xml file
    ServletContext context = getServletContext();
    host = context.getInitParameter("host");
    port = context.getInitParameter("port");
    user = context.getInitParameter("user");
    pass = context.getInitParameter("pass");
   
  
   
   
   }





protected void doPost(HttpServletRequest request,
        HttpServletResponse response) throws ServletException, IOException {
    // reads form fields
	PrintWriter out=response.getWriter();
   double ot = Math.random()*100000;
   int value = (int)ot;
   String otp=Integer.toString(value);
  
   
   HttpSession s=request.getSession();
   s.setAttribute("otp", otp);
   String rc=request.getParameter("rc");
   s.setAttribute("rc", rc);
   Dao d=new Dao();
   Vrent v=d.readVrent(rc);
  

   int mread=Integer.parseInt(v.getMread());
   
   int read=Integer.parseInt(request.getParameter("read"));
   if(request.getParameter("read").equals(null))
   {
	   RequestDispatcher rd=request.getRequestDispatcher("current.jsp");
   	rd.include(request,response);
   	out.println("\n"+"<script>window.alert('PLEASE ENTER ODOMETER READING');</script>");
   }
   else if(read < mread )
   {
	   RequestDispatcher rd=request.getRequestDispatcher("current.jsp");
	   	rd.include(request,response);
	   	out.println("\n"+"<script>window.alert('INVALID ODOMETER READING');</script>");
   }
   else{
   String email=request.getParameter("email");
   String etime=v.getEtime();
   String date=v.getDate();
  
   int rate=Integer.parseInt(v.getKfare());
   int base=Integer.parseInt(v.getBfare());
   int diff=read-mread;
   s.setAttribute("travel", diff);
   s.setAttribute("base", base);
   s.setAttribute("rate", rate);
   int total =(diff*rate)+base;
 
   String end_date =date.concat(" "+etime);
  
s.setAttribute("total",total);
Date dNow = new Date( );
SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd HH:mm");
String Start_date=ft.format(dNow);
long time=d.findDifference(Start_date, end_date);

s.setAttribute("time", time);
 
   String recipient = email;
   String subject = "OTP";
   String content = "Welcome to Parth Web Services"+"\n\n"+"Welcome to the world of Parth Web Technology."
   		+ " We are here to serve you 24/7, just ping us with your query we will respond to your query in 24 hours."+"\n\n"+
   		"ODOMETER READING = "+read+". PLEASE CHECK ODOMETER READING BEFORE PROCEEDING FURTHER."+"\n\n"+ "Your OTP is - "+otp+"\n\n"
   		+"Share this OTP with Hirer if ODOMETER READING IS CORRECT, to end Renting and Generate Bill.";
;
   
   
    String resultMessage = "";

    try {
        EmailUtility.sendEmail(host, port, user, pass, recipient, subject,
                content);
       
    } catch (Exception ex) {
        ex.printStackTrace();
        resultMessage = "There were an error: " + ex.getMessage();
    } finally {
    	RequestDispatcher rd=request.getRequestDispatcher("otp2.jsp");
    	rd.include(request,response);
    	out.println("\n"+"<script>window.alert('OTP Sent To RENT Successfully');</script>");
    }
}}
}
