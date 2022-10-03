package SurveyDTO;

import java.time.LocalDateTime;

public class SurveyInfo {
	private int surveyIdx;
	private String surveyTitle;
	private String category;
	private String content;
	private int point;
	private String startDate;
	private String endDate;
	private LocalDateTime writeDate;
	private String img;
	
	
	public SurveyInfo() {
		
	}


	public SurveyInfo(int surveyIdx, String surveyTitle, String category, String content, int point, String startDate,
			String endDate, LocalDateTime writeDate, String img) {
		this.surveyIdx = surveyIdx;
		this.surveyTitle = surveyTitle;
		this.category = category;
		this.content = content;
		this.point = point;
		this.startDate = startDate;
		this.endDate = endDate;
		this.writeDate = writeDate;
		this.img = img;
	}


	public int getSurveyIdx() {
		return surveyIdx;
	}


	public void setSurveyIdx(int surveyIdx) {
		this.surveyIdx = surveyIdx;
	}


	public String getSurveyTitle() {
		return surveyTitle;
	}


	public void setSurveyTitle(String surveyTitle) {
		this.surveyTitle = surveyTitle;
	}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public int getPoint() {
		return point;
	}


	public void setPoint(int point) {
		this.point = point;
	}


	public String getStartDate() {
		return startDate;
	}


	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}


	public String getEndDate() {
		return endDate;
	}


	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}


	public LocalDateTime getWriteDate() {
		return writeDate;
	}


	public void setWriteDate(LocalDateTime writeDate) {
		this.writeDate = writeDate;
	}


	public String getImg() {
		return img;
	}


	public void setImg(String img) {
		this.img = img;
	}
	
	
	
	
	
}
