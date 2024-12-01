package kr.or.ddit.book.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.book.service.BookService;
import kr.or.ddit.book.service.IBookService;
import kr.or.ddit.book.vo.WishlistVO;

@WebServlet("/wishlist/insert.do")
public class InsertWishlistController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int cnt=0;
		String bookId= req.getParameter("bookId");
		String memId=(String)req.getSession().getAttribute("loginCode");
		IBookService bookService= BookService.getInstance();
		
		WishlistVO wv=new WishlistVO();
		wv.setBookId(bookId);
		wv.setMemId(memId);
		WishlistVO wv2=new WishlistVO();
		wv2=bookService.getWishlist(wv);
		if(wv2==null) {
			cnt=bookService.insertWishlist(wv);
		}
		System.out.println(cnt);
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
