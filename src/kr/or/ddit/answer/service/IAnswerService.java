package kr.or.ddit.answer.service;

import java.util.List;

import kr.or.ddit.vo.AnswerVO;

public interface IAnswerService {

	// 관리자

	// 삽입
	public int registerAnswer(AnswerVO av);

	// 수정
	public int modifyAnswer(AnswerVO av);

	// 삭제
	public int removeAnswer(String inqNo);

	public List<AnswerVO> getTotalAnswer();
	
	public AnswerVO getAnswer(String inqNo);

	List<AnswerVO> getAnswersByInquiry(String inqNo);
}
