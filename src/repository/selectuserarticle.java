package repository;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Article;
import web.Article_Dao;

@WebServlet("/finduserarticle")
public class selectuserarticle extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public selectuserarticle() {
        super();
   }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		String name = request.getParameter("name");
		List<Article> list = new Article_Dao().FindUserArticle(name);
		
		request.setAttribute("Allarticlelist", list);
		
		request.getRequestDispatcher("").forward(request, response);

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
