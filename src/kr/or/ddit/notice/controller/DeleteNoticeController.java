package kr.or.ddit.notice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.notice.service.INoticeService;
import kr.or.ddit.notice.service.NoticeServicempl;

@WebServlet("/notice/delete.do")
public class DeleteNoticeController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String noticeNo = req.getParameter("noticeNo");
		
		INoticeService noticeService = NoticeServicempl.getInstance();
		
		int cnt = noticeService.removeNotice(noticeNo);
		
		String msg="";
		if (cnt > 0) {
			msg="SUCCESS";
		} else {
			msg="FAIL";
		}
		
		req.getSession().setAttribute("msg", msg); //세션에 담기
		
		
		resp.sendRedirect(req.getContextPath() + "/notice/list.do");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
