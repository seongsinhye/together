package Member.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Member.Service.MemberService;
import common.util.MemberInfoValidator;
import exception.BadParameterException;
import memberDTO.MemberInfo;


@WebServlet("/member/join")
public class Join extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {

			request.setCharacterEncoding("UTF-8");
			
			String id = request.getParameter("id");
			String pw = request.getParameter("pw");
			String pwChk = request.getParameter("pwChk");
			String name = request.getParameter("name");
			String birthDay = request.getParameter("birthDay");
			String gender = request.getParameter("gender");
			String tel = request.getParameter("tel");
			String addr = request.getParameter("addr");
			String email = request.getParameter("email");
			
			
			// 파라미터 검증하기 
			MemberInfoValidator validator = new MemberInfoValidator();
			
			if(!validator.idValidator(id)) 								throw new BadParameterException();
			else if(!validator.pwValidator(pw) || !pw.equals(pwChk))  	throw new BadParameterException();
			else if(!validator.nameValidator(name)) 					throw new BadParameterException();
			else if(!validator.telValidator(tel)) 						throw new BadParameterException();
			else if(!validator.addrValidator(addr)) 					throw new BadParameterException();
			else if(!validator.emailValidator(email)) 					throw new BadParameterException();
			else if(!validator.genderValidator(gender))					throw new BadParameterException();
			else if(!validator.birthDayValidator(birthDay))				throw new BadParameterException();
			// 파라미터 검증하기 
			
			// 하나의 정보로 합친다. 
			MemberInfo newMemberInfo = new MemberInfo();
			newMemberInfo.setId(id);
			newMemberInfo.setPw(pw);
			newMemberInfo.setPwChk(pwChk);
			newMemberInfo.setName(name);
			newMemberInfo.setTel(tel);
			newMemberInfo.setAddr(addr);
			newMemberInfo.setEmail(email);
			newMemberInfo.setGender(gender);
			newMemberInfo.setBirthDay(birthDay);
			newMemberInfo.setJoinDate(LocalDateTime.now());
			
			
			// 회원가입 처리 
			MemberService service = new MemberService();
			
			boolean result = service.join(newMemberInfo);
			
			if(result) {
				response.setStatus(HttpServletResponse.SC_CREATED);
				
				
			} else {
				response.setStatus(HttpServletResponse.SC_CONFLICT);
			}
			
		} catch(BadParameterException e) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		}
		
		
	
	}

}
