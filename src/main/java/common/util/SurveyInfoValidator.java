package common.util;

import java.util.regex.Pattern;
import java.util.regex.Matcher;



import javax.servlet.http.HttpServletResponse;

public class SurveyInfoValidator {

	// 설문조사 제목이 올바른지 검증하는 메서드 
	public boolean surveyTitleValidator(String surveyTitle) {
		
		boolean result = false;
		
		// 제목은 필수 이므로 비어있으면 true 출력된다. 
		if(surveyTitle.length() != 0) {
			result = true;
		}
		
		// 끝나니깐 결과를 리턴한다 
		
		
		return result;
	}
	
	// 카테고리 정규표현식 
	public boolean categoryValidator(String category) {
		
		
		
		String name1 = "환경";
		String name2 = "경제";
		
		if(category.equals(name1) || category.equals(name2)) {
			return true;
		} else {
			return false;
		}
		
		
	}
	
	
	
	
	
	// point 마이너스 넣으면 안되니깐
	public boolean pointValidator(int point) {
		
		boolean result = false;
		
		
		
		if(point > 0) {
			result = true;
		}
		
		
		return result;
		
	}
	
	
	

	
	
	// 시작 날짜  정규표현식 사용하기 
		public boolean startDateValidator(String startDate) {
			
			
			boolean result = false;
			
			if(startDate.length() == 0) {
				result = true;
			}
			
			// matches()메서드를 활용하면 대상문자열 숫자가 맞다면 true, 틀리면 false 
			String pattern = "^(19[0-9][0-9]|20\\d{2})(0[0-9]|1[0-2])(0[1-9]|[1-2][0-9]|3[0-1])$";
			
			result = Pattern.matches(pattern, startDate);
			
			
			// 끝나니깐 결과를 리턴한다 
			
			
			return result;
			
			
		}
		// 종료 날짜  정규표현식 사용하기 
			public boolean endDateValidator(String endDatae) {
				
				
				boolean result = false;
				
				if(endDatae.length() == 0) {
					result = true;
				}
				
				// matches()메서드를 활용하면 대상문자열 숫자가 맞다면 true, 틀리면 false 
				String pattern = "^(19[0-9][0-9]|20\\d{2})(0[0-9]|1[0-2])(0[1-9]|[1-2][0-9]|3[0-1])$";
				
				result = Pattern.matches(pattern, endDatae);
				
				
				// 끝나니깐 결과를 리턴한다 
				
				
				return result;
				
				
			}
			
			// pageNumber 마이너스 넣으면 안되니깐
			public boolean pageNumberValidator(int pageNumber) {
				
				boolean result = false;
				
				if(pageNumber > 0) {
					result = true;
				}
				
				return result;
				
			}

	
	
}
