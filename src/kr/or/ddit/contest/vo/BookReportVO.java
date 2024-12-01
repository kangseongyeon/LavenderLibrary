package kr.or.ddit.contest.vo;

import java.time.LocalDate;


public class BookReportVO {
	
	private String rptNo; /* 독후감번호 */
	private String rptTitle; /* 제목 */
	private LocalDate rptDate; /* 작성날짜 */
	private String rptContent; /* 내용 */
	private String memId; /* 회원ID */
	private String bookTitle; /* 도서명 */
	private long atchFileId=-1; /* 첨부파일ID */
	
	
	
	//기본 생성
	public BookReportVO() {
		
	}
	
	
	
	public BookReportVO(String rptNo, String rptTitle, String rptContent) {
		super();
		this.rptNo = rptNo;
		this.rptTitle = rptTitle;
		this.rptContent = rptContent;
	}



	public BookReportVO(String rptTitle, String rptContent, String memId, String bookTitle) {
		super();
		this.rptTitle = rptTitle;
		this.rptContent = rptContent;
		this.memId = memId;
		this.bookTitle = bookTitle;
	}
	
	
	
	
	public String getRptNo() {
		return rptNo;
	}
	public void setRptNo(String rptNo) {
		this.rptNo = rptNo;
	}
	public String getRptTitle() {
		return rptTitle;
	}
	public void setRptTitle(String rptTitle) {
		this.rptTitle = rptTitle;
	}
	public LocalDate getRptDate() {
		return rptDate;
	}
	public void setRptDate(LocalDate rptDate) {
		this.rptDate = rptDate;
	}
	public String getRptContent() {
		return rptContent;
	}
	public void setRptContent(String rptContent) {
		this.rptContent = rptContent;
	}
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}

	
	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public long getAtchFileId() {
		return atchFileId;
	}

	public void setAtchFileId(long atchFileId) {
		this.atchFileId = atchFileId;
	}

	@Override
	public String toString() {
		return "BookReportVO [rptNo=" + rptNo + ", rptTitle=" + rptTitle + ", rptDate=" + rptDate + ", rptContent="
				+ rptContent + ", memId=" + memId + ", bookId=" + bookTitle + ", atchFileId=" + atchFileId + "]";
	}
	

}
