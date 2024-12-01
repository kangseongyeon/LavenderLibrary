package kr.or.ddit.contest.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.contest.service.IOneSentenceService;
import kr.or.ddit.contest.service.IReportService;
import kr.or.ddit.contest.service.OneSentenceServiceImpl;
import kr.or.ddit.contest.service.ReportServiceImpl;
import kr.or.ddit.contest.vo.BookReportVO;
import kr.or.ddit.contest.vo.OneSentenceVO;

@MultipartConfig
@WebServlet("/sentence/search.do")
public class SearchSentenceController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String selValue = req.getParameter("selValue");
		String searchWord = req.getParameter("searchWord");
		IOneSentenceService sentenceService = OneSentenceServiceImpl.getInstance();
		
		List<OneSentenceVO> sentenceList = null;
		
		if(selValue.equals("senTitle")) {
			
			sentenceList = sentenceService.searchTitleSentence(searchWord);
			req.setAttribute("sentenceList", sentenceList);
			req.getRequestDispatcher("/views/sentence/searchS.jsp").forward(req, resp);
		}
		
		if (selValue.equals("senContent")) {
			sentenceList = sentenceService.searchContentSentence(searchWord);
			req.setAttribute("sentenceList", sentenceList);
			req.getRequestDispatcher("/views/sentence/searchS.jsp").forward(req, resp);
		}
		
		if (selValue.equals("memId")) {
			sentenceList = sentenceService.searchMemSentense(searchWord);
			req.setAttribute("sentenceList", sentenceList);
			req.getRequestDispatcher("/views/sentence/searchS.jsp").forward(req, resp);
		}
		
		if (selValue.equals("bookTitle")) {
			sentenceList = sentenceService.searchBookSentense(searchWord);
			req.setAttribute("sentenceList", sentenceList);
			req.getRequestDispatcher("/views/sentence/searchS.jsp").forward(req, resp);
		}
		
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
