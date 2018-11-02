import java.util.ArrayList;
import java.util.Arrays;

public class PermMissingElem {
	public static void main(String[] args) {
		int[] A = {2,3,1,5};
		System.out.println(solution(A));
	}
	
	public static int solution(int[] A) {
        // write your code in Java SE 8
		Arrays.sort(A);
		int result = 1;
		if(A.length == 0)
			return 1;
		
		ArrayList<Integer> container = new ArrayList<>();
		for(int val : A)
			container.add(val);
		
		int i = 0;
		
		while(i < container.size()) {
			if (result != container.get(i)) {
				break;
			}
			i++;
			result++;
		}
		
		
		return result;
    }
}
