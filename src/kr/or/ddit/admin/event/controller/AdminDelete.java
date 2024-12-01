package kr.or.ddit.admin.event.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.event.service.EventServiceImpl;
import kr.or.ddit.event.service.IEventService;

@WebServlet("/adminEvent/delete.do")
public class AdminDelete extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String eventName = req.getParameter("eventName");
		IEventService eventService = EventServiceImpl.getInsetance();
		int cnt = eventService.removeEvent(eventName);
		
		String msg ="";
		
		if(cnt>0) {
			msg = "SUCCESS";
		}else {
			//회원정보 삭제처리 실패..
			msg = "FAIL";
		}
		
		req.getSession().setAttribute("msg", msg);
		resp.sendRedirect(req.getContextPath()+"/views/adminEvent/calender.jsp");
	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
}
