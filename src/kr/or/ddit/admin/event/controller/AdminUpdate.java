package kr.or.ddit.admin.event.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.comm.service.AtchFileServiceImpl;
import kr.or.ddit.comm.service.IAtchFileService;
import kr.or.ddit.comm.vo.AtchFileVO;
import kr.or.ddit.event.service.EventServiceImpl;
import kr.or.ddit.event.service.IEventService;
import kr.or.ddit.vo.EventVO;


@MultipartConfig
@WebServlet("/adminEvent/update.do")
public class AdminUpdate extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String eventNo = req.getParameter("eventNo");
		IEventService eventService = EventServiceImpl.getInsetance();
		EventVO ev = eventService.getEvent(eventNo);
		req.setAttribute("ev", ev);
		System.out.println(ev);
		req.getRequestDispatcher("/views/adminEvent/update.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String eventNo = req.getParameter("eventNo");
		String eventName = req.getParameter("eventName");
		String eventDateStr = req.getParameter("eventDateStr"); 
		String eventDateEnd = req.getParameter("eventDateEnd"); 
		String eventPeople = req.getParameter("eventPeople"); 
		String eventPlace = req.getParameter("eventPlace"); 
		String eventRegDateStr = req.getParameter("eventRegDateStr"); 
		String eventRegDateEnd = req.getParameter("eventRegDateEnd"); 
		String eventContent = req.getParameter("eventContent"); 
		String admId = "관리자";
		
		IEventService eventService = EventServiceImpl.getInsetance();
		IAtchFileService fileService = AtchFileServiceImpl.getInstance();
		
		EventVO ev = new EventVO(eventNo,eventName, LocalDate.parse(eventDateStr, DateTimeFormatter.ISO_DATE), LocalDate.parse(eventDateEnd, DateTimeFormatter.ISO_DATE),eventPeople ,eventPlace,LocalDate.parse(eventRegDateStr, DateTimeFormatter.ISO_DATE),LocalDate.parse(eventRegDateEnd, DateTimeFormatter.ISO_DATE),eventContent,admId);
		AtchFileVO atchFileVO = fileService.saveAtchFileList(req.getParts());

		if (atchFileVO != null) {
			ev.setAtchFileId(atchFileVO.getAtchFileId());
		}
		
		int cnt = eventService.editEvent(ev);
		String msg = "";
		if(cnt > 0) {
			msg = "SUCCESS";
		} else {
			msg ="FAIL";
		}
		req.getSession().setAttribute("msg", msg);
		resp.sendRedirect(req.getContextPath()+"/views/adminEvent/calender.jsp");
		}
	
}
