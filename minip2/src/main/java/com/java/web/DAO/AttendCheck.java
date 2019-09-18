package com.java.web.DAO;

public class AttendCheck {
	private String id;
	private int check;
	private int day;
	private String approval;
	
	public String getApproval() {
		return approval;
	}
	public void setApproval(String approval) {
		this.approval = approval;
	}
	@Override
	public String toString() {
		return "AttendCheck [id=" + id + ", check=" + check + ", day=" + day + ", approval=" + approval + "]";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getCheck() {
		return check;
	}
	public void setCheck(int check) {
		this.check = check;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	
}
