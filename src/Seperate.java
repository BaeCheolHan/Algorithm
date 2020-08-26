import java.util.Arrays;

public class Seperate {

	public static void main(String[] args) {
		String text = "우리나라 만세";
		System.out.println(getInitialSound(text));
		
	}
	
	public static String getInitialSound(String text) {
	    String[] chs = { 
	        "ㄱ", "ㄲ", "ㄴ", "ㄷ", "ㄸ", 
	        "ㄹ", "ㅁ", "ㅂ", "ㅃ", "ㅅ", 
	        "ㅆ", "ㅇ", "ㅈ", "ㅉ", "ㅊ", 
	        "ㅋ", "ㅌ", "ㅍ", "ㅎ" 
	    };
		String[] arr = text.split("");
	    if(arr.length > 0) {
	    	StringBuilder result = new StringBuilder();
	    	
	    	Arrays.asList(arr).stream().forEach(e -> {
	    		if(e.equals(" ")) {
	    			result.append(e);
	    		}
	    		
	    		char chName = e.charAt(0);
	    		
		        if(chName >= 0xAC00) {
		            int unicodeVal = chName - 0xAC00;
		            int chosungVal = unicodeVal / (21 * 28);
		            result.append(chs[chosungVal]);
		        }
	    	});
	    	
		        
	    	return result.toString();
	    	
	    }
	   		
	    return "값을 입력해 주세요."; 
	}

	/**
	   글 음절의 코드 포인트 값은 시작 값인 0xAC00에 ((초성 값 x 21) + 중성 값) x 28 + 종성 값을 더하면 된다. 
	   예를 들어, '한'이라는 글자는 'ㅎ', 'ㅏ', 'ㄴ'으로 구성되어 있으며, 각각 18, 0, 4 값을 가지고 있으므로, 
	   '한'의 코드 포인트 값은 U+AC00 + ((18 x 21) + 0) x 28 + 4 = U+AC00 + U+295C = U+D55C가 된다. 
	   이를 역으로 생각해 보면, 한글 음절에 대해 초성, 중성, 종성의 분리가 가능하다. 즉 한글 음절의 코드 포인트 값에서 
	   0xAC00을 뺀 값을 ①이라 한다면, 다음과 같이 정리할 수 있다.

			①의 값을 (21 x 28)로 나눈 몫은 초성
			①의 값을 (21 x 28)로 나눈 나머지를, 28로 나눈 몫은 중성
			①의 값을 28로 나눈 나머지는 종성
			
	   참고 : https://d2.naver.com/helloworld/76650
	 */
	
}
