package kr.or.ddit.vo;

import java.time.LocalDate;

public class NewsVO {
	private String newsNo; 
	private String newsTitle; 
	private LocalDate newsDate; 
	private String newsContent;
	private long atchFileId = -1; 
	private String admId;
	
	public NewsVO() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public NewsVO(String newsTitle, String newsContent) {
		super();
		this.newsTitle = newsTitle;
		this.newsContent = newsContent;
	}
	public NewsVO(String newsNo, String newsTitle, String newsContent, long atchFileId) {
		super();
		this.newsNo = newsNo;
		this.newsTitle = newsTitle;
		this.newsContent = newsContent;
		this.atchFileId = atchFileId;
	}


	public NewsVO(String newsNo, String newsTitle, LocalDate newsDate, long atchFileId, String admId) {
		super();
		this.newsNo = newsNo;
		this.newsTitle = newsTitle;
		this.newsDate = newsDate;
		this.atchFileId = atchFileId;
		this.admId = admId;
	}
	
	public String getNewsNo() {
		return newsNo;
	}
	public void setNewsNo(String newsNo) {
		this.newsNo = newsNo;
	}
	public String getNewsTitle() {
		return newsTitle;
	}
	public void setNewsTitle(String newsTitle) {
		this.newsTitle = newsTitle;
	}
	public LocalDate getNewsDate() {
		return newsDate;
	}
	public void setNewsDate(LocalDate newsDate) {
		this.newsDate = newsDate;
	}
	public String getNewsContent() {
		return newsContent;
	}
	public void setNewsContent(String newsContent) {
		this.newsContent = newsContent;
	}
	public long getAtchFileId() {
		return atchFileId;
	}
	public void setAtchFileId(long atchFileId) {
		this.atchFileId = atchFileId;
	}
	public String getAdmId() {
		return admId;
	}
	public void setAdmId(String admId) {
		this.admId = admId;
	}



	@Override
	public String toString() {
		return "NewsVO [newsNo=" + newsNo + ", newsTitle=" + newsTitle + ", newsDate=" + newsDate + ", newsContent="
				+ newsContent + ", atchFileId=" + atchFileId + ", admId=" + admId + "]";
	}
	
	
}
