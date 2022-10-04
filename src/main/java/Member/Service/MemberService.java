package Member.Service;

import MemberDAO.MemberInfoDao;
import memberDTO.MemberInfo;

public class MemberService {
	
	// 회원 삭제 
	public boolean delete(int memberIdx) {
		
		MemberInfoDao dao = new MemberInfoDao();
		
		return dao.delete(memberIdx);
		
	}
	
	// 회원 수정하기 
	public boolean update(MemberInfo oldMemberInfo, MemberInfo updateMemberInfo) {
		
		MemberInfoDao dao = new MemberInfoDao();
		
		String oldTel = oldMemberInfo.getTel();
		String oldEmail = oldMemberInfo.getEmail();
		
		String newTel = updateMemberInfo.getTel();
		String newEmail = updateMemberInfo.getEmail();
		
		if(!oldTel.equals(newTel) && dao.seletTel(newTel) != null) {
			return false;
		} else if(!oldEmail.equals(newEmail) && dao.selectEmail(newEmail) != null) {
			return false;
		}
		
		
		return dao.update(updateMemberInfo);
	}
	
	// 회원 로그인 
	public MemberInfo login(MemberInfo memberInfo) {
		
		MemberInfoDao dao = new MemberInfoDao();
		
		// seletedMemberInfo => 아이디 찾아보기 
		MemberInfo seletedMemberInfo = dao.selectId(memberInfo.getId());
		
		// 회원 정보가 없다면 회원가입이 안되어있으면 null 
		if(seletedMemberInfo == null) {
			return null;
		} else if(!seletedMemberInfo.getPw().equals(memberInfo.getPw())) {
			// DB에 있는 비밀번호랑 입력한 비밀번호를 비교해서 같으면 true를 출력하지만 !를 해서 false가 된다 
			// false이면 밖으로 나간다 
			return null;
		}
		
		return seletedMemberInfo;
		
	}

	// 회원 회원가입 
	public boolean join(MemberInfo memberInfo) {
		
		MemberInfoDao dao = new MemberInfoDao();
		
		
		// id, email, tel은 유니크 키로 사용할것이다. 
		// 중복되는 정보가 없다면 insert 중복된다면 return false 로 설정하기 
		// 아이디가 널이 아니다 회원가입이 되어있다 
		if(dao.selectId(memberInfo.getId()) != null || dao.selectEmail(memberInfo.getEmail()) != null ||
				dao.seletTel(memberInfo.getTel()) != null) {
			return false;
		} else {
			return dao.insert(memberInfo);
		}
		
		
		
	}
}
