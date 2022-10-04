package SurveyService;
import java.io.File;

import SurveyDAO.MngSurveyInfoDao;
import SurveyDAO.SurveyInfoDao;
import SurveyDTO.AnswerInfo;
import SurveyDTO.QuestionInfo;
import SurveyDTO.SurveyInfo;

public class MngSurveyService {
	
	// 이미지 추가힉 
	public boolean addImg(int surveyIdx, String img) {
		MngSurveyInfoDao dao = new MngSurveyInfoDao();
		
		return dao.updateImg(surveyIdx, img);
	}
	
	// 이미지 삭제하기 
	public boolean deleteImg(int surveyIdx, String realPath) {
		MngSurveyInfoDao dao = new MngSurveyInfoDao();
		
		SurveyInfo surveyInfo = dao.getSurveyIdxReturnSurInfo(surveyIdx);
		
		String img = surveyInfo.getImg();
		
		File file = new File(realPath + img);
		
		
		if(file.delete()) {
			// 이미지 삭제시 null로 바꾸기 
			dao.setImgNull(surveyIdx);
			return true;
		}else {
			return false;
		}
		
	}
	
	// 질문과 답변 지우기 
	public boolean questionAndAnswerDelete(int surveyIdx) {
		
		MngSurveyInfoDao dao = new MngSurveyInfoDao();
		
		// 답 먼저 지우기 
		return dao.answerDelete(surveyIdx);
		
		
	}
//	public boolean questionDelete(int surveyIdx) {
//		
//		MngSurveyInfoDao dao = new MngSurveyInfoDao();
//		
//		// 답 먼저 지우기 
//		return dao.questionDelete(surveyIdx);
//		
//		
//	}
	
	// 설문조사 삭제하기 
	public boolean surveyDelete(int surveyIdx, String realPath) {
		
		MngSurveyInfoDao dao = new MngSurveyInfoDao();
		
		SurveyInfoDao daoTwo = new SurveyInfoDao();
		
		SurveyInfo surveyInfo = daoTwo.getSurveyInfo(surveyIdx);
		if(surveyInfo.getImg() != null) {
			File file = new File(realPath + surveyInfo.getImg());
			file.delete();
		}
		 dao.surveyDelete(surveyIdx);
		 
		 return true;
	}
	
	
	public boolean faqDelete(int faqIdx) {
		
		
		 return true;
	}
	
	// 설문조사 수정하기 
	public boolean update(SurveyInfo updateSurveyInfo) {
		
		MngSurveyInfoDao dao = new MngSurveyInfoDao();
		
		return dao.update(updateSurveyInfo);
		
	}

	// 설문조사 추가하기 
	public int insert(SurveyInfo newSurveyInfo) {
		
		MngSurveyInfoDao dao = new MngSurveyInfoDao();
		
		// pstmt로 insert한 데이터의 idx(AutoIncrement)를 가져오는 방법
		return dao.insertAndSelectIdx(newSurveyInfo);
		
	}
	
	


	// 설문조사 idx가져오기 
	public int selectSurveyIdx(int surveyIdx) {
		
		MngSurveyInfoDao dao = new MngSurveyInfoDao();
		
		int selectedSurveyIdx = dao.getSurveyIdx(surveyIdx);
		
		return selectedSurveyIdx;
		
		
	}
	// 질문 idx 가져오기 
	public int selectQuestionIdx(int questionIdx) {
		
		MngSurveyInfoDao dao = new MngSurveyInfoDao();
		
		int selectedQuestionIdx = dao.getQuestionIdx(questionIdx);
		
		return selectedQuestionIdx;
		
		
	}
	// 회원 idx 가져오기 
	public int selectMemberIdx(int memberIdx) {
		
		MngSurveyInfoDao dao = new MngSurveyInfoDao();
		
		int selectedSurveyIdx = dao.getMemberIdx(memberIdx);
		
		return selectedSurveyIdx;
		
		
	}
	
	// 질문 추가하기 
	public boolean questionAdd(int surveyIdx,  QuestionInfo questionInfo) {
		MngSurveyInfoDao dao = new MngSurveyInfoDao();
		
		return dao.questionAdd(surveyIdx,questionInfo);
	}
	// 질문 가져오기 
	public QuestionInfo getQuestion(int surveyIdx) {
		MngSurveyInfoDao dao = new MngSurveyInfoDao();
		
		return dao.getQuestionInfo(surveyIdx);

	}

}
