package kr.or.ddit.news.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.news.service.INewsService;
import kr.or.ddit.news.service.NewsServiceImpl;

@WebServlet("/news/delete.do")
public class DeleteNewsController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String newsNo = req.getParameter("newsNo");
		
		INewsService newsService = NewsServiceImpl.getInstance();
		
		int cnt = newsService.removeNews(newsNo);
		
		String msg = "";
		if (cnt > 0) {
			msg = "SUCCESS";
		} else {
			msg = "FAIL";
		}
		req.getSession().setAttribute("msg", msg);
		
		resp.sendRedirect(req.getContextPath() + "/news/list.do");
	
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
}
