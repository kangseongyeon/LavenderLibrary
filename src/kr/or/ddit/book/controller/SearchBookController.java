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
import kr.or.ddit.book.vo.BookVO;

@WebServlet("/book/search.do")
public class SearchBookController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String searchOption = req.getParameter("searchOption");
        String searchKeyword = req.getParameter("searchKeyword");
        
        BookVO bv = new BookVO();
        if ("bookAll".equals(searchOption)) {
            bv.setBookName(searchKeyword);
            bv.setBookWriter(searchKeyword);
        } else if ("bookName".equals(searchOption)) {
            bv.setBookName(searchKeyword);
        }
        
        IBookService bookService = BookService.getInstance();
        List<BookVO> bookList = bookService.searchBook(bv);
        req.setAttribute("bookList", bookList);
        
        req.getRequestDispatcher("/views/book/search.jsp").forward(req, resp);
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
