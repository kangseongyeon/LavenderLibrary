package kr.or.ddit.inquiry.service;

import java.util.List;

import kr.or.ddit.vo.InqCategoryVO;

/**
 * 모든 정보를 가져오기 위한 메서드
 * 
 * @return 모든 정보를 담은 List객체
 */
public interface IInqCategoryService {
	public List<InqCategoryVO> getTotalCategories();
}
