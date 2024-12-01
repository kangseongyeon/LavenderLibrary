package kr.or.ddit.inquiry.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.vo.AnswerVO;
import kr.or.ddit.vo.InquiryVO;

public interface IInquiryService {
	/**
	 * InquiryVO에 담겨진 도서관에 바라다 정보를 등록하기 위한 메서드
	 * 
	 * @param iv 도서관에 바라다 정보를 담은 InquiryVO 객체
	 * @return 성공하면 1, 실패하면 0 반환됨
	 */
	public int registerInquiry(InquiryVO iv);

	/**
	 * InquiryVO에 담겨진 도서관에 바라다 정보를 수정하기 위한 메서드
	 * 
	 * @param iv 도서관에 바라다 정보를 담은 InquiryVO 객체
	 * @return 성공하면 1, 실패하면 0 반환됨.
	 */
	public int modifyInquiry(InquiryVO iv);

	/**
	 * 해당도서관에 바라다 존재여부를 확인하기위한 메서드
	 * 
	 * @param inqNo 존재여부 확인하기위한 도서관에 바라다 ID
	 * @return 해당도서관에 바라다 이 존재하면 true, 존재하지 않으면 false 리턴함
	 */
	public boolean checkInquiry(String inqNo);

	/**
	 * 해당 도서관에 바라다 의 상세정보를 조회하기 위한 메서드
	 * 
	 * @param inqNo 상세정보를 조회할 도서관에 바라다 ID
	 * @return 해당 도서관에 바라다 의 상세정보를 담은 InquiryVO 객체 리턴함
	 */
	public InquiryVO getInquiry(String inqNo);

	/**
	 * 해당 도서관에 바라다 정보를 삭제하기위한 메서드
	 * 
	 * @param inqNo 삭제하고자 하는 도서관에 바라다 ID
	 * @return 삭제처리가 성공하면 1, 실패하면 0 반환
	 */

	public int removeInquiry(String inqNo);

	/**
	 * 모든 도서관에 바라다 정보를 가져오기위한 메서드
	 * 
	 * @return 모든 도서관에 바라다 정보를 담은 List객체
	 */
	public List<InquiryVO> getTotalInquiry();

	/**
	 * 도서관에 바라다 정보를 검색하기 위한 메서드
	 * 
	 * @param iv 검색할 도서관에 바라다 정보를 담은 InquiryVO객체
	 * @return 검색된 도서관에 바라다 정보를 담은 List 객체
	 */
	public List<InquiryVO> searchInquiry(InquiryVO iv);

	public int removeAllAnswers(String inqNo);

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
