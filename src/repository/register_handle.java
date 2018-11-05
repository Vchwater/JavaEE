package repository;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.User;
import web.User_Dao;

@WebServlet("/register_handle")
public class register_handle extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public register_handle() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		User user = new User();
		user.setName(request.getParameter("name"));
		user.setEmail(request.getParameter("email"));
		user.setPassword(request.getParameter("password"));
		if(request.getParameter("birth")!=null) {
			user.setBirth(request.getParameter("birth"));
		}
		if(request.getParameter("school")!=null) {
			user.setBirth(request.getParameter("school"));
		}
		if(request.getParameter("phone")!=null) {
			user.setBirth(request.getParameter("phone"));
		}
		User_Dao userdao = new User_Dao();
		userdao.adduser(user);
		response.sendRedirect("login_in");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
