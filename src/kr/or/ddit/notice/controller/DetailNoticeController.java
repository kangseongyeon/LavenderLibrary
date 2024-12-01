package kr.or.ddit.notice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.notice.service.INoticeService;
import kr.or.ddit.notice.service.NoticeServicempl;
import kr.or.ddit.vo.NoticeVO;

@WebServlet("/notice/detail.do")
public class DetailNoticeController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String noticeNo = req.getParameter("noticeNo");
		
		INoticeService noticeService = NoticeServicempl.getInstance();
		
		NoticeVO nv = noticeService.getNotice(noticeNo);
		
		req.setAttribute("nv", nv);
		
		req.getRequestDispatcher("/views/notice/noticeDetail.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		doGet(req, resp);
	}
}
