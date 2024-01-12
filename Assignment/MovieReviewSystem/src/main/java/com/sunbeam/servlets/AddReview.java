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
import com.sunbeam.pojo.Movies;
import com.sunbeam.pojo.Users;
@WebServlet("/addreview")
public class AddReview extends HttpServlet {
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
		out.println("<form method='post' action='newreviewadded'>");
		out.println("<select name='movies'>");
		List<Movies> mlist = new ArrayList<Movies>();
		try (MoviesDao md = new MoviesDao()) {
			mlist = md.display();
			for (Movies movie : mlist) {
				out.println("<option value="+movie.getId()+">"+movie.getTitle()+"</option>");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new ServletException();
		}
		out.println("<input type='number' name='rating'/>");
		out.println("<input type='textarea' name='review'/>");
		out.println("<input type='submit' value='Add'/>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
	}
}
