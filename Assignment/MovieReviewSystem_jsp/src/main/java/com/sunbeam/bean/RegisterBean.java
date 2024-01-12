package com.sunbeam.bean;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.sunbeam.dao.UserDao;
import com.sunbeam.pojo.Users;

public class RegisterBean {
	public String fname;
	public String lname;
	public String email;
	public String password;
	public String mobile;
	public String birth;
	public boolean status;
	public boolean getStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public RegisterBean() {
		// TODO Auto-generated constructor stub
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public void addUser() {
		try(UserDao udao=new UserDao()){
			Users u = new Users();
			SimpleDateFormat sdf=new SimpleDateFormat("dd-mm-yyyy");
			Date d=sdf.parse(birth);
			u.setBirth(d);
			u.setEmail(email);
			u.setFirst_name(fname);
			u.setLast_name(lname);
			u.setMobile(mobile);
			u.setPassword(password);
			int cnt=udao.adduser(u);
			if(cnt==1) {
				setStatus(true);
			}
			else {
				setStatus(false);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
