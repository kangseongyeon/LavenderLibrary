package kr.or.ddit.event.service;

import java.util.List;

import kr.or.ddit.event.dao.EventCalenderDaoImpl;
import kr.or.ddit.event.dao.IEventCalenderDao;
import kr.or.ddit.vo.CalenderVO;
import kr.or.ddit.vo.EventVO;

public class EventCalenderImpl implements IEventCalenderService{

	private static IEventCalenderService calenderService = new EventCalenderImpl();
	private IEventCalenderDao calenderDao;
	
	private EventCalenderImpl() {
		
		calenderDao = EventCalenderDaoImpl.getInstance();
	}
	
	public static IEventCalenderService getInstance() { 
		return calenderService;
	}
	
	@Override
	public List<EventVO> getEventCalender(CalenderVO cv) {
		// TODO Auto-generated method stub
		return calenderDao.getEventCalender(cv);
	}

}
