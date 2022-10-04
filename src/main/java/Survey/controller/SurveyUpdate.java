package Survey.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import SurveyDTO.SurveyInfo;
import SurveyService.MngSurveyService;
import SurveyService.SurveyService;
import common.util.SurveyInfoValidator;
import exception.BadParameterException;

@WebServlet("/survey/update")
public class SurveyUpdate extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// 설문조사 수정하기 
		try {
			request.setCharacterEncoding("UTF-8");
			
			int surveyIdx = Integer.parseInt(request.getParameter("surveyIdx"));
			String surveyTitle = request.getParameter("surveyTitle");
			String category = request.getParameter("category");
			String content = request.getParameter("content");
			int point = Integer.parseInt(request.getParameter("point"));
			String img = request.getParameter("img");
			String startDate = request.getParameter("startDate");
			String endDate = request.getParameter("endDate");
			
			// 파라미터 검증 
			SurveyInfoValidator validator = new SurveyInfoValidator();
			
			if(!validator.surveyTitleValidator(surveyTitle)) 		throw new BadParameterException();
			else if(!validator.categoryValidator(category))			throw new BadParameterException();
			else if(!validator.pointValidator(point))				throw new BadParameterException();
			else if(!validator.startDateValidator(startDate))		throw new BadParameterException();
			else if(!validator.endDateValidator(endDate))			throw new BadParameterException();
			
			// 파라미터 검증  
			
			SurveyInfo updateSurveyInfo = new SurveyInfo();
			updateSurveyInfo.setSurveyIdx(surveyIdx);
			updateSurveyInfo.setSurveyTitle(surveyTitle);
			updateSurveyInfo.setCategory(category);
			updateSurveyInfo.setContent(content);
			updateSurveyInfo.setPoint(point);
			updateSurveyInfo.setImg(img);
			updateSurveyInfo.setStartDate(startDate);
			updateSurveyInfo.setEndDate(endDate);
			
			
			MngSurveyService service = new MngSurveyService();
			
			service.update(updateSurveyInfo);
			
		}catch(BadParameterException e) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		}
		
		
	
	}

}
