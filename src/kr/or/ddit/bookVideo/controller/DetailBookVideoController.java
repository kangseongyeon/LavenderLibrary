package kr.or.ddit.bookVideo.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.bookVideo.service.BookVideoServiceImpl;
import kr.or.ddit.bookVideo.service.IBookVideoService;
import kr.or.ddit.vo.BookVideoVO;


@WebServlet("/bookVideo/detail.do")
public class DetailBookVideoController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String bookVideoNo = req.getParameter("bookVideoNo");
		
		IBookVideoService bookVideoService = BookVideoServiceImpl.getInstance();
		
		BookVideoVO bv = bookVideoService.getBookVideo(bookVideoNo);
		
		req.setAttribute("bv", bv);
		
		req.getRequestDispatcher("/views/bookVideo/bookVideoDetail.jsp").forward(req, resp);
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException ,IOException {
		doGet(req, resp);
	};
}
