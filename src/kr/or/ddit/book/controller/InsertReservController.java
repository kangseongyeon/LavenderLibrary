package kr.or.ddit.book.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.book.service.BookService;
import kr.or.ddit.book.service.IBookService;
import kr.or.ddit.book.vo.BookVO;
import kr.or.ddit.book.vo.ReservVO;

@WebServlet("/reserv/insert.do")
public class InsertReservController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int cnt=0;
		String bookId= req.getParameter("bookId");
		String memId=(String)req.getSession().getAttribute("loginCode");
		IBookService bookService= BookService.getInstance();
		
		ReservVO rv=new ReservVO();
		rv.setBookId(bookId);
		rv.setMemId(memId);
		ReservVO rv2=new ReservVO();
		rv2=bookService.getReserv(rv);
		if(rv2==null) {
			cnt=bookService.insertReserv(rv);
		}
		
		
		String msg = "";
        if (cnt > 0) {
            // 등록 성공
            msg = "SUCCESS";
        } else {
            // 등록 실패
            msg = "FAIL";
        }
        req.getSession().setAttribute("msg", msg); // 세션에 담기
        
        resp.sendRedirect(req.getContextPath() + "/book/list.do");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
