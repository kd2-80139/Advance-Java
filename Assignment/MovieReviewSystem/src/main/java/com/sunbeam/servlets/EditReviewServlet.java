package com.sunbeam.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sunbeam.dao.ReviewsDao;
import com.sunbeam.pojo.Reviews;
import com.sunbeam.pojo.Users;
@WebServlet("/editreview")
public class EditReviewServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		HttpSession session=req.getSession();
		int id=Integer.parseInt(req.getParameter("id"));
		Users u=(Users)session.getAttribute("curuser");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Edit Review</title>");
		out.println("</head");
		out.println("<body>");
		out.println("<H2>HELLO "+u.getFirst_name()+"</H2>");
		out.println("<form method='post' action='editreview'>");
		out.printf("Review Id<input type='number' value='%s' readonly name='id'>",id);
		try(ReviewsDao rdao=new ReviewsDao()){
			Reviews r=rdao.displayById(id);
		
			out.printf("Review<input type='text' name='review' value='"+r.getReview()+"'/>");
			out.printf("Review Rating<input type='text' value='%s' readonly name='rating'>",r.getRating());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.printf("<input type='submit' value='Update'/>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
		
		
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub

		int rid=Integer.parseInt(req.getParameter("id"));
		String review=req.getParameter("review");
		HttpSession session=req.getSession();
		Users u=(Users)session.getAttribute("curuser");
		try(ReviewsDao rdao=new ReviewsDao()){
			rdao.edit(rid, review,u.getId() );
			resp.sendRedirect("allreview");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
