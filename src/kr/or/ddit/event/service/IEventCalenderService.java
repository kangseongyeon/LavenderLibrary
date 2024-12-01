package kr.or.ddit.event.service;

import java.util.List;

import kr.or.ddit.vo.CalenderVO;
import kr.or.ddit.vo.EventVO;

public interface IEventCalenderService {
	
	public List<EventVO> getEventCalender(CalenderVO cv);
}
