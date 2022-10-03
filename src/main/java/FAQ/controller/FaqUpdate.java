package FAQ.controller;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import faqDTO.FaqInfo;
import faqDTO.QuestionPersonInfo;
import FaqService.FaqService;

@WebServlet("/faq/update")
public class FaqUpdate extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		
		int faqIdx = Integer.parseInt(request.getParameter("faqIdx"));
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		FaqInfo faqInfo = new FaqInfo();
		faqInfo.setTitle(title);
		faqInfo.setContent(content);
		
		FaqService service = new FaqService();
		
		service.updateQPerson(faqIdx, faqInfo);
		
		response.sendRedirect("http://localhost/survey/faq/list");
	}

}
