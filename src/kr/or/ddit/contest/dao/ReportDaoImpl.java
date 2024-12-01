package kr.or.ddit.contest.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.contest.vo.BookReportVO;
import kr.or.ddit.util.MyBatisUtil;

public class ReportDaoImpl implements IReportDao {
	
	//싱글톤
	private static IReportDao reportDao = new ReportDaoImpl();
	
	private ReportDaoImpl() {
		
	}
	
	public static IReportDao getInstace() {
		return reportDao;
	}
	

	@Override
	public int insertReport(BookReportVO rv) {
		SqlSession session = MyBatisUtil.getSQLSession();
		
		int cnt = 0;
		
		try {
			
			cnt = session.insert("report.insertReport", rv);
			
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
	public int updateReport(BookReportVO rv) {
		
		SqlSession session = MyBatisUtil.getSQLSession();
		
		int cnt=0;
		
		try {
			cnt = session.update("report.updateReport", rv);
			
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
	public int deleteReport(String rptNo) {
		
		SqlSession session = MyBatisUtil.getSQLSession();
		
		int cnt = 0;
		try {
			cnt = session.delete("report.deleteReport", rptNo);
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
	public List<BookReportVO> getAllReports() {
		
		List<BookReportVO> reportList = new ArrayList<BookReportVO>();
		
		SqlSession session = MyBatisUtil.getSQLSession(true);
		
		try {
			reportList = session.selectList("report.getAllReports");
			
		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return reportList;
	}

	@Override
	public BookReportVO detailReport(String rptNo) {
		
		BookReportVO rv = null;
		
		SqlSession session = MyBatisUtil.getSQLSession(true);
		
		try {
			rv = session.selectOne("report.detailReport", rptNo);
			
		} catch (PersistenceException e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return rv;
	}

	//검색기능 시작
	
	//글쓰기 제목으로 검색
	@Override
	public List<BookReportVO> searchTitleReport(String rptTitle) {
		List<BookReportVO> reportList = new ArrayList<BookReportVO>();
		
		SqlSession session = MyBatisUtil.getSQLSession(true);
		
		try {
			reportList = session.selectList("report.searchTitleReport", rptTitle);
		} catch (PersistenceException e) {
			e.printStackTrace();
			session.rollback();
		} finally {
			session.close();
		}
		
		return reportList;
	}

	//글쓰기 내용으로 검색
	@Override
	public List<BookReportVO> searchContentReport(String rptContent) {
		List<BookReportVO> reportList = new ArrayList<BookReportVO>();
		
		SqlSession session = MyBatisUtil.getSQLSession(true);
		
		try {
			reportList = session.selectList("report.searchContentReport", rptContent);
		} catch (PersistenceException e) {
			e.printStackTrace();
			session.rollback();
		} finally {
			session.close();
		}
		
		return reportList;
	}

	//회원ID로 검색
	@Override
	public List<BookReportVO> searchMemReport(String memId) {
		List<BookReportVO> reportList = new ArrayList<BookReportVO>();
		
		SqlSession session = MyBatisUtil.getSQLSession(true);
		
		try {
			reportList = session.selectList("report.searchMemReport", memId);
		} catch (PersistenceException e) {
			e.printStackTrace();
			session.rollback();
		} finally {
			session.close();
		}
		
		return reportList;
	}

	//책제목으로 검색
	@Override
	public List<BookReportVO> searchBookReport(String bookTitle) {
		List<BookReportVO> reportList = new ArrayList<BookReportVO>();
		
		SqlSession session = MyBatisUtil.getSQLSession(true);
		
		try {
			reportList = session.selectList("report.searchBookReport", bookTitle);
		} catch (PersistenceException e) {
			e.printStackTrace();
			session.rollback();
		} finally {
			session.close();
		}
		
		return reportList;
	}
	
	@Override
	public int countList() {
		int cnt  = 0;
		SqlSession session = MyBatisUtil.getSQLSession();
		
		try {
			cnt = session.selectOne("report.countList");
			
		} catch (PersistenceException e) {
			throw new RuntimeException("데이터 조회 중 예외 발생",e);
		} finally {
			session.close();
		}
		
		return cnt;
	}

	@Override
	public List<BookReportVO> boardList(Map<String, Object> map) {
		
		List<BookReportVO> list= null;
		
		SqlSession session = MyBatisUtil.getSQLSession();
		try {
			list = session.selectList("report.boardList", map);
		} catch (Exception e) {
			throw new RuntimeException("데이터 조회 중 예외 발생",e); 
		} finally{
			session.close();
		}			
		return list;
	}

}
