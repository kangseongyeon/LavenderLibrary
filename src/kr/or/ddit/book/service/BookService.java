package kr.or.ddit.book.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.book.dao.BookDao;
import kr.or.ddit.book.dao.IBookDao;
import kr.or.ddit.book.vo.BookVO;
import kr.or.ddit.book.vo.RentalVO;
import kr.or.ddit.book.vo.ReservVO;
import kr.or.ddit.book.vo.WishlistVO;

public class BookService implements IBookService{

	private static IBookService bookService=new BookService();
	private IBookDao bookDao;
	
	private BookService() {
		bookDao= BookDao.getInstance();
	}
	public static IBookService getInstance() {
		return bookService;
	}
	
	@Override
	public int insertBook(BookVO bv) {
		int cnt=bookDao.insertBook(bv);
		return cnt;
	}

	@Override
	public int updateBook(BookVO bv) {
		int cnt=bookDao.updateBook(bv);
		return cnt;
	}

	@Override
	public int deleteBook(String bookId) {
		int cnt=bookDao.deleteBook(bookId);
		return cnt;
	}

	@Override
	public List<BookVO> getAllBook() {
		List<BookVO> bookList=bookDao.getAllBook();
		return bookList;
	}

	@Override
	public List<BookVO> searchBook(BookVO bv) {
		
		return bookDao.searchBook(bv);
	}
	@Override
	public BookVO getBook(String bookId) {
		
		return bookDao.getBook(bookId);
	}
	@Override
	public int reservChk(String bookId) {
		
		return bookDao.reservChk(bookId);
	}
	@Override
	public ReservVO getReserv(ReservVO rv) {
		return bookDao.getReserv(rv);
	}
	@Override
	public int insertReserv(ReservVO rv) {
		return bookDao.insertReserv(rv);
	}
	@Override
	public int deleteReserv(String revNo) {
		return bookDao.deleteReserv(revNo);
	}
	@Override
	public List<ReservVO> getMemReserv(String memId) {
		return bookDao.getMemReserv(memId);
	}
	@Override
	public List<ReservVO> getAllReserv() {
		return bookDao.getAllReserv();
	}
	@Override
	public WishlistVO getWishlist(WishlistVO wv) {
		return bookDao.getWishlist(wv);
	}
	@Override
	public int insertWishlist(WishlistVO wv) {
		return bookDao.insertWishlist(wv);
	}
	@Override
	public int deleteWishlist(String wishlistNo) {
		return bookDao.deleteWishlist(wishlistNo);
	}
	@Override
	public List<WishlistVO> getMemWishlist(String memId) {
		return bookDao.getMemWishlist(memId);
	}
	@Override
	public List<RentalVO> getAllRental() {
		return bookDao.getAllRental();
	}
	@Override
	public List<RentalVO> getMemRental(String memId) {
		return bookDao.getMemRental(memId);
	}
	@Override
	public List<RentalVO> getOverRental() {
		return bookDao.getOverRental();
	}
	@Override
	public int updateWarnYn() {
		return bookDao.updateWarnYn();
	}
	@Override
	public int updateRental(String rentalNo) {
		return bookDao.updateRental(rentalNo);
	}
	@Override
	public int countList() {
		return bookDao.countList();
	}
	@Override
	public List<BookVO> boardList(Map<String, Object> map) {
		return bookDao.boardList(map);
	}
	@Override
	public int rentalCountList() {
		return bookDao.rentalCountList();
	}
	@Override
	public List<RentalVO> rentalBoardList(Map<String, Object> map) {
		return bookDao.rentalBoardList(map);
	}
	@Override
	public int overRentalCountList() {
		return bookDao.overRentalCountList();
	}
	@Override
	public List<RentalVO> overRentalBoardList(Map<String, Object> map) {
		return bookDao.overRentalBoardList(map);
	}
	@Override
	public int reservCountList() {
		return bookDao.reservCountList();
	}
	@Override
	public List<ReservVO> reservBoardList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return bookDao.reservBoardList(map);
	}
	@Override
	public int updateViewCnt(String bookId) {
		return bookDao.updateViewCnt(bookId);
	}
	@Override
	public List<BookVO> getPopularList() {
		return bookDao.getPopularList();
	}
	@Override
	public List<BookVO> getNewList() {
		return bookDao.getNewList();
	}
	@Override
	public int newCountList() {
		// TODO Auto-generated method stub
		return bookDao.newCountList();
	}
	@Override
	public List<BookVO> newBoardList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return bookDao.newBoardList(map);
	}
	@Override
	public int updateBookRental(String bookId) {
		return bookDao.updateBookRental(bookId);
	}
	@Override
	public int insertRental(RentalVO rv) {
		return bookDao.insertRental(rv);
	}
}
