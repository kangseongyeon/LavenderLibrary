package kr.or.ddit.contest.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.contest.dao.IReportDao;
import kr.or.ddit.contest.dao.ReportDaoImpl;
import kr.or.ddit.contest.vo.BookReportVO;

public class ReportServiceImpl implements IReportService {
	
	//싱글톤
	private static IReportService reportService = new ReportServiceImpl();
	
	private IReportDao reportDao;
	
	private ReportServiceImpl() {
		reportDao = ReportDaoImpl.getInstace();
	}
	
	public static IReportService getInstance() {
		return reportService;
	}

	@Override
	public int insertReport(BookReportVO rv) {
		int cnt = reportDao.insertReport(rv);
		return cnt;
	}

	@Override
	public int updateReport(BookReportVO rv) {
		int cnt = reportDao.updateReport(rv);
		return cnt;
	}

	@Override
	public int deleteReport(String rptNo) {
		int cnt = reportDao.deleteReport(rptNo);
		return cnt;
	}

	@Override
	public List<BookReportVO> getAllReports() {
		List<BookReportVO> reportList = reportDao.getAllReports();
		return reportList;
	}

	@Override
	public BookReportVO detailReport(String rptNo) {
		
		return reportDao.detailReport(rptNo);
	}

	@Override
	public List<BookReportVO> searchTitleReport(String rptTitle) {
		
		return reportDao.searchTitleReport(rptTitle);
	}

	@Override
	public List<BookReportVO> searchContentReport(String rptContent) {
		return reportDao.searchContentReport(rptContent);
	}

	@Override
	public List<BookReportVO> searchMemReport(String memId) {
		return reportDao.searchMemReport(memId);
	}

	@Override
	public List<BookReportVO> searchBookReport(String bookTitle) {
		return reportDao.searchBookReport(bookTitle);
	}
	
	@Override
	public int countList() {
		// TODO Auto-generated method stub
		return reportDao.countList();
	}

	@Override
	public List<BookReportVO> boardList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return reportDao.boardList(map);
	}

}
