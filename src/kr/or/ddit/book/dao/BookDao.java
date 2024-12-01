package kr.or.ddit.book.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import kr.or.ddit.book.vo.BookVO;
import kr.or.ddit.book.vo.RentalVO;
import kr.or.ddit.book.vo.ReservVO;
import kr.or.ddit.book.vo.WishlistVO;
import kr.or.ddit.util.MyBatisUtil;
import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;

public class BookDao implements IBookDao {

	private static IBookDao bookDao=new BookDao();
	
	private BookDao() {
		
	}
	
	public static IBookDao getInstance() {
		return bookDao;
	}
	
	
	@Override
	public int insertBook(BookVO bv) {
		SqlSession session = MyBatisUtil.getSQLSession();
		int cnt=0;
		try {
			cnt=session.insert("book.insertBook",bv);
			if(cnt>0) {
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
	public int updateBook(BookVO bv) {
		SqlSession session = MyBatisUtil.getSQLSession();
		int cnt=0;
		try {
			cnt=session.update("book.updateBook",bv);
			if(cnt>0) {
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
	public int deleteBook(String bookId) {
		SqlSession session = MyBatisUtil.getSQLSession();
		int cnt=0;
		try {
			cnt=session.delete("book.deleteBook",bookId);
			
			if(cnt>0) {
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
	public List<BookVO> getAllBook() {
		List<BookVO> bookList=new ArrayList<BookVO>();
		SqlSession session = MyBatisUtil.getSQLSession(true);
		
		try {
			bookList=session.selectList("book.selectAllBook");
		} catch (PersistenceException e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return bookList;
	}

	@Override
	public List<BookVO> searchBook(BookVO bv) {
		List<BookVO> bookList=new ArrayList<BookVO>();
		SqlSession session = MyBatisUtil.getSQLSession(true);
		
		try {
			bookList=session.selectList("book.searchBook",bv);
		} catch (PersistenceException e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return bookList;
	}

	@Override
	public BookVO getBook(String bookId) {
		BookVO bv=null;
		SqlSession session = MyBatisUtil.getSQLSession(true);
		
		try {
			bv=session.selectOne("book.getBook", bookId);
		} catch (PersistenceException e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return bv;
	}

	@Override
	public int reservChk(String bookId) {
		int cnt=0;
		SqlSession session = MyBatisUtil.getSQLSession(true);
		
		try {
			cnt=session.selectOne("book.reservChk", bookId);
			if(cnt>0) {
				session.commit();
			}
		}  catch (PersistenceException e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return cnt;
	}

	@Override
	public ReservVO getReserv(ReservVO rv) {
		
		ReservVO rv2=null;
		SqlSession session = MyBatisUtil.getSQLSession(true);
		
		try {
			rv2=session.selectOne("book.getReserv", rv);
		} catch (PersistenceException e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return rv2;
	}

	@Override
	public int insertReserv(ReservVO rv) {
		int cnt=0;
		SqlSession session = MyBatisUtil.getSQLSession(true);
		
		try {
			cnt=session.insert("book.insertReserv", rv);
			if(cnt>0) {
				session.commit();
			}
		}  catch (PersistenceException e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return cnt;
	}

	@Override
	public int deleteReserv(String revNo) {
		int cnt=0;
		SqlSession session = MyBatisUtil.getSQLSession(true);
		
		try {
			cnt=session.delete("book.deleteReserv", revNo);
			if(cnt>0) {
				session.commit();
			}
		}  catch (PersistenceException e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return cnt;
	}

	@Override
	public List<ReservVO> getMemReserv(String memId) {
		List<ReservVO> revList=new ArrayList<ReservVO>();
		SqlSession session = MyBatisUtil.getSQLSession(true);
		
		try {
			revList=session.selectList("book.getMemReserv",memId);
		} catch (PersistenceException e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return revList;
	}

	@Override
	public List<ReservVO> getAllReserv() {
		List<ReservVO> revList=new ArrayList<ReservVO>();
		SqlSession session = MyBatisUtil.getSQLSession(true);
		
		try {
			revList=session.selectList("book.getAllReserv");
		} catch (PersistenceException e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return revList;
	}

	@Override
	public WishlistVO getWishlist(WishlistVO wv) {
		WishlistVO wv2=null;
		SqlSession session = MyBatisUtil.getSQLSession(true);
		
		try {
			wv2=session.selectOne("book.getWishlist", wv);
		} catch (PersistenceException e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return wv2;
	}

	@Override
	public int insertWishlist(WishlistVO wv) {
		int cnt=0;
		SqlSession session = MyBatisUtil.getSQLSession(true);
		
		try {
			cnt=session.insert("book.insertWishlist", wv);
			if(cnt>0) {
				session.commit();
			}
		}  catch (PersistenceException e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return cnt;
	}

	@Override
	public int deleteWishlist(String wishlistNo) {
		int cnt=0;
		SqlSession session = MyBatisUtil.getSQLSession(true);
		
		try {
			cnt=session.delete("book.deleteWishlist", wishlistNo);
			if(cnt>0) {
				session.commit();
			}
		}  catch (PersistenceException e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return cnt;
	}

	@Override
	public List<WishlistVO> getMemWishlist(String memId) {
		List<WishlistVO> wishList=new ArrayList<WishlistVO>();
		SqlSession session = MyBatisUtil.getSQLSession(true);
		
		try {
			wishList=session.selectList("book.getMemWishlist",memId);
		} catch (PersistenceException e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return wishList;
	}

	@Override
	public List<RentalVO> getAllRental() {
		
		List<RentalVO> rentalList=new ArrayList<RentalVO>();
		SqlSession session = MyBatisUtil.getSQLSession(true);
		
		try {
			rentalList=session.selectList("book.getAllRental");
		} catch (PersistenceException e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return rentalList;
	}

	@Override
	public List<RentalVO> getMemRental(String memId) {
		
		List<RentalVO> rentalList=new ArrayList<RentalVO>();
		SqlSession session = MyBatisUtil.getSQLSession(true);
		
		try {
			rentalList=session.selectList("book.getMemRental",memId);
		} catch (PersistenceException e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return rentalList;
	}

	@Override
	public List<RentalVO> getOverRental() {
		List<RentalVO> rentalList=new ArrayList<RentalVO>();
		SqlSession session = MyBatisUtil.getSQLSession(true);
		
		try {
			rentalList=session.selectList("book.getOverRental");
		} catch (PersistenceException e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return rentalList;
	}

	@Override
	public int updateWarnYn() {
		SqlSession session = MyBatisUtil.getSQLSession();
		int cnt=0;
		try {
			cnt=session.update("book.updateWarnYn");
			if(cnt>0) {
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
	public int updateRental(String rentalNo) {
		SqlSession session = MyBatisUtil.getSQLSession();
		int cnt=0;
		try {
			cnt=session.update("book.updateRental",rentalNo);
			if(cnt>0) {
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
	public int countList() {
		int cnt  = 0;
		SqlSession session = MyBatisUtil.getSQLSession();
		
		try {
			cnt = session.selectOne("book.countList");
			
		} catch (PersistenceException e) {
			throw new RuntimeException("데이터 조회 중 예외 발생",e);
		} finally {
			session.close();
		}
		
		return cnt;
	}

	@Override
	public List<BookVO> boardList(Map<String, Object> map) {
		List<BookVO> list= null;
		
		SqlSession session = MyBatisUtil.getSQLSession();
		try {
			list = session.selectList("book.boardList", map);
		} catch (Exception e) {
			throw new RuntimeException("데이터 조회 중 예외 발생",e); 
		} finally{
			session.close();
		}			
		return list;
	}
	
	@Override
	public int rentalCountList() {
		int cnt  = 0;
		SqlSession session = MyBatisUtil.getSQLSession();
		
		try {
			cnt = session.selectOne("book.rentalCountList");
			
		} catch (PersistenceException e) {
			throw new RuntimeException("데이터 조회 중 예외 발생",e);
		} finally {
			session.close();
		}
		
		return cnt;
	}

	@Override
	public List<RentalVO> rentalBoardList(Map<String, Object> map) {
		List<RentalVO> list= null;
		
		SqlSession session = MyBatisUtil.getSQLSession();
		try {
			list = session.selectList("book.rentalBoardList", map);
		} catch (Exception e) {
			throw new RuntimeException("데이터 조회 중 예외 발생",e); 
		} finally{
			session.close();
		}			
		return list;
	}
	
	@Override
	public int overRentalCountList() {
		int cnt  = 0;
		SqlSession session = MyBatisUtil.getSQLSession();
		
		try {
			cnt = session.selectOne("book.overRentalCountList");
			
		} catch (PersistenceException e) {
			throw new RuntimeException("데이터 조회 중 예외 발생",e);
		} finally {
			session.close();
		}
		
		return cnt;
	}

	@Override
	public List<RentalVO> overRentalBoardList(Map<String, Object> map) {
		List<RentalVO> list= null;
		
		SqlSession session = MyBatisUtil.getSQLSession();
		try {
			list = session.selectList("book.overRentalBoardList", map);
		} catch (Exception e) {
			throw new RuntimeException("데이터 조회 중 예외 발생",e); 
		} finally{
			session.close();
		}			
		return list;
	}
	
	@Override
	public int reservCountList() {
		int cnt  = 0;
		SqlSession session = MyBatisUtil.getSQLSession();
		
		try {
			cnt = session.selectOne("book.reservCountList");
			
		} catch (PersistenceException e) {
			throw new RuntimeException("데이터 조회 중 예외 발생",e);
		} finally {
			session.close();
		}
		
		return cnt;
	}

	@Override
	public List<ReservVO> reservBoardList(Map<String, Object> map) {
		List<ReservVO> list= null;
		
		SqlSession session = MyBatisUtil.getSQLSession();
		try {
			list = session.selectList("book.reservBoardList", map);
		} catch (Exception e) {
			throw new RuntimeException("데이터 조회 중 예외 발생",e); 
		} finally{
			session.close();
		}			
		return list;// TODO Auto-generated method stub
	}

	@Override
	public int updateViewCnt(String bookId) {
		SqlSession session = MyBatisUtil.getSQLSession();
		int cnt=0;
		try {
			cnt=session.update("book.updateViewCnt",bookId);
			if(cnt>0) {
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
	public List<BookVO> getPopularList() {
		List<BookVO> bookList=new ArrayList<BookVO>();
		SqlSession session = MyBatisUtil.getSQLSession(true);
		
		try {
			bookList=session.selectList("book.getPopularList");
		} catch (PersistenceException e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return bookList;
	}

	@Override
	public List<BookVO> getNewList() {
		List<BookVO> bookList=new ArrayList<BookVO>();
		SqlSession session = MyBatisUtil.getSQLSession(true);
		
		try {
			bookList=session.selectList("book.getNewList");
		} catch (PersistenceException e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return bookList;
	}

	@Override
	public int newCountList() {
		int cnt  = 0;
		SqlSession session = MyBatisUtil.getSQLSession();
		
		try {
			cnt = session.selectOne("book.newCountList");
			
		} catch (PersistenceException e) {
			throw new RuntimeException("데이터 조회 중 예외 발생",e);
		} finally {
			session.close();
		}
		
		return cnt;
	}

	@Override
	public List<BookVO> newBoardList(Map<String, Object> map) {
		List<BookVO> list= null;
		
		SqlSession session = MyBatisUtil.getSQLSession();
		try {
			list = session.selectList("book.newBoardList", map);
		} catch (Exception e) {
			throw new RuntimeException("데이터 조회 중 예외 발생",e); 
		} finally{
			session.close();
		}			
		return list;
	}

	@Override
	public int updateBookRental(String bookId) {
		SqlSession session = MyBatisUtil.getSQLSession();
		int cnt=0;
		try {
			cnt=session.update("book.updateBookRental",bookId);
			if(cnt>0) {
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
	public int insertRental(RentalVO rv) {
		SqlSession session = MyBatisUtil.getSQLSession();
		int cnt=0;
		try {
			cnt=session.insert("book.insertRental",rv);
			if(cnt>0) {
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




}
