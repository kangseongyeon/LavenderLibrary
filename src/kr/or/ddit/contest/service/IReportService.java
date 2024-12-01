package kr.or.ddit.contest.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.contest.vo.BookReportVO;

public interface IReportService {
	
	/**
	 * BookReportVO에 담겨진 글쓰기 정보를 DB에 Insert하기 위한 메서드
	 * @param rv
	 * @return DB작업이 성공하면 1, 실패하면 0 반환됨.
	 */
	public int insertReport(BookReportVO rv);
	
	/**
	 * BookReportVO에 담겨진 글쓰기 정보를 DB에 update하기 위한 메서드
	 * @param rv
	 * @return DB작업이 성공하면 1, 실패하면 0 반환됨.
	 */
	public int updateReport(BookReportVO rv);
	
	/**
	 * 해당 글쓰기를 삭제하기 위한 메서드
	 * @param rptNo
	 * @return 삭제처리가 성공하면 1, 실패하면 0이 반환됨
	 */
	public int deleteReport(String rptNo);
	
	/**
	 * DB에 존재하는 모든 글쓰기를 가져오기 위한 메서드
	 * @return 모든 글쓰기 정보을 담은 List객체
	 */
	public List<BookReportVO> getAllReports();
	
	/**
	 * 글쓰기의 상세 정보를 가져오기 위한 메서드
	 * @param rptNo
	 * @return 해당되는 글쓰기의 상세정보가 담긴 BookReportVO객체
	 */
	public BookReportVO detailReport(String rptNo);
	
	/**
	 * 제목으로 검색해서 글쓰기정보를 찾기 위한 메서드
	 * @param rptTitle
	 * @return 검색된 글쓰기 정보를 담은 List객체
	 */
	public List<BookReportVO> searchTitleReport(String rptTitle);
	
	/**
	 * 내용으로 검색해서 글쓰기정보를 찾기 위한 메서드
	 * @param rptContent
	 * @return 검색된 글쓰기 정보를 담은 List객체
	 */
	public List<BookReportVO> searchContentReport(String rptContent);
	
	/**
	 * 회원ID로 검색해서 글쓰기 정보를 찾기 위한 메서드
	 * @param memId
	 * @return 검색된 글쓰기 정보를 담은 List객체
	 */
	public List<BookReportVO> searchMemReport(String memId);

	
	/**
	 * 도서명으로 검색해서 글쓰기 정보를 찾기 위한 메서드
	 * inner join으로 BookName에 해당하는 bookId찾아서 그것으로 검색
	 * @param BookName
	 * @return 검색된 글쓰기 정보를 담은 List객체
	 */
	public List<BookReportVO> searchBookReport(String bookTitle);
	
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
	public List<BookReportVO> boardList(Map<String, Object> map);
	
	

}
