package codility.lesson4.elements;

import java.util.Arrays;

public class PermCheck {

	public static void main(String[] args) {
		System.out.println(solution(new int[]{100001}));
	}

	public static int solution(int[] A) {
		Arrays.sort(A);

		for(int i = 1; i < A.length; i++) {
			if(A[i-1] != i) {
				return 0;
			}
		}
		return 1;
	}
}
