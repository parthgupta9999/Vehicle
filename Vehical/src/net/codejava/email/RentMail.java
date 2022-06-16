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
import Veh.Hire;
import Veh.Ongoing;

/**
 * Servlet implementation class RentMail
 */
@WebServlet("/RentMail")
public class RentMail extends HttpServlet {
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
   String Hemail=(String)s.getAttribute("email");


   Dao d=new Dao();
   Hire h=d.HDetails(Hemail);

String rc=request.getParameter("regno");
String REmail=request.getParameter("email");
String Cname=request.getParameter("vname");
String mod=request.getParameter("mod");
String add=request.getParameter("add");
String city=request.getParameter("city");
String mread=request.getParameter("mread");
String fuel=request.getParameter("fuel");
String base=request.getParameter("base");
String pkm=request.getParameter("pkm");
String etime=request.getParameter("etime");
String date=request.getParameter("date");
String gps=request.getParameter("gps");


Ongoing o=new Ongoing();
o.setRcnum(rc);
o.setGps(gps);
o.setRemail(REmail);
o.setHemail(Hemail);
o.setHMnum(h.getMobileNumber());
o.setCity(city);
o.setDate(date);
o.setEtime(etime);
try{
int a=d.ongoing(o);


	String recipient = REmail;
       String subject = "Hired";
       String content = "Welcome to Parth Web Services"+"\n\n"+"Welcome to the world of Parth Web Technology. We are here to serve you 24/7, just ping us with your query we will respond to your query in 24 hours."
       		+ ""+"\n\n"+"Congratulations! Your Vehicle "+Cname+" "+rc+" is Hired."+"\n\n\n\n"+"DETAILS OF HIRER"+"\n\n"
    		   +"NAME - "+h.getName()+
       		"\n"+"MOBILE NUMBER - "+h.getMobileNumber()+"\n\n\n\n"+"CAUTION: Please Make Video of Vehicle before Renting ,So as to Claim your Damage . Otherwise Company will not be responsible for any Claim Settlement."
       		+"\n\n"+"DISCLAIMER : You are Renting Your Vehicle on your Risk. Company will not be responsible for your loss."+"\n"+"THANKYOU ";
;
       
       
        String resultMessage = "";
 
        if(a==1)
    	{ try {
        	
            EmailUtility.sendEmail(host, port, user, pass, recipient, subject,
                    content);
                  recipient =Hemail; 
            		subject ="Hired";
            		content ="Welcome to Parth Web Services"+"\n\n"+"Welcome to the world of Parth Web Technology. We are here to serve you 24/7, just ping us with your query we will respond to your query in 24 hours."
            	       		+ ""+"\n\n"+"Congratulations! You Have Successfully Hired Vehicle."+"\n\n\n"
            				+"DETAILS OF HIRED VEHICLE"+"\n\n"
            	       		+"Vehicle - "+Cname+" "+mod+"\n"
            	       		+"Fuel - "+fuel+"\n"
            	       		+"Address - "+add+","+city+"\n"
            	       		+"Odometer Reading - "+mread+"\n"
            	       		+"Base Price - "+base+"\n"
            	       		+"Per KiloMeter Rent - "+pkm+"\n"
            	       		+"Return Date and Time - "+date+" "+etime+"\n"+"\n"
            	       		+"NOTE : 1> IF  YOU FAIL TO RETURN VEHICLE WITHIN TIME LIMIT i.e.( "+etime+" ) YOU WILL HAVE TO PAY 100 FOR EVERY 15 MIN.\n"
            	       				+ "           2> IF ANY PHYSICAL DAMAGE IS DONE BY YOU ON VEHICLE THEN YOU WILL HAVE TO PAY FOR REPAIR"
            	       		+"\n\n\n\n"+"CAUTION: Please Make Video of Vehicle before Using ,So as to Prevent Damage Claim that is not Done by You  . Otherwise Company will not be responsible for any Claim ."
            	       		+"\n\n"+"DISCLAIMER : You are Hiring Vehicle on your Risk. Company will not be responsible for any loss."+"\n"+"THANKYOU ";;
            		EmailUtility.sendEmail(host, port, user, pass, recipient, subject,
                            content);
        		
           
        } catch (Exception ex) {
            ex.printStackTrace();
            resultMessage = "There were an error: " + ex.getMessage();
        } finally {
        	RequestDispatcher rd=request.getRequestDispatcher("HireHome.jsp");
        	rd.include(request,response);
        	out.println("\n"+"<script>window.alert('Booked Successfully');</script>");
        	
        	
      } 
}
else
	out.println("ERROR ENCOUNTERED");
}
catch(Exception e)
{
	e.printStackTrace();
}


    }

}
