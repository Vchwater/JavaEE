package repository;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web.Article_Dao;

@WebServlet("/addlike.do")
public class addlike extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public addlike() {
        super();
     }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("idarticle");
		new Article_Dao().addlike(Integer.parseInt(id));
		HttpSession session = request.getSession();
		session.setAttribute(id, "alreadylike");
		
		request.setAttribute("idarticle1", id);
		request.getRequestDispatcher("findarticle.do").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
