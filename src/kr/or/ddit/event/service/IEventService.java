package kr.or.ddit.event.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.EventVO;

public interface IEventService {
	
	/**
	 * 이벤트 개시글 신규 작성을 위한 메서드
	 * @param ev
	 * @return DB직업이 성공하면 1 실패하면 0 반환
	 */
	public int createEvent(EventVO ev);
	
	
	/**
	 * 이벤트 게시글 수정을 위한 메서드
	 * @param ev
	 * @return DB직업이 성공하면 1 실패하면 0 반환
	 */
	public int editEvent(EventVO ev);
	
	
	/**
	 * 이벤트 삭제를 위한 메서드
	 * @param ev
	 * @return DB직업이 성공하면 1 실패하면 0 반환
	 */
	public int removeEvent(String eventName);
	
	
	/**
	 * 이벤트 상세 조회를 위한 메서드
	 * @param eventName
	 * @return
	 */
	public EventVO getEvent(String eventName);
	
	
	/**
	 * 이벤트 전체 조회를 위한 메서드
	 * @return
	 */
	public List<EventVO> getTotalEvent();
	/**
	 * 이벤트 전체 조회를 위한 메서드
	 * @return
	 */
	public List<EventVO> getTotalLibEvent();
	
	/**
	 * 이벤트 전체 조회를 위한 메서드
	 * @return
	 */
	public List<EventVO> getTypeAllEvent(String eventType);
	
	/**
	 * 이벤트 검색하기 위한 메서드
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
