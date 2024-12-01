package kr.or.ddit.notice.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.util.MyBatisUtil;
import kr.or.ddit.vo.NoticeVO;

public class NoticeDaoImpl implements INoticeDao {

	private static INoticeDao noticeDao = new NoticeDaoImpl();
	
	private NoticeDaoImpl() {
		
	}
	
	public static INoticeDao getInstance() {
		return noticeDao;
	}
	
	@Override
	public int insertNotice(NoticeVO nv) {

		SqlSession session = MyBatisUtil.getSQLSession();
		int cnt = 0;

		try {
			cnt = session.insert("notice.insertNotice", nv);
			
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
	public int updateNotice(NoticeVO nv) {
		SqlSession session = MyBatisUtil.getSQLSession();
		int cnt = 0;

		try {
			cnt = session.update("notice.updateNotice", nv);

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
	public boolean checkNotice(String noticeNo) {
		boolean isExist = false;

		SqlSession session = MyBatisUtil.getSQLSession(true);

		try {
			int cnt = session.selectOne("notice.checkNotice", noticeNo);
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
	public int deleteNotice(String noticeNo) {
		SqlSession session = MyBatisUtil.getSQLSession();
		int cnt = 0;

		try {
			cnt = session.delete("notice.deleteNotice", noticeNo);

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
	public List<NoticeVO> getAllNotice() {

		List<NoticeVO> noticeList = new ArrayList<NoticeVO>();

		SqlSession session = MyBatisUtil.getSQLSession(true);

		try {
			noticeList = session.selectList("notice.selectAllNotice");
		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return noticeList;
	}

	@Override
	public List<NoticeVO> searchNotice(NoticeVO nv) {
		List<NoticeVO> noticeList = new ArrayList<NoticeVO>();

		SqlSession session = MyBatisUtil.getSQLSession(true);

		try {
			noticeList = session.selectList("notice.searchNotice",nv);
		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return noticeList;
	}

	@Override
	public NoticeVO getNotice(String noticeNo) {
		NoticeVO nv = null;
		
		SqlSession session = MyBatisUtil.getSQLSession(true);

		try {
			nv = session.selectOne("notice.getNotice",noticeNo);
		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		return nv;
	}

	@Override
	public int countList() {
		int cnt  = 0;
		SqlSession session = MyBatisUtil.getSQLSession();
		
		try {
			cnt = session.selectOne("notice.countList");
			
		} catch (PersistenceException e) {
			throw new RuntimeException("데이터 조회 중 예외 발생",e);
		} finally {
			session.close();
		}
		
		return cnt;
	}

	@Override
	public List<NoticeVO> boardList(Map<String, Object> map) {
		List<NoticeVO> list= null;
		
		SqlSession session = MyBatisUtil.getSQLSession();
		try {
			list = session.selectList("notice.boardList", map);
		} catch (Exception e) {
			throw new RuntimeException("데이터 조회 중 예외 발생",e); 
		} finally{
			session.close();
		}			
		return list;
	}

	@Override
	public List<NoticeVO> selectPinNotice() {
		List<NoticeVO> noticeList = new ArrayList<NoticeVO>();

		SqlSession session = MyBatisUtil.getSQLSession(true);

		try {
			noticeList = session.selectList("notice.selectPinNotice");
		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return noticeList;
	}

}
