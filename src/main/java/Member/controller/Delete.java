package Member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Member.Service.MemberService;
import MemberDAO.MemberInfoDao;
import memberDTO.MemberInfo;

@WebServlet("/member/delete")
public class Delete extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 세션에 로그인된 정보를 삭제한다 
		HttpSession session = request.getSession();
		
		MemberInfo loginMemberInfo = (MemberInfo) session.getAttribute("memberInfo");
		
		int memberIdx = loginMemberInfo.getMemberIdx();
		
		MemberService service = new MemberService();
		
		
		
		if(service.delete(memberIdx)) {
			session.invalidate();
			
		}
		
		
		
	
	}

}
