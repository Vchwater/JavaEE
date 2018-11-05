package repository;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import domain.Article;
import web.Article_Dao;

@WebServlet("/updateArticle.do")
public class updateArticle extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public updateArticle() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		Article article = new Article();
		
		
	     
		String title = request.getParameter("name");
		String content = request.getParameter("content");
		String id = request.getParameter("id");
		System.out.println(id+title+"id:");
		article.setTitle(title);
		article.setContent(content);
		article.setId(Integer.parseInt(id));
		new Article_Dao().updateArticle(article);
		System.out.println("更新成功");
		response.sendRedirect("myblog_in");
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
