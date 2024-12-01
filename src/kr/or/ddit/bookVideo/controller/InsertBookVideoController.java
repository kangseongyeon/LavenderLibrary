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

@WebServlet("/bookVideo/insert.do")
public class InsertBookVideoController extends HttpServlet{
	@Override
	protected void doGet(javax.servlet.http.HttpServletRequest req, javax.servlet.http.HttpServletResponse resp) throws javax.servlet.ServletException ,java.io.IOException {
		req.getRequestDispatcher("/views/bookVideo/bookVideoInsert.jsp").forward(req, resp);
	};
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String bookVideoTitle = req.getParameter("bookVideoTitle");
		String bookVideoContent = req.getParameter("bookVideoContent");
		
		IBookVideoService bookVideoService = BookVideoServiceImpl.getInstance();
		
		BookVideoVO bv = new BookVideoVO(bookVideoTitle, bookVideoContent);
		
		int cnt = bookVideoService.registerBookVideo(bv);
		
		 String msg = "";
	        if (cnt > 0) {
	            // 등록 성공
	            msg = "SUCCESS";
	        } else {
	            // 등록 실패
	            msg = "FAIL";
	        }
	    req.getSession().setAttribute("msg", msg); // 세션에 담기
		resp.sendRedirect(req.getContextPath() + "/bookVideo/list.do");
		
	}
}
