package kr.or.ddit.inquiry.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.book.service.BookService;
import kr.or.ddit.book.service.IBookService;
import kr.or.ddit.inquiry.service.IInquiryService;
import kr.or.ddit.inquiry.service.InquiryServiceImpl;
import kr.or.ddit.vo.InquiryVO;

@WebServlet("/inquiry/search.do")
public class SearchInquiryController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String searchOption = req.getParameter("searchOption");
        String searchKeyword = req.getParameter("searchKeyword");
        
        InquiryVO iv = new InquiryVO(); 
        if ("inqCategoryCode".equals(searchOption)) {
        	iv.setInqCategoryCode(searchKeyword);
        } 
        if ("memId".equals(searchOption)) {
            iv.setMemId(searchKeyword);
        }
        if ("inqTitle".equals(searchOption)) {
        	iv.setInqTitle(searchKeyword);
        }
        
        IInquiryService inquiryService = InquiryServiceImpl.getInstance();
        List<InquiryVO> inquiryList = inquiryService.searchInquiry(iv);
        
        req.setAttribute("inquiryList", inquiryList);
        
        req.getRequestDispatcher("/views/inquiry/inquirySearch.jsp").forward(req, resp);
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
