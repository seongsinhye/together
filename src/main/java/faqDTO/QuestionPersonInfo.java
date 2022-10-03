package faqDTO;

import java.time.LocalDateTime;

public class QuestionPersonInfo {

	private int questionPersinIdx;
	private int memberIdx;
	private String questionText;
	private String answerStatus;
	private LocalDateTime questionDate;
	
	
	public QuestionPersonInfo() {
		
	}


	public QuestionPersonInfo(int questionPersinIdx, int memberIdx, String questionText, String answerStatus,
			LocalDateTime questionDate) {
		super();
		this.questionPersinIdx = questionPersinIdx;
		this.memberIdx = memberIdx;
		this.questionText = questionText;
		this.answerStatus = answerStatus;
		this.questionDate = questionDate;
	}


	public int getQuestionPersinIdx() {
		return questionPersinIdx;
	}


	public void setQuestionPersinIdx(int questionPersinIdx) {
		this.questionPersinIdx = questionPersinIdx;
	}


	public int getMemberIdx() {
		return memberIdx;
	}


	public void setMemberIdx(int memberIdx) {
		this.memberIdx = memberIdx;
	}


	public String getQuestionText() {
		return questionText;
	}


	public void setQuestionText(String questionText) {
		this.questionText = questionText;
	}


	public String getAnswerStatus() {
		return answerStatus;
	}


	public void setAnswerStatus(String answerStatus) {
		this.answerStatus = answerStatus;
	}


	public LocalDateTime getQuestionDate() {
		return questionDate;
	}


	public void setQuestionDate(LocalDateTime questionDate) {
		this.questionDate = questionDate;
	}
	
	
}
