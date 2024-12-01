package kr.or.ddit.faq.service;

import java.util.List;

import kr.or.ddit.vo.FaqVO;

public interface IFaqService {
	/**
	 * FaqVO에 담겨진 faq정보를 등록하기 위한 메서드
	 * 
	 * @param fv faq정보를 담은 FaqVO 객체
	 * @return 성공하면 1, 실패하면 0 반환됨
	 */
	public int registerFaq(FaqVO fv);

	/**
	 * FaqVO에 담겨진 faq정보를 수정하기 위한 메서드
	 * 
	 * @param fv faq정보를 담은 FaqVO 객체
	 * @return 성공하면 1, 실패하면 0 반환됨.
	 */
	public int modifyFaq(FaqVO fv);

	/**
	 * 해당faq이 존재여부를 확인하기위한 메서드
	 * 
	 * @param faqNo 존재여부 확인하기위한 faqID
	 * @return 해당faq이 존재하면 true, 존재하지 않으면 false 리턴함
	 */

	public boolean checkFaq(String faqNo);

	/**
	 * 해당 faq의 상세정보를 조회하기 위한 메서드
	 * 
	 * @param faqNo 상세정보를 조회할 faq ID
	 * @return 해당 faq의 상세정보를 담은 FaqVO 객체 리턴함
	 */
	public FaqVO getFaq(String faqNo);

	/**
	 * 해당 faq정보를 삭제하기위한 메서드
	 * 
	 * @param faqNo 삭제하고자 하는 faqID
	 * @return 삭제처리가 성공하면 1, 실패하면 0 반환
	 */

	public int removeFaq(String faqNo);

	/**
	 * 모든 faq정보를 가져오기위한 메서드
	 * 
	 * @return 모든 faq정보를 담은 List객체
	 */
	public List<FaqVO> getTotalFaq();

	/**
	 * faq정보를 검색하기 위한 메서드
	 * 
	 * @param fv 검색할 faq정보를 담은 FaqVO객체
	 * @return 검색된 faq정보를 담은 List 객체
	 */
	public List<FaqVO> searchFaq(FaqVO fv);
}
