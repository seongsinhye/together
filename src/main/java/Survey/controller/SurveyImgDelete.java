package Survey.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import SurveyService.MngSurveyService;

@WebServlet("/mng/survey/img/delete")
public class SurveyImgDelete extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		int surveyIdx = Integer.parseInt(request.getParameter("surveyIdx"));
		
		String realPath = request.getServletContext().getRealPath("/images/product/");
		
		MngSurveyService service = new MngSurveyService();
		
		service.deleteImg(surveyIdx, realPath);
	
	
	}

}
