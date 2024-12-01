package kr.or.ddit.contest.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.contest.service.DebateServiceImpl;
import kr.or.ddit.contest.service.IDebateService;
import kr.or.ddit.contest.service.IOneSentenceService;
import kr.or.ddit.contest.service.OneSentenceServiceImpl;
import kr.or.ddit.contest.vo.DebateVO;
import kr.or.ddit.contest.vo.OneSentenceVO;

@MultipartConfig
@WebServlet("/debate/update.do")
public class UpdateDebateController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String debateNo = req.getParameter("debateNo");
		
		IDebateService debateService = DebateServiceImpl.getInstance();
		
		DebateVO dv = debateService.detailDebate(debateNo);
		
		
		req.setAttribute("dv", dv);
		
		
		req.getRequestDispatcher("/views/debate/updateFormD.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		
		String bookTitle = req.getParameter("bookTitle");
		String debateTopic = req.getParameter("debateTopic");
		String debateContent = req.getParameter("debateContent");
		String debateNo = req.getParameter("debateNo");
		

		IDebateService debateService = DebateServiceImpl.getInstance();
		
		DebateVO dv = new DebateVO(debateNo, bookTitle, debateTopic, debateContent);
		
	
		
		int cnt = debateService.updateDebate(dv);
		
		String msg="";
		
		if(cnt > 0) {
			// 회원정보 업데이트 처리 성공...
			msg="SUCCESS";
			
		}else {
			// 회원정보 실패...
			msg="FAIL";
		}
		req.getSession().setAttribute("msg", msg);  
		
		
		resp.sendRedirect(req.getContextPath()+"/debate/list.do");
	}
}
