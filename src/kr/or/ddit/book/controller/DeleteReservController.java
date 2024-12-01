package kr.or.ddit.book.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.book.service.BookService;
import kr.or.ddit.book.service.IBookService;

@WebServlet("/reserv/delete.do")
public class DeleteReservController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String revNo=req.getParameter("revNo");
		IBookService bookService=BookService.getInstance();
		int cnt=bookService.deleteReserv(revNo);
		
		String msg="";
		if(cnt>0) {
			//삭제 성공
			msg="SUCCESS";
		}else {
			//삭제 실패
			msg="FAIL";
		}
		
		req.getSession().setAttribute("msg", msg); //세션에 담기
		
		resp.sendRedirect(req.getContextPath()+"/reserv/memReserv.do");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}