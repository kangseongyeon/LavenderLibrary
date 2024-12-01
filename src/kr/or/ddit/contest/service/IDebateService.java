package kr.or.ddit.contest.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.contest.vo.DebateVO;

public interface IDebateService {
	
	/**
	 * DebateVO에 담겨진 토론 정보를 DB에 insert하기 위한 메서드
	 * @param dv
	 * @return DB작업이 성공하면 1, 실패하면 0 반환됨.
	 */
	public int insertDebate(DebateVO dv);
	
	/**
	 * DebateVO에 담겨진 토론 정보를 DB에 update하기 위한 메서드
	 * @param dv
	 * @return DB작업이 성공하면 1, 실패하면 0 반환됨.
	 */
	public int updateDebate(DebateVO dv);
	
	/**
	 * 해당 토론정보를 삭제하기 위한 메서드
	 * @param debateNo
	 * @return 삭제처리가 성공하면 1, 실패하면 0이 반환됨
	 */
	public int deleteDebate(String debateNo);
	
	/**
	 * DB에 존재하는 모든 토론 정보를 가져오기 위한 메서드
	 * @return 모든 토론 정보를 담은 List객체
	 */
	public List<DebateVO> getAllDebates();
	
	/**
	 * 토론의 상세 정보를 가져오기 위한 메서드
	 * @param debateNo
	 * @return 해당되는 토론의 상세 정보가 담긴 DebateVO객체
	 */
	public DebateVO detailDebate(String debateNo);
	
	
	/**
	 * 도서명으로 검색해서 토론 정보를 찾기 위한 메서드
	 * inner join으로 BookName에 해당하는 bookId찾아서 그것으로 검색
	 * @param BookName
	 * @return 검색된 토론 정보를 담은 List객체
	 */
	public List<DebateVO> searchBookDebate(String bookTitle);
	
	/**
	 * 토론 주제로 검색해서 토론정보를 찾기 위한 메서드
	 * @param debateTopic
	 * @return 검색된 토론 정보를 담은 List객체
	 */
	public List<DebateVO> searchTopicDebate(String debateTopic);
	
	/**
	 * 토로 내용으로 검색해서 토론 정보를 찾기 위한 메서드
	 * @param debateContent
	 * @return 검색된 토론 정보를 담은 List객체
	 */
	public List<DebateVO> searchContentDebate(String debateContent);

	/**
	 * 페이징처리를 위한 전체게시글 개수 찾기 위한 메서드
	 * @return 전체 게시글 수
	 */
	public int countList();

	/**
	 * 페이징처리를 위한 게시글 가져오는 메소드
	 * @param map
	 * @return 원하는 개수만큼의 게시글들
	 */
	public List<DebateVO> boardList(Map<String, Object> map);
	
	

}
