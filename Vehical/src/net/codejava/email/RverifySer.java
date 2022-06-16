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

/**
 * Servlet implementation class RverifySer
 */
@WebServlet("/RverifySer")
public class RverifySer extends HttpServlet {
	
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

  
HttpSession s=request.getSession();


  String email=request.getParameter("id");
  s.setAttribute("id", email); 


   String recipient = email;
   String subject = "Approved";
   String content = "Welcome to Parth Web Services"+"\n\n"+"Welcome to the world of Parth Web Technology."
   		+ " We are here to serve you 24/7, just ping us with your query we will respond to your query in 24 hours."+"\n\n"+
   		"Congratulations! Your Documents are verified."+"\n\n"+" Welcome To GO RENT "+"\n"+"You are now Authorized to Rent your Vehicle on GO RENT."
   		+ "Use Your Login Credentials to login"+"\n"
   		+"THANKYOU ";
   
;
   
   
    String resultMessage = "";

    try {
        EmailUtility.sendEmail(host, port, user, pass, recipient, subject,
                content);
       
    } catch (Exception ex) {
        ex.printStackTrace();
        resultMessage = "There were an error: " + ex.getMessage();
    } finally {
    	RequestDispatcher rd=request.getRequestDispatcher("Raprv.jsp");
    	rd.include(request,response);
    	out.println("\n"+"<script>window.alert('Mail sent');</script>");
    }
 
}}
