package kr.or.ddit.inquiry.dao;

import java.util.List;

import kr.or.ddit.vo.InqCategoryVO;

/**
 * DB에 존재하는 모든 iv 정보를 가져오기위한 메서드
 * 
 * @return 모든 iv 정보를 담은 List객체
 */
public interface IInqCategoryDao {
	public List<InqCategoryVO> getAllCategories();
}
