package com.java.web.DAO;

public class User {
	String id;
	String pwd;
	
	@Override
	public String toString() {
		return "User [id=" + id + ", pwd=" + pwd + "]";
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
}
