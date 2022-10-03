package Execute.DTO;

import java.time.LocalDateTime;

public class GetPointInfo {

	private int pointNumber;
	private int memberIdx;
	private int surveyIdx;
	private int getPoint;
	private LocalDateTime getPointDate;
	
	
	public GetPointInfo(int pointNumber, int memberIdx, int surveyIdx, int getPoint, LocalDateTime getPointDate) {
		this.pointNumber = pointNumber;
		this.memberIdx = memberIdx;
		this.surveyIdx = surveyIdx;
		this.getPoint = getPoint;
		this.getPointDate = getPointDate;
	}


	public int getPointNumber() {
		return pointNumber;
	}


	public void setPointNumber(int pointNumber) {
		this.pointNumber = pointNumber;
	}


	public int getMemberIdx() {
		return memberIdx;
	}


	public void setMemberIdx(int memberIdx) {
		this.memberIdx = memberIdx;
	}


	public int getSurveyIdx() {
		return surveyIdx;
	}


	public void setSurveyIdx(int surveyIdx) {
		this.surveyIdx = surveyIdx;
	}


	public int getGetPoint() {
		return getPoint;
	}


	public void setGetPoint(int getPoint) {
		this.getPoint = getPoint;
	}


	public LocalDateTime getGetPointDate() {
		return getPointDate;
	}


	public void setGetPointDate(LocalDateTime getPointDate) {
		this.getPointDate = getPointDate;
	}
	
	
	
	
	
}
