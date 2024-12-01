package kr.or.ddit.answer.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.answer.dao.AnswerDaoImpl;
import kr.or.ddit.answer.dao.IAnswerDao;
import kr.or.ddit.vo.AnswerVO;

public class AnswerServiceImpl implements IAnswerService {
	private static IAnswerService answerService = new AnswerServiceImpl();

	private IAnswerDao answerDao;

	private AnswerServiceImpl() {
		answerDao = AnswerDaoImpl.getInstance();
	}

	public static IAnswerService getInstance() {
		return answerService;
	}

	// 관리자
	@Override
	public int registerAnswer(AnswerVO av) {
		int cnt = answerDao.insertAnswer(av);
		return cnt;
	}

	@Override
	public int modifyAnswer(AnswerVO av) {
		int cnt = answerDao.updateAnswer(av);
		return cnt;
	}

	@Override
	public int removeAnswer(String inqNo) {
		int cnt = answerDao.deleteAnswer(inqNo);
		return cnt;
	}

	@Override
	public List<AnswerVO> getTotalAnswer() {
		List<AnswerVO> answerList = answerDao.getAllAnswer();
		return answerList;
	}

	@Override
	public AnswerVO getAnswer(String inqNo) {
		return answerDao.getAnswer(inqNo);
	}

	@Override
	public List<AnswerVO> getAnswersByInquiry(String inqNo) {
		List<AnswerVO> answerList = answerDao.getAnswersByInquiry(inqNo);
		return answerList;
	}

}
