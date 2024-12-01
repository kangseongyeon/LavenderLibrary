package kr.or.ddit.book.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.book.service.BookService;
import kr.or.ddit.book.service.IBookService;
import kr.or.ddit.book.vo.BookVO;
import kr.or.ddit.book.vo.RentalVO;
import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.member.vo.MemberVO;

@MultipartConfig
@WebServlet("/rental/insert.do")
public class InsertRentalController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		IBookService bookService=BookService.getInstance();
		IMemberService memService=MemberServiceImpl.getInstance();
		
		List<BookVO> bookList=bookService.getAllBook();
		List<MemberVO> memList=memService.getAllMember();
		
		req.setAttribute("bookList", bookList);
		req.setAttribute("memList", memList);
		
		
		req.getRequestDispatcher("/views/rental/insertRental.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String bookId = req.getParameter("bookId");
		String memId = req.getParameter("memId");
		
		IBookService bookService=BookService.getInstance();
		RentalVO rv=new RentalVO();
		rv.setBookId(bookId);
		rv.setMemId(memId);
		
		int cnt=bookService.insertRental(rv);
		
		String msg = "";
        if (cnt > 0) {
            // 등록 성공
            msg = "SUCCESS";
        } else {
            // 등록 실패
            msg = "FAIL";
        }
        req.getSession().setAttribute("msg", msg); // 세션에 담기
        
        resp.sendRedirect(req.getContextPath() + "/rental/list.do");
	}
}
