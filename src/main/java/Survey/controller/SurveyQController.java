package Survey.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;

import SurveyDTO.AnswerInfo;
import SurveyDTO.QuestionInfo;
import SurveyDTO.SurveyInfo;
import SurveyService.MngSurveyService;
import memberDTO.MemberInfo;


@WebServlet("/mng/survey/question")
public class SurveyQController extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		// 설문조사 질문 등록하기 
		request.setCharacterEncoding("UTF-8");
		
		int surveyIdx = Integer.parseInt(request.getParameter("surveyIdx"));
		String question1= request.getParameter("question1");
		String question2 = request.getParameter("question2");
		String question3 = request.getParameter("question3");
		
		
		
		QuestionInfo questionInfo = new QuestionInfo();
		questionInfo.setQuestion1(question1);
		questionInfo.setQuestion2(question2);
		questionInfo.setQuestion3(question3);
		
		
		
		// 정보 저장
		MngSurveyService service = new MngSurveyService();
		
		
		service.questionAdd(surveyIdx, questionInfo);
		
		request.setAttribute("questionInfo", questionInfo);
		
	}

}
