package kr.or.ddit.book.dao;

import java.util.List;
import java.util.Map;

import kr.or.ddit.book.vo.BookVO;
import kr.or.ddit.book.vo.RentalVO;
import kr.or.ddit.book.vo.ReservVO;
import kr.or.ddit.book.vo.WishlistVO;

public interface IBookDao {

	// 책 등록
	public int insertBook(BookVO bv);

	// 책정보 수정
	public int updateBook(BookVO bv);

	// 책정보 삭제(실제 삭제 아니고 delyn을 y로 변경
	public int deleteBook(String bookId);

	// 모든 책 정보 출력
	public List<BookVO> getAllBook();

	// 책 검색
	public List<BookVO> searchBook(BookVO bv);

	// 책 상세보기
	public BookVO getBook(String bookId);

	// 책 예약원수 확인
	public int reservChk(String bookId);

	// 예약확인
	public ReservVO getReserv(ReservVO rv);

	// 예약추가
	public int insertReserv(ReservVO rv);

	// 예약삭제
	public int deleteReserv(String revNo);

	// 회원별 예약목록 출력
	public List<ReservVO> getMemReserv(String memId);

	// 예약 전체 출력
	public List<ReservVO> getAllReserv();

	// 찜확인
	public WishlistVO getWishlist(WishlistVO wv);

	// 찜추가
	public int insertWishlist(WishlistVO wv);

	// 찜삭제
	public int deleteWishlist(String wishlistNo);

	// 회원별 찜목록 출력
	public List<WishlistVO> getMemWishlist(String memId);

	//대여 추가
	public int insertRental(RentalVO rv);
	
	// 대여목록 전체 출력
	public List<RentalVO> getAllRental();

	// 회원별 대여목록 출력
	public List<RentalVO> getMemRental(String memId);

	// 연체 대여목록 출력
	public List<RentalVO> getOverRental();

	// 대여 경고유무 수정
	public int updateWarnYn();
	
	//대여 반납처리(rental테이블)
	public int updateRental(String rentalNo);
	
	//대여 반납처리(book 테이블)
	public int updateBookRental(String bookId);
	
	//조회수 증가
	public int updateViewCnt(String bookId);
	
	//인기도서 목록 출력
	public List<BookVO> getPopularList();
	
	//신규도서 목록 출력
	public List<BookVO> getNewList();
	
	/**
	 * 페이징처리를 위한 전체게시글 개수 찾기 위한 메서드
	 * @return 전체 게시글 수
	 */
	public int countList();

	/**
	 * 페이징처리를 위한 게시글 가져오는 메소드
	 * @param map
	 * @return 원하는 개수만큼의 게시글들
	 */
	public List<BookVO> boardList(Map<String, Object> map);
	
	/**
	 * 페이징처리를 위한 대여도서 개수 찾기 위한 메서드
	 * @return 대여도서 게시글 수
	 */
	public int rentalCountList();

	/**
	 * 페이징처리를 위한 대여여도서 게시글 가져오는 메소드
	 * @param map
	 * @return 원하는 개수만큼의 대여도서 목록
	 */
	public List<RentalVO> rentalBoardList(Map<String, Object> map);
	
	/**
	 * 페이징처리를 위한 연체도서 개수 찾기 위한 메서드
	 * @return 대여도서 게시글 수
	 */
	public int overRentalCountList();
	
	/**
	 * 페이징처리를 위한 연체도서 게시글 가져오는 메소드
	 * @param map
	 * @return 원하는 개수만큼의 대여도서 목록
	 */
	public List<RentalVO> overRentalBoardList(Map<String, Object> map);
	
	/**
	 * 페이징처리를 위한 예약도서 개수 찾기 위한 메서드
	 * @return 예약도서 게시글 수
	 */
	public int reservCountList();
	
	/**
	 * 페이징처리를 위한 예약도서 게시글 가져오는 메소드
	 * @param map
	 * @return 원하는 개수만큼의 예약도서 목록
	 */
	public List<ReservVO> reservBoardList(Map<String, Object> map);
	
	
	/**
	 * 페이징처리를 위한 신작도서 개수 찾기 위한 메서드
	 * @return 예약도서 게시글 수
	 */
	public int newCountList();
	
	/**
	 * 페이징처리를 위한 신작도서 게시글 가져오는 메소드
	 * @param map
	 * @return 원하는 개수만큼의 예약도서 목록
	 */
	public List<BookVO> newBoardList(Map<String, Object> map);
	
	

}
