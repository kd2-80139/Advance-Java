package com.sunbeam.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sunbeam.dao.SharesDao;
import com.sunbeam.dao.UserDao;
import com.sunbeam.pojo.Users;
@WebServlet("/sharereview")
public class ShareReviewServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setContentType("text/html");
		PrintWriter out=resp.getWriter();
		int id=Integer.parseInt(req.getParameter("id"));
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Edit Review</title>");
		out.println("</head");
		out.println("<body>");
		out.println("<form method='post' action='sharereview'>");
		out.printf("Review Id<input type='number' value=%s name='rid'/>",id);
		out.println("<select name='user'>");
		List<Users> ulist=new ArrayList<Users>();
		try(UserDao udao=new UserDao()){
			
			ulist=udao.display();
			
			for(Users u:ulist) {
				out.printf("<option value=%s>%s</option>",u.getId(),u.getFirst_name());
			}
			

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		out.println("</select>");
		out.println("<input type='submit' value='Share'/>");
		out.println("</form>");
		out.println("</body>");
		out.println("</html>");
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int rid=Integer.parseInt(req.getParameter("rid"));
		int uid=Integer.parseInt(req.getParameter("user"));
		try(SharesDao sdao=new SharesDao()){
			sdao.add(rid, uid); 
			resp.sendRedirect("allreview");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
