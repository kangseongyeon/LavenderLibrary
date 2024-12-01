package kr.or.ddit.book.vo;

import java.time.LocalDate;

public class RentalVO {
	private String rentalNo;
	private String memId;
	private String bookId;
	private LocalDate rentalDate;
	private LocalDate returnDate;
	private String returnYn;
	private String bookName;
	private String warnYn;
	
	
	
	
	public String getWarnYn() {
		return warnYn;
	}
	public void setWarnYn(String warnYn) {
		this.warnYn = warnYn;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getRentalNo() {
		return rentalNo;
	}
	public void setRentalNo(String rentalNo) {
		this.rentalNo = rentalNo;
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
	public LocalDate getRentalDate() {
		return rentalDate;
	}
	public void setRentalDate(LocalDate rentalDate) {
		this.rentalDate = rentalDate;
	}
	public LocalDate getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(LocalDate returnDate) {
		this.returnDate = returnDate;
	}
	public String getReturnYn() {
		return returnYn;
	}
	public void setReturnYn(String returnYn) {
		this.returnYn = returnYn;
	}
	
	
	
	
	
	
}
