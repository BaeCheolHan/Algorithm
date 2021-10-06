package codility.lesson3.timeComplexity;
import java.util.Arrays;

public class PermMissingElem {
	public static void main(String[] args) {
		int[] A = {2,3,1,5};
		System.out.println(solution(A));
	}

	public static int solution(int[] A) {
		Arrays.sort(A);
		int result = 1;

		if(A.length == 0)
			return 1;

		int i = 0;

		while(i < A.length) {
			if (result != A[i]) 
				break;

			i++;
			result++;
		}

		return result;
	}
}
