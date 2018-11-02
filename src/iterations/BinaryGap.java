package iterations;


import java.util.ArrayList;
import java.util.List;

public class BinaryGap {
	
	public static void main(String[] args) {
		
		System.out.println(solution(529));
		
	}
	
	private static int solution(int input) {
		int result = 0;
		int idx = 1;
		String[] binary = Integer.toBinaryString(input).split("");
		List<Integer> arr = new ArrayList<>();
		
		while(idx < binary.length) {
			if(binary[idx].equals("0")) {
				result++;
			} else {
				arr.add(result);
				result = 0;
			}
			idx++;
		}
		
		result = 0;
		
		for (int i : arr) {
			
			if(result < i) {
				result = i;
			} 
		}
		
		return result;
	}
}
