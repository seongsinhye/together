package Survey.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import SurveyDTO.SurveyInfo;
import SurveyService.SurveyService;
import common.util.SurveyInfoValidator;
import exception.BadParameterException;

@WebServlet("/survey/list")
public class SurveyList extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 설문조사 목록페이지 
		try {
			// 페이지 네이션 때문에 pageNumber 초기화 
			int pageNumber = 1;
			if(request.getParameter("pageNumber") != null) {
				pageNumber = Integer.parseInt(request.getParameter("pageNumber")); 
			}
			
			// 페이지 번호 validator 필요함 
			SurveyInfoValidator validator = new SurveyInfoValidator();
			
			if(!validator.pageNumberValidator(pageNumber)) 		throw new BadParameterException();
			
			// 페이지 번호에 맞는 상품 목록을 불러온다 
			SurveyService service = new SurveyService();
		
			int amount = service.getAmount();
			List<SurveyInfo> surveyInfoList = service.getSurvetInfoList(pageNumber);
			 
			request.setAttribute("amount", amount);
			request.setAttribute("surveyInfoList", amount == 0 ? null : surveyInfoList);
			 
			RequestDispatcher rd = request.getRequestDispatcher("/survey/survey-list.jsp");
			rd.forward(request, response);
		}catch(BadParameterException e) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		}
		
		
		
		
	
	}


}
