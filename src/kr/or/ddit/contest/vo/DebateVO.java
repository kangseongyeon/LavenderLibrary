package kr.or.ddit.contest.vo;
import java.time.LocalDate;


public class DebateVO {
	
	private String debateNo; /* 토론번호 */
	private String bookTitle; /* 도서명 */
	private String debateTopic; /* 토론주제 */
	private LocalDate debateDate; /* 날짜 */
	private String admId; /* 관리자ID */
	private String debateContent; /* 토론내용 */
	
	
	
	public DebateVO() {
	}
	
	
	public DebateVO(String bookTitle, String debateTopic, String debateContent) {
		super();
		this.bookTitle = bookTitle;
		this.debateTopic = debateTopic;
		this.debateContent = debateContent;
	}


	public DebateVO(String debateNo, String bookTitle, String debateTopic, String debateContent) {
		this.debateNo = debateNo;
		this.bookTitle = bookTitle;
		this.debateTopic = debateTopic;
		this.debateContent = debateContent;
	}
	public String getDebateContent() {
		return debateContent;
	}
	public void setDebateContent(String debateContent) {
		this.debateContent = debateContent;
	}
	public String getDebateNo() {
		return debateNo;
	}
	public void setDebateNo(String debateNo) {
		this.debateNo = debateNo;
	}
	
	
	public String getBookTitle() {
		return bookTitle;
	}
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}
	public String getDebateTopic() {
		return debateTopic;
	}
	public void setDebateTopic(String debateTopic) {
		this.debateTopic = debateTopic;
	}
	public LocalDate getDebateDate() {
		return debateDate;
	}
	public void setDebateDate(LocalDate debateDate) {
		this.debateDate = debateDate;
	}
	public String getAdmId() {
		return admId;
	}
	public void setAdmId(String admId) {
		this.admId = admId;
	}
	
	@Override
	public String toString() {
		return "DebateVO [debateNo=" + debateNo + ", bookTitle=" + bookTitle + ", debateTopic=" + debateTopic
				+ ", debateDate=" + debateDate + ", admId=" + admId + ", debateContent=" + debateContent + "]";
	}
	



	
	
	
	

}
