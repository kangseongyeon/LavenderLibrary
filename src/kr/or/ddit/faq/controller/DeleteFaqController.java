package kr.or.ddit.faq.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.faq.service.FaqServiceImpl;
import kr.or.ddit.faq.service.IFaqService;

@WebServlet("/faq/delete.do")
public class DeleteFaqController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String faqNo = req.getParameter("faqNo");
		
		IFaqService faqService = FaqServiceImpl.getInstance();
		
		faqService.removeFaq(faqNo);
		
		int cnt=faqService.removeFaq(faqNo);
		
		String msg="";
		if(cnt>0) {
			msg="SUCCESS";
		}else {
			msg="FAIL";
		}
		
		req.getSession().setAttribute("msg", msg);
		
		resp.sendRedirect(req.getContextPath() + "/faq/list.do");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
	
}
