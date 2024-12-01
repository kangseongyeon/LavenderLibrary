package kr.or.ddit.book.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.book.service.BookService;
import kr.or.ddit.book.service.IBookService;
import kr.or.ddit.book.vo.ReservVO;

@WebServlet("/reserv/memReserv.do")
public class MemReservController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		IBookService bookService=BookService.getInstance();
		String memId=(String)req.getSession().getAttribute("loginCode");
		List<ReservVO> revList=bookService.getMemReserv(memId);
		
		req.setAttribute("revList", revList);
		
		req.getRequestDispatcher("/views/reserv/memRevList.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
