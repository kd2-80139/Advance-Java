package com.sunbeam.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sunbeam.dao.MoviesDao;
import com.sunbeam.dao.ReviewsDao;
import com.sunbeam.pojo.Movies;
import com.sunbeam.pojo.Reviews;
import com.sunbeam.pojo.Users;

@WebServlet("/allreview")
public class ReviewsServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=req.getSession();
		Users u=(Users)session.getAttribute("curuser");
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		out.println("<html>");
		out.println("<head>");
		out.println("<title>All REVIEWS</title>");
		out.println("</head");
		out.println("<body>");
		out.println("<H2>HELLO "+u.getFirst_name()+"</H2>");
		Date now=new Date();
		out.println(now);
		out.printf("<a href='allreview?type=%s'>All Reviews</a>","all");
		out.println("<a href='allreview?type=my'>My Reviews</a>");
		out.println("<a href='allreview?type=shared'>Shared Reviews</a>");
		out.println("<table border=1>");
		out.println("<thead");
		out.println("<tr>");
		out.println("<th>ID</th>");
		out.println("<th>Review</th>");
		out.println("<th>Rating</th>");
		out.println("<th>Movie_Name</th>");
		out.println("<th>Action</th>");
		out.println("<tr>");
		out.println("</thead");
		out.println("<tbody");
		String ty=req.getParameter("type");
		if(ty == null || ty.equals("all")) {
		List<Reviews> rlist=new ArrayList<Reviews>();
		try(ReviewsDao rdao=new ReviewsDao()){
			rlist = rdao.display();
			for (Reviews r : rlist) {
				
				out.println("<tr>");
				out.println("<th>"+r.getId() +"</th>");
				out.println("<th>"+r.getReview()+"</th>");
				out.println("<th>"+r.getRating()+"</th>");
				Movies movies=new Movies();
				try(MoviesDao mdao=new MoviesDao()){
						movies=mdao.findById(r.getMovie_id());
						out.println("<th>"+movies.getTitle()+"</th>");
						
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
						throw new ServletException();
					}
				if(r.getUser_id()==u.getId()) {
					out.printf("<th><a href='editreview?id=%s'><img src='allowedit.png' height='24' width='24'/></a><a href='deletereview?id=%s'><img src='Allowdelete.png' height='24' width='24'/></a><a href='sharereview?id=%s'><img src='share.png' height='24' width='24'/></a></th>",r.getId(),r.getId(),r.getId());
					}
					else {
						out.printf("<th><a href=''><img src='edit.png' height='24' width='24'/></a><a href=''><img src='delete.png' height='24' width='24'/></a><a href=''><img src='share.png' height='24' width='24'/></a></th>");
					}
					out.println("<tr>");
				
			}
		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ServletException();
		}
		}
		
		else if(ty.equals("my")) {
			List<Reviews> rlist=new ArrayList<Reviews>();
			try(ReviewsDao rdao=new ReviewsDao()){
				rlist = rdao.myReviews(u.getId());
				for (Reviews r : rlist) {
					
					out.println("<tr>");
					out.println("<th>"+r.getId() +"</th>");
					out.println("<th>"+r.getReview()+"</th>");
					out.println("<th>"+r.getRating()+"</th>");
					Movies movies=new Movies();
					try(MoviesDao mdao=new MoviesDao()){
							movies=mdao.findById(r.getMovie_id());
							out.println("<th>"+movies.getTitle()+"</th>");
							
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
							throw new ServletException();
						}
					if(r.getUser_id()==u.getId()) {
						out.printf("<th><a href='editreview?id=%s'><img src='allowedit.png' height='24' width='24'/></a><a href='deletereview?id=%s'><img src='Allowdelete.png' height='24' width='24'/></a><a href='sharereview?id=%s'><img src='share.png' height='24' width='24'/></a></th>",r.getId(),r.getId(),r.getId());
						}
						else {
							out.printf("<th><a href=''><img src='edit.png' height='24' width='24'/></a><a href=''><img src='delete.png' height='24' width='24'/></a><a href=''><img src='share.png' height='24' width='24'/></a></th>");
						}
						out.println("<tr>");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new ServletException();
			}
		}
		else {
			List<Reviews> rlist=new ArrayList<Reviews>();
			try(ReviewsDao rdao=new ReviewsDao()){
				rlist = rdao.displaySharedReview(u.getId());
				for (Reviews r : rlist) {
					out.println("<tr>");
					out.println("<th>"+r.getId() +"</th>");
					out.println("<th>"+r.getReview()+"</th>");
					out.println("<th>"+r.getRating()+"</th>");
					Movies movies=new Movies();
					try(MoviesDao mdao=new MoviesDao()){
							movies=mdao.findById(r.getMovie_id());
							out.println("<th>"+movies.getTitle()+"</th>");
							
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
							throw new ServletException();
						}
					if(r.getUser_id()==u.getId()) {
						out.printf("<th><a href='editreview?id=%s'><img src='allowedit.png' height='24' width='24'/></a><a href='deletereview?id=%s'><img src='Allowdelete.png' height='24' width='24'/></a></th>",r.getId(),r.getId());
						}
						else {
							out.printf("<th><a href=''><img src='edit.png' height='24' width='24'/></a><a href=''><img src='delete.png' height='24' width='24'/></a></th>");
						}
						out.println("<tr>");
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new ServletException();
			}
		}
		out.println("</tbody");
		out.println("</table>");
		out.println("<br/>");
		out.println("<a href='addreview'>Add Reviews</a>");
		out.println("<a href='signout'>SignOut</a>");
		out.println("</body>");
		out.println("</html>");
//		
		
	}
	
}