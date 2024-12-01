package kr.or.ddit.event.dao;

import java.util.List;

import kr.or.ddit.vo.CalenderVO;
import kr.or.ddit.vo.EventVO;

public interface IEventCalenderDao {

	
	/**
	 * 달력 리스트 전체 출력
	 * @param cv
	 * @return
	 */
	public List<EventVO> getEventCalender(CalenderVO cv);
	
	
}
