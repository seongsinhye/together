package Survey.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import SurveyService.MngSurveyService;

@WebServlet("/survey/delete")
public class SurveyDelete extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int surveyIdx = Integer.parseInt(request.getParameter("surveyIdx"));
		String realPath = request.getServletContext().getRealPath("/images/survey/");
		
		MngSurveyService service = new MngSurveyService();
		
		if(surveyIdx > 0) {
			service.questionAndAnswerDelete(surveyIdx);
			
			
			service.surveyDelete(surveyIdx, realPath);
			
			response.sendRedirect("http://localhost/survey/operate/list");
		}
			
		
	
	}

}
