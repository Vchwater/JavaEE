package repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.Article;
import web.Article_Dao;

@WebServlet("/findarticle.do")
public class findarticle extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public findarticle() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		List<Article> list = new ArrayList<Article>() ;
		Article_Dao dao = new Article_Dao();
		String idarticle;
		if(request.getParameter("idarticle")!=null) {
			idarticle = request.getParameter("idarticle");
		}else {
			idarticle = (String) request.getAttribute("idarticle1");
		}
		if(session.getAttribute(idarticle)!=null) {
			if("alreadylook".equals(session.getAttribute(idarticle))!=true) {
				dao.addlook(Integer.parseInt(idarticle));
			}else {
				session.setAttribute("alreadylook", idarticle);
			}
			
		}
		
		Article article = dao.FindArticle(idarticle);
		list.add(article);
		request.setAttribute("articlelist", list);
		request.setAttribute("idarticle", idarticle);
		request.getRequestDispatcher("article.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
