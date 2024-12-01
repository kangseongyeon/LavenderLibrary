package kr.or.ddit.answer.dao;

import java.util.List;

import kr.or.ddit.vo.AnswerVO;

public interface IAnswerDao {
	// 관리자 댓글 관리

	// 댓글 삽입
	public int insertAnswer(AnswerVO av);

	// 댓글 수정
	public int updateAnswer(AnswerVO av);

	// 댓글 삭제
	public int deleteAnswer(String inqNo);

	// 댓글 조회
	public List<AnswerVO> getAllAnswer();

	public AnswerVO getAnswer(String inqNo);

	public List<AnswerVO> getAnswersByInquiry(String inqNo);
	
	public int deleteAnswersByInquiryNo(String inqNo);
}
