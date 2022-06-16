package net.codejava.email;


 
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Veh.Dao;

 
/**
 * A servlet that takes message details from user and send it as a new e-mail
 * through an SMTP server.
 *
 * @author www.codejava.net
 *
 */
@WebServlet("/EmailSendingServlet")

public class EmailSendingServlet extends HttpServlet {
	
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
    	Dao dd=new Dao();
    	PrintWriter out=response.getWriter();
    	int z=dd.Duplicate("hire", request.getParameter("Email"));
    	if(z==2)
    	{
    	
       double ot = Math.random()*100000;
       int value = (int)ot;
       String otp=Integer.toString(value);
      
        //String recipient = request.getParameter("email");
       /*String recipient = "parthgupta9999@gmail.com";
        
       String subject = "OTP";
        String content = "Welcome to Parth Web Services"+"\n\n"+"Welcome to the world of Parth Web Technology. We are here to serve you 24/7, just ping us with your query we will respond to your query in 24 hours."+"\n\n"+"Your OTP is - "+otp;
 */
       HttpSession s=request.getSession();
       s.setAttribute("otp", otp);
       String adhar=request.getParameter("adharnum");
       String name=request.getParameter("name");
       String drLinum=request.getParameter("drLinum");
       String mob=request.getParameter("MobileNumber");
       
       String Password=request.getParameter("Password");
       String email=request.getParameter("Email");

       s.setAttribute("adharnum", adhar);
       s.setAttribute("name", name);
       s.setAttribute("drLinum", drLinum);
       s.setAttribute("email", email);
       s.setAttribute("MobileNumber", mob);
       s.setAttribute("Password", Password);
       s.setAttribute("RES", "HIRE");
       
       String recipient = email;
       String subject = "OTP";
       String content = "Welcome to Parth Web Services"+"\n\n"+"Welcome to the world of Parth Web Technology. We are here to serve you 24/7, just ping us with your query we will respond to your query in 24 hours."+"\n\n"+"Your OTP is - "+otp;
;
       
       
        String resultMessage = "";
 
        try {
            EmailUtility.sendEmail(host, port, user, pass, recipient, subject,
                    content);
           
        } catch (Exception ex) {
            ex.printStackTrace();
            resultMessage = "There were an error: " + ex.getMessage();
        } finally {
        	RequestDispatcher rd=request.getRequestDispatcher("otp1.jsp");
        	rd.include(request,response);
        	out.println("\n"+"<script>window.alert('Email Sent Successfully');</script>");
        }
    }
    	 else
    	    {
    		 RequestDispatcher rd=request.getRequestDispatcher("EmailForm.jsp");
         	rd.include(request,response);
         	out.println("\n"+"<script>window.alert('Email Already Registered. Contact our Customer Support for Password Change.');</script>");
    	    }
    }
   
}
