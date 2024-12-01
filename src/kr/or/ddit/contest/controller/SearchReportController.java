package kr.or.ddit.contest.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.contest.service.IReportService;
import kr.or.ddit.contest.service.ReportServiceImpl;
import kr.or.ddit.contest.vo.BookReportVO;

@MultipartConfig
@WebServlet("/report/search.do")
public class SearchReportController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String selValue = req.getParameter("selValue");
		String searchWord = req.getParameter("searchWord");
		IReportService reportService = ReportServiceImpl.getInstance();
		
		List<BookReportVO> reportList = null;
		
		if(selValue.equals("rptTitle")) {
			reportList = reportService.searchTitleReport(searchWord);
			req.setAttribute("reportList", reportList);
			req.getRequestDispatcher("/views/report/searchR.jsp").forward(req, resp);
		}
		
		if (selValue.equals("rptContent")) {
			reportList = reportService.searchContentReport(searchWord);
			req.setAttribute("reportList", reportList);
			req.getRequestDispatcher("/views/report/searchR.jsp").forward(req, resp);
		}
		
		if (selValue.equals("memId")) {
			reportList = reportService.searchMemReport(searchWord);
			req.setAttribute("reportList", reportList);
			req.getRequestDispatcher("/views/report/searchR.jsp").forward(req, resp);
		}
		
		if (selValue.equals("bookTitle")) {
			reportList = reportService.searchBookReport(searchWord);
			req.setAttribute("reportList", reportList);
			req.getRequestDispatcher("/views/report/searchR.jsp").forward(req, resp);
		}
		
		
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
