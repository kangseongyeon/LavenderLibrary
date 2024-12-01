package kr.or.ddit.bookVideo.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.bookVideo.dao.BookVideoDaoImpl;
import kr.or.ddit.bookVideo.dao.IBookVideoDao;
import kr.or.ddit.vo.BookVideoVO;

public class BookVideoServiceImpl implements IBookVideoService{
	private static IBookVideoService bookService = new BookVideoServiceImpl();
	
	private IBookVideoDao bookVideoDao;
	private BookVideoServiceImpl() {
		bookVideoDao = BookVideoDaoImpl.getInstance();
	}
	
	public static IBookVideoService getInstance() {
		return bookService;
	}

	@Override
	public int registerBookVideo(BookVideoVO bv) {
		int cnt = bookVideoDao.insertBookVideo(bv);
		return cnt;
	}

	@Override
	public int modifyBookVideo(BookVideoVO bv) {
		int cnt = bookVideoDao.updateBookVideo(bv);
		return cnt;
	}

	@Override
	public boolean checkBookVideo(String bookVideoNo) {
		return bookVideoDao.checkBookVideo(bookVideoNo);
	}

	@Override
	public BookVideoVO getBookVideo(String bookVideoNo) {
		return bookVideoDao.getBookVideo(bookVideoNo);
	}

	@Override
	public int removeBookVideo(String bookVideoNo) {
		int cnt = bookVideoDao.deletBookVideo(bookVideoNo);
		return cnt;
	}

	@Override
	public List<BookVideoVO> getTotalBookVideo() {
		List<BookVideoVO> bookVideoList = bookVideoDao.getAllBookVideo();
		return bookVideoList;
	}

	@Override
	public List<BookVideoVO> searchBookVideo(BookVideoVO bv) {
		return bookVideoDao.searchBookVideo(bv);
	}

	@Override
	public int countList() {
		// TODO Auto-generated method stub
		return bookVideoDao.countList();
	}

	@Override
	public List<BookVideoVO> boardList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return bookVideoDao.boardList(map);
	}
}
