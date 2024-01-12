 /**
 * 
 */
package com.sunbeam.servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sunbeam.dao.UserDao;
import com.sunbeam.pojo.Users;

/**
 * @author Ujjwal Pratap Singh
 *
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req,resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email= req.getParameter("email");
		String pass=req.getParameter("pass");
		try(UserDao user=new UserDao()){
			Users us = new Users();
			us.setEmail(email);
			us.setPassword(pass);
			Users u=user.valid(us);
			if(u!=null) {
				HttpSession session=req.getSession();
				session.setAttribute("curuser", u);
				resp.sendRedirect("allreview?type=all");
			}
			else {
				resp.sendRedirect("fail.html");
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new ServletException(e);
		}
	}

}
