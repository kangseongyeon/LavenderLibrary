package kr.or.ddit.contest.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.contest.dao.IOneSentenceDao;
import kr.or.ddit.contest.dao.OneSentenceDaoImpl;
import kr.or.ddit.contest.vo.OneSentenceVO;

public class OneSentenceServiceImpl implements IOneSentenceService {

	//싱글톤
	private static IOneSentenceService sentenceService = new OneSentenceServiceImpl();
	
	private IOneSentenceDao sentenceDao;
	
	private OneSentenceServiceImpl() {
		sentenceDao = OneSentenceDaoImpl.getInstace();
	}
	
	public static IOneSentenceService getInstance() {
		return sentenceService;
	}
	
	@Override
	public int insertSentence(OneSentenceVO ov) {
		
		return sentenceDao.insertSentence(ov); 
	}

	@Override
	public int updateSentence(OneSentenceVO ov) {
		
		return sentenceDao.updateSentence(ov);
	}

	@Override
	public int deleteSentence(String senNo) {
		
		return sentenceDao.deleteSentence(senNo);
	}

	@Override
	public List<OneSentenceVO> getAllSentences() {
		
		return sentenceDao.getAllSentences();
	}

	@Override
	public OneSentenceVO detailSentence(String senNo) {
		return sentenceDao.detailSentence(senNo);
	}

	@Override
	public List<OneSentenceVO> searchTitleSentence(String senTitle) {
		return sentenceDao.searchTitleSentence(senTitle);
	}

	@Override
	public List<OneSentenceVO> searchContentSentence(String senContent) {

		return sentenceDao.searchContentSentence(senContent);
	}

	@Override
	public List<OneSentenceVO> searchBookSentense(String bookTitle) {
		return sentenceDao.searchBookSentense(bookTitle);
	}

	@Override
	public List<OneSentenceVO> searchMemSentense(String memId) {
		return sentenceDao.searchMemSentense(memId);
	}

	@Override
	public int countList() {
		// TODO Auto-generated method stub
		return sentenceDao.countList();
	}

	@Override
	public List<OneSentenceVO> boardList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return sentenceDao.boardList(map);
	}



}
