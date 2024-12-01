package kr.or.ddit.faq.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.util.MyBatisUtil;
import kr.or.ddit.vo.FaqVO;

public class FaqDaoImpl implements IFaqDao {
	private static IFaqDao faqDao = new FaqDaoImpl();

	public FaqDaoImpl() {
	}

	public static IFaqDao getInstance() {
		return faqDao;
	}

	@Override
	public int insertFaq(FaqVO fv) {
		SqlSession session = MyBatisUtil.getSQLSession();
		int cnt = 0;

		try {
			cnt = session.insert("faq.insertFaq", fv);

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
	public int updateFaq(FaqVO fv) {
		SqlSession session = MyBatisUtil.getSQLSession();
		int cnt = 0;

		try {
			cnt = session.update("faq.updateFaq", fv);

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
	public boolean checkFaq(String faqNo) {
		boolean isExist = false;

		SqlSession session = MyBatisUtil.getSQLSession(true);

		try {
			int cnt = session.selectOne("faq.checkFaq", faqNo);
			if (cnt > 0) {
				isExist = true;
			}
		} catch (PersistenceException e) {
			session.rollback();
			e.printStackTrace();
		} finally {
			session.close();
		}
		return isExist;
	}

	@Override
	public FaqVO getFaq(String faqNo) {
		FaqVO fv = null;

		SqlSession session = MyBatisUtil.getSQLSession(true);

		try {
			fv = session.selectOne("faq.getFaq", faqNo);
		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return fv;
	}

	@Override
	public int deletFaq(String faqNo) {
		SqlSession session = MyBatisUtil.getSQLSession();
		int cnt = 0;

		try {
			cnt = session.delete("faq.deleteFaq", faqNo);

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
	public List<FaqVO> getAllFaq() {
		List<FaqVO> memList = new ArrayList<FaqVO>();

		SqlSession session = MyBatisUtil.getSQLSession(true);

		try {
			memList = session.selectList("faq.selectAllFaq");
		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return memList;
	}

	@Override
	public List<FaqVO> searchFaq(FaqVO fv) {
		List<FaqVO> memList = new ArrayList<FaqVO>();

		SqlSession session = MyBatisUtil.getSQLSession(true);

		try {
			memList = session.selectList("faq.searchFaq", fv);
		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return memList;
	}

}
