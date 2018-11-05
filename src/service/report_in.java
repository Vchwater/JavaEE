package service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/report_in")
public class report_in extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public report_in() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		
		Cookie[] cookies = request.getCookies();
		int flag= 0;
		if(cookies!=null) {
			for(Cookie cookie:cookies){
				if( (cookie.getName()).equals("username")){
					System.out.println("cookie为"+cookie.getValue());
					flag = 1;
					break;
				}
			}
		}
		if(flag==0) {
			out.println("未登录，请登录");
			response.setHeader("refresh", "3;URL=login_in");
		}else {
			response.sendRedirect("report.jsp");
		}
		

		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
