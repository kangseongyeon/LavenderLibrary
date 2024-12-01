package kr.or.ddit.book.vo;

import java.time.LocalDate;

public class BookVO {
	
	private String bookId;
	private String bookName;
	private String bookWriter;
	private String bookPublisher;
	private String bookRentalYN;
	private String delYN;
	private String bookCategory;
	private String viewCnt;
	private long atchFileId=-1;
	

	private LocalDate regdt;

	public BookVO() {
		
	}
	
	
	public BookVO(String bookName, String bookWriter, String bookPublisher, String bookCategory) {
		this.bookName = bookName;
		this.bookWriter = bookWriter;
		this.bookPublisher = bookPublisher;
		this.bookCategory = bookCategory;
	}

	
	
	
	public String getViewCnt() {
		return viewCnt;
	}


	public void setViewCnt(String viewCnt) {
		this.viewCnt = viewCnt;
	}


	public long getAtchFileId() {
		return atchFileId;
	}

	public void setAtchFileId(long atchFileId) {
		this.atchFileId = atchFileId;
	}

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookWriter() {
		return bookWriter;
	}

	public void setBookWriter(String bookWriter) {
		this.bookWriter = bookWriter;
	}

	public String getBookPublisher() {
		return bookPublisher;
	}

	public void setBookPublisher(String bookPublisher) {
		this.bookPublisher = bookPublisher;
	}

	public String getBookRentalYN() {
		return bookRentalYN;
	}

	public void setBookRentalYN(String bookRentalYN) {
		this.bookRentalYN = bookRentalYN;
	}

	public String getDelYN() {
		return delYN;
	}

	public void setDelYN(String delYN) {
		this.delYN = delYN;
	}

	public String getBookCategory() {
		return bookCategory;
	}

	public void setBookCategory(String bookCategory) {
		this.bookCategory = bookCategory;
	}

	public LocalDate getRegdt() {
		return regdt;
	}

	public void setRegdt(LocalDate regdt) {
		this.regdt = regdt;
	}


	@Override
	public String toString() {
		return "BookVO [bookId=" + bookId + ", bookName=" + bookName + ", bookWriter=" + bookWriter + ", bookPublisher="
				+ bookPublisher + ", bookRentalYN=" + bookRentalYN + ", delYN=" + delYN + ", bookCategory="
				+ bookCategory + ", viewCnt=" + viewCnt + ", atchFileId=" + atchFileId + ", regdt=" + regdt + "]";
	}

	
	
	
	
	
	
	
}
