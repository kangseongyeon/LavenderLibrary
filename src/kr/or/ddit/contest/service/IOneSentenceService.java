package kr.or.ddit.contest.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.contest.vo.OneSentenceVO;

public interface IOneSentenceService {
	
	/**
	 * OneSentenceVO에 담겨진 1일1문장 정보를 DB에 insert하기 위한 메서드
	 * @param ov
	 * @return DB작업이 성공하면 1, 실패하면 0 반환됨.
	 */
	public int insertSentence(OneSentenceVO ov);
	
	/**
	 * OneSentenceVO에 담겨진 1일1문장 정보를 DB에 updata하기 위한 메서드
	 * @param ov
	 * @return DB작업이 성공하면 1, 실패하면 0 반환됨.
	 */
	public int updateSentence(OneSentenceVO ov);
	
	/**
	 * 해당 1일1문장을 삭제하기 위한 메서드
	 * @param senNo
	 * @return 삭제처리가 성공하면 1, 실패하면 0이 반환됨
	 */
	public int deleteSentence(String senNo);
	
	/**
	 * DB에 존재하는 모든 1일1문장 정보를 가져오기 위한 메서드
	 * @return 모든 1일1문장 정보를 담은 List객체
	 */
	public List<OneSentenceVO> getAllSentences();
	
	/**
	 * 1일1문장의 상세정보를 가져오기 위한 메서드
	 * @param senNo
	 * @return 해당되는 1일1문장의 살세 정보가 담긴 OneSentenceVO객체
	 */
	public OneSentenceVO detailSentence(String senNo);
	
	/**
	 * 제목으로 검색해서 1일1문장 정보를 찾기 위한 메서
	 * @param senTitle
	 * @return 검색된 1일1문장 정보를 담은 List객체
	 */
	public List<OneSentenceVO> searchTitleSentence(String senTitle);
	
	/**
	 * 내용으로 검색해서 1일1문장 정보를 찾기 위한 메서드
	 * @param senContent
	 * @return 검색된 1일1문장 정보를 담은 List객체
	 */
	public List<OneSentenceVO> searchContentSentence(String senContent);
	
	/**
	 * 도서명으로 검색해서 1일1문장 정보를 찾기 위한 메서드
	 * inner join으로 bookTitle에 해당하는 bookId찾아서 그것으로 검색
	 * @param bookTitle
	 * @return 검색된 1일1문장 정보를 담은 List객체
	 */
	public List<OneSentenceVO> searchBookSentense(String bookTitle);
	
	/**
	 * 회원ID로 검색해서 1일1문장 정보를 찾기 위한 메서드
	 * @param memId
	 * @return 검색된 1일1문장정보를 담은 List객체
	 */
	public List<OneSentenceVO> searchMemSentense(String memId);

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
	public List<OneSentenceVO> boardList(Map<String, Object> map);
	
	

}

