package Veh;

public class Vehicle {
	private String Rcnum;
	private String Rcpic;
	private String vpic;
	private String email;
	private String gps;
	private String Vtype;
	private String Vname;
	private String Vmod;
	private String Vfuel;
	private String Mread;
	private String permission;
	private String Rent;
	
	public String getRent() {
		return Rent;
	}
	public void setRent(String rent) {
		Rent = rent;
	}
	public String getPermission() {
		return permission;
	}
	public void setPermission(String permission) {
		this.permission = permission;
	}
	public String getRcnum() {
		return Rcnum;
	}
	public void setRcnum(String rcnum) {
		Rcnum = rcnum;
	}
	public String getRcpic() {
		return Rcpic;
	}
	public void setRcpic(String rcpic) {
		Rcpic = rcpic;
	}
	public String getVpic() {
		return vpic;
	}
	public void setVpic(String vpic) {
		this.vpic = vpic;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGps() {
		return gps;
	}
	public void setGps(String gps) {
		this.gps = gps;
	}
	public String getVtype() {
		return Vtype;
	}
	public void setVtype(String vtype) {
		Vtype = vtype;
	}
	public String getVname() {
		return Vname;
	}
	public void setVname(String vname) {
		Vname = vname;
	}
	public String getVmod() {
		return Vmod;
	}
	public void setVmod(String vmod) {
		Vmod = vmod;
	}
	public String getVfuel() {
		return Vfuel;
	}
	public void setVfuel(String vfuel) {
		Vfuel = vfuel;
	}
	public String getMread() {
		return Mread;
	}
	public void setMread(String mread) {
		Mread = mread;
	}
	

}
