package repository;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import domain.Article;
import web.Article_Dao;

@MultipartConfig(location="F:\\javaee_workspace\\BLOG-2016121068\\WebContent\\images")
@WebServlet("/report_handle")
public class report_handle extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public report_handle() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		Article article = new Article();
		Cookie[] cookies = request.getCookies();
		String value = null;
		for(Cookie cookie:cookies){
			if( cookie.getName().equals("email")){
				value = cookie.getValue();
				break;
			}
		}
		
		if(request.getPart("image")==null) {
			article.setImage("zd01.jpg");
		}else {
			Part part =request.getPart("image");
		     System.out.println(part.getSubmittedFileName());
		     article.setImage(part.getSubmittedFileName());
		     part.write(part.getSubmittedFileName());
		}
		
	     
		String title = request.getParameter("name");
		String content = request.getParameter("content");
		
		article.setTitle(title);
		article.setContent(content);
		article.setName(value);
		
		new Article_Dao().AddArticle(article);
		
		response.sendRedirect("myblog_in");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
