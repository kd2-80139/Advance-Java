package com.sunbeam.servlets;

import java.io.IOException;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sunbeam.dao.ReviewsDao;
import com.sunbeam.pojo.Reviews;
import com.sunbeam.pojo.Users;
@WebServlet("/newreviewadded")
public class NewReviewAdd extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=req.getSession();
		Users u=(Users)session.getAttribute("curuser");
		int uid=u.getId();
		int id=Integer.parseInt(req.getParameter("movies"));
		int rating=Integer.parseInt(req.getParameter("rating"));
		String review=req.getParameter("review");
		Reviews r=new Reviews();
		r.setMovie_id(id);
		r.setRating(rating);
		r.setReview(review);
		try(ReviewsDao rdao=new ReviewsDao()){
			int x=rdao.accept(r,uid);
			resp.sendRedirect("allreview");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ServletException();
		}
	}
}
