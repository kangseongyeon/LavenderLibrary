package kr.or.ddit.bookVideo.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.bookVideo.service.BookVideoServiceImpl;
import kr.or.ddit.bookVideo.service.IBookVideoService;
import kr.or.ddit.vo.BookVideoVO;

@WebServlet("/bookVideo/search.do")
public class SearchBookVIdeoController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String searchKeyword = req.getParameter("searchKeyword");
		
		IBookVideoService bookVideoService = BookVideoServiceImpl.getInstance();
		BookVideoVO bv = new BookVideoVO();
		bv.setBookVideoTitle(searchKeyword);
		
		List<BookVideoVO> bookVideoList = bookVideoService.searchBookVideo(bv);
		req.setAttribute("bookVideoList", bookVideoList);
		req.getRequestDispatcher("/views/bookVideo/bookVideoSearch.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
