package kr.or.ddit.inquiry.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.answer.service.AnswerServiceImpl;
import kr.or.ddit.answer.service.IAnswerService;
import kr.or.ddit.inquiry.service.IInquiryService;
import kr.or.ddit.inquiry.service.InquiryServiceImpl;
import kr.or.ddit.vo.AnswerVO;
import kr.or.ddit.vo.InquiryVO;

@WebServlet("/inquiry/detail.do")
public class DetailInquiryController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String inqNo = req.getParameter("inqNo");
        
        IInquiryService inquiryService = InquiryServiceImpl.getInstance();
        IAnswerService answerService = AnswerServiceImpl.getInstance();
        
        InquiryVO iv = inquiryService.getInquiry(inqNo);
        List<AnswerVO> answers = answerService.getAnswersByInquiry(inqNo);
        
        req.setAttribute("iv", iv);
        req.setAttribute("answers", answers);
		
        req.getRequestDispatcher("/views/inquiry/inquiryDetail.jsp").forward(req, resp);
        
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}

