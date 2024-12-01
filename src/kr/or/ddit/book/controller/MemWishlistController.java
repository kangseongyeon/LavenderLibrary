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
import kr.or.ddit.book.vo.WishlistVO;

@WebServlet("/wishlist/memWishlist.do")
public class MemWishlistController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		IBookService bookService=BookService.getInstance();
		String memId=(String)req.getSession().getAttribute("loginCode");
		List<WishlistVO> wishlist=bookService.getMemWishlist(memId);
		
		req.setAttribute("wishlist", wishlist);
		
		req.getRequestDispatcher("/views/wishlist/memWishlist.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
