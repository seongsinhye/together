package FAQ.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import FaqService.FaqService;
import SurveyService.MngSurveyService;

@WebServlet("/faq/delete")
public class faqDelete extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//faq  삭제하기 
		int faqIdx = Integer.parseInt(request.getParameter("faqIdx"));
		
		FaqService service = new FaqService();
		
		service.deleteFaq(faqIdx);

		
		response.sendRedirect("http://localhost:8083/survey/faq/list");
	}

}
