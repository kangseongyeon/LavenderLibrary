package kr.or.ddit.contest.controller;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.comm.service.AtchFileServiceImpl;
import kr.or.ddit.comm.service.IAtchFileService;
import kr.or.ddit.comm.vo.AtchFileVO;
import kr.or.ddit.contest.dao.IOneSentenceDao;
import kr.or.ddit.contest.service.IOneSentenceService;
import kr.or.ddit.contest.service.IReportService;
import kr.or.ddit.contest.service.OneSentenceServiceImpl;
import kr.or.ddit.contest.service.ReportServiceImpl;
import kr.or.ddit.contest.vo.BookReportVO;
import kr.or.ddit.contest.vo.OneSentenceVO;

@MultipartConfig
@WebServlet("/sentence/insert.do")
public class InsertSentenceController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/sentence/insertFormS.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String senTitle = req.getParameter("senTitle");
		String senContent = req.getParameter("senContent");
		String memId = req.getParameter("memId");
		String bookTitle = req.getParameter("bookTitle");
		
		IOneSentenceService sentenceService = OneSentenceServiceImpl.getInstance();
		
		OneSentenceVO ov= new OneSentenceVO(senTitle, senContent, memId, bookTitle);
	
		
		int cnt = sentenceService.insertSentence(ov);
		
		String msg="";
		
		if(cnt > 0) {
			// 회원 등록 작업 성공...
			msg="SUCCESS";
			
		}else {
			// 회원 등록 작업 실패...
			msg="FAIL";
		}
//		req.setAttribute("msg", msg); ///alert창에 띄울때 뭔지 알아야 하니깐 저장
		///redirect 할때 다른 request가 돼서 창이 안뜬다
		
		req.getSession().setAttribute("msg", msg); ///alert창에 띄울때 뭔지 알아야 하니깐 저장
		
		
		
		resp.sendRedirect(req.getContextPath()+"/sentence/list.do");
		
	}
			
	
	

}
