package kr.or.ddit.faq.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.faq.service.FaqServiceImpl;
import kr.or.ddit.faq.service.IFaqService;
import kr.or.ddit.vo.FaqVO;

@WebServlet("/faq/list.do")
public class ListFaqController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		IFaqService faqService = FaqServiceImpl.getInstance();
		
		List<FaqVO> faqList = faqService.getTotalFaq();
		
		req.setAttribute("faqList", faqList);
		
		req.setAttribute("active", "faqList");
		req.getRequestDispatcher("/views/faq/faqList.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
