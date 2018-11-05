package repository;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.User;
import web.User_Dao;

@WebServlet("/update_user.do")
public class update_user extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public update_user() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		User user = new User_Dao().finduser(request.getParameter("email"));
		user.setName(request.getParameter("name"));
		user.setBirth(request.getParameter("birth"));
		user.setPhone(request.getParameter("phone"));
		user.setSchool(request.getParameter("school"));
		
		new User_Dao().updateuser(user);
		
		response.sendRedirect("myblog_in");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
