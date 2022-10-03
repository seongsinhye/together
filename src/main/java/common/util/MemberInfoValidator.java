package common.util;

import java.util.regex.Pattern;
import java.util.regex.Matcher;



import javax.servlet.http.HttpServletResponse;

public class MemberInfoValidator {

	// 아이디가 올바른지 검증하는 메서드 
	public boolean idValidator(String id) {
		
		boolean result = false;
		
		if(id.length() == 0) {
			result = true;
		}
		
		
		// matches()메서드를 활용하면 대상문자열 숫자가 맞다면 true, 틀리면 false 
		// 아이디 : 영문 대소문자 숫자 각 한자씩 포함해서  4자 ~ 15자 
		String pattern = "^[a-zA-Z0-9][a-zA-Z0-9]{4,15}$";
		
		result = Pattern.matches(pattern, id);
		
		
		// 끝나니깐 결과를 리턴한다 
		
		
		return result;
	}
	
	
	
	// 비밀번호가 올바른지 검증하는 메서드 
	public boolean pwValidator(String pw) {
		
		
		boolean result = false;
		
		if(pw.length() == 0) {
			result = true;
		}
		
		
		// matches()메서드를 활용하면 대상문자열 숫자가 맞다면 true, 틀리면 false 
		// 비밀번호 영문 대소문자 숫자 각 한자씩 포함해서 8자 ~ 16자 
		String pattern = "^[a-zA-Z0-9][a-zA-Z0-9]{4,16}$";
		
		result = Pattern.matches(pattern, pw);
		
		
		// 끝나니깐 결과를 리턴한다 
		
		
		return result;
		
	}
	
	// 이름이 올바른지 검증하는 메서드 
	// 규칙 : 3자만 가능, 한글만 가능 
	// 정규표현식 사용하기 
	public boolean nameValidator(String name) {
		
		boolean result = false;
		
		if(name.length() == 0) {
			result = true;
		}
		
		// matches()메서드를 활용하면 대상문자열 숫자가 맞다면 true, 틀리면 false 
		String pattern = "[ㄱ-힣]{3}";
		
		result = Pattern.matches(pattern, name);
		
		
		// 끝나니깐 결과를 리턴한다 
		
		
		return result;
		
	}
	
	// 연락처가 올바른지 검증하는 메서드 
	// 규칙 : 010-1111-2222 와 같은 형식만 가능 
	//       각 자기마다 하이픈(-)이 반드시 있어야하고 
	//       첫 자리는 3자, 중간자리 4자, 마지막 자리는 4자여야함 
	public boolean telValidator(String tel) {
		// 문자열의 split() 메서드를 활용 
		// 연락처 정규표현식 사용하기 
		// 두가지 다 해보기
		
		
		boolean result = false;
		
		
		// matches()메서드를 활용하면 대상문자열 숫자가 맞다면 true, 틀리면 false 
		String pattern = "^[0-9]{3}-[0-9]{4}-[0-9]{4}$";
		
		result = Pattern.matches(pattern, tel);
		
		
		// 끝나니깐 결과를 리턴한다 
		
		
		return result;
		
	}
	
	// 주소가 올바른지 검증하는 메서드 
	// 규칙 : 특별시, 광역시, 시, 도만 입력 가능 
	// 서울특별시
	// 인천광역시 
	// 제주특별자치도 
	// ....
	public boolean addrValidator(String addr) {
		// 정규표현식 못씀 골라낼수가 없다. 
		// 배열이나 컬렉션 프레임 워크를 활용해야함 + 정규표현식 
//		String[] list = {"서울특별시", "인천광역시", "..."};
//		for(String nth : list) {
//			if(addr.equals(nth)){
//				// ... 
//			} 
		boolean result = false;
		
		if(addr.length() != 0) {
			return true;
		}
		
		// matches()메서드를 활용하면 대상문자열 숫자가 맞다면 true, 틀리면 false 
		//String pattern = "(([가-힣A-Za-z·\\d~\\-\\.]{2,}(로|길).[\\d]+)|([가-힣A-Za-z·\\d~\\-\\.]+(읍|동)\\s)[\\d]+)";
		
		//result = Pattern.matches(pattern, addr);
		
		
		// 끝나니깐 결과를 리턴한다 
		
		
		return result;
		
	}
	
	// 이메일 정규표현식 사용하기 
	public boolean emailValidator(String email) {
		// 
		
		boolean result = false;
		
		
		// matches()메서드를 활용하면 대상문자열 숫자가 맞다면 true, 틀리면 false 
		String pattern = "^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$";
		
		result = Pattern.matches(pattern, email);
		
		
		// 끝나니깐 결과를 리턴한다 
		
		
		return result;
		
		
	}
	
	// 성별 정규표현식 
	public boolean genderValidator(String gender) {
		
		
		
		String name1 = "여자";
		String name2 = "남자";
		
		if(gender.equals(name1) || gender.equals(name2)) {
			return true;
		} else {
			return false;
		}
		
		
	}
	
	
	// 생년월일 정규표현식 사용하기 
		public boolean birthDayValidator(String birthDay) {
			
			
			boolean result = false;
			
			if(birthDay.length() == 0) {
				result = true;
			}
			
			// matches()메서드를 활용하면 대상문자열 숫자가 맞다면 true, 틀리면 false 
			String pattern = "^(19[0-9][0-9]|20\\d{2})(0[0-9]|1[0-2])(0[1-9]|[1-2][0-9]|3[0-1])$";
			
			result = Pattern.matches(pattern, birthDay);
			
			
			// 끝나니깐 결과를 리턴한다 
			
			
			return result;
			
			
		}
	

	
	
}
