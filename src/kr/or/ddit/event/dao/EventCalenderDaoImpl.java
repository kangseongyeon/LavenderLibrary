package kr.or.ddit.event.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.util.MyBatisUtil;
import kr.or.ddit.vo.CalenderVO;
import kr.or.ddit.vo.EventVO;

public class EventCalenderDaoImpl implements IEventCalenderDao {
	
	private static IEventCalenderDao evCalenderDao = new EventCalenderDaoImpl();
	
	public EventCalenderDaoImpl() {
	}
	
	public static IEventCalenderDao getInstance() {
		return evCalenderDao;
	}

	@Override
	public List<EventVO> getEventCalender(CalenderVO cv) {
		List<EventVO> calenderList = new ArrayList<EventVO>();
		SqlSession session = MyBatisUtil.getSQLSession(true);
		try {
			calenderList = session.selectList("calenderEvent.thisMonthEvent", cv);
		} catch (PersistenceException e) {
			e.printStackTrace();
			
		} finally {
			session.close();
		}
		
		return calenderList;
	}

}
