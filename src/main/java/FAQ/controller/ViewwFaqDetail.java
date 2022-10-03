package FAQ.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import FaqService.FaqService;
import faqDTO.FaqInfo;

@WebServlet("/faq/admindetail")
public class ViewwFaqDetail extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int faqIdx = Integer.parseInt(request.getParameter("faqIdx"));
		
		FaqService service = new FaqService();
		
		FaqInfo faqInfo = service.getFaqInfo(faqIdx);
		
		request.setAttribute("faqInfo", faqInfo);
		
		RequestDispatcher rd = request.getRequestDispatcher("/operate/admin-faq-add.jsp");
		
		rd.forward(request, response);
	}

}
