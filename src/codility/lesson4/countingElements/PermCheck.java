package codility.lesson4.countingElements;

import java.util.Arrays;

public class PermCheck {

	public static void main(String[] args) {
		System.out.println(solution(new int[]{100001}));
	}

	public static int solution(int[] A) {
		Arrays.sort(A);

		if(A[0] != 1) {
			return 0;
		}

		for(int i = 0; i < A.length; i++) {
			if(A[i] !=  i+1) {
				return 0;
			}
		}
		return 1;
	}
}
