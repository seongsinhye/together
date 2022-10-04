package FaqService;

import java.util.List;

import FaqDAO.FaqInfoDao;
import SurveyDAO.SurveyInfoDao;
import faqDTO.FaqInfo;
import faqDTO.QuestionPersonInfo;

public class FaqService {
	
	// faq 정보 가져오기 
	public FaqInfo getFaqInfo(int faqIdx) {
		FaqInfoDao dao = new FaqInfoDao();
		
		FaqInfo faqInfo = dao.getFaqInfo(faqIdx);
		
		return faqInfo;
	}
	
	// faq 삭제하기 
	public boolean deleteFaq(int faqIdx) {
		FaqInfoDao dao = new FaqInfoDao();
		
		
		return dao.faqDelete(faqIdx);
	}
	
	// faq 총 개수 가져오기 
	public int getFaqAmount() {
		FaqInfoDao dao = new FaqInfoDao();
		
		// DAO를 통해서 등록된 설문조사 수를 가져옴 
		int amount = dao.getFaqAmount();
		
		return amount;
	}
	
	// faq List로 가져오기 
	public List<FaqInfo> getFaqInfoList(int pageNumber) {
		pageNumber = (pageNumber - 1) * 8;
		
		FaqInfoDao dao = new FaqInfoDao();
		
		// DAO 통해서 페이지 번호에 맞는 설문조사를 가져옴 
		List<FaqInfo> faqInfoList = dao.getFaqInfoList(pageNumber);
		
		return faqInfoList;
		
	}
	
	
	public boolean updateQPerson(int faqIdx, FaqInfo faqInfo) {
		FaqInfoDao dao = new FaqInfoDao();

		return dao.updateFaq(faqIdx, faqInfo);
		
	}
//	
//	public boolean answerQPerson(int questionPersonIdx, String answerStatus, String answerText) {
//		
//		FaqInfoDao dao = new FaqInfoDao();
//		
//		return dao.answerQPerson(questionPersonIdx, answerStatus, answerText);
//		
//	}
//
//	public boolean addQPerson(QuestionPersonInfo qpi) {
//		
//		FaqInfoDao dao = new FaqInfoDao();
//		
//		
//		// 답변 상태 jsp로 0일때 답변대기 1로 바꿔서 답변 완료로 바꾸기 
//		
//		return dao.addQPerson(qpi);
//		
//		
//	}
	
	// faq 추가하기 
	public boolean addFaq(FaqInfo faqInfo) {
		
		FaqInfoDao dao = new FaqInfoDao();
		
		return dao.addFaq(faqInfo);
	}
}
