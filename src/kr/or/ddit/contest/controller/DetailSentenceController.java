package kr.or.ddit.contest.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.contest.service.IOneSentenceService;
import kr.or.ddit.contest.service.OneSentenceServiceImpl;
import kr.or.ddit.contest.vo.OneSentenceVO;

@WebServlet("/sentence/detail.do")
public class DetailSentenceController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		String senNo = req.getParameter("senNo");  
		
		IOneSentenceService sentenceService = OneSentenceServiceImpl.getInstance();

		OneSentenceVO ov = sentenceService.detailSentence(senNo);
		
		req.setAttribute("ov", ov);
		
		
		req.getRequestDispatcher("/views/sentence/detailS.jsp").forward(req, resp);
	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
}
