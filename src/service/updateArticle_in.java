package service;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.Article;
import web.Article_Dao;

@WebServlet("/updateArticle_in")
public class updateArticle_in extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public updateArticle_in() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("idarticle");
		System.out.println("id:"+id);
		Article article = new Article_Dao().FindArticle(id);
		
		request.setAttribute("article", article);
		request.getRequestDispatcher("updateArticle.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
