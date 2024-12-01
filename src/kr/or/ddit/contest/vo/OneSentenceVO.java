package kr.or.ddit.contest.vo;

import java.time.LocalDate;

public class OneSentenceVO {
	
	private String senNo; /* 문장번호 */
	private String senTitle; /* 문장제목 */
	private LocalDate senDate; /* 작성날짜 */
	private String senContent; /* 내용 */
	private String memId; /* 회원ID */
	private String bookTitle; /* 도서명 */
	
	
	
	
	public OneSentenceVO() {
	}
	
	
	
	
	public OneSentenceVO(String senNo, String senTitle, String senContent) {
		this.senNo = senNo;
		this.senTitle = senTitle;
		this.senContent = senContent;
	}




	public OneSentenceVO(String senTitle, String senContent, String memId, String bookTitle) {
		this.senTitle = senTitle;
		this.senContent = senContent;
		this.memId = memId;
		this.bookTitle = bookTitle;
	}
	
	public String getSenNo() {
		return senNo;
	}
	public void setSenNo(String senNo) {
		this.senNo = senNo;
	}
	public String getSenTitle() {
		return senTitle;
	}
	public void setSenTitle(String senTitle) {
		this.senTitle = senTitle;
	}
	public LocalDate getSenDate() {
		return senDate;
	}
	public void setSenDate(LocalDate senDate) {
		this.senDate = senDate;
	}
	public String getSenContent() {
		return senContent;
	}
	public void setSenContent(String senContent) {
		this.senContent = senContent;
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
	@Override
	public String toString() {
		return "OneSentenceVO [senNo=" + senNo + ", senTitle=" + senTitle + ", senDate=" + senDate + ", senContent="
				+ senContent + ", memId=" + memId + ", bookTitle=" + bookTitle + "]";
	}


	
	
	

}
