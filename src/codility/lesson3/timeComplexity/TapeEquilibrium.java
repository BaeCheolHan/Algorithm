package codility.lesson3.timeComplexity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TapeEquilibrium {
	
    public static void main(String[] args) {
        int[] A ={3, 1, 2, 4, 3};
        System.out.println(solution(A));
    }

	public static int solution(int[] A) {
		List<Integer> sumList = new ArrayList<>();

		int left = 0;
		int right = 0;
		int totalSumValue = 0;

		for(int i : A)  totalSumValue += i;

		for(int j = 1 ; j < A.length ; j++){
			left += A[j-1];
			right = totalSumValue - left;
			sumList.add(Math.abs(left - right));
		}

		return (Integer)Collections.min(sumList);
	}
}
