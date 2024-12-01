package kr.or.ddit.admin.event.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.event.dao.IEventCalenderDao;
import kr.or.ddit.event.service.EventCalenderImpl;
import kr.or.ddit.event.service.IEventCalenderService;
import kr.or.ddit.vo.CalenderVO;
import kr.or.ddit.vo.EventVO;

@WebServlet("/adminEvent/eventCalender.do")
public class eventCalender extends HttpServlet {
	private static final String String = null;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String year = req.getParameter("startDate");
		String month = req.getParameter("endDate");
		PrintWriter out = resp.getWriter();

		CalenderVO cv = new CalenderVO(year, month);
		IEventCalenderService eventCalenderService = EventCalenderImpl.getInstance();
		List<EventVO> calenderList = eventCalenderService.getEventCalender(cv);

		StringBuilder jsonResult = new StringBuilder();
		jsonResult.append("[");
		for (int i = 0; i < calenderList.size(); i++) {
			jsonResult.append(calenderList.get(i).toJson());
			if (i < calenderList.size() - 1) {
				jsonResult.append(",");
			}
		}
		jsonResult.append("]");
		System.out.println(jsonResult);

		
		 out.print(jsonResult); req.setAttribute("calenderList", calenderList);
		 
		 
//		 req.getRequestDispatcher("/views/adminEvent/calender.jsp").forward(req,resp);
		 

//		resp.setContentType("application/json"); // JSON 데이터임을 명시
//		resp.getWriter().print(jsonResult); // JSON 데이터만 출력
	}

}
