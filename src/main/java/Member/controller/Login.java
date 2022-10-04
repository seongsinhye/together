package Member.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Member.Service.MemberService;
import common.util.MemberInfoValidator;
import exception.BadParameterException;
import memberDTO.MemberInfo;

@WebServlet("/member/login")
public class Login extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 회원 로그인 
		try {
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			
			// 파라미터 검증해야함 
			MemberInfoValidator validator = new MemberInfoValidator();
			
			if(!validator.idValidator(id)) 								throw new BadParameterException();
			else if(!validator.pwValidator(pw))  						throw new BadParameterException();
			
			
			
			// 객체로 저장하기 
			MemberInfo loginMemberInfo = new MemberInfo();
			loginMemberInfo.setId(id);
			loginMemberInfo.setPw(pw);
			
			
			MemberService service = new MemberService();
			loginMemberInfo = service.login(loginMemberInfo);
		
			// 로그인 되면 세션에 정보를 저장한다 loginMemberInfo 비어있지 않다 = 회원가입이 되어있다 
			if(loginMemberInfo != null) {
				HttpSession session = request.getSession();
				session.setMaxInactiveInterval(60*10);
				session.setAttribute("memberInfo", loginMemberInfo);
				
				
			} else {
				response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			}
		}catch(BadParameterException e) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		}
		
		
	}

}
