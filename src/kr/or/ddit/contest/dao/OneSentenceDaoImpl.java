package kr.or.ddit.contest.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.contest.vo.OneSentenceVO;
import kr.or.ddit.util.MyBatisUtil;

public class OneSentenceDaoImpl implements IOneSentenceDao {

	//싱글톤
	private static IOneSentenceDao sentenceDao = new OneSentenceDaoImpl();
	
	private OneSentenceDaoImpl() {
		
	}
	
	public static IOneSentenceDao getInstace() {
		return sentenceDao;
	}
	
	@Override
	public int insertSentence(OneSentenceVO ov) {
		SqlSession session = MyBatisUtil.getSQLSession();
		
		int cnt = 0;
		
		try {
			
			cnt = session.insert("sentence.insertSentence", ov);
			
			if(cnt > 0) {
				session.commit();
			}
			
		} catch (PersistenceException e) {
			session.rollback();
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return cnt;
	}

	@Override
	public int updateSentence(OneSentenceVO ov) {

		SqlSession session = MyBatisUtil.getSQLSession();
		
		int cnt=0;
		
		try {
			cnt = session.update("sentence.updateSentence", ov);
			
			if(cnt > 0) {
				session.commit();
			}
			
		} catch (PersistenceException e) {
			e.printStackTrace();
			session.rollback();
		}finally {
			session.close();
		}
		
		return cnt;
	}

	@Override
	public int deleteSentence(String senNo) {
		SqlSession session = MyBatisUtil.getSQLSession();
		
		int cnt = 0;
		try {
			cnt = session.delete("sentence.deleteSentence", senNo);
			if(cnt > 0) {
				session.commit();
			}
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		} finally {
			session.close();
		}
		return cnt;
	}

	@Override
	public List<OneSentenceVO> getAllSentences() {
		List<OneSentenceVO> sentenceList = new ArrayList<OneSentenceVO>();
		
		SqlSession session = MyBatisUtil.getSQLSession(true);
		
		try {
			sentenceList = session.selectList("sentence.getAllSentences");
			
		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return sentenceList;
	}

	@Override
	public OneSentenceVO detailSentence(String senNo) {
		OneSentenceVO ov = null;
		
		SqlSession session = MyBatisUtil.getSQLSession(true);
		
		try {
			ov = session.selectOne("sentence.detailSentence", senNo);
			
		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return ov;
	}
	
	//검색기능 시작
	
	//글쓰기 제목으로 검색
	@Override
	public List<OneSentenceVO> searchTitleSentence(String senTitle) {
		List<OneSentenceVO> sentenceList = new ArrayList<OneSentenceVO>();
		
		SqlSession session = MyBatisUtil.getSQLSession(true);
		
		try {
			sentenceList = session.selectList("sentence.searchTitleSentence", senTitle);
		} catch (PersistenceException e) {
			e.printStackTrace();
			session.rollback();
		} finally {
			session.close();
		}
		
		return sentenceList;
	}

	@Override
	public List<OneSentenceVO> searchContentSentence(String senContent) {
		List<OneSentenceVO> sentenceList = new ArrayList<OneSentenceVO>();
		
		SqlSession session = MyBatisUtil.getSQLSession(true);
		
		try {
			sentenceList = session.selectList("sentence.searchContentSentence", senContent);
		} catch (PersistenceException e) {
			e.printStackTrace();
			session.rollback();
		} finally {
			session.close();
		}
		
		return sentenceList;
	}

	@Override
	public List<OneSentenceVO> searchBookSentense(String bookTitle) {
		List<OneSentenceVO> sentenceList = new ArrayList<OneSentenceVO>();
		
		SqlSession session = MyBatisUtil.getSQLSession(true);
		
		try {
			sentenceList = session.selectList("sentence.searchBookSentense", bookTitle);
		} catch (PersistenceException e) {
			e.printStackTrace();
			session.rollback();
		} finally {
			session.close();
		}
		
		return sentenceList;
	}

	@Override
	public List<OneSentenceVO> searchMemSentense(String memId) {
		List<OneSentenceVO> sentenceList = new ArrayList<OneSentenceVO>();
		
		SqlSession session = MyBatisUtil.getSQLSession(true);
		
		try {
			sentenceList = session.selectList("sentence.searchMemSentense", memId);
		} catch (PersistenceException e) {
			e.printStackTrace();
			session.rollback();
		} finally {
			session.close();
		}
		
		return sentenceList;
	}

	@Override
	public int countList() {
		int cnt  = 0;
		SqlSession session = MyBatisUtil.getSQLSession();
		
		try {
			cnt = session.selectOne("sentence.countList");
			
		} catch (PersistenceException e) {
			throw new RuntimeException("데이터 조회 중 예외 발생",e);
		} finally {
			session.close();
		}
		
		return cnt;
	}

	@Override
	public List<OneSentenceVO> boardList(Map<String, Object> map) {
		List<OneSentenceVO> list= null;
		
		SqlSession session = MyBatisUtil.getSQLSession();
		try {
			list = session.selectList("sentence.boardList", map);
		} catch (Exception e) {
			throw new RuntimeException("데이터 조회 중 예외 발생",e); 
		} finally{
			session.close();
		}			
		return list;
	}

}
