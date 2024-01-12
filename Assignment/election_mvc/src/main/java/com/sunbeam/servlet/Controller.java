package com.sunbeam.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/ctl")
public class Controller extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String s=req.getParameter("to");
		String path="";
		if(s.equals("index")) {
			path="/index.jsp";
		}
		else if(s.equals("login")) {
			path="/login.jsp";
		}
		else if(s.equals("candlist")) {
			path="/candlist.jsp";
		}
		else if(s.equals("logout")) {
			path="/logout.jsp";
		}
		else if(s.equals("logout")) {
			path="/logout.jsp";
		}
		else if(s.equals("register")) {
			path="/register.jsp";
		}
		else if(s.equals("result")) {
			path="/result.jsp";
		}
		else if(s.equals("delcand")) {
			path="/delcand.jsp";
		}
		else if(s.equals("candedit")) {
			path="/candedit.jsp";
		}
		else if(s.equals("updatecand")) {
			path="/updatecand.jsp";
		}
		else if(s.equals("registration")) {
			path="/registration.jsp";
		}
		else {
			path="/notFound.jsp";
		}
		ServletContext ctx=this.getServletContext();
		RequestDispatcher rd=ctx.getRequestDispatcher(path);
		rd.forward(req, resp);
		
	}
}
