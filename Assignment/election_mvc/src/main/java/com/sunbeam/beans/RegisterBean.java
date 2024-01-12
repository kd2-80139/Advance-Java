package com.sunbeam.beans;


import java.text.SimpleDateFormat;
import java.util.Date;

import com.sunbeam.daos.UserDaoImpl;
import com.sunbeam.pojos.User;

public class RegisterBean {
	private String fName;
	private String lName;
	private String email;
	private String password;
	private String birth;
	public RegisterBean() {
		// TODO Auto-generated constructor stub
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
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
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public void  addUser() {
		SimpleDateFormat sdf= new SimpleDateFormat("dd-MM-yyyy");	
		try(UserDaoImpl udao=new UserDaoImpl()){
			Date d=sdf.parse(birth);
			java.sql.Date sDate=new java.sql.Date(d.getTime());
			User u=new User();
			u.setBirth(sDate);
			u.setEmail(email);
			u.setFirstName(fName);
			u.setLastName(lName);
			u.setPassword(password);
			udao.save(u);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
