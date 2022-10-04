package Execute.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ExecuteService.ExecuteService;
import memberDTO.MemberInfo;

@WebServlet("/get/point")
public class getPoint extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 설문조사 실행시 포인트 올라간다 
		int surveyIdx = Integer.parseInt(request.getParameter("surveyIdx"));
		
		HttpSession session = request.getSession();
		MemberInfo loginMemberInfo = (MemberInfo) session.getAttribute("memberInfo");
		int memberIdx = loginMemberInfo.getMemberIdx();
		
		ExecuteService service = new ExecuteService();
		
		MemberInfo getPointMember = new MemberInfo();
		getPointMember.setPoint(loginMemberInfo.getPoint());
		
		
		if(service.getpoint(memberIdx, surveyIdx)) {
		
			session.setAttribute("memberInfo", getPointMember);
		}
		
		
	
	}

}
