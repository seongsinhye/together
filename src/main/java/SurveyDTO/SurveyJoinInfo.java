package SurveyDTO;

import java.time.LocalDateTime;

public class SurveyJoinInfo {

	private int surveyIdx;
	private LocalDateTime joinDate;
	private int point;
	
	
	
	
	
	public SurveyJoinInfo(int surveyIdx, LocalDateTime joinDate, int point) {
		super();
		this.surveyIdx = surveyIdx;
		this.joinDate = joinDate;
		this.point = point;
	}


	public int getPoint() {
		return point;
	}


	public void setPoint(int point) {
		this.point = point;
	}


	public SurveyJoinInfo() {
		
	}
	
	
	public SurveyJoinInfo(int surveyIdx, LocalDateTime joinDate) {
		this.surveyIdx = surveyIdx;
		this.joinDate = joinDate;
	}
	public int getSurveyIdx() {
		return surveyIdx;
	}
	public void setSurveyIdx(int surveyIdx) {
		this.surveyIdx = surveyIdx;
	}
	public LocalDateTime getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(LocalDateTime joinDate) {
		this.joinDate = joinDate;
	}
	
	
	
}
