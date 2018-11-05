package repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Article;
import domain.User;
import web.Article_Dao;
import web.User_Dao;

@WebServlet("/finduser.do")
public class finduser extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public finduser() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		String email = request.getParameter("email");
		List<Article> list = new Article_Dao().FindUserArticle(email);
		List<User> list1 = new ArrayList<User>();
		User user = new User_Dao().finduser(email);
		list1.add(user);
		request.setAttribute("userlist", list1);
		request.setAttribute("finduserlist", list);
		
		request.getRequestDispatcher("heblog.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
