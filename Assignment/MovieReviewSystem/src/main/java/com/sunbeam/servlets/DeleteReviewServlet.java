package com.sunbeam.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sunbeam.dao.ReviewsDao;
import com.sunbeam.pojo.Users;
@WebServlet("/deletereview")
public class DeleteReviewServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id=Integer.parseInt(req.getParameter("id"));
		HttpSession session=req.getSession();
		Users u=(Users)session.getAttribute("curuser");
		int cnt=0;
		try(ReviewsDao rdao=new ReviewsDao()){
			cnt=rdao.delete(id, u.getId());
			RequestDispatcher rs=req.getRequestDispatcher("allreview");
			rs.forward(req, resp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
