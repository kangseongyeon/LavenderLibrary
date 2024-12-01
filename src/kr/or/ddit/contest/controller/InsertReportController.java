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
import kr.or.ddit.contest.service.IReportService;
import kr.or.ddit.contest.service.ReportServiceImpl;
import kr.or.ddit.contest.vo.BookReportVO;

@MultipartConfig
@WebServlet("/report/insert.do")
public class InsertReportController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/report/insertFormR.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String rptTitle = req.getParameter("rptTitle");
		String rptContent = req.getParameter("rptContent");
		String memId = req.getParameter("memId");
		String bookTitle = req.getParameter("bookTitle");
		
		IReportService reportService = ReportServiceImpl.getInstance();
		
		IAtchFileService fileService = AtchFileServiceImpl.getInstance();
		
		AtchFileVO atchFileVO = fileService.saveAtchFileList(req.getParts());
		
		BookReportVO rv = new BookReportVO(rptTitle, rptContent, memId, bookTitle);
		
		if(atchFileVO != null) { ///atchFileVO == null 이면 파일이없다는거니깐 그건 신경쓰지 말자
			rv.setAtchFileId(atchFileVO.getAtchFileId());
		}
		
		
		int cnt = reportService.insertReport(rv);
		
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
		
		
		
		resp.sendRedirect(req.getContextPath()+"/report/list.do");
		
	}
			
	
	

}
