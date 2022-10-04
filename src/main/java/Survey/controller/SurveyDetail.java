package Survey.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import SurveyDTO.QuestionInfo;
import SurveyDTO.SurveyInfo;
import SurveyService.MngSurveyService;
import SurveyService.SurveyService;

@WebServlet("/survey/detail")
public class SurveyDetail extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 설문조사 상세페이지 
		int surveyIdx = Integer.parseInt(request.getParameter("surveyIdx"));
		
		
		// 상품 상세 정보 불러옴 
		SurveyService service = new SurveyService();
		
		MngSurveyService serviceview = new MngSurveyService();
		
		SurveyInfo surveyInfo = service.surveyInfo(surveyIdx);
		QuestionInfo questionInfo = serviceview.getQuestion(surveyIdx);
		
		request.setAttribute("surveyInfo", surveyInfo);
		request.setAttribute("questionInfo", questionInfo);
	
		RequestDispatcher rd = request.getRequestDispatcher("/survey/survey-detail.jsp");
		rd.forward(request, response);
	
	}


}
 