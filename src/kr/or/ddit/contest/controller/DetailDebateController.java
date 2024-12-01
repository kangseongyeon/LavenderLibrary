package kr.or.ddit.contest.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import kr.or.ddit.comm.service.AtchFileServiceImpl;
import kr.or.ddit.comm.service.IAtchFileService;
import kr.or.ddit.comm.vo.AtchFileVO;
import kr.or.ddit.contest.service.DebateServiceImpl;
import kr.or.ddit.contest.service.IDebateService;
import kr.or.ddit.contest.service.IOneSentenceService;
import kr.or.ddit.contest.service.IReportService;
import kr.or.ddit.contest.service.OneSentenceServiceImpl;
import kr.or.ddit.contest.service.ReportServiceImpl;
import kr.or.ddit.contest.vo.BookReportVO;
import kr.or.ddit.contest.vo.DebateVO;
import kr.or.ddit.contest.vo.OneSentenceVO;

@WebServlet("/debate/detail.do")
public class DetailDebateController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		
		String debateNo = req.getParameter("debateNo");  
		
		IDebateService debateService = DebateServiceImpl.getInstance();

		DebateVO dv = debateService.detailDebate(debateNo);
		
		req.setAttribute("dv", dv);
		
		req.getRequestDispatcher("/views/debate/detailD.jsp").forward(req, resp);
	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
}
