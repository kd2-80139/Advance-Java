package com.sunbeam.servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sunbeam.dao.UserDao;
import com.sunbeam.pojo.Users;
@WebServlet("/adduserservlet")
public class AddUserServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Users u = new Users();
		String fname=req.getParameter("fname");
		String lname=req.getParameter("lname");
		String email=req.getParameter("email");
		String password=req.getParameter("password");
		String mobile=req.getParameter("mobile");
		try {
			SimpleDateFormat sdf=new SimpleDateFormat("dd-mm-yy");
			String birth=req.getParameter("birth");
			Date birthday;
			birthday = sdf.parse(birth);
			u.setBirth(birthday);
			u.setEmail(email);
			u.setFirst_name(fname);
			u.setLast_name(lname);
			u.setMobile(mobile);
			u.setPassword(password);
			try(UserDao udao=new UserDao()){
				udao.adduser(u);
				resp.sendRedirect("successfull.html");
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new ServletException();
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ServletException();
		}
		
		
		
	}
}
