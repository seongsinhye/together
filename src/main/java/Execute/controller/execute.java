package Execute.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Execute.DTO.ExecuteInfo;
import ExecuteService.ExecuteService;
import memberDTO.MemberInfo;

@WebServlet("/execute")
public class execute extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int surveyIdx = Integer.parseInt(request.getParameter("surveyIdx"));
		String answer1 = request.getParameter("answer1");
		String answer2 = request.getParameter("answer2");
		String answer3 = request.getParameter("answer3");
		
		
		// 파라미터 검증이 필요할까 ? 
		
		
		// memberIdx 가져오기 
		HttpSession session = request.getSession();
		MemberInfo loginMemberInfo = (MemberInfo) session.getAttribute("memberInfo");
		int memberIdx = loginMemberInfo.getMemberIdx();
		
		ExecuteInfo executeInfo = new ExecuteInfo();
		executeInfo.setSurveyIdx(surveyIdx);
		executeInfo.setAnswer1(answer1);
		executeInfo.setAnswer2(answer2);
		executeInfo.setAnswer3(answer3);
		executeInfo.setJoinDate(LocalDateTime.now());
		
		ExecuteService service = new ExecuteService();
		service.execute(memberIdx, executeInfo);
		
	}

}
