

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class OddOccurrencesInArray {
	public static void main(String[] args) {
		int[] arr = {9, 3, 9, 3, 9, 7, 9};
		int result = solution(arr);
		System.out.println(result);
	}
	
	private static int solution(int[] A) {
		int result = 0;
		HashSet workset = new HashSet();
		for (int i : A) {
			if(workset.add(i)) {
			} else { 
				workset.remove(i);
			}
		}
		result = (int) workset.iterator().next();
		return result;
	}
}
