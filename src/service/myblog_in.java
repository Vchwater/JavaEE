package service;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Article;
import domain.User;
import web.Article_Dao;
import web.User_Dao;

@WebServlet("/myblog_in")
public class myblog_in extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public myblog_in() {
        super();
   }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		Cookie[] cookies = request.getCookies();
		int flag= 0;
		String value = null;
		if(cookies!=null) {
			for(Cookie cookie:cookies){
				if( (cookie.getName()).equals("email")){
					value = cookie.getValue();
					flag = 1;
					break;
				}
			}
		}
		if(flag==0) {
			out.println("未登录，请登录");
			response.setHeader("refresh", "2;URL=login_in");
		}else {
			if(request.getParameter("order")!=null) {
				if(request.getParameter("order").equals("update")) {
					request.setAttribute("update", request.getParameter("order"));
				}
			}
			
			
			List<Article> list = new Article_Dao().FindUserArticle(value);
			List<User> list1 = new ArrayList<User>();
			
			User user = new User_Dao().finduser(value);
			list1.add(user);
			request.setAttribute("userlist",list1);
			request.setAttribute("finduserlist", list);
			
			request.getRequestDispatcher("myblog.jsp").forward(request, response);
		}
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
