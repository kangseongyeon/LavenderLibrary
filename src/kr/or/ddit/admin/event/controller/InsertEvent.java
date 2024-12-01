package kr.or.ddit.admin.event.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
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

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@MultipartConfig
@WebServlet("/adminEvent/insert.do")
public class InsertEvent extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.getRequestDispatcher("/views/adminEvent/adminInsertForm.jsp").forward(req, resp);
	
	}	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 값이 들어갔는지 확인하기 용
		Enumeration params = req.getParameterNames();
		
		while(params.hasMoreElements()) {
			String name = (String) params.nextElement();
			System.out.println(name+" : "+req.getParameter(name));
			
		}
		
		String eventType = req.getParameter("eventType");
		String eventName = req.getParameter("eventName");
		String eventDateStr = req.getParameter("eventDateStr");
		String eventDateEnd = req.getParameter("eventDateEnd");
		String eventPeople = req.getParameter("eventPeople");
		String eventPlace = req.getParameter("eventPlace");
		String eventRegDateStr = req.getParameter("eventRegDateStr");
		String eventRegDateEnd = req.getParameter("eventRegDateEnd");
		String eventContent = req.getParameter("eventContent");
		String adminId = "관리자";
		System.out.println(eventType);
		
	
		IEventService eventService = EventServiceImpl.getInsetance();
		IAtchFileService fileService = AtchFileServiceImpl.getInstance();
//		EventVO ev = new EventVO(eventType , eventName, LocalDate.parse(eventDateStr, DateTimeFormatter.ISO_DATE), LocalDate.parse(eventDateEnd, DateTimeFormatter.ISO_DATE),eventPeople ,eventPlace,LocalDate.parse(eventRegDateStr, DateTimeFormatter.ISO_DATE),LocalDate.parse(eventRegDateEnd, DateTimeFormatter.ISO_DATE),eventContent,admId);
		EventVO ev=new EventVO();
		ev.setEventName(eventName); 
		ev.setEventType(eventType);
		ev.setEventDateStr(LocalDate.parse(eventDateStr, DateTimeFormatter.ISO_DATE));
		ev.setEventDateEnd(LocalDate.parse(eventDateEnd, DateTimeFormatter.ISO_DATE));
		ev.setEventPeople(eventPeople);
		ev.setEventPlace(eventPlace);
		ev.setEventRegDateStr(LocalDate.parse(eventRegDateStr, DateTimeFormatter.ISO_DATE));
		ev.setEventRegDateEnd(LocalDate.parse(eventRegDateEnd, DateTimeFormatter.ISO_DATE));
		ev.setEventContent(eventContent);
		ev.setAdminId(adminId);
		
		
		AtchFileVO atchFileVO=fileService.saveAtchFileList(req.getParts());
		if(atchFileVO!=null) {
			ev.setAtchFileId(atchFileVO.getAtchFileId());
		}
		
		
		int cnt = eventService.createEvent(ev);
		System.out.println(ev);
		
		String msg = "";
		
		if(cnt > 0) {
			//회원정보 추가처리 성공..
			msg = "SUCCESS";
		}else {
			//회원정보 추가처리 실패..
			msg = "FAIL";
		}
		
		req.getSession().setAttribute("msg", msg);
		resp.sendRedirect(req.getContextPath()+"/views/adminEvent/calender.jsp");
		
	}
}
