package Survey.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.SendResult;

import SurveyDTO.SurveyInfo;
import SurveyService.SurveyService;
import common.util.SurveyInfoValidator;
import exception.BadParameterException;

@WebServlet("/operate/list")
public class AdminSurveyList extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 관리자 설문조사 리스트 보여주기 
		try {
			
		 // 페이지 네이션을 위해서 pageNumber 설정 
				int pageNumber = 1;
				if(request.getParameter("pageNumber") != null) {
					pageNumber = Integer.parseInt(request.getParameter("pageNumber")); 
				}
				
				
				// 페이지 번호에 맞는 상품 목록을 불러온다 
				SurveyService service = new SurveyService();
				
				int amount = service.getAmount();
				if(amount >= 0) {
					List<SurveyInfo> surveyInfoList = service.getSurvetInfoList(pageNumber);
					 
					 request.setAttribute("amount", amount);
					 request.setAttribute("surveyInfoList", surveyInfoList);
					 
					 RequestDispatcher admin = request.getRequestDispatcher("/operate/admin-survey-list.jsp");
					 admin.forward(request, response);
				}
			
		}catch(BadParameterException e) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		}
		
		
		
		
	
	}


}
