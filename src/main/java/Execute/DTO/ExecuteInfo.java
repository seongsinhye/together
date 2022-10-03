package Execute.DTO;

import java.time.LocalDateTime;

public class ExecuteInfo {
	
	private int memberIdx;
	private int surveyIdx;
	private LocalDateTime joinDate;
	private String answer1;
	private String answer2;
	private String answer3;
	
	public ExecuteInfo() {
		
	}
	
	public ExecuteInfo(int memberIdx, int surveyIdx, LocalDateTime joinDate, String answer1, String answer2,
			String answer3) {
		this.memberIdx = memberIdx;
		this.surveyIdx = surveyIdx;
		this.joinDate = joinDate;
		this.answer1 = answer1;
		this.answer2 = answer2;
		this.answer3 = answer3;
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



	public LocalDateTime getJoinDate() {
		return joinDate;
	}



	public void setJoinDate(LocalDateTime joinDate) {
		this.joinDate = joinDate;
	}



	public String getAnswer1() {
		return answer1;
	}



	public void setAnswer1(String answer1) {
		this.answer1 = answer1;
	}



	public String getAnswer2() {
		return answer2;
	}



	public void setAnswer2(String answer2) {
		this.answer2 = answer2;
	}



	public String getAnswer3() {
		return answer3;
	}



	public void setAnswer3(String answer3) {
		this.answer3 = answer3;
	}
	
	
	
	
}
