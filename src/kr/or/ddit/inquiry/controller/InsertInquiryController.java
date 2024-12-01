package kr.or.ddit.inquiry.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.inquiry.service.IInqCategoryService;
import kr.or.ddit.inquiry.service.IInquiryService;
import kr.or.ddit.inquiry.service.InqCategoryServiceImpl;
import kr.or.ddit.inquiry.service.InquiryServiceImpl;
import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;
import kr.or.ddit.member.vo.MemberVO;
import kr.or.ddit.vo.InqCategoryVO;
import kr.or.ddit.vo.InquiryVO;

@WebServlet("/inquiry/insert.do")
public class InsertInquiryController extends HttpServlet {
    private IInqCategoryService inqCategoryService = InqCategoryServiceImpl.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<InqCategoryVO> categoryList = inqCategoryService.getTotalCategories();
        req.setAttribute("categoryList", categoryList);
        req.getRequestDispatcher("/views/inquiry/inquiryInsert.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String inqCategoryCode = req.getParameter("inqCategoryCode");
        String inqTitle = req.getParameter("inqTitle");
        String inqContent = req.getParameter("inqContent");
        
        HttpSession session = req.getSession();
        MemberVO mv= new MemberVO();
        IMemberService memService = MemberServiceImpl.getInstance();
        String memId = (String) session.getAttribute("memId");

        if (inqCategoryCode == null || inqCategoryCode.isEmpty()) {
            req.getSession().setAttribute("msg", "문의 분류 코드를 선택해주세요.");
            resp.sendRedirect(req.getContextPath() + "/inquiry/insert.do");
            return;
        }

        IInquiryService inquiryService = InquiryServiceImpl.getInstance();
        mv = memService.memInfo(memId);
        InquiryVO iv = new InquiryVO(inqCategoryCode, inqTitle, inqContent, memId);

        int cnt = inquiryService.registerInquiry(iv);

        String msg = (cnt > 0) ? "SUCCESS" : "FAIL";
        req.getSession().setAttribute("msg", msg);
        resp.sendRedirect(req.getContextPath() + "/inquiry/list.do");
    }

}