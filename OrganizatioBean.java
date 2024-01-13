package com.Connection;

public class OrganizatioBean {
	public String oid;
	public String oname;
	public String uname;
	public String pass;
	public String getOid() {
		return oid;
	}
	public void setOid(String oid) {
		this.oid = oid;
	}
	public String getOname() {
		return oname;
	}
	public void setOname(String oname) {
		this.oname = oname;
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
	public OrganizatioBean(String oid, String oname, String uname, String pass) {
//		super();
		this.oid = oid;
		this.oname = oname;
		this.uname = uname;
		this.pass = pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public OrganizatioBean() {
//		super();
	}
	

}
