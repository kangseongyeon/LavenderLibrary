package kr.or.ddit.book.vo;

import java.time.LocalDate;

public class ReservVO {
	
	private String revNo;
	private String memId;
	private String bookId;
	private LocalDate revDate;
	private int waitCount;
	private String warnYn;
	private String bookName;
	
	
	
	
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
	public int getWaitCount() {
		return waitCount;
	}
	public void setWaitCount(int waitCount) {
		this.waitCount = waitCount;
	}
	public String getRevNo() {
		return revNo;
	}
	public void setRevNo(String revNo) {
		this.revNo = revNo;
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
	public LocalDate getRevDate() {
		return revDate;
	}
	public void setRevDate(LocalDate revDate) {
		this.revDate = revDate;
	}
	
	
	
	@Override
	public String toString() {
		return "ReservVO [revNo=" + revNo + ", memId=" + memId + ", bookId=" + bookId + ", revDate=" + revDate
				+ ", waitCount=" + waitCount + ", warnYn=" + warnYn + ", bookName=" + bookName + "]";
	}
	
	
	
	
	
	
}
