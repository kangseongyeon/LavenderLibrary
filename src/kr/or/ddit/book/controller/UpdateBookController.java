package kr.or.ddit.book.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.book.service.BookService;
import kr.or.ddit.book.service.IBookService;
import kr.or.ddit.book.vo.BookVO;
import kr.or.ddit.comm.service.AtchFileServiceImpl;
import kr.or.ddit.comm.service.IAtchFileService;
import kr.or.ddit.comm.vo.AtchFileVO;

@MultipartConfig
@WebServlet("/book/update.do")
public class UpdateBookController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String bookId = req.getParameter("bookId");
		IBookService bookService = BookService.getInstance();
		BookVO bv = bookService.getBook(bookId);
		req.setAttribute("bv", bv);

		req.getRequestDispatcher("/views/book/updateForm.jsp").forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String bookId = req.getParameter("bookId");
		String bookName = req.getParameter("bookName");
		String bookWriter = req.getParameter("bookWriter");
		String bookPublisher = req.getParameter("bookPublisher");
		String bookCategory = req.getParameter("bookCategory");

		IBookService bookService = BookService.getInstance();
		IAtchFileService fileService = AtchFileServiceImpl.getInstance();
		BookVO bv = new BookVO(bookName, bookWriter, bookPublisher, bookCategory);
		bv.setBookId(bookId);
		AtchFileVO atchFileVO = fileService.saveAtchFileList(req.getParts());

		if (atchFileVO != null) {
			bv.setAtchFileId(atchFileVO.getAtchFileId());
		}

		int cnt = bookService.updateBook(bv);

		String msg = "";
		if (cnt > 0) {
			// 수정 성공
			msg = "SUCCESS";
		} else {
			// 수정 실패
			msg = "FAIL";
		}

		req.getSession().setAttribute("msg", msg); // 세션에 담기

		resp.sendRedirect(req.getContextPath() + "/book/list.do");

	}

}
