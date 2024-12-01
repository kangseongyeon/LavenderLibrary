package kr.or.ddit.news.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.news.service.INewsService;
import kr.or.ddit.news.service.NewsServiceImpl;
import kr.or.ddit.vo.NewsVO;

@WebServlet("/news/search.do")
public class SearchNewsController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String searchKeyword = req.getParameter("searchKeyword");
		
		INewsService newsService = NewsServiceImpl.getInstance();
		NewsVO nv = new NewsVO();
		nv.setNewsTitle(searchKeyword);
		
		List<NewsVO> newsList = newsService.searchNews(nv);
		req.setAttribute("newsList", newsList);
		req.getRequestDispatcher("/views/news/newsSearch.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req,resp);
	}
}
