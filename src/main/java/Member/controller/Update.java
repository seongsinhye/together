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


@WebServlet("/member/update")
public class Update extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 회원 정보 수정 
		try {

			request.setCharacterEncoding("UTF-8");
			
			String oldPw = request.getParameter("oldPw");
			String newPw = request.getParameter("newPw");
			String newPwChk = request.getParameter("newPwChk");
			String name = request.getParameter("name");
			String tel = request.getParameter("tel");
			String addr = request.getParameter("addr");
			String email = request.getParameter("email");
			
			// 파라미터 검증 
			MemberInfoValidator validator = new MemberInfoValidator();
			
			// 비밀번호를 변경을 하지않은 경우가 생길수 있으므로 
			if(oldPw != null && oldPw.length() > 0) {
				if(!validator.pwValidator(oldPw))  							throw new BadParameterException();
				else if(!validator.pwValidator(newPwChk))					throw new BadParameterException();
				else if(!newPw.equals(newPwChk))							throw new BadParameterException();
			}
			
			else if(!validator.nameValidator(name)) 					throw new BadParameterException();
			else if(!validator.telValidator(tel)) 						throw new BadParameterException();
			else if(!validator.addrValidator(addr)) 					throw new BadParameterException();
			else if(!validator.emailValidator(email)) 					throw new BadParameterException();
			
			
			
			// 세션에 저장 
			HttpSession session = request.getSession();
			MemberInfo loginMemberInfo = (MemberInfo) session.getAttribute("memberInfo");
			
			if(oldPw != null && oldPw.length() > 0) {
				String nowPw = loginMemberInfo.getPw();
				if(!nowPw.equals(oldPw)) throw new BadParameterException();
			}
			
			MemberInfo updateMemberInfo = new MemberInfo();
			if(oldPw != null && oldPw.length() > 0) {
				updateMemberInfo.setPw(newPw);
			} else {
				updateMemberInfo.setPw(loginMemberInfo.getPw());
			}
			
			updateMemberInfo.setName(name);
			updateMemberInfo.setTel(tel);
			updateMemberInfo.setAddr(addr);
			updateMemberInfo.setEmail(email);
			
			// 로그인 사용자의 식별값을 이용해서 정보를 수정한다 
			// 로그인은 세션에 저장되어있다 
			
			int memberIdx = loginMemberInfo.getMemberIdx();
			updateMemberInfo.setMemberIdx(memberIdx);
			
			MemberService service = new MemberService();
			
			// 수정된 정보 다시 저
			if(service.update(loginMemberInfo, updateMemberInfo)) {
				updateMemberInfo.setId(loginMemberInfo.getId());
				updateMemberInfo.setJoinDate(loginMemberInfo.getJoinDate());
				
				// 세션에 저장 
				session.setAttribute("memberInfo", updateMemberInfo);
			} else {
				// 409 
				response.setStatus(HttpServletResponse.SC_CONFLICT);
			}
		}catch(BadParameterException e) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
		}
		
	}

}
