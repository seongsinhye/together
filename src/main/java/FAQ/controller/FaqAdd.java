package FAQ.controller;

import java.io.IOException;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import FaqService.FaqService;
import faqDTO.FaqInfo;

@WebServlet("/faq/add")
public class FaqAdd extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// faq 추가하기 
		request.setCharacterEncoding("UTF-8");
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		// 파라 검증해야함 제목 내용 비우면 안됨 
		
		FaqInfo faqInfo = new FaqInfo();
		faqInfo.setTitle(title);
		faqInfo.setContent(content);
		faqInfo.setWriteDate(LocalDateTime.now());
		
		FaqService service = new FaqService();
		
		service.addFaq(faqInfo);
		
		response.sendRedirect("http://localhost:8083/survey/faq/list");
	
	}

}
