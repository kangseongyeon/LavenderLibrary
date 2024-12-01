package kr.or.ddit.bookVideo.controller;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.bookVideo.service.BookVideoServiceImpl;
import kr.or.ddit.bookVideo.service.IBookVideoService;
import kr.or.ddit.vo.BookVideoVO;

@WebServlet("/bookVideo/update.do")
public class UpdateBookVideoController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String bookVideoNo = req.getParameter("bookVideoNo");
		
		IBookVideoService bookVideoService = BookVideoServiceImpl.getInstance();
		
		BookVideoVO bv = bookVideoService.getBookVideo(bookVideoNo);
		
		req.setAttribute("bv", bv);
		
		req.getRequestDispatcher("/views/bookVideo/bookVideoUpdate.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String bookVideoNo = req.getParameter("bookVideoNo");
		String bookVideoTitle = req.getParameter("bookVideoTitle");
		String bookVideoContent = req.getParameter("bookVideoContent");
		
		IBookVideoService bookVideoService = BookVideoServiceImpl.getInstance();
		
		BookVideoVO bv = new BookVideoVO(bookVideoNo, bookVideoTitle, bookVideoContent);
		
		int cnt = bookVideoService.modifyBookVideo(bv);
		String msg = "";
		if (cnt > 0) {
			msg = "SUCCESS";
		} else {
			msg = "FAIL";
		}
		req.getSession().setAttribute("msg", msg);
		
		resp.sendRedirect(req.getContextPath() + "/bookVideo/list.do");
	}
}
