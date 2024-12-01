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
@WebServlet("/book/insert.do")
public class InsertBookController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	System.out.println("실행");
        req.getRequestDispatcher("/views/book/insertForm.jsp").forward(req, resp);
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String bookName = req.getParameter("bookName");
        String bookWriter = req.getParameter("bookWriter");
        String bookPublisher = req.getParameter("bookPublisher");
        String bookCategory = req.getParameter("bookCategory");

        
        IBookService bookService = BookService.getInstance();
        IAtchFileService fileService = AtchFileServiceImpl.getInstance();
        BookVO bv = new BookVO(bookName, bookWriter, bookPublisher, bookCategory);
        
        AtchFileVO atchFileVO=fileService.saveAtchFileList(req.getParts());
        
        if(atchFileVO!=null) {
			bv.setAtchFileId(atchFileVO.getAtchFileId());
		}
        
        int cnt=bookService.insertBook(bv);
        
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
}
