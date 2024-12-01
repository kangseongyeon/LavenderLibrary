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

@WebServlet("/book/detail.do")
public class DetailBookController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String bookId=req.getParameter("bookId");
		IBookService bookService=BookService.getInstance();
		BookVO bv=bookService.getBook(bookId);
		int cnt=bookService.reservChk(bookId);
		req.setAttribute("revCnt", cnt);
		
		req.setAttribute("bv", bv);
		bookService.updateViewCnt(bookId);
		req.getRequestDispatcher("/views/book/detail.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
