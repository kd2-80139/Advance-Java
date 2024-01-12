package com.sunbeam.bean;

import com.sunbeam.dao.UserDao;
import com.sunbeam.pojo.Users;

public class LoginBean {
	private String email;
	private String password;
	private Boolean message;
	

	public Boolean getMessage() {
		return message;
	}
	public void setMessage(Boolean message) {
		this.message = message;
	}
	public LoginBean() {
		// TODO Auto-generated constructor stub
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
	public void auth(){
		try(UserDao udao=new UserDao()){
			Users u=new Users();
			u.setEmail(email);
			u.setPassword(password);
			u=udao.valid(u);
			if(u!=null) {
				setMessage(true);
			}
			else {
				setMessage(false);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
