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
@WebServlet("/report/update.do")
public class UpdateReportController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String rptNo = req.getParameter("rptNo");
		
		IReportService reportService = ReportServiceImpl.getInstance();
		
		BookReportVO rv = reportService.detailReport(rptNo);
		
		req.setAttribute("rv", rv);
		
		if (rv.getAtchFileId() > 0) { //첨부파일이 존재 하는 경우....
			IAtchFileService fileService = AtchFileServiceImpl.getInstance();
			
			AtchFileVO atchFileVO = new AtchFileVO();
			atchFileVO.setAtchFileId(rv.getAtchFileId());
			atchFileVO =fileService.getAtchFile(atchFileVO);
			/// atchFileVO는 파라미터 겸 리턴 값을 받아준다, 변수 선언 하나더 안하고 그냥 이렇게 하셨다
			
			req.setAttribute("atchFileVO", atchFileVO);
		}
		
		
		
		
		
		req.getRequestDispatcher("/views/report/updateFormR.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String bookTitle = req.getParameter("bookTitle");
		String rptTitle = req.getParameter("rptTitle");
		String rptContent = req.getParameter("rptContent");
		String rptNo = req.getParameter("rptNo");
		
		long atchFileId = req.getParameter("atchFileId") == null ?-1
				: Long.parseLong(req.getParameter("atchFileId")) ; // 기존 첨부파일ID
		
		IReportService reportService = ReportServiceImpl.getInstance();
		
		IAtchFileService fileService = AtchFileServiceImpl.getInstance();
		//첨부파일 저장하기
		AtchFileVO atchFileVO = fileService.saveAtchFileList(req.getParts());

		
		BookReportVO rv = new BookReportVO(rptNo, rptTitle, rptContent);
		
		
		if(atchFileVO != null) { // 새로 업로드 파일을 선택한 경우
			rv.setAtchFileId(atchFileVO.getAtchFileId());
			
		}else { // 새로운 첨부파일을 선택하지 않은 경우...(기존 첨부파일은 유지하고 싶은경우...) 
			///null인경우
			rv.setAtchFileId(atchFileId);
			
		}
		
		int cnt = reportService.updateReport(rv);
		
		String msg="";
		
		if(cnt > 0) {
			// 회원정보 업데이트 처리 성공...
			msg="SUCCESS";
			
		}else {
			// 회원정보 실패...
			msg="FAIL";
		}
		req.getSession().setAttribute("msg", msg);  
		
		
		resp.sendRedirect(req.getContextPath()+"/report/list.do");
	}
}
