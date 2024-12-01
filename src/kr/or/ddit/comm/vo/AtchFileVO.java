package kr.or.ddit.comm.vo;

import java.time.LocalDate;
import java.util.List;

public class AtchFileVO {
	
	private long atchFileId=-1; /* 첨부파일ID */
	private LocalDate createDate; /* 생성일시 */
	private String useAt; /* 사용여부 */
	
	private List<AtchFileDetailVO> atchFileDetailList;

	public long getAtchFileId() {
		return atchFileId;
	}

	public void setAtchFileId(long atchFileId) {
		this.atchFileId = atchFileId;
	}

	public LocalDate getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDate createDate) {
		this.createDate = createDate;
	}

	public String getUseAt() {
		return useAt;
	}

	public void setUseAt(String useAt) {
		this.useAt = useAt;
	}

	public List<AtchFileDetailVO> getAtchFileDetailList() {
		return atchFileDetailList;
	}

	public void setAtchFileDetailList(List<AtchFileDetailVO> atchFileDetailList) {
		this.atchFileDetailList = atchFileDetailList;
	}

	@Override
	public String toString() {
		return "AtchFileVO [atchFileId=" + atchFileId + ", createDate=" + createDate + ", useAt=" + useAt
				+ ", atchFileDetailList=" + atchFileDetailList + "]";
	}

		

	
	
	
}
