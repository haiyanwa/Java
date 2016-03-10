package cs320.lab4;

import java.util.Date;

public class Survey {
	private String fname;
	private String lname;
	private String cin;
	private String quarter;
	private String courseName;
	private Date date;
	
	public Survey(){
		date = new Date();
	}
	public Survey(String fname, String lname,String cin, String quarter, String courseName){
		this.fname = fname;
		this.lname = lname;
		this.cin = cin;
		this.quarter = quarter;
		this.courseName = courseName;
		date = new Date();
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public String getCin() {
		return cin;
	}
	public void setCin(String cin) {
		this.cin = cin;
	}
	public String getQuarter() {
		return quarter;
	}
	public void setQuarter(String quarter) {
		this.quarter = quarter;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
}
