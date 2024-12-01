package kr.or.ddit.contest.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.contest.service.IOneSentenceService;
import kr.or.ddit.contest.service.OneSentenceServiceImpl;
import kr.or.ddit.contest.vo.OneSentenceVO;

@MultipartConfig
@WebServlet("/sentence/update.do")
public class UpdateSentenceController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String senNo = req.getParameter("senNo");
		
		IOneSentenceService sentenceService = OneSentenceServiceImpl.getInstance();
		
		OneSentenceVO ov = sentenceService.detailSentence(senNo);
		
		
		req.setAttribute("ov", ov);
		
		
		req.getRequestDispatcher("/views/sentence/updateFormS.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String senTitle = req.getParameter("senTitle");
		String senContent = req.getParameter("senContent");
		String senNo = req.getParameter("senNo");
		
		IOneSentenceService sentenceService = OneSentenceServiceImpl.getInstance();
		
		OneSentenceVO ov = new OneSentenceVO(senNo, senTitle, senContent);
		
	
		
		int cnt = sentenceService.updateSentence(ov);
		
		String msg="";
		
		if(cnt > 0) {
			// 회원정보 업데이트 처리 성공...
			msg="SUCCESS";
			
		}else {
			// 회원정보 실패...
			msg="FAIL";
		}
		req.getSession().setAttribute("msg", msg);  
		
		
		resp.sendRedirect(req.getContextPath()+"/sentence/list.do");
	}
}
