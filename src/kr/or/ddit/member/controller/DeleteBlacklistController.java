package kr.or.ddit.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.member.service.IMemberService;
import kr.or.ddit.member.service.MemberServiceImpl;

@WebServlet("/admin/delBlack.do")
public class DeleteBlacklistController extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String memId=req.getParameter("memId");
		IMemberService memService=MemberServiceImpl.getInstance();
		int cnt=memService.deleteBlacklist(memId);
		memService.resetMemWarn(memId);
		
		String msg="";
		if(cnt>0) {
			//수정 성공
			msg="SUCCESS";
		}else {
			//수정 실패
			msg="FAIL";
		}
		
		req.getSession().setAttribute("msg", msg); //세션에 담기
		
		resp.sendRedirect(req.getContextPath()+"/main/listBlack.do");
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
