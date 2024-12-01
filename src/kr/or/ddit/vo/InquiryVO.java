package kr.or.ddit.vo;

import java.time.LocalDate;

public class InquiryVO {
    private String inqNo; 
    private String inqCategoryCode; 
    private String inqTitle; 
    private LocalDate inqDate; 
    private String inqContent; 
    private String memId;
    private String inqStatus;

	
	public InquiryVO() {
		
	}
	
	
	public InquiryVO(String inqCategoryCode, String inqTitle, String inqContent, String memId) {
		super();
		this.inqCategoryCode = inqCategoryCode;
		this.inqTitle = inqTitle;
		this.inqContent = inqContent;
		this.memId = memId;
	}
	
	public InquiryVO(String inqCategoryCode, String inqTitle, String inqContent, String memId, String inqNo) {
		super();
		this.inqCategoryCode = inqCategoryCode;
		this.inqTitle = inqTitle;
		this.inqContent = inqContent;
		this.memId = memId;
		this.inqNo = inqNo;
	}
	

	public String getInqNo() {
		return inqNo;
	}

	public void setInqNo(String inqNo) {
		this.inqNo = inqNo;
	}

	public String getInqCategoryCode() {
		return inqCategoryCode;
	}

	public void setInqCategoryCode(String inqCategoryCode) {
		this.inqCategoryCode = inqCategoryCode;
	}

	public String getInqTitle() {
		return inqTitle;
	}

	public void setInqTitle(String inqTitle) {
		this.inqTitle = inqTitle;
	}

	public LocalDate getInqDate() {
		return inqDate;
	}

	public void setInqDate(LocalDate inqDate) {
		this.inqDate = inqDate;
	}

	public String getInqContent() {
		return inqContent;
	}

	public void setInqContent(String inqContent) {
		this.inqContent = inqContent;
	}

	public String getMemId() {
		return memId;
	}

	public void setMemId(String memId) {
		this.memId = memId;
	}
	
    public String getInqStatus() {
        return inqStatus;
    }

    public void setInqStatus(String inqStatus) {
        this.inqStatus = inqStatus;
    }


	@Override
	public String toString() {
		return "InquiryVO [inqNo=" + inqNo + ", inqCategoryCode=" + inqCategoryCode + ", inqTitle=" + inqTitle
				+ ", inqDate=" + inqDate + ", inqContent=" + inqContent + ", memId=" + memId + ", inqStatus="
				+ inqStatus + "]";
	}


	
}
