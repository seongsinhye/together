package SurveyService;
import java.io.File;

import SurveyDAO.MngSurveyInfoDao;
import SurveyDAO.SurveyInfoDao;
import SurveyDTO.AnswerInfo;
import SurveyDTO.QuestionInfo;
import SurveyDTO.SurveyInfo;

public class MngSurveyService {
	
	public boolean addImg(int surveyIdx, String img) {
		MngSurveyInfoDao dao = new MngSurveyInfoDao();
		
		return dao.updateImg(surveyIdx, img);
	}
	
	public boolean deleteImg(int surveyIdx, String realPath) {
		MngSurveyInfoDao dao = new MngSurveyInfoDao();
		
		SurveyInfo surveyInfo = dao.getSurveyIdxReturnSurInfo(surveyIdx);
		
		String img = surveyInfo.getImg();
		
		File file = new File(realPath + img);
		
		
		if(file.delete()) {
			dao.setImgNull(surveyIdx);
			return true;
		}else {
			return false;
		}
		
	}
	
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
	
	
	public boolean update(SurveyInfo updateSurveyInfo) {
		
		MngSurveyInfoDao dao = new MngSurveyInfoDao();
		
		return dao.update(updateSurveyInfo);
		
	}

	public int insert(SurveyInfo newSurveyInfo) {
		
		MngSurveyInfoDao dao = new MngSurveyInfoDao();
		
		// pstmt로 insert한 데이터의 idx(AutoIncrement)를 가져오는 방법
		return dao.insertAndSelectIdx(newSurveyInfo);
		
	}
	
	
//	public int selecedSurveyIdx(SurveyInfo newSurveyInfo) {
//		MngSurveyInfoDao dao = new MngSurveyInfoDao();
//		
//		int surveyIdx = dao.insertAndGetSurveyIdx(newSurveyInfo);
//		
//		return surveyIdx;
//	}

	
	public int selectSurveyIdx(int surveyIdx) {
		
		MngSurveyInfoDao dao = new MngSurveyInfoDao();
		
		int selectedSurveyIdx = dao.getSurveyIdx(surveyIdx);
		
		return selectedSurveyIdx;
		
		
	}
	public int selectQuestionIdx(int questionIdx) {
		
		MngSurveyInfoDao dao = new MngSurveyInfoDao();
		
		int selectedQuestionIdx = dao.getQuestionIdx(questionIdx);
		
		return selectedQuestionIdx;
		
		
	}
	public int selectMemberIdx(int memberIdx) {
		
		MngSurveyInfoDao dao = new MngSurveyInfoDao();
		
		int selectedSurveyIdx = dao.getMemberIdx(memberIdx);
		
		return selectedSurveyIdx;
		
		
	}
	
	public boolean questionAdd(int surveyIdx,  QuestionInfo questionInfo) {
		MngSurveyInfoDao dao = new MngSurveyInfoDao();
		
		return dao.questionAdd(surveyIdx,questionInfo);
	}
	
	public QuestionInfo getQuestion(int surveyIdx) {
		MngSurveyInfoDao dao = new MngSurveyInfoDao();
		
		return dao.getQuestionInfo(surveyIdx);

	}
//	public boolean answerAdd(AnswerInfo newAnswerInfo) {
//		MngSurveyInfoDao dao = new MngSurveyInfoDao();
//		
//		return dao.answerAdd(newAnswerInfo);
//	}
}
