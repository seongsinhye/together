package Survey.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import SurveyDTO.AnswerInfo;
import SurveyDTO.QuestionInfo;
import SurveyDTO.SurveyInfo;
import SurveyService.MngSurveyService;


@WebServlet("/mng/survey/answer")
public class SurveyAController extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 설문조사 등록시 질문 내역 
		request.setCharacterEncoding("UTF-8");
		
		int questionIdx = Integer.parseInt(request.getParameter("questionIdx"));
		int surveyIdx = Integer.parseInt(request.getParameter("surveyIdx"));
		int memberIdx = Integer.parseInt(request.getParameter("memberIdx"));
		String text = request.getParameter("text");
		
	
		// 정보 저장
		MngSurveyService service = new MngSurveyService();
		
		int selectedQuestionIdx = service.selectQuestionIdx(questionIdx);
		int selectedSurveyIdx = service.selectSurveyIdx(surveyIdx);
		int selectedMemberIdx = service.selectMemberIdx(memberIdx);
		
		request.setAttribute("questionIdx", selectedQuestionIdx);
		request.setAttribute("surveyIdx", selectedSurveyIdx);
		request.setAttribute("memberIdx", selectedMemberIdx);
		
//		AnswerInfo answerInfo = new AnswerInfo(questionIdx,surveyIdx, memberIdx,text);
//		
//		
//		service.answerAdd(answerInfo);
		
	}

}
