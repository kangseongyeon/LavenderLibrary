package kr.or.ddit.inquiry.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.inquiry.service.IInquiryService;
import kr.or.ddit.inquiry.service.InquiryServiceImpl;

@WebServlet("/inquiry/delete.do")
public class DeleteInquiryController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String inqNo = req.getParameter("inqNo");
		
		IInquiryService inquiryService = InquiryServiceImpl.getInstance();
		
		inquiryService.removeInquiry(inqNo);
		
		int cnt = inquiryService.removeInquiry(inqNo);
		
		String msg="";
		if(cnt>0) {
			//삭제 성공
			msg="SUCCESS";
		}else {
			//삭제 실패
			msg="FAIL";
		}
		
		req.getSession().setAttribute("msg", msg);
		
		resp.sendRedirect(req.getContextPath() + "/inquiry/list.do");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
