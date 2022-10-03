package FAQ.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import FaqService.FaqService;
import SurveyDTO.SurveyInfo;
import SurveyService.SurveyService;
import common.util.SurveyInfoValidator;
import exception.BadParameterException;
import faqDTO.FaqInfo;

@WebServlet("/view/faq")
public class ViewFaqList extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
			int pageNumber = 1;
			// 페이지 번호에 맞는 상품 목록을 불러온다 
			FaqService service = new FaqService();
			
			List<FaqInfo> faqInfoList = service.getFaqInfoList(pageNumber);
				 
			request.setAttribute("faqInfoList", faqInfoList);
			 
			 RequestDispatcher admin = request.getRequestDispatcher("/faq/faq.jsp");
			 admin.forward(request, response);
				 
		
	
	}


}
