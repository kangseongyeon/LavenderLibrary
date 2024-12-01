package kr.or.ddit.event.dao;

import java.awt.Event;
import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.EventVO;

public interface IEventDao {
	 /**
	  * 이벤트 글 추가
	  * @param ev
	  * @return
	  */
	public int insertEvent(EventVO ev);
	
	/** 
	 * 이벤트 글 수정 
	 * @param ev
	 * @return
	 */
	public int updateEvent(EventVO ev);
	
	/**
	 * 이벤트 삭제
	 * @param ev
	 * @return
	 */
	public int deleteEvent(String eventName);
	
	/**
	 * 이벤트 상세 조회 메서드
	 * @param eventName
	 * @return
	 */
	public EventVO getEvent(String eventName);
	
	
	/**
	 * 이벤트 전체 리스트 보기 
	 * @param ev
	 * @return
	 */
	public List<EventVO> allEvent();
	/**
	 * 이벤트 전체 리스트 보기 
	 * @param ev
	 * @return
	 */
	public List<EventVO> libEvent();
	
	/**
	 * 이벤트 타입별 리스트 보기 
	 * @param ev
	 * @return
	 */
	public List<EventVO> typeAllEvent(String eventType);
	
	/**
	 * 이벤트 검색 
	 * @param ev
	 * @return
	 */
	public List<EventVO> searchEvent(EventVO ev);
	
	//페이징처리
	/**
	 * 페이징처리를 위한 도서관행사 전체 게시글 수 찾기 위한 메서드
	 * @return 전체 게시글 수
	 */
	public int eventCountList();

	/**
	 * 페이징처리를 위한 도서관행사 게시글 가져오는 메소드
	 * @param map
	 * @return 원하는 개수만큼의 게시글들
	 */
	public List<EventVO> eventBoardList(Map<String, Object> map);
	
	/**
	 * 페이징처리를 위한 도서관체험 전체 게시글 수 찾기 위한 메서드
	 * @return 전체 게시글 수
	 */
	public int fieldstudyCountList();
	
	/**
	 * 페이징처리를 위한 도서관체험 게시글 가져오는 메소드
	 * @param map
	 * @return 원하는 개수만큼의 게시글들
	 */
	public List<EventVO> fieldstudyBoardList(Map<String, Object> map);
	
	/**
	 * 페이징처리를 위한 영화상영 전체 게시글 수 찾기 위한 메서드
	 * @return 전체 게시글 수
	 */
	public int movieCountList();
	
	/**
	 * 페이징처리를 위한 영화상영 게시글 가져오는 메소드
	 * @param map
	 * @return 원하는 개수만큼의 게시글들
	 */
	public List<EventVO> movieBoardList(Map<String, Object> map);

	
	
}
