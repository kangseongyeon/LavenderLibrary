package kr.or.ddit.bookVideo.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.util.MyBatisUtil;
import kr.or.ddit.vo.BookVideoVO;

public class BookVideoDaoImpl implements IBookVideoDao {
	public static IBookVideoDao bookVideoDao = new BookVideoDaoImpl();

	public BookVideoDaoImpl() {

	}

	public static IBookVideoDao getInstance() {
		return bookVideoDao;
	}

	@Override
	public int insertBookVideo(BookVideoVO bv) {
		SqlSession session = MyBatisUtil.getSQLSession();
		int cnt = 0;

		try {
			cnt = session.insert("bookVideo.insertBookVideo", bv);

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
	public int updateBookVideo(BookVideoVO bv) {
		SqlSession session = MyBatisUtil.getSQLSession();
		int cnt = 0;

		try {
			cnt = session.update("bookVideo.updateBookVideo", bv);

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
	public boolean checkBookVideo(String bookVideoNo) {
		boolean isExist = false;
		SqlSession session = MyBatisUtil.getSQLSession();
		try {
			int cnt = session.selectOne("bookVideo.checkBookVideo", bookVideoNo);
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
	public BookVideoVO getBookVideo(String bookVideoNo) {
		BookVideoVO bv = null;

		SqlSession session = MyBatisUtil.getSQLSession(true);

		try {
			bv = session.selectOne("bookVideo.getBookVideo", bookVideoNo);
		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return bv;
	}

	@Override
	public int deletBookVideo(String bookVideoNo) {
		SqlSession session = MyBatisUtil.getSQLSession();
		int cnt = 0;

		try {
			cnt = session.delete("bookVideo.deleteBookVideo", bookVideoNo);

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
	public List<BookVideoVO> getAllBookVideo() {
		List<BookVideoVO> bookVideoList = new ArrayList<BookVideoVO>();

		SqlSession session = MyBatisUtil.getSQLSession(true);

		try {
			bookVideoList = session.selectList("bookVideo.selectAllBookVideo");
		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return bookVideoList;
	}

	@Override
	public List<BookVideoVO> searchBookVideo(BookVideoVO bv) {
		List<BookVideoVO> bookVideoList = new ArrayList<BookVideoVO>();

		SqlSession session = MyBatisUtil.getSQLSession(true);

		try {
			bookVideoList = session.selectList("bookVideo.searchBookVideo", bv);
		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return bookVideoList;
	}

	@Override
	public int countList() {
		int cnt  = 0;
		SqlSession session = MyBatisUtil.getSQLSession();
		
		try {
			cnt = session.selectOne("bookVideo.countList");
			
		} catch (PersistenceException e) {
			throw new RuntimeException("데이터 조회 중 예외 발생",e);
		} finally {
			session.close();
		}
		
		return cnt;
	}

	@Override
	public List<BookVideoVO> boardList(Map<String, Object> map) {

		List<BookVideoVO> list= null;
		
		SqlSession session = MyBatisUtil.getSQLSession();
		try {
			list = session.selectList("bookVideo.boardList", map);
		} catch (Exception e) {
			throw new RuntimeException("데이터 조회 중 예외 발생",e); 
		} finally{
			session.close();
		}			
		return list;
	}
	
	

}
