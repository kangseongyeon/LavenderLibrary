package kr.or.ddit.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;

@WebServlet("/member/memberWithDraw.do")
public class DeleteMemberContoller extends HttpServlet{

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
		String memId = (String) session.getAttribute("memId");
//		System.out.println(memId);
//        String memId = req.getParameter("memId");
        System.out.println(memId);
		IMemberService memService=MemberServiceImpl.getInstance();
		int cnt = memService.deleteMember(memId);
		
		String msg="";
		if(cnt>0) {
			//수정 성공
			msg="SUCCESS";
		}else {
			//수정 실패
			msg="FAIL";
		}
		
		req.getSession().setAttribute("msg", msg); //세션에 담기
		req.getSession().setAttribute("deletMem", memId); //세션에 담기
		
//		resp.sendRedirect(req.getContextPath()+"/main.do");
		resp.sendRedirect(req.getContextPath()+"/Logout.do");

		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
	
	
}
