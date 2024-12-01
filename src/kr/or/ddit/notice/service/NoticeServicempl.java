package kr.or.ddit.notice.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.notice.dao.INoticeDao;
import kr.or.ddit.notice.dao.NoticeDaoImpl;
import kr.or.ddit.vo.NoticeVO;


public class NoticeServicempl implements INoticeService{

	private static INoticeService noticeService = new NoticeServicempl();
	
	private INoticeDao noticeDao;
	private NoticeServicempl() {
		noticeDao = NoticeDaoImpl.getInstance();
	}
	
	public static INoticeService getInstance() {
		return noticeService;
	}
	@Override
	public int registerNotice(NoticeVO nv) {
		int cnt= noticeDao.insertNotice(nv);
		return cnt;
	}

	@Override
	public int modifyNotice(NoticeVO nv) {
		int cnt= noticeDao.updateNotice(nv);
		return cnt;
	}

	@Override
	public boolean checkNotice(String noticeNo) {
		return noticeDao.checkNotice(noticeNo);
	}

	@Override
	public int removeNotice(String noticeNo) {
		int cnt= noticeDao.deleteNotice(noticeNo);
		return cnt;
	}

	@Override
	public List<NoticeVO> getTotalNotice() {
		List<NoticeVO> noticeList = noticeDao.getAllNotice();
		return noticeList;
	}

	@Override
	public List<NoticeVO> searchNotice(NoticeVO nv) {
		return noticeDao.searchNotice(nv);
	}

	@Override
	public NoticeVO getNotice(String noticeNo) {
		return noticeDao.getNotice(noticeNo);
	}

	@Override
	public int countList() {
		// TODO Auto-generated method stub
		return noticeDao.countList();
	}

	@Override
	public List<NoticeVO> boardList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return noticeDao.boardList(map);
	}

	@Override
	public List<NoticeVO> selectPinNotice() {
		// TODO Auto-generated method stub
		return noticeDao.selectPinNotice();
	}

}
