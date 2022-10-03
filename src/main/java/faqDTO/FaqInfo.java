package faqDTO;

import java.time.LocalDateTime;

public class FaqInfo {

	private int	faqIdx;
	private String title;
	private String content;
	private LocalDateTime writeDate;
	
	public FaqInfo() {
		
	}

	public FaqInfo(int faqIdx, String title, String content, LocalDateTime writeDate) {
		this.faqIdx = faqIdx;
		this.title = title;
		this.content = content;
		this.writeDate = writeDate;
	}

	public int getFaqIdx() {
		return faqIdx;
	}

	public void setFaqIdx(int faqIdx) {
		this.faqIdx = faqIdx;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public LocalDateTime getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(LocalDateTime writeDate) {
		this.writeDate = writeDate;
	}
	
	
	
	
	
}
