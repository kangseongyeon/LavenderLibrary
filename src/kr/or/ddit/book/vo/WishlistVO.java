package kr.or.ddit.book.vo;

public class WishlistVO {
	
	private String wishlistNo;
	private String memId;
	private String bookId;
	private String bookName;
	
	
	
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getWishlistNo() {
		return wishlistNo;
	}
	public void setWishlistNo(String wishlistNo) {
		this.wishlistNo = wishlistNo;
	}
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	
	@Override
	public String toString() {
		return "WishlistVO [wishlistNo=" + wishlistNo + ", memId=" + memId + ", bookId=" + bookId + "]";
	}
	
	
}
