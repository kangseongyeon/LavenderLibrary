package kr.or.ddit.inquiry.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.AnswerVO;
import kr.or.ddit.vo.InquiryVO;

public interface IInquiryDao {
	/**
	 * InquiryVO에 담겨진 iv 정보를 DB에 Insert하기 위한 메서드
	 * 
	 * @param iv iv 정보를 담은 InquiryVO 객체
	 * @return DB작업이 성공하면 1, 실패하면 0 반환됨
	 */
	public int insertInquiry(InquiryVO iv);

	
	/**
	 * InquiryVO에 담겨진 iv 정보를 DB에 update하기 위한 메서드
	 * 
	 * @param iv iv 정보를 담은 InquiryVO 객체
	 * @return DB작업이 성공하면 1, 실패하면 0 반환됨.
	 */
	public int updateInquiry(InquiryVO iv);

	
	/**
	 * iv 이 존재여부를 확인하기위한 메서드
	 * 
	 * @param iv 존재여부 확인하기위한 iv No
	 * @return 해당iv 이 존재하면 true, 존재하지 않으면 false 리턴함
	 */
	public boolean checkInquiry(String inquiryNo);

	/**
	 * 해당 iv 의 상세정보를 조회하기 위한 메서드
	 * 
	 * @param inquiryNo 상세정보를 조회할 iv  No
	 * @return 해당 iv 의 상세정보를 담은 InquiryVO 객체 리턴함
	 */
	
	public InquiryVO getInquiry(String inquiryNo);
	
	/**
	 * 해당 iv 정보를 삭제하기위한 메서드
	 * 
	 * @param iv inquiryNo 삭제하고자 하는 iv No
	 * @return 삭제처리가 성공하면 1, 실패하면 0 반환
	 */
	public int deleteInquiry(String inquiryNo);

	/**
	 * DB에 존재하는 모든 iv 정보를 가져오기위한 메서드
	 * 
	 * @return 모든 iv 정보를 담은 List객체
	 */
	public List<InquiryVO> selectAllInquiry();
	
	
	/**
	 *  iv 정보를 검색하기 위한 메서드
	 * @param iv 검색할 iv 정보를 담은 InquiryVO객체
	 * @return 검색된 iv 정보를 담은 List 객체
	 */
	public List<InquiryVO> searchInquiry(InquiryVO iv);


	/*
	 * 상태 정보 표시
	 */
	public List<InquiryVO> getInquiryList();
	
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
	public List<InquiryVO> boardList(Map<String, Object> map);
	
	
}
