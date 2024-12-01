package kr.or.ddit.vo;

import java.time.LocalDate;

public class NoticeVO {
	private String noticeNo;
	private String noticeTitle;
	private LocalDate noticeDate;
	private String noticeContent;
	private String admId;
	private int pin; 
	
	public NoticeVO() {
		// TODO Auto-generated constructor stub
	}
 
	public NoticeVO(String noticeTitle, String noticeContent) {
		super();
		this.noticeTitle = noticeTitle;
		this.noticeContent = noticeContent;
	}
	
	public NoticeVO(String noticeNo, String noticeTitle, String noticeContent) {
		super();
		this.noticeNo = noticeNo;
		this.noticeTitle = noticeTitle;
		this.noticeContent = noticeContent;
	}
	
	public NoticeVO(String noticeNo, String noticeTitle, LocalDate noticeDate, String noticeContent, String admId) {
		super();
		this.noticeNo = noticeNo;
		this.noticeTitle = noticeTitle;
		this.noticeDate = noticeDate;
		this.noticeContent = noticeContent;
		this.admId = admId;
	}

	public String getNoticeNo() {
		return noticeNo;
	}


	public void setNoticeNo(String noticeNo) {
		this.noticeNo = noticeNo;
	}

	public String getNoticeTitle() {
		return noticeTitle;
	}

	public void setNoticeTitle(String noticeTitle) {
		this.noticeTitle = noticeTitle;
	}

	public LocalDate getNoticeDate() {
		return noticeDate;
	}

	public void setNoticeDate(LocalDate noticeDate) {
		this.noticeDate = noticeDate;
	}

	public String getNoticeContent() {
		return noticeContent;
	}

	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}

	public String getAdmId() {
		return admId;
	}

	public void setAdmId(String admId) {
		this.admId = admId;
	}

	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

	@Override
	public String toString() {
		return "NoticeVO [noticeNo=" + noticeNo + ", noticeTitle=" + noticeTitle + ", noticeDate=" + noticeDate
				+ ", noticeContent=" + noticeContent + ", admId=" + admId + ", pin=" + pin + "]";
	}


}
