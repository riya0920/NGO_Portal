package com.Connection;

public class EventBean {
	public String eid;
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public int getHours() {
		return hours;
	}
	public void setHours(int hours) {
		this.hours = hours;
	}
	public String loc,desc;
	public int hours;
	public EventBean() {
//		super();
	}
	
	public EventBean(String eid, String loc, String desc, int hours, String ename, String evac) {
		super();
		this.eid = eid;
		this.loc = loc;
		this.desc = desc;
		this.hours = hours;
		this.ename = ename;
		this.evac = evac;
	}
	public String ename;
	public String evac;
	public String getEid() {
		return eid;
	}
	public void setEid(String eid) {
		this.eid = eid;
	}
	public String getEname() {
		return ename;
	}
	public void setEname(String ename) {
		this.ename = ename;
	}
	public String getEvac() {
		return evac;
	}
	public void setEvac(String evac) {
		this.evac = evac;
	}
}
