package kr.or.ddit.vo;

import java.time.LocalDate;

public class BookVideoVO {
	private String bookVideoNo; 
	private String bookVideoTitle; 
	private LocalDate bookVideoDate;
	private String bookVideoContent;
	private String admId; 
	
	public BookVideoVO() {
		// TODO Auto-generated constructor stub
	}
	
	public BookVideoVO(String bookVideoNo, String bookVideoTitle, String bookVideoContent, String admId) {
		super();
		this.bookVideoNo = bookVideoNo;
		this.bookVideoTitle = bookVideoTitle;
		this.bookVideoContent = bookVideoContent;
		this.admId = admId;
	}
	public BookVideoVO(String bookVideoNo, String bookVideoTitle, String bookVideoContent) {
		super();
		this.bookVideoNo = bookVideoNo;
		this.bookVideoTitle = bookVideoTitle;
		this.bookVideoContent = bookVideoContent;
	}
	public BookVideoVO(String bookVideoTitle, String bookVideoContent) {
		super();
		this.bookVideoTitle = bookVideoTitle;
		this.bookVideoContent = bookVideoContent;
	}

	public String getBookVideoNo() {
		return bookVideoNo;
	}

	public void setBookVideoNo(String bookVideoNo) {
		this.bookVideoNo = bookVideoNo;
	}

	public String getBookVideoTitle() {
		return bookVideoTitle;
	}

	public void setBookVideoTitle(String bookVideoTitle) {
		this.bookVideoTitle = bookVideoTitle;
	}

	public LocalDate getBookVideoDate() {
		return bookVideoDate;
	}

	public void setBookVideoDate(LocalDate bookVideoDate) {
		this.bookVideoDate = bookVideoDate;
	}

	public String getBookVideoContent() {
		return bookVideoContent;
	}

	public void setBookVideoContent(String bookVideoContent) {
		this.bookVideoContent = bookVideoContent;
	}

	public String getAdmId() {
		return admId;
	}

	public void setAdmId(String admId) {
		this.admId = admId;
	}

	@Override
	public String toString() {
		return "BookVideoVO [bookVideoNo=" + bookVideoNo + ", bookVideoTitle=" + bookVideoTitle + ", bookVideoDate="
				+ bookVideoDate + ", bookVideoContent=" + bookVideoContent + ", admId=" + admId + "]";
	}
	
	
}
