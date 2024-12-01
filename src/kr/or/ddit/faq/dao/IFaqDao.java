package kr.or.ddit.faq.dao;

import java.util.List;

import kr.or.ddit.vo.FaqVO;

public interface IFaqDao {
	/**
	 * FaqVO에 담겨진 faq 정보를 DB에 Insert하기 위한 메서드
	 * 
	 * @param fv faq 정보를 담은 FaqVO 객체
	 * @return DB작업이 성공하면 1, 실패하면 0 반환됨
	 */
	public int insertFaq(FaqVO fv);

	
	/**
	 * FaqVO에 담겨진 faq 정보를 DB에 update하기 위한 메서드
	 * 
	 * @param fv faq 정보를 담은 FaqVO 객체
	 * @return DB작업이 성공하면 1, 실패하면 0 반환됨.
	 */
	public int updateFaq(FaqVO fv);

	
	/**
	 * faq 이 존재여부를 확인하기위한 메서드
	 * 
	 * @param faqNo 존재여부 확인하기위한 faq No
	 * @return 해당faq 이 존재하면 true, 존재하지 않으면 false 리턴함
	 */
	public boolean checkFaq(String faqNo);

	/**
	 * 해당 faq 의 상세정보를 조회하기 위한 메서드
	 * 
	 * @param faqNo 상세정보를 조회할 faq  No
	 * @return 해당 faq 의 상세정보를 담은 FaqVO 객체 리턴함
	 */
	
	public FaqVO getFaq(String faqNo);
	
	/**
	 * 해당 faq 정보를 삭제하기위한 메서드
	 * 
	 * @param faqNo faqNo 삭제하고자 하는 faq No
	 * @return 삭제처리가 성공하면 1, 실패하면 0 반환
	 */
	public int deletFaq(String faqNo);

	/**
	 * DB에 존재하는 모든 faq 정보를 가져오기위한 메서드
	 * 
	 * @return 모든 faq 정보를 담은 List객체
	 */
	public List<FaqVO> getAllFaq();
	
	
	/**
	 *  faq 정보를 검색하기 위한 메서드
	 * @param fv 검색할 faq 정보를 담은 FaqVO객체
	 * @return 검색된 faq 정보를 담은 List 객체
	 */
	public List<FaqVO> searchFaq(FaqVO fv);

}
