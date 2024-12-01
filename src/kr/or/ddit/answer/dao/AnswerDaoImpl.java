package kr.or.ddit.answer.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.util.MyBatisUtil;
import kr.or.ddit.vo.AnswerVO;

public class AnswerDaoImpl implements IAnswerDao {
	private static IAnswerDao answerDao = new AnswerDaoImpl();

	private AnswerDaoImpl() {
	}

	public static IAnswerDao getInstance() {
		return answerDao;
	}

	@Override
	public int insertAnswer(AnswerVO av) {
		SqlSession session = MyBatisUtil.getSQLSession();
		int cnt = 0;

		try {
			cnt = session.insert("answer.insertAnswer", av);

			if (cnt > 0) {
				session.commit();
			}
		} catch (PersistenceException e) {
			session.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return cnt;
	}

	@Override
	public int updateAnswer(AnswerVO av) {
		SqlSession session = MyBatisUtil.getSQLSession();
		int cnt = 0;

		try {
			cnt = session.update("answer.updateAnswer", av);

			if (cnt > 0) {
				session.commit();
			}
		} catch (PersistenceException e) {
			session.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return cnt;
	}

	@Override
	public int deleteAnswer(String inqNo) {
		SqlSession session = MyBatisUtil.getSQLSession();
		int cnt = 0;

		try {
			cnt = session.delete("answer.deleteAnswer", inqNo);

			if (cnt > 0) {
				session.commit();
			}
		} catch (PersistenceException e) {
			session.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return cnt;
	}

	@Override
	public List<AnswerVO> getAllAnswer() {
		List<AnswerVO> answerList = new ArrayList<AnswerVO>();

		SqlSession session = MyBatisUtil.getSQLSession(true);
		try {
			answerList = session.selectList("answer.selectAllAnswer");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return answerList;
	}

	@Override
	public AnswerVO getAnswer(String inqNo) {
		AnswerVO av = null;
		
		SqlSession session = MyBatisUtil.getSQLSession(true);
		
		try {
			av = session.selectOne("answer.getAnswer", inqNo);
		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return av;
	}

	@Override
	public List<AnswerVO> getAnswersByInquiry(String inqNo) {
		List<AnswerVO> answerList = new ArrayList<AnswerVO>();

		SqlSession session = MyBatisUtil.getSQLSession(true);
		try {
			answerList = session.selectList("answer.getAnswersByInquiry", inqNo);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return answerList;
	}

	@Override
	public int deleteAnswersByInquiryNo(String inqNo) {
		SqlSession session = MyBatisUtil.getSQLSession();
		int cnt = 0;

		try {
			cnt = session.delete("answer.deleteAnswer", inqNo);

			if (cnt > 0) {
				session.commit();
			}
		} catch (PersistenceException e) {
			session.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return cnt;
    }

}
