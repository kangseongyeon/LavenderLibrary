package kr.or.ddit.event.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.event.dao.EventDaoImpl;
import kr.or.ddit.event.dao.IEventDao;
import kr.or.ddit.vo.EventVO;

public class EventServiceImpl implements IEventService{

	private static IEventService eventService = new EventServiceImpl();
	
	private IEventDao eventDao;
	
	private EventServiceImpl() {
		eventDao = EventDaoImpl.getInstance();
	}
	
	
	public static IEventService getInsetance() {
		return eventService;
	
	}
	
	
	@Override
	public int createEvent(EventVO ev) {
		int cnt = eventDao.insertEvent(ev);

		return cnt;
	}

	@Override
	public int editEvent(EventVO ev) {
		int cnt = eventDao.updateEvent(ev);
		
		return cnt;
	
	}

	@Override
	public int removeEvent(String eventName) {
		int cnt = eventDao.deleteEvent(eventName);
		
		return cnt;
	}

	@Override
	public EventVO getEvent(String eventName) {
		return eventDao.getEvent(eventName);
	
	}

	@Override
	public List<EventVO> getTotalEvent() {
		List<EventVO> eventList = eventDao.allEvent();
		return eventList;
	
	}
	@Override
	public List<EventVO> getTotalLibEvent() {
		List<EventVO> eventList = eventDao.libEvent();
		return eventList;
		
	}

	@Override
	public List<EventVO> searchEvent(EventVO ev) {
		return eventDao.searchEvent(ev);
	}


	@Override
	public List<EventVO> getTypeAllEvent(String eventType) {
		List<EventVO> eventTypeList = eventDao.typeAllEvent(eventType);
		return eventTypeList;
	}


	@Override
	public int eventCountList() {
		// TODO Auto-generated method stub
		return eventDao.eventCountList();
	}


	@Override
	public List<EventVO> eventBoardList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return eventDao.eventBoardList(map);
	}


	@Override
	public int fieldstudyCountList() {
		// TODO Auto-generated method stub
		return eventDao.fieldstudyCountList();
	}


	@Override
	public List<EventVO> fieldstudyBoardList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return eventDao.fieldstudyBoardList(map);
	}


	@Override
	public int movieCountList() {
		// TODO Auto-generated method stub
		return eventDao.movieCountList();
	}


	@Override
	public List<EventVO> movieBoardList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return eventDao.movieBoardList(map);
	}



}
