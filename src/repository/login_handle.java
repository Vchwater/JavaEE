package repository;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.User;
import web.User_Dao;

@WebServlet("/login_handle")
public class login_handle extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public login_handle() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		
		if(new User_Dao().UserCheck(email,password)) {
			System.out.println("登录失败！");
			out.println("登录失败，用户名或密码不正确，请重新登录");
	    	response.setHeader("refresh", "2;URL=login_in");
		}else System.out.println("登录成功");
		
		User user = new User_Dao().finduser(email);
		
		if(request.getParameter("checkbox")!=null) {
	    	Cookie cookie1 = new Cookie("username",user.getName());
	    	Cookie cookie2 = new Cookie("email", user.getEmail());
	    	Cookie cookie3 = new Cookie("password", user.getPassword());
	    	cookie1.setMaxAge(60*60*24*10);
	    	cookie2.setMaxAge(60*60*24*10);
	    	cookie3.setMaxAge(60*60*24*10);
	    	response.addCookie(cookie1);
	    	response.addCookie(cookie2);
	    	response.addCookie(cookie3);
	    }else {
	    	Cookie cookie1 = new Cookie("username",user.getName());
	    	Cookie cookie2 = new Cookie("email", user.getEmail());
	    	Cookie cookie3 = new Cookie("password", user.getPassword());
	    	response.addCookie(cookie1);
	    	response.addCookie(cookie2);
	    	response.addCookie(cookie3);
	    }
		response.sendRedirect("myblog_in");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
