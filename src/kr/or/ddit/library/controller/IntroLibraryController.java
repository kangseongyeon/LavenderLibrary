package kr.or.ddit.library.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/library/intro.do")
public class IntroLibraryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public IntroLibraryController() {
        super();
    }

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
//		System.out.println("인사말");
		req.setAttribute("active", "intro");
		req.getRequestDispatcher("/views/library/intro.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
