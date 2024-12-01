package kr.or.ddit.event.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.vo.EventVO;
import kr.or.ddit.util.MyBatisUtil;

public class EventDaoImpl implements IEventDao{
	
	private static IEventDao eventDao = new EventDaoImpl();
	
	private EventDaoImpl() {

	}
	
	public static IEventDao getInstance() {
		return eventDao;
	}
	
	
	@Override
	public int insertEvent(EventVO ev) {

		SqlSession session = MyBatisUtil.getSQLSession();
		
		int cnt = 0;
		
		try {
			cnt = session.insert("adminEvent.insertEvent", ev);
			if(cnt > 0) {
				session.commit();
			}
			
			
		} catch (PersistenceException e) {
			session.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		
		return cnt;
	}

	@Override
	public int updateEvent(EventVO ev) {

		SqlSession session = MyBatisUtil.getSQLSession();
		
		int cnt = 0;
		
		try {
			cnt = session.update("adminEvent.updateEvent",ev);
			if(cnt > 0) {
				session.commit();
			}
			
			
		} catch (PersistenceException e) {
			session.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		
		return cnt;
		
	}

	@Override
	public int deleteEvent(String eventName) {

		SqlSession session = MyBatisUtil.getSQLSession();
		
		int cnt = 0;
		
		try {
			cnt = session.delete("adminEvent.deleteEvent",eventName);
			if(cnt > 0) {
				session.commit();
			}
			
			
		} catch (PersistenceException e) {
			session.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		
		return cnt;
		
	}

	@Override
	public List<EventVO> allEvent() {

		List<EventVO> eventList = new ArrayList<EventVO>();
		SqlSession session = MyBatisUtil.getSQLSession(true);
		
		try {
			eventList = session.selectList("adminEvent.allEvent");
			
		} catch (PersistenceException e) {
			e.printStackTrace();
			
		} finally {
			session.close();
		}
		
		return eventList;
	}
	@Override
	public List<EventVO> libEvent() {
		
		List<EventVO> eventList = new ArrayList<EventVO>();
		SqlSession session = MyBatisUtil.getSQLSession(true);
		
		try {
			eventList = session.selectList("adminEvent.libEvent");
			
		} catch (PersistenceException e) {
			e.printStackTrace();
			
		} finally {
			session.close();
		}
		
		return eventList;
	}

	
	@Override
	public EventVO getEvent(String eventName) {

		EventVO ev = null;
		
		SqlSession session = MyBatisUtil.getSQLSession(true);
		
		try {
			ev = session.selectOne("adminEvent.getEvent",eventName);
		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return ev;
	}

	@Override
	public List<EventVO> searchEvent(EventVO ev) {
		
		List<EventVO> eventList = new ArrayList<EventVO>();
		SqlSession session = MyBatisUtil.getSQLSession(true);
		
		try {
			eventList = session.selectList("adminEvent.searchEvent",ev);
			
		} catch (PersistenceException e) {
			e.printStackTrace();
			
		} finally {
			session.close();
		}
		
		return eventList;
	}

	@Override
	public List<EventVO> typeAllEvent(String eventType) {
		
		List<EventVO> eventTypeList = new ArrayList<EventVO>();
		SqlSession session = MyBatisUtil.getSQLSession(true);
		
		try {
			eventTypeList = session.selectList("adminEvent.typeAllEvent",eventType);
			
		} catch (PersistenceException e) {
			e.printStackTrace();
			
		} finally {
			session.close();
		}
		
		return eventTypeList;
	}

	//페이징처리
	@Override
	public int eventCountList() {
		int cnt  = 0;
		SqlSession session = MyBatisUtil.getSQLSession();
		
		try {
			cnt = session.selectOne("adminEvent.eventCountList");
			
		} catch (PersistenceException e) {
			throw new RuntimeException("데이터 조회 중 예외 발생",e);
		} finally {
			session.close();
		}
		
		return cnt;
	}

	@Override
	public List<EventVO> eventBoardList(Map<String, Object> map) {
		List<EventVO> list= null;
		
		SqlSession session = MyBatisUtil.getSQLSession();
		try {
			list = session.selectList("adminEvent.eventBoardList", map);
		} catch (Exception e) {
			throw new RuntimeException("데이터 조회 중 예외 발생",e); 
		} finally{
			session.close();
		}			
		return list;
	}

	@Override
	public int fieldstudyCountList() {
		int cnt  = 0;
		SqlSession session = MyBatisUtil.getSQLSession();
		
		try {
			cnt = session.selectOne("adminEvent.fieldstudyCountList");
			
		} catch (PersistenceException e) {
			throw new RuntimeException("데이터 조회 중 예외 발생",e);
		} finally {
			session.close();
		}
		
		return cnt;
	}

	@Override
	public List<EventVO> fieldstudyBoardList(Map<String, Object> map) {
		List<EventVO> list= null;
		
		SqlSession session = MyBatisUtil.getSQLSession();
		try {
			list = session.selectList("adminEvent.fieldstudyBoardList", map);
		} catch (Exception e) {
			throw new RuntimeException("데이터 조회 중 예외 발생",e); 
		} finally{
			session.close();
		}			
		return list;
	}

	@Override
	public int movieCountList() {
		int cnt  = 0;
		SqlSession session = MyBatisUtil.getSQLSession();
		
		try {
			cnt = session.selectOne("adminEvent.movieCountList");
			
		} catch (PersistenceException e) {
			throw new RuntimeException("데이터 조회 중 예외 발생",e);
		} finally {
			session.close();
		}
		
		return cnt;
	}

	@Override
	public List<EventVO> movieBoardList(Map<String, Object> map) {
		List<EventVO> list= null;
		
		SqlSession session = MyBatisUtil.getSQLSession();
		try {
			list = session.selectList("adminEvent.movieBoardList", map);
		} catch (Exception e) {
			throw new RuntimeException("데이터 조회 중 예외 발생",e); 
		} finally{
			session.close();
		}			
		return list;
	}

}
