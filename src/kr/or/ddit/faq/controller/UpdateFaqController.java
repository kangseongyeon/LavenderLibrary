package kr.or.ddit.faq.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.bookVideo.service.BookVideoServiceImpl;
import kr.or.ddit.bookVideo.service.IBookVideoService;
import kr.or.ddit.faq.service.FaqServiceImpl;
import kr.or.ddit.faq.service.IFaqService;
import kr.or.ddit.vo.BookVideoVO;
import kr.or.ddit.vo.FaqVO;

@WebServlet("/faq/update.do")
public class UpdateFaqController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String faqNo = req.getParameter("faqNo");
		
		IFaqService faqService = FaqServiceImpl.getInstance();
		
		FaqVO fv = faqService.getFaq(faqNo);
		
		req.setAttribute("fv", fv);
		
		req.getRequestDispatcher("/views/faq/faqUpdate.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String faqNo = req.getParameter("faqNo");
		String faqQuestion = req.getParameter("faqQuestion");
		String faqAnswer = req.getParameter("faqAnswer");
		
		IFaqService faqService = FaqServiceImpl.getInstance();
		
		FaqVO fv = new FaqVO(faqNo, faqQuestion, faqAnswer);
		
		int cnt = faqService.modifyFaq(fv);
		String msg = "";
		if (cnt > 0) {
			msg = "SUCCESS";
		} else {
			msg = "FAIL";
		}
		req.getSession().setAttribute("msg", msg);
		
		resp.sendRedirect(req.getContextPath() + "/faq/list.do");
	}
}
