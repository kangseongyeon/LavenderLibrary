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
import kr.or.ddit.contest.service.IReportService;
import kr.or.ddit.contest.service.ReportServiceImpl;
import kr.or.ddit.contest.vo.BookReportVO;

@WebServlet("/report/detail.do")
public class DetailReportController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String rptNo = req.getParameter("rptNo");  
		
		IReportService reportService = ReportServiceImpl.getInstance();
		
		BookReportVO rv = reportService.detailReport(rptNo);
		
		req.setAttribute("rv", rv);
		
		///혹시 첨부파일이 있다면 가져오고 싶다
		if (rv.getAtchFileId() > 0) { //첨부파일이 존재 하는 경우....
			IAtchFileService fileService = AtchFileServiceImpl.getInstance();
			
			AtchFileVO atchFileVO = new AtchFileVO();
			atchFileVO.setAtchFileId(rv.getAtchFileId());
			atchFileVO =fileService.getAtchFile(atchFileVO);
			/// atchFileVO는 파라미터 겸 리턴 값을 받아준다, 변수 선언 하나더 안하고 그냥 이렇게 하셨다
			
			req.setAttribute("atchFileVO", atchFileVO);
		}
		
		
		
		req.getRequestDispatcher("/views/report/detailR.jsp").forward(req, resp);
	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
	
}
