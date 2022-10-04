package exception;

import java.util.regex.Pattern;

public class Ex01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
			// matches()메서드를 활용하면 대상문자열 숫자가 맞다면 true, 틀리면 false 
			String pattern = "(19|20)\\\\d{2}(0[1-9]|1[012])(0[1-9]|[12][0-9]|3[01])";
			
			String num = "1995-05-11";
			boolean result;
			
			result = Pattern.matches(pattern, num);
			
			System.out.println(result);
		
	}

}
