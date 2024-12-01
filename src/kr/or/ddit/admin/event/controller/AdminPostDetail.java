package kr.or.ddit.admin.event.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.event.service.EventServiceImpl;
import kr.or.ddit.event.service.IEventService;
import kr.or.ddit.vo.EventVO;

@WebServlet("/adminEvent/eventDetail.do")
public class AdminPostDetail extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String eventNo = req.getParameter("eventNo");
		IEventService eventService = EventServiceImpl.getInsetance();
		EventVO ev = eventService.getEvent(eventNo);
		System.out.println(ev);
		req.setAttribute("ev", ev);
		
		req.getRequestDispatcher("/views/adminEvent/adminDetail.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
		
		
	}
}
