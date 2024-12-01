package kr.or.ddit.admin.event.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.event.service.EventServiceImpl;
import kr.or.ddit.event.service.IEventService;
import kr.or.ddit.vo.EventVO;

@WebServlet("/adminEvent/list.do")
public class AdminPostAllList extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		IEventService eventService = EventServiceImpl.getInsetance();
		List<EventVO> eventList = eventService.getTotalEvent();
		
		req.setAttribute("eventList", eventList);
		
		req.getRequestDispatcher("/views/adminEvent/list.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
	}
	
	
	
}
