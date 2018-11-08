package edu.curso.entity;
import java.io.Serializable;
public class User implements Serializable {
	private static final long serialVersionUID = -6724522992805803925L;
	private String userid;
	private String password;
	
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
