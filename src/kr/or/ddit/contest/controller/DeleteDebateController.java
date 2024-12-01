package kr.or.ddit.contest.controller;

import java.io.IOException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.contest.service.DebateServiceImpl;
import kr.or.ddit.contest.service.IDebateService;
import kr.or.ddit.contest.service.IOneSentenceService;
import kr.or.ddit.contest.service.IReportService;
import kr.or.ddit.contest.service.OneSentenceServiceImpl;
import kr.or.ddit.contest.service.ReportServiceImpl;

@WebServlet("/debate/delete.do")
public class DeleteDebateController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		String debateNo = req.getParameter("debateNo");
		
		IDebateService debateService = DebateServiceImpl.getInstance();
		
		int cnt = debateService.deleteDebate(debateNo);
		

		///메세지 담기 위한것
		String msg="";
		
		if(cnt > 0) {
			// 회원정보 삭제 처리 성공...
			msg="SUCCESS";
			///SUCCESS이면 성공이라는 alert창을 띄우고 싶다
			
		}else {
			// 회원정보 삭제 처리 실패...
			msg="FAIL";
		}
		
		req.getSession().setAttribute("msg", msg); ///alert창에 띄울때 뭔지 알아야 하니깐 저장

		
		
		resp.sendRedirect(req.getContextPath()+"/debate/list.do");
	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
