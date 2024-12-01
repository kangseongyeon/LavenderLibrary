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

@WebServlet("/notice/update.do")
public class UpdateNoticeController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String noticeNo = req.getParameter("noticeNo");
		
		INoticeService noticeService = NoticeServicempl.getInstance();
		
		NoticeVO nv = noticeService.getNotice(noticeNo);
		
		req.setAttribute("nv", nv);
		
		req.getRequestDispatcher("/views/notice/noticeUpdate.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String noticeNo = req.getParameter("noticeNo");
		String noticeTitle = req.getParameter("noticeTitle");
		String noticeContent = req.getParameter("noticeContent");
		
		INoticeService noticeService = NoticeServicempl.getInstance();
		
		NoticeVO nv = new NoticeVO(noticeNo, noticeTitle, noticeContent);
		int cnt = noticeService.modifyNotice(nv);
		String msg = "";
		if (cnt > 0) {
			msg = "SUCCESS";
		} else {
			msg = "FAIL";
		}
		req.getSession().setAttribute("msg", msg);

		resp.sendRedirect(req.getContextPath() + "/notice/list.do");
	}
	
}
