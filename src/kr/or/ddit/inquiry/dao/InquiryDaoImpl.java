package kr.or.ddit.inquiry.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.util.MyBatisUtil;
import kr.or.ddit.vo.AnswerVO;
import kr.or.ddit.vo.InquiryVO;

public class InquiryDaoImpl implements IInquiryDao{
	private static IInquiryDao inquiryDao = new InquiryDaoImpl();
	
	private InquiryDaoImpl() {
		
	}
	
	public static IInquiryDao getInstance() {
		return inquiryDao;
	}

	@Override
	public int insertInquiry(InquiryVO iv) {
		SqlSession session = MyBatisUtil.getSQLSession();
		int cnt = 0;

		try {
			cnt = session.insert("inquiry.insertInquiry", iv);
			
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
	public int updateInquiry(InquiryVO iv) {
		SqlSession session = MyBatisUtil.getSQLSession();
		int cnt = 0;

		try {
			cnt = session.update("inquiry.updateInquiry", iv);

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
	public boolean checkInquiry(String inquiryNo) {
		boolean isExist = false;

		SqlSession session = MyBatisUtil.getSQLSession(true);

		try {
			int cnt = session.selectOne("inquiry.checkInquiry", inquiryNo);
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
	public InquiryVO getInquiry(String inquiryNo) {
		InquiryVO mv = null;
		
		SqlSession session = MyBatisUtil.getSQLSession(true);

		try {
			mv = session.selectOne("inquiry.getInquiry",inquiryNo);
		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return mv;
	}
	
	
	@Override
	public int deleteInquiry(String inquiryNo) {
		SqlSession session = MyBatisUtil.getSQLSession();
		int cnt = 0;

		try {
			cnt = session.delete("inquiry.deleteInquiry", inquiryNo);

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
	public List<InquiryVO> selectAllInquiry() {
		List<InquiryVO> inquiryList = new ArrayList<InquiryVO>();

		SqlSession session = MyBatisUtil.getSQLSession(true);

		try {
			inquiryList = session.selectList("inquiry.selectAllInquiry");
		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return inquiryList;
	}

	@Override
	public List<InquiryVO> searchInquiry(InquiryVO iv) {
		List<InquiryVO> inquiryList = new ArrayList<InquiryVO>();

		SqlSession session = MyBatisUtil.getSQLSession(true);
		try {
			inquiryList = session.selectList("inquiry.searchInquiry",iv);
		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return inquiryList;
	}

	@Override
	public List<InquiryVO> getInquiryList() {
		List<InquiryVO> inquiryList = new ArrayList<InquiryVO>();

		SqlSession session = MyBatisUtil.getSQLSession(true);

		try {
			inquiryList = session.selectList("inquiry.getInquiryList");
		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return inquiryList;
	}

	@Override
	public int countList() {
		int cnt  = 0;
		SqlSession session = MyBatisUtil.getSQLSession();
		
		try {
			cnt = session.selectOne("inquiry.countList");
			
		} catch (PersistenceException e) {
			throw new RuntimeException("데이터 조회 중 예외 발생",e);
		} finally {
			session.close();
		}
		
		return cnt;
	}

	@Override
	public List<InquiryVO> boardList(Map<String, Object> map) {
		List<InquiryVO> list= null;
		
		SqlSession session = MyBatisUtil.getSQLSession();
		try {
			list = session.selectList("inquiry.boardList", map);
		} catch (Exception e) {
			throw new RuntimeException("데이터 조회 중 예외 발생",e); 
		} finally{
			session.close();
		}			
		return list;
	}

}
