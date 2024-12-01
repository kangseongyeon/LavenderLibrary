package kr.or.ddit.bookVideo.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.bookVideo.service.BookVideoServiceImpl;
import kr.or.ddit.bookVideo.service.IBookVideoService;

@WebServlet("/bookVideo/delete.do")
public class DeleteBookVideoController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String bookVideoNo = req.getParameter("bookVideoNo");
		
		IBookVideoService bookVideoService = BookVideoServiceImpl.getInstance();
		
		bookVideoService.removeBookVideo(bookVideoNo);
		
		int cnt=bookVideoService.removeBookVideo(bookVideoNo);
		
		String msg="";
		if(cnt>0) {
			//삭제 성공
			msg="SUCCESS";
		}else {
			//삭제 실패
			msg="FAIL";
		}
		
		req.getSession().setAttribute("msg", msg); //세션에 담기
		
		resp.sendRedirect(req.getContextPath() + "/bookVideo/list.do");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
	
}
