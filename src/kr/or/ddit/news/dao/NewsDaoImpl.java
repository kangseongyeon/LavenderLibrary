package kr.or.ddit.news.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.util.MyBatisUtil;
import kr.or.ddit.vo.NewsVO;

public class NewsDaoImpl implements INewsDao {
	private static INewsDao newsDao = new NewsDaoImpl();

	private NewsDaoImpl() {

	}

	public static INewsDao getInstance() {
		return newsDao;
	}

	@Override
	public int insertNews(NewsVO nv) {
		SqlSession session = MyBatisUtil.getSQLSession();
		int cnt = 0;

		try {
			cnt = session.insert("news.insertNews", nv);

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
	public int updateNews(NewsVO nv) {
		SqlSession session = MyBatisUtil.getSQLSession();
		int cnt = 0;
		
		try {
			cnt = session.update("news.updateNews", nv);
			
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
	public boolean checkNews(String newsNo) {
		boolean isExist = false;
		SqlSession session = MyBatisUtil.getSQLSession();
		
		try {
			int cnt = session.selectOne("news.checkNews", newsNo);
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
	public NewsVO getNews(String newsNo) {
		NewsVO nv = null;
		
		SqlSession session = MyBatisUtil.getSQLSession();
		
		try {
			nv = session.selectOne("news.getNews", newsNo);
		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
				
		return nv;
	}

	@Override
	public int deleteNews(String newsNo) {
		SqlSession session = MyBatisUtil.getSQLSession();
		int cnt = 0;
		
		try {
			cnt = session.delete("news.deleteNews", newsNo);
			
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
	public List<NewsVO> getAllNews() {
		List<NewsVO> newsList = new ArrayList<NewsVO>();
		
		SqlSession session = MyBatisUtil.getSQLSession();
		try {
			newsList = session.selectList("news.selectAllNews");
		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
				
		return newsList;
	}

	@Override
	public List<NewsVO> searchNews(NewsVO nv) {
		List<NewsVO> newsList = new ArrayList<NewsVO>();
		SqlSession session = MyBatisUtil.getSQLSession();
		
		try {
			newsList = session.selectList("news.searchNews", nv);
		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return newsList;
	}

	@Override
	public int countList() {
		int cnt  = 0;
		SqlSession session = MyBatisUtil.getSQLSession();
		
		try {
			cnt = session.selectOne("news.countList");
			
		} catch (PersistenceException e) {
			throw new RuntimeException("데이터 조회 중 예외 발생",e);
		} finally {
			session.close();
		}
		
		return cnt;
	}

	@Override
	public List<NewsVO> boardList(Map<String, Object> map) {
		List<NewsVO> list= null;
		
		SqlSession session = MyBatisUtil.getSQLSession();
		try {
			list = session.selectList("news.boardList", map);
		} catch (Exception e) {
			throw new RuntimeException("데이터 조회 중 예외 발생",e); 
		} finally{
			session.close();
		}			
		return list;
	}
}
