package kr.or.ddit.vo;

public class InqCategoryVO {
    private String inqCategoryCode;
    private String categoryName;

    // 기본 생성자
    public InqCategoryVO() {
    }

    // 생성자
    public InqCategoryVO(String inqCategoryCode, String categoryName) {
        this.inqCategoryCode = inqCategoryCode;
        this.categoryName = categoryName;
    }

    // getter 및 setter 메서드
    public String getInqCategoryCode() {
        return inqCategoryCode;
    }

    public void setInqCategoryCode(String inqCategoryCode) {
        this.inqCategoryCode = inqCategoryCode;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

	@Override
	public String toString() {
		return "InqCategoryVO [inqCategoryCode=" + inqCategoryCode + ", categoryName=" + categoryName + "]";
	}
    
    
}
