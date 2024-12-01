package kr.or.ddit.vo;

import java.time.LocalDate;

public class CalenderVO {
	
	private String year;
	private String month;
	public CalenderVO(String year, String month) {
		super();
		this.year = year;
		this.month = month;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	@Override
	public String toString() {
		return "CalenderVO [year=" + year + ", month=" + month + "]";
	}
	
	
	
	
	
	
}
