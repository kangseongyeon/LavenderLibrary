package kr.or.ddit.notice.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.notice.service.INoticeService;
import kr.or.ddit.notice.service.NoticeServicempl;
import kr.or.ddit.vo.NewsVO;
import kr.or.ddit.vo.NoticeVO;

@MultipartConfig
@WebServlet("/notice/search.do")
public class SearchNoticeController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String searchKeyword = req.getParameter("searchKeyword");
		
		INoticeService noticeService = NoticeServicempl.getInstance();
		NoticeVO nv = new NoticeVO();
		nv.setNoticeTitle(searchKeyword);
		
		List<NoticeVO> noticeList = noticeService.searchNotice(nv);
		req.setAttribute("noticeList", noticeList);
		req.getRequestDispatcher("/views/notice/noticeSearch.jsp").forward(req, resp);

	}
		
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
