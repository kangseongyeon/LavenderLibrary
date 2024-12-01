package kr.or.ddit.contest.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.contest.dao.DebateDaoImpl;
import kr.or.ddit.contest.dao.IDebateDao;
import kr.or.ddit.contest.vo.DebateVO;

public class DebateServiceImpl implements IDebateService {
	
	//싱글톤
	private static IDebateService debateService = new DebateServiceImpl();
	
	private IDebateDao debateDao;
	
	private DebateServiceImpl() {
		debateDao = DebateDaoImpl.getInstace();
	}
	
	public static IDebateService getInstance() {
		return debateService;
	}


	@Override
	public int insertDebate(DebateVO dv) {
		
		return debateDao.insertDebate(dv);
	}

	@Override
	public int updateDebate(DebateVO dv) {
		// TODO Auto-generated method stub
		return debateDao.updateDebate(dv);
	}

	@Override
	public int deleteDebate(String debateNo) {
		// TODO Auto-generated method stub
		return debateDao.deleteDebate(debateNo);
	}

	@Override
	public List<DebateVO> getAllDebates() {
		// TODO Auto-generated method stub
		return debateDao.getAllDebates();
	}

	@Override
	public DebateVO detailDebate(String debateNo) {
		// TODO Auto-generated method stub
		return debateDao.detailDebate(debateNo);
	}

	@Override
	public List<DebateVO> searchBookDebate(String bookTitle) {
		// TODO Auto-generated method stub
		return debateDao.searchBookDebate(bookTitle);
	}

	@Override
	public List<DebateVO> searchTopicDebate(String debateTopic) {
		// TODO Auto-generated method stub
		return debateDao.searchTopicDebate(debateTopic);
	}

	@Override
	public List<DebateVO> searchContentDebate(String debateContent) {
		// TODO Auto-generated method stub
		return debateDao.searchContentDebate(debateContent);
	}

	@Override
	public int countList() {
		// TODO Auto-generated method stub
		return debateDao.countList();
	}

	@Override
	public List<DebateVO> boardList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return debateDao.boardList(map);
	}

}
