package Veh;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;



public class Dao {
	Connection con;
	
	
	public Connection getCon() throws SQLException, ClassNotFoundException
	{
		Class.forName("com.mysql.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/project1","root","1234");
	}

	public int inserthire(Hire hh) throws ClassNotFoundException, SQLException
	{   Connection con=getCon();
		String qr = "insert into hire values(?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps=con.prepareStatement(qr);
	    ps.setString(1,hh.getAdhrnum());
		ps.setString(4,hh.getAdhradd());
        ps.setString(2,hh.getName());
		ps.setString(3,hh.getDrLinum());
		ps.setString(5,hh.getDrLiadd());
	    ps.setInt(6,0);
        ps.setString(8,hh.getEmail());
		ps.setString(7,hh.getMobileNumber());
		ps.setString(9,"UNVERIFIED");
		ps.setInt(10,0);
		ps.setString(11,hh.getPassword());
	 int a=ps.executeUpdate();
		return a;
	}
	
	public int insertrent(Rent hh) throws ClassNotFoundException, SQLException
	{Connection con=getCon();
		String qr = "insert into rent values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps=con.prepareStatement(qr);
	    ps.setString(1,hh.getAdhrnum());
		ps.setString(4,hh.getAdhradd());
        ps.setString(2,hh.getName());
		ps.setString(3,hh.getDrLinum());
		ps.setString(5,hh.getDrLiadd());
	    ps.setInt(6,0);
		
		ps.setString(8,hh.getEmail());
		ps.setString(7,hh.getMobileNumber());
		ps.setString(9,"UNVERIFIED");
		ps.setInt(10,0);
		ps.setString(11,hh.getPassword());
		ps.setString(12,hh.getAccNo());
		ps.setString(13,hh.getIFSC());
	int a=ps.executeUpdate();
		return a;
	}
	
	public int Vehicleinsert(Vehicle v) throws ClassNotFoundException, SQLException
	{Connection con=getCon();
		String qr = "insert into vehicle values(?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps=con.prepareStatement(qr);
	    ps.setString(1,v.getVname());
		ps.setString(2,v.getRcnum());
        ps.setString(3,v.getRcpic());
		ps.setString(4,v.getVpic());
		ps.setString(5,v.getEmail());
	    ps.setString(6,v.getVtype());
		ps.setString(7,v.getGps());
		ps.setString(8,v.getVmod());
		ps.setString(9,v.getVfuel());
		ps.setString(10,v.getMread());
		ps.setString(11,"UNVERIFIED");
		ps.setString(12,"NO");
		
	int a=ps.executeUpdate();
		return a;
	}
	
	public int Rentvehicle(Vrent v) throws ClassNotFoundException, SQLException
	{Connection con=getCon();
		String qr = "insert into Vrent values(?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement ps=con.prepareStatement(qr);
	    ps.setString(1,v.getDate());
	    ps.setString(2,v.getCity());
	    ps.setString(3,v.getRcnum());
        ps.setString(4,v.getEmail());
		ps.setString(5,v.getStime());
		ps.setString(6,v.getEtime());
	    ps.setString(7,v.getBfare());
		ps.setString(8,v.getKfare());
		ps.setString(9,v.getAddress());
		ps.setString(10,v.getMread());
		ps.setString(11, "NO");
		

	String qr2="update vehicle set RENT='YES' where RC_NUMBER=?";
	PreparedStatement pss=con.prepareStatement(qr2);
	pss.setString(1,v.getRcnum());
	pss.executeUpdate();
	int a=ps.executeUpdate();
	return a;
	
	}
	
	public Map<Vrent,Vehicle> Rentlist() throws ClassNotFoundException, SQLException
	{
		Connection con=getCon();
		String qr="select * from vehicle,vrent where vrent.rc_number=vehicle.rc_number and vrent.rent='NO'";
		Statement s=con.createStatement();
		ResultSet rs=s.executeQuery(qr);
		LinkedHashMap<Vrent,Vehicle> al= new LinkedHashMap<Vrent,Vehicle>();
		while(rs.next())
		{
			Vrent r=new Vrent();
			Vehicle v=new Vehicle();
			v.setVname(rs.getString(1));
			v.setRcnum(rs.getString(2));
			v.setRcpic(rs.getString(3));
			v.setVpic(rs.getString(4));
			v.setEmail(rs.getString(5));
			v.setVtype(rs.getString(6));
			v.setGps(rs.getString(7));
			v.setVmod(rs.getString(8));
			v.setVfuel(rs.getString(9));
			v.setMread(rs.getString(10));
			v.setPermission(rs.getString(11));
			v.setRent(rs.getString(12));
			r.setDate(rs.getString(13));
			
			    r.setCity(rs.getString(14));
			    r.setRcnum(rs.getString(15));
		        r.setEmail(rs.getString(16));
				r.setStime(rs.getString(17));
				r.setEtime(rs.getString(18));
			  r.setBfare(rs.getString(19));
				r.setKfare(rs.getString(20));
				r.setAddress(rs.getString(21));
				r.setMread(rs.getString(22));
			
			
			Date dNow = new Date( );
		         SimpleDateFormat ft = 
		         new SimpleDateFormat ("dd");
		       int dd=Integer.parseInt(ft.format(dNow));
		       SimpleDateFormat ftt =  new SimpleDateFormat ("MM");
				int MM=Integer.parseInt(ftt.format(dNow));
				
				 int ddd=Integer.parseInt(rs.getString(13).substring(8));  
				  int MMM=Integer.parseInt(rs.getString(13).substring(5,7));
			
		       if((dd>ddd)||(MM>MMM))
		       {
		    	   timetrash(rs.getString(2));
		       }
		       else{
			
				al.put(r,v);
		       }
		}
			
		
		return al;
		
	}
	
	public void timetrash(String rc)
	{
		try {
			Connection con=getCon();
			String qr="delete from vrent where rc_number=?";
			PreparedStatement ps=con.prepareStatement(qr);
			ps.setString(1, rc);
			ps.executeUpdate();
			String qr2="update vehicle set rent='NO' where rc_number=?";
			PreparedStatement pss=con.prepareStatement(qr2);
			pss.setString(1, rc);
			pss.executeUpdate();
			
		}
		 catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	public Hire  readHire(String id,String pass) throws ClassNotFoundException, SQLException
	{   Connection con=getCon();
		String qr="select * from hire where (email=? or mobile_number=?)and password=?";
		PreparedStatement s=con.prepareStatement(qr);
		s.setString(1, id);
		s.setString(2, id);
		s.setString(3, pass);
		ResultSet rs=s.executeQuery();
		if(rs.next())
		{
			Hire er=new Hire();
		    er.setEmail(rs.getString("EMAIL"));
			er.setMobileNumber(rs.getString("MOBILE_NUMBER"));
			er.setPassword(rs.getString("PASSWORD"));
			er.setName(rs.getString("NAME"));
			er.setAproved(rs.getString("PERMISSION"));
			
			return er;
			}
		else
	{Hire er=new Hire();
			er.setEmail("nul");
			er.setMobileNumber("nul");
			er.setPassword("nul");
			er.setName("nul");
			er.setAproved("nul");	
return er;
	} 
	}



public Rent  readRent(String id,String pass) throws ClassNotFoundException, SQLException
{   Connection con=getCon();
	String qr="select * from rent where (email=? or mobile_number=?)and password=?";
	PreparedStatement s=con.prepareStatement(qr);
	s.setString(1, id);
	s.setString(2, id);
	s.setString(3, pass);
	ResultSet rs=s.executeQuery();
	if(rs.next())
	{
		Rent er=new Rent();
	    er.setEmail(rs.getString("EMAIL"));
		er.setMobileNumber(rs.getString("MOBILE_NUMBER"));
		er.setPassword(rs.getString("PASSWORD"));
		er.setName(rs.getString("NAME"));
		er.setAproved(rs.getString("PERMISSION"));
		return er;
		}
	else
{Rent er=new Rent();
		er.setEmail("nul");
		er.setMobileNumber("nul");
		er.setPassword("nul");
		er.setName("nul");
		er.setAproved("nul");	
return er;
} 
}

public List<Vehicle> VehicleDetails(String id) throws ClassNotFoundException, SQLException
{ Connection con=getCon();

String st="select * from vehicle where (email=? and PERMISSION='VERIFIED')AND RENT='NO' ";
PreparedStatement ps=con.prepareStatement(st);
ps.setString(1, id);


ResultSet rs=ps.executeQuery();
ArrayList<Vehicle> al=new ArrayList<Vehicle>();

while(rs.next())
{

	Vehicle v=new Vehicle();
	
	v.setVname(rs.getString(1));
	v.setRcnum(rs.getString(2));
	v.setRcpic(rs.getString(3));
	v.setVpic(rs.getString(4));
	v.setEmail(rs.getString(5));
	v.setVtype(rs.getString(6));
	v.setGps(rs.getString(7));
	v.setVmod(rs.getString(8));
	v.setVfuel(rs.getString(9));
	v.setMread(rs.getString(10));
	v.setPermission(rs.getString(11));

al.add(v);
}
return al;
}

public Hire HDetails(String id)
{
	try {
		Connection con=getCon();
		String qr="select * from hire where email=?";
		PreparedStatement ps=con.prepareStatement(qr);
		ps.setString(1,id);
		ResultSet rs=ps.executeQuery();
		Hire h=new Hire();
		if(rs.next())
		{
			h.setAdhrnum(rs.getString(1));
			h.setAdhradd(rs.getString(4));
	     h.setName(rs.getString(2));
			h.setDrLinum(rs.getString(3));
			h.setDrLiadd(rs.getString(5));
		    h.setRidesDone(rs.getInt(6));
	     h.setEmail(rs.getString(8));
			h.setMobileNumber(rs.getString(7));
			h.setAproved(rs.getString(9));
			h.setDue(rs.getInt(10));
			h.setPassword(rs.getString(11));
		return h;
		}
		else
		{
			return null;
		}
	}  catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return null;
	}
	
}

public Rent RDetails(String id)
{
	try {
		Connection con=getCon();
		String qr="select * from rent where email=?";
		PreparedStatement ps=con.prepareStatement(qr);
		ps.setString(1,id);
		ResultSet rs=ps.executeQuery();
		Rent h=new Rent();
		if(rs.next())
		{
		
			h.setAdhrnum(rs.getString(1));
			h.setAdhradd(rs.getString(4));
	  h.setName(rs.getString(2));
			h.setDrLinum(rs.getString(3));
			h.setDrLiadd(rs.getString(5));
		    h.setRentDone(rs.getInt(6));
	  h.setEmail(rs.getString(8));
			h.setMobileNumber(rs.getString(7));
			h.setAproved(rs.getString(9));
			h.setEarn(rs.getInt(10));
			h.setPassword(rs.getString(11));
			h.setAccNo(rs.getString(12));
			h.setIFSC(rs.getString(13));
		
		return h;
		}
		else
		{
			return null;
		}
	}  catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		return null;
	}
	
}

public int ongoing(Ongoing o) throws ClassNotFoundException, SQLException
{
	 Connection con=getCon();
		String qr = "insert into ongoing values(?,?,?,?,?,?,?,?)";
		PreparedStatement ps=con.prepareStatement(qr);
	    ps.setString(1,o.getRcnum());
		ps.setString(2,o.getGps());
     ps.setString(3,o.getHemail());
		ps.setString(4,o.getHMnum());
		ps.setString(5,o.getRemail());
	    ps.setString(6,o.getCity());
		ps.setString(7,o.getDate());
     ps.setString(8,o.getEtime());
		
	 int a=ps.executeUpdate();
		String qr2="update vrent set rent='YES' where rc_number=?";
		PreparedStatement ps2=con.prepareStatement(qr2);
		ps2.setString(1, o.getRcnum());
		ps2.executeUpdate();
	 
		return a;
}

public Map<Ongoing,Vehicle> Current(String id) throws ClassNotFoundException, SQLException
{
	Connection con=getCon();
	String qr="select * from vehicle,ongoing where ongoing.rc_number=vehicle.rc_number and ongoing.HIRER_EMAIL='"+id+"'";
	Statement s=con.createStatement();
	ResultSet rs=s.executeQuery(qr);
	LinkedHashMap<Ongoing,Vehicle> al= new LinkedHashMap<Ongoing,Vehicle>();
	while(rs.next())
	{
		Ongoing r=new Ongoing();
		Vehicle v=new Vehicle();
		v.setVname(rs.getString(1));
		v.setRcnum(rs.getString(2));
		v.setRcpic(rs.getString(3));
		v.setVpic(rs.getString(4));
		v.setEmail(rs.getString(5));
		v.setVtype(rs.getString(6));
		v.setGps(rs.getString(7));
		v.setVmod(rs.getString(8));
		v.setVfuel(rs.getString(9));
		v.setMread(rs.getString(10));
		v.setPermission(rs.getString(11));
		v.setRent(rs.getString(12));
		r.setRcnum(rs.getString(13));
		r.setGps(rs.getString(14));
        r.setHemail(rs.getString(15));
		r.setHMnum(rs.getString(16));
		r.setRemail(rs.getString(17));
	    r.setCity(rs.getString(18));
		r.setDate(rs.getString(19));
        r.setEtime(rs.getString(20));
		
		
		
			al.put(r,v); 
	       
	}
		
	
	return al;
	
}
public static long findDifference(String start_date,String end_date)
{
    SimpleDateFormat sdf
        = new SimpleDateFormat(
            "yyyy-MM-dd HH:mm");
try {
Date d1 = sdf.parse(start_date);
        Date d2 = sdf.parse(end_date);
long difference_In_Time= d2.getTime() - d1.getTime();
          long difference_In_Minutes = (difference_In_Time/ (1000 * 60));
          return difference_In_Minutes;
}

    catch (ParseException e) {
        e.printStackTrace();
        return 0;
    }

}

public Vrent  readVrent(String rc) 
{  try{ Connection con=getCon();
	String qr="select * from vrent where rc_number=?";
	PreparedStatement s=con.prepareStatement(qr);
	s.setString(1, rc);
	ResultSet rs=s.executeQuery();
	if(rs.next())
	{
		Vrent r=new Vrent();
		r.setDate(rs.getString(1));
		
	    r.setCity(rs.getString(2));
	    r.setRcnum(rs.getString(3));
        r.setEmail(rs.getString(4));
		r.setStime(rs.getString(5));
		r.setEtime(rs.getString(6));
	  r.setBfare(rs.getString(7));
		r.setKfare(rs.getString(8));
		r.setAddress(rs.getString(9));
		r.setMread(rs.getString(10));
	
		
		return r;
		}
	else
		return null;
}
catch(Exception e)
{
	e.printStackTrace();
	return null;
}
}

public Ongoing  readOngoing(String rc) 
{  try{ Connection con=getCon();
	String qr="select * from ongoing where rc_number=?";
	PreparedStatement s=con.prepareStatement(qr);
	s.setString(1, rc);
	ResultSet rs=s.executeQuery();
	if(rs.next())
	{
		Ongoing r=new Ongoing();
		r.setRcnum(rs.getString(1));
		r.setGps(rs.getString(2));
        r.setHemail(rs.getString(3));
		r.setHMnum(rs.getString(4));
		r.setRemail(rs.getString(5));
	    r.setCity(rs.getString(6));
		r.setDate(rs.getString(7));
        r.setEtime(rs.getString(8));
		
		return r;
		}
	else
		return null;
}
catch(Exception e)
{
	e.printStackTrace();
	return null;
}
}

public int Records(Ongoing v,String time,int fare)
{
	try{
	Connection con=getCon();
	String qr = "insert into records values(?,?,?,?,?,?,?,?)";
	PreparedStatement ps=con.prepareStatement(qr);
    ps.setString(1,v.getRcnum());
	ps.setString(2,v.getHemail());
    ps.setString(3,v.getRemail());
	ps.setString(4,v.getCity());
	ps.setString(5,v.getDate());
    ps.setString(6,v.getEtime());
	ps.setString(7,time);
	ps.setInt(8,fare);
	
	
int a=ps.executeUpdate();
	return a;
	}
	catch(Exception e)
	{
		e.printStackTrace();
		return 0;
	}
	}

public int demonish(String rc,Hire h,Rent r)
{try{
	Connection con=getCon();
String qr1="delete from Vrent where rc_number='"+rc+"'";
String qr2="delete from ongoing where rc_number='"+rc+"'";
Statement s=con.createStatement();
s.executeUpdate(qr1);
Statement ss=con.createStatement();
ss.executeUpdate(qr2);
String qr3="update vehicle set RENT='NO' where rc_number='"+rc+"'";
Statement sss=con.createStatement();
sss.executeUpdate(qr3);
String qr4="update hire set ride_done=? , due=? where email=?";
PreparedStatement ps1=con.prepareStatement(qr4);
ps1.setInt(1, h.getRidesDone());
ps1.setInt(2,h.getDue());
ps1.setString(3, h.getEmail());
int a=ps1.executeUpdate();
String qr5="update rent set rent_done=? , credit=? where email=?";
PreparedStatement ps2=con.prepareStatement(qr5);
ps2.setInt(1, r.getRentDone());
ps2.setInt(2,r.getEarn());
ps2.setString(3, r.getEmail());
int ab=ps2.executeUpdate();
if(a==ab)
	return 1;
else
	return 0;


}
catch(Exception e)
{
	e.printStackTrace();
	return 0;
}
}


public List<Vehicle> VehicleDetailsR(String id) throws ClassNotFoundException, SQLException
{ Connection con=getCon();

String st="select * from vehicle where ((email=? or rc_number=?) and PERMISSION='VERIFIED')AND RENT='YES' ";
PreparedStatement ps=con.prepareStatement(st);
ps.setString(1, id);
ps.setString(2, id);


ResultSet rs=ps.executeQuery();
ArrayList<Vehicle> al=new ArrayList<Vehicle>();

while(rs.next())
{

	Vehicle v=new Vehicle();
	
	v.setVname(rs.getString(1));
	v.setRcnum(rs.getString(2));
	v.setRcpic(rs.getString(3));
	v.setVpic(rs.getString(4));
	v.setEmail(rs.getString(5));
	v.setVtype(rs.getString(6));
	v.setGps(rs.getString(7));
	v.setVmod(rs.getString(8));
	v.setVfuel(rs.getString(9));
	v.setMread(rs.getString(10));
	v.setPermission(rs.getString(11));

al.add(v);
}
return al;
}


public List<Ongoing> OngoingDetailsR(String id) throws ClassNotFoundException, SQLException
{ Connection con=getCon();

String st="select * from ongoing where rent_email=? ";
PreparedStatement ps=con.prepareStatement(st);
ps.setString(1, id);


ResultSet rs=ps.executeQuery();
ArrayList<Ongoing> al=new ArrayList<Ongoing>();

while(rs.next())
{

	
	Ongoing r=new Ongoing();
	r.setRcnum(rs.getString(1));
	r.setGps(rs.getString(2));
    r.setHemail(rs.getString(3));
	r.setHMnum(rs.getString(4));
	r.setRemail(rs.getString(5));
    r.setCity(rs.getString(6));
	r.setDate(rs.getString(7));
    r.setEtime(rs.getString(8));

al.add(r);
}
return al;
}
public List<Hire> HireDetails(String id) throws ClassNotFoundException, SQLException
{ Connection con=getCon();

String st="select * from hire where PERMISSION=? ";
PreparedStatement ps=con.prepareStatement(st);
ps.setString(1, id);


ResultSet rs=ps.executeQuery();
ArrayList<Hire> al=new ArrayList<Hire>();

while(rs.next())
{

	
	Hire h=new Hire();
	 h.setAdhrnum(rs.getString(1));
		h.setAdhradd(rs.getString(4));
     h.setName(rs.getString(2));
		h.setDrLinum(rs.getString(3));
		h.setDrLiadd(rs.getString(5));
	    h.setRidesDone(rs.getInt(6));
     h.setEmail(rs.getString(8));
		h.setMobileNumber(rs.getString(7));
		h.setAproved(rs.getString(9));
		h.setDue(rs.getInt(10));
		h.setPassword(rs.getString(11));
al.add(h);
}
return al;
}
public List<Rent> RentDetails(String id) throws ClassNotFoundException, SQLException
{ Connection con=getCon();

String st="select * from Rent where PERMISSION=? ";
PreparedStatement ps=con.prepareStatement(st);
ps.setString(1, id);


ResultSet rs=ps.executeQuery();
ArrayList<Rent> al=new ArrayList<Rent>();

while(rs.next())
{

	
	Rent h=new Rent();
	 h.setAdhrnum(rs.getString(1));
		h.setAdhradd(rs.getString(4));
  h.setName(rs.getString(2));
		h.setDrLinum(rs.getString(3));
		h.setDrLiadd(rs.getString(5));
	    h.setRentDone(rs.getInt(6));
  h.setEmail(rs.getString(8));
		h.setMobileNumber(rs.getString(7));
		h.setAproved(rs.getString(9));
		h.setEarn(rs.getInt(10));
		h.setPassword(rs.getString(11));
		h.setAccNo(rs.getString(12));
		h.setIFSC(rs.getString(13));
al.add(h);
}
return al;
}
public List<Vehicle> VDetails(String id) throws ClassNotFoundException, SQLException
{ Connection con=getCon();

String st="select * from Vehicle where PERMISSION=? ";
PreparedStatement ps=con.prepareStatement(st);
ps.setString(1, id);


ResultSet rs=ps.executeQuery();
ArrayList<Vehicle> al=new ArrayList<Vehicle>();

while(rs.next())
{

	
Vehicle v=new Vehicle();
	
	v.setVname(rs.getString(1));
	v.setRcnum(rs.getString(2));
	v.setRcpic(rs.getString(3));
	v.setVpic(rs.getString(4));
	v.setEmail(rs.getString(5));
	v.setVtype(rs.getString(6));
	v.setGps(rs.getString(7));
	v.setVmod(rs.getString(8));
	v.setVfuel(rs.getString(9));
	v.setMread(rs.getString(10));
	v.setPermission(rs.getString(11));
al.add(v);
}
return al;
}
public List<Vrent> VDetails() throws ClassNotFoundException, SQLException
{ Connection con=getCon();

String st="select * from Vrent ";
Statement ps=con.createStatement();



ResultSet rs=ps.executeQuery(st);
ArrayList<Vrent> al=new ArrayList<Vrent>();

while(rs.next())
{

	

	Vrent r=new Vrent();
	r.setDate(rs.getString(1));
	
    r.setCity(rs.getString(2));
    r.setRcnum(rs.getString(3));
    r.setEmail(rs.getString(4));
	r.setStime(rs.getString(5));
	r.setEtime(rs.getString(6));
  r.setBfare(rs.getString(7));
	r.setKfare(rs.getString(8));
	r.setAddress(rs.getString(9));
	r.setMread(rs.getString(10));

al.add(r);
}
return al;
}

public List<Ongoing> ODetails() throws ClassNotFoundException, SQLException
{ Connection con=getCon();

String st="select * from Ongoing ";
Statement ps=con.createStatement();



ResultSet rs=ps.executeQuery(st);
ArrayList<Ongoing> al=new ArrayList<Ongoing>();

while(rs.next())
{

	

	Ongoing r=new Ongoing();
	r.setRcnum(rs.getString(1));
	r.setGps(rs.getString(2));
    r.setHemail(rs.getString(3));
	r.setHMnum(rs.getString(4));
	r.setRemail(rs.getString(5));
    r.setCity(rs.getString(6));
	r.setDate(rs.getString(7));
    r.setEtime(rs.getString(8));

al.add(r);
}
return al;
}

public List<Records> Records() throws ClassNotFoundException, SQLException
{ Connection con=getCon();

String st="select * from Records ";
Statement ps=con.createStatement();



ResultSet rs=ps.executeQuery(st);
ArrayList<Records> al=new ArrayList<Records>();

while(rs.next())
{

	Records v=new Records();
	v.setRcnum(rs.getString(1));
	v.setHid(rs.getString(2));
   v.setRid(rs.getString(3));
	v.setCity(rs.getString(4));
	v.setDate(rs.getString(5));
    v.setEtime(rs.getString(6));
    		v.setCtime(rs.getString(7));
    		v.setFare(rs.getString(8));
al.add(v);
}
return al;
}




public Vehicle VVDetails(String rc)
{try{
	Connection con=getCon();
	String qr="select * from vehicle where rc_number=?";
	PreparedStatement ps= con.prepareStatement(qr);
	ps.setString(1,rc);
	ResultSet rs=ps.executeQuery();
	Vehicle v=new Vehicle();
	while(rs.next())
	{

		
	
		
		v.setVname(rs.getString(1));
		v.setRcnum(rs.getString(2));
		v.setRcpic(rs.getString(3));
		v.setVpic(rs.getString(4));
		v.setEmail(rs.getString(5));
		v.setVtype(rs.getString(6));
		v.setGps(rs.getString(7));
		v.setVmod(rs.getString(8));
		v.setVfuel(rs.getString(9));
		v.setMread(rs.getString(10));
		v.setPermission(rs.getString(11));
		
	}
	return v;
	
}
catch(Exception e)
{
	e.printStackTrace();
return null;
}
}



public int delete(String tab,String id)
{
	try{
		Connection con=getCon();
	String qr="delete from "+tab+" where email= ? ";
	PreparedStatement ps=con.prepareStatement(qr);
	ps.setString(1, id);
	ps.setString(1, id);
	return ps.executeUpdate();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	return 0;
	}
}
public int vdelete(String id)
{
	try{
		Connection con=getCon();
	String qr="delete from vehicle where rc_number= ? ";
	PreparedStatement ps=con.prepareStatement(qr);
	ps.setString(1, id);
	return ps.executeUpdate();
	}
	catch(Exception e)
	{
		e.printStackTrace();
	return 0;
	}
}

public int agree(String tab,String id)
{
	
try {
	Connection con=getCon();
	String qr="update "+tab+" set permission='VERIFIED' where email=?";
	PreparedStatement ps=con.prepareStatement(qr);
	ps.setString(1, id);
	return ps.executeUpdate();
	
	
} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	return 0;
} 


}
public int Vagree(String id)
{
	
try {
	Connection con=getCon();
	String qr="update vehicle set permission='VERIFIED' where rc_number=?";
	PreparedStatement ps=con.prepareStatement(qr);
	ps.setString(1, id);
	return ps.executeUpdate();
	
	
} catch (Exception e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	return 0;
} 


}

public int Duplicate(String tab,String id)
{
	try{
		Connection con=getCon();
		String qr="select * from "+tab+" where email=?";
		PreparedStatement ps=con.prepareStatement(qr);
		ps.setString(1,id);
		ResultSet rs=ps.executeQuery();
		if(rs.next())
		{
			return 1;
		}
		else
			return 2;
	}
	catch(Exception e)
	{
		e.printStackTrace();
		return 0;
	}
	
	
	
}

public int VDuplicate(String id)
{
	try{
		Connection con=getCon();
		String qr="select * from vehicle where upper(rc_number)=Upper(?)";
		PreparedStatement ps=con.prepareStatement(qr);
		ps.setString(1,id);
		ResultSet rs=ps.executeQuery();
		if(rs.next())
		{
			return 1;
		}
		else
			return 2;
	}
	catch(Exception e)
	{
		e.printStackTrace();
		return 0;
	}
	
	
	
}

}
