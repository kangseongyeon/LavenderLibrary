package kr.or.ddit.vo;

import java.time.LocalDate;

public class AnswerVO {
	private String admId; 
	private String inqNo; 
	private String answerTitle; 
	private String answerContent; 
	private LocalDate answerDate;
	
	public AnswerVO() {
		
	}
	
	public AnswerVO(String answerTitle, String answerContent, String inqNo) {
		super();
		this.answerTitle = answerTitle;
		this.answerContent = answerContent;
		this.inqNo = inqNo;
	}

	public String getAdmId() {
		return admId;
	}
	public void setAdmId(String admId) {
		this.admId = admId;
	}
	public String getInqNo() {
		return inqNo;
	}
	public void setInqNo(String inqNo) {
		this.inqNo = inqNo;
	}
	public String getAnswerTitle() {
		return answerTitle;
	}
	public void setAnswerTitle(String answerTitle) {
		this.answerTitle = answerTitle;
	}
	public String getAnswerContent() {
		return answerContent;
	}
	public void setAnswerContent(String answerContent) {
		this.answerContent = answerContent;
	}
	public LocalDate getAnswerDate() {
		return answerDate;
	}
	public void setAnswerDate(LocalDate answerDate) {
		this.answerDate = answerDate;
	}
	@Override
	public String toString() {
		return "AnswerVO [admId=" + admId + ", inqNo=" + inqNo + ", answerTitle=" + answerTitle + ", answerContent="
				+ answerContent + ", answerDate=" + answerDate + "]";
	}
	
}
