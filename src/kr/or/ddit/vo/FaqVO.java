package kr.or.ddit.vo;

import java.time.LocalDate;

public class FaqVO {
	private String faqNo; 
	private String faqQuestion; 
	private String faqAnswer; 
	private LocalDate faqDate; 
	private String admId; 
	
	public FaqVO() {
		// TODO Auto-generated constructor stub
	}

	public FaqVO(String faqQuestion, String faqAnswer) {
		super();
		this.faqQuestion = faqQuestion;
		this.faqAnswer = faqAnswer;
	}
	
	public FaqVO(String faqNo, String faqQuestion, String faqAnswer) {
		super();
		this.faqNo = faqNo;
		this.faqQuestion = faqQuestion;
		this.faqAnswer = faqAnswer;
	}
	
	public FaqVO(String faqNo, String faqQuestion, String faqAnswer, LocalDate faqDate, String admId) {
		super();
		this.faqNo = faqNo;
		this.faqQuestion = faqQuestion;
		this.faqAnswer = faqAnswer;
		this.faqDate = faqDate;
		this.admId = admId;
	}

	public String getFaqNo() {
		return faqNo;
	}

	public void setFaqNo(String faqNo) {
		this.faqNo = faqNo;
	}

	public String getFaqQuestion() {
		return faqQuestion;
	}

	public void setFaqQuestion(String faqQuestion) {
		this.faqQuestion = faqQuestion;
	}

	public String getFaqAnswer() {
		return faqAnswer;
	}

	public void setFaqAnswer(String faqAnswer) {
		this.faqAnswer = faqAnswer;
	}

	public LocalDate getFaqDate() {
		return faqDate;
	}

	public void setFaqDate(LocalDate faqDate) {
		this.faqDate = faqDate;
	}

	public String getAdmId() {
		return admId;
	}

	public void setAdmId(String admId) {
		this.admId = admId;
	}

	@Override
	public String toString() {
		return "FaqVO [faqNo=" + faqNo + ", faqQuestion=" + faqQuestion + ", faqAnswer=" + faqAnswer + ", faqDate="
				+ faqDate + ", admId=" + admId + "]";
	}
	
	
	
	
}
