package kr.or.ddit.faq.service;

import java.util.List;

import kr.or.ddit.faq.dao.FaqDaoImpl;
import kr.or.ddit.faq.dao.IFaqDao;
import kr.or.ddit.vo.FaqVO;

public class FaqServiceImpl implements IFaqService {
	private static IFaqService faqService = new FaqServiceImpl();
	
	private IFaqDao faqDao;
	
	private FaqServiceImpl() {
		faqDao = FaqDaoImpl.getInstance();
	}
	
	public static IFaqService getInstance() {
		return faqService;
	}

	@Override
	public int registerFaq(FaqVO fv) {
		int cnt = faqDao.insertFaq(fv);
		return cnt;
	}

	@Override
	public int modifyFaq(FaqVO fv) {
		int cnt = faqDao.updateFaq(fv);
		return cnt;
	}

	@Override
	public boolean checkFaq(String faqNo) {
		return faqDao.checkFaq(faqNo);
	}

	@Override
	public FaqVO getFaq(String faqNo) {
		return faqDao.getFaq(faqNo);
	}

	@Override
	public int removeFaq(String faqNo) {
		int cnt = faqDao.deletFaq(faqNo);
		return cnt;
	}

	@Override
	public List<FaqVO> getTotalFaq() {
		List<FaqVO> faqList = faqDao.getAllFaq();
		return faqList;
	}

	@Override
	public List<FaqVO> searchFaq(FaqVO fv) {
		return faqDao.searchFaq(fv);
	}
}
