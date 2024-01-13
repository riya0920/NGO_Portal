package com.Connection;

public class VolunteerBean {

	public String fname;
	public String uname;
	public String pass;
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public VolunteerBean(String fname, String uname, String pass) {
//		super();
		this.fname = fname;
		this.uname = uname;
		this.pass = pass;
	}
	public VolunteerBean() {
//		super();
	}
	
}
