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

@WebServlet("/adminEvent/search.do")
public class SearchEventController extends HttpServlet{

		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			String searchOption = req.getParameter("searchOption");
			String keyWord = req.getParameter("keyWord");
			
			
			EventVO ev = new EventVO();
			
			if("eventNameType".equals(searchOption)) {
				ev.setEventName(keyWord);
				ev.setEventType(keyWord);
			} else if("eventName".equals(searchOption)) {
				ev.setEventName(keyWord);
			}
			
			IEventService eventService = EventServiceImpl.getInsetance();
			List<EventVO> eventList = eventService.searchEvent(ev);
			req.setAttribute("eventList", eventList);
			req.getRequestDispatcher("/views/adminEvent/eventSearch.jsp").forward(req, resp);
		
		}
		
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, resp);
		}
		
		
}
