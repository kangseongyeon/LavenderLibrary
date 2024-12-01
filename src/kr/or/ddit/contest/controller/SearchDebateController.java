package kr.or.ddit.contest.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
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
import kr.or.ddit.contest.vo.BookReportVO;
import kr.or.ddit.contest.vo.DebateVO;
import kr.or.ddit.contest.vo.OneSentenceVO;

@MultipartConfig
@WebServlet("/debate/search.do")
public class SearchDebateController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String selValue = req.getParameter("selValue");
		String searchWord = req.getParameter("searchWord");
		IDebateService debateService = DebateServiceImpl.getInstance();
		
		List<DebateVO> debateList = null;
		
		if(selValue.equals("debateTopic")) {
			
			debateList = debateService.searchTopicDebate(searchWord);
			req.setAttribute("debateList", debateList);
			req.getRequestDispatcher("/views/debate/searchD.jsp").forward(req, resp);
		}
		
		if (selValue.equals("debateContent")) {
			debateList = debateService.searchContentDebate(searchWord);
			req.setAttribute("debateList", debateList);
			req.getRequestDispatcher("/views/debate/searchD.jsp").forward(req, resp);
		}
		
		if (selValue.equals("bookTitle")) {
			debateList = debateService.searchBookDebate(searchWord);
			req.setAttribute("debateList", debateList);
			req.getRequestDispatcher("/views/debate/searchD.jsp").forward(req, resp);
		}
		
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
