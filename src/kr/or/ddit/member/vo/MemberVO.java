package kr.or.ddit.member.vo;


public class MemberVO {
	
	private String memId;
	private String memPass;
	private String memName;
	private String memTel;
	private String memEmail;
	private String memBir;
	private String memPostno;
	private String memAddr1;
	private String memAddr2;
	private String adYn; // 광고 수신동의 여부
	private String banYn; /*  */
	private String delYn; /*  */
	private int warnCnt; /*  */
	

	public String getBanYn() {
		return banYn;
	}
	public void setBanYn(String banYn) {
		this.banYn = banYn;
	}
	public String getDelYn() {
		return delYn;
	}
	public void setDelYn(String delYn) {
		this.delYn = delYn;
	}
	public int getWarnCnt() {
		return warnCnt;
	}
	public void setWarnCnt(int warnCnt) {
		this.warnCnt = warnCnt;
	}
	public String getMemId() {
		return memId;
	}
	public void setMemId(String memId) {
		this.memId = memId;
	}
	public String getMemPass() {
		return memPass;
	}
	public void setMemPass(String memPass) {
		this.memPass = memPass;
	}
	public String getMemName() {
		return memName;
	}
	public void setMemName(String memName) {
		this.memName = memName;
	}
	public String getMemTel() {
		return memTel;
	}
	public void setMemTel(String memTel) {
		this.memTel = memTel;
	}
	public String getMemEmail() {
		return memEmail;
	}
	public void setMemEmail(String memEmail) {
		this.memEmail = memEmail;
	}
	public String getMemBir() {
		return memBir;
	}
	public void setMemBir(String memBir) {
		this.memBir = memBir;
	}
	public String getMemPostno() {
		return memPostno;
	}
	public void setMemPostno(String memPostno) {
		this.memPostno = memPostno;
	}
	public String getMemAddr1() {
		return memAddr1;
	}
	public void setMemAddr1(String memAddr1) {
		this.memAddr1 = memAddr1;
	}
	public String getMemAddr2() {
		return memAddr2;
	}
	public void setMemAddr2(String memAddr2) {
		this.memAddr2 = memAddr2;
	}
	public String getAdYn() {
		return adYn;
	}
	public void setAdYn(String adYn) {
		this.adYn = adYn;
	}
	@Override
	public String toString() {
		return "MemberVO [memId=" + memId + ", memPass=" + memPass + ", memName=" + memName + ", memTel=" + memTel
				+ ", memEmail=" + memEmail + ", memBir=" + memBir + ", memPostno=" + memPostno + ", memAddr1="
				+ memAddr1 + ", memAddr2=" + memAddr2 + ", adYn=" + adYn + ", banYn=" + banYn + ", delYn=" + delYn
				+ ", warnCnt=" + warnCnt + "]";
	}

	
	

}
