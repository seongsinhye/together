package Execute.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import FaqService.FaqService;
import MemberDAO.MemberInfoDao;
import SurveyDTO.SurveyInfo;
import SurveyDTO.SurveyJoinInfo;
import SurveyService.SurveyService;
import common.util.SurveyInfoValidator;
import exception.BadParameterException;
import faqDTO.FaqInfo;
import memberDTO.MemberInfo;

@WebServlet("/mypage/list")
public class mypageSurveyList extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			int pageNumber = 1;
			if(request.getParameter("pageNumber") != null) {
				pageNumber = Integer.parseInt(request.getParameter("pageNumber")); 
			}
			
			int memberIdx = Integer.parseInt(request.getParameter("memberIdx"));
		
			
			SurveyInfoValidator validator = new SurveyInfoValidator();
			
			if(!validator.pageNumberValidator(pageNumber)) 		throw new BadParameterException();
			
			// 페이지 번호에 맞는 상품 목록을 불러온다 
			SurveyService service = new SurveyService();
		
			int amount = service.getAmount();
			List<SurveyJoinInfo> surveyJoinInfoList = service.surveyJoinList(pageNumber);
			
			
			// member db에 있는 point 가져와야함 그래서 다시 조회 
			MemberInfo memberInfo = new MemberInfo();
			memberInfo.setPoint(service.getPoint(memberIdx));
			
			
			 
			request.setAttribute("amount", amount);
			request.setAttribute("surveyJoinInfoList", amount == 0 ? null : surveyJoinInfoList);
			request.setAttribute("memberInfo", memberInfo);
			 
			RequestDispatcher rd = request.getRequestDispatcher("/member/my-page.jsp");
			rd.forward(request, response);
		}catch(BadParameterException e) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		}
		
	
	
	
	}


}
