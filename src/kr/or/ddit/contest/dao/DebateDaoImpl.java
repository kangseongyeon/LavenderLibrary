package kr.or.ddit.contest.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.contest.vo.DebateVO;
import kr.or.ddit.util.MyBatisUtil;

public class DebateDaoImpl implements IDebateDao {
	
	//싱글톤
	private static IDebateDao debateDao = new DebateDaoImpl();
	
	private DebateDaoImpl() {
		
	}
	
	public static IDebateDao getInstace() {
		return debateDao;
	}
	

	@Override
	public int insertDebate(DebateVO dv) {
		SqlSession session = MyBatisUtil.getSQLSession();
		
		int cnt = 0;
		
		try {
			
			cnt = session.insert("debate.insertDebate", dv);
			
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
	public int updateDebate(DebateVO dv) {
		SqlSession session = MyBatisUtil.getSQLSession();
		
		int cnt=0;
		
		try {
			cnt = session.update("debate.updateDebate", dv);
			
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
	public int deleteDebate(String debateNo) {
		SqlSession session = MyBatisUtil.getSQLSession();
		
		int cnt = 0;
		try {
			cnt = session.delete("debate.deleteDebate", debateNo);
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
	public List<DebateVO> getAllDebates() {
		List<DebateVO> debateList = new ArrayList<DebateVO>();
		
		SqlSession session = MyBatisUtil.getSQLSession(true);
		
		try {
			debateList = session.selectList("debate.getAllDebates");
			
		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return debateList;
	}

	@Override
	public DebateVO detailDebate(String debateNo) {
		DebateVO dv = null;
		
		SqlSession session = MyBatisUtil.getSQLSession(true);
		
		try {
			dv = session.selectOne("debate.detailDebate", debateNo);
			
		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return dv;
	}

	//검색 시작
	@Override
	public List<DebateVO> searchBookDebate(String bookTitle) {
		List<DebateVO> debateList = new ArrayList<DebateVO>();
		
		SqlSession session = MyBatisUtil.getSQLSession(true);
		
		try {
			debateList = session.selectList("debate.searchBookDebate", bookTitle);
		} catch (PersistenceException e) {
			e.printStackTrace();
			session.rollback();
		} finally {
			session.close();
		}
		
		return debateList;
	}

	@Override
	public List<DebateVO> searchTopicDebate(String debateTopic) {
		List<DebateVO> debateList = new ArrayList<DebateVO>();
		
		SqlSession session = MyBatisUtil.getSQLSession(true);
		
		try {
			debateList = session.selectList("debate.searchTopicDebate", debateTopic);
		} catch (PersistenceException e) {
			e.printStackTrace();
			session.rollback();
		} finally {
			session.close();
		}
		
		return debateList;
	}

	@Override
	public List<DebateVO> searchContentDebate(String debateContent) {
		List<DebateVO> debateList = new ArrayList<DebateVO>();
		
		SqlSession session = MyBatisUtil.getSQLSession(true);
		
		try {
			debateList = session.selectList("debate.searchContentDebate", debateContent);
		} catch (PersistenceException e) {
			e.printStackTrace();
			session.rollback();
		} finally {
			session.close();
		}
		
		return debateList;
	}

	@Override
	public int countList() {
		int cnt  = 0;
		SqlSession session = MyBatisUtil.getSQLSession();
		
		try {
			cnt = session.selectOne("debate.countList");
			
		} catch (PersistenceException e) {
			throw new RuntimeException("데이터 조회 중 예외 발생",e);
		} finally {
			session.close();
		}
		
		return cnt;
	}

	@Override
	public List<DebateVO> boardList(Map<String, Object> map) {
		List<DebateVO> list= null;
		
		SqlSession session = MyBatisUtil.getSQLSession();
		try {
			list = session.selectList("debate.boardList", map);
		} catch (Exception e) {
			throw new RuntimeException("데이터 조회 중 예외 발생",e); 
		} finally{
			session.close();
		}			
		return list;
	}

}
