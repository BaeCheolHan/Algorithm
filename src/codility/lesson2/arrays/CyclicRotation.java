package codility.lesson2.arrays;

import java.util.*;
import java.util.stream.Collectors;

public class CyclicRotation {
	public static void main(String[] args) {
		int[] A = {3, 8, 9, 7, 6};
		int K = 3;
		A = solution2(A, K);
		System.out.println(A);
	}

	private static int[] solution2(int[] A, int K) {
		List<Integer> l = Arrays.stream(A).boxed().collect(Collectors.toList());
		Deque<Integer> q = new LinkedList<>(l);

		for (int i = 0; i < K; i++) {
			q.addFirst(q.pollLast());
		}

		List<Integer> result = new ArrayList<>(q);

		return result.stream()
				.filter(Objects::nonNull)
				.mapToInt(i -> i)
				.toArray();
	}

	private static int[] solution(int[] A, int K) {
		int[] result = new int[A.length];

		if (A.length == 0) {
			return result;
		} else if (K == 0) {
			return A;
		}

		for (int i = 0; i < K; i++) {
			result[0] = A[A.length - 1];
			for (int x = 1; x < A.length; x++) {
				result[x] = A[x - 1];
			}

			for (int y = 0; y < result.length; y++) {
				A[y] = result[y];
			}
		}

		return result;
	}
}
