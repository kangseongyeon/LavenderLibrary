package kr.or.ddit.inquiry.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.answer.dao.IAnswerDao;
import kr.or.ddit.answer.service.AnswerServiceImpl;
import kr.or.ddit.answer.service.IAnswerService;
import kr.or.ddit.inquiry.dao.IInquiryDao;
import kr.or.ddit.inquiry.dao.InquiryDaoImpl;
import kr.or.ddit.vo.InquiryVO;

public class InquiryServiceImpl implements IInquiryService{
	private static IInquiryService inquiryService = new InquiryServiceImpl();
	
	private IInquiryDao inquiryDao;
	private IAnswerDao answerDao;
	
	private InquiryServiceImpl() {
		inquiryDao = InquiryDaoImpl.getInstance();
	}
	
	public static IInquiryService getInstance() {
		return inquiryService;
	}

	@Override
	public int registerInquiry(InquiryVO iv) {
		int cnt = inquiryDao.insertInquiry(iv);
		return cnt;
	}

	@Override
	public int modifyInquiry(InquiryVO iv) {
		int cnt = inquiryDao.updateInquiry(iv);
		return cnt;
	}

	@Override
	public boolean checkInquiry(String inquiryNo) {
		return inquiryDao.checkInquiry(inquiryNo);
	}

	@Override
	public InquiryVO getInquiry(String inquiryNo) {
		return inquiryDao.getInquiry(inquiryNo);
	}

	@Override
	public int removeInquiry(String inquiryNo) {
		int cnt = inquiryDao.deleteInquiry(inquiryNo);
		return cnt;
	}

	@Override
	public List<InquiryVO> getTotalInquiry() {
		List<InquiryVO> inquiryList = inquiryDao.selectAllInquiry();
		return inquiryList;
	}

	@Override
	public List<InquiryVO> searchInquiry(InquiryVO iv) {
		return inquiryDao.searchInquiry(iv);
	}

	@Override
	public int removeAllAnswers(String inqNo) {
		return answerDao.deleteAnswersByInquiryNo(inqNo);
	}

	@Override
	public List<InquiryVO> getInquiryList() {
		return inquiryDao.getInquiryList();
	}

	@Override
	public int countList() {
		// TODO Auto-generated method stub
		return inquiryDao.countList();
	}

	@Override
	public List<InquiryVO> boardList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return inquiryDao.boardList(map);
	}
}
