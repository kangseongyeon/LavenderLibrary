package kr.or.ddit.inquiry.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.inquiry.service.IInqCategoryService;
import kr.or.ddit.inquiry.service.IInquiryService;
import kr.or.ddit.inquiry.service.InqCategoryServiceImpl;
import kr.or.ddit.inquiry.service.InquiryServiceImpl;
import kr.or.ddit.vo.InqCategoryVO;
import kr.or.ddit.vo.InquiryVO;

@WebServlet("/inquiry/update.do")
public class UpdateInquiryController extends HttpServlet {
	private IInqCategoryService inqCategoryService = InqCategoryServiceImpl.getInstance();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String inqNo = req.getParameter("inqNo");
		String inqCategoryCode = req.getParameter("inqCategoryCode");

		IInquiryService inquiryService = InquiryServiceImpl.getInstance();
		InquiryVO iv = inquiryService.getInquiry(inqNo);

		List<InqCategoryVO> categoryList = inqCategoryService.getTotalCategories();

		req.setAttribute("iv", iv);
		req.setAttribute("categoryList", categoryList);

		req.getRequestDispatcher("/views/inquiry/inquiryUpdate.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String inqCategoryCode = req.getParameter("inqCategoryCode");
		String inqTitle = req.getParameter("inqTitle");
		String inqContent = req.getParameter("inqContent");
		String memId = req.getParameter("memId");
		String inqNo = req.getParameter("inqNo");

		IInquiryService inquiryService = InquiryServiceImpl.getInstance();

		InquiryVO iv = new InquiryVO(inqCategoryCode, inqTitle, inqContent, memId, inqNo);

		int cnt = inquiryService.modifyInquiry(iv);
		String msg = "";
		if (cnt > 0) {
			msg = "SUCCESS";
		} else {
			msg = "FAIL";
		}
		req.getSession().setAttribute("msg", msg);

		resp.sendRedirect(req.getContextPath() + "/inquiry/list.do");
	}
}
