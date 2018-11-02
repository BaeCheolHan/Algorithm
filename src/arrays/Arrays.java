package arrays;


public class Arrays {
	public static void main(String[] args) {
		int[] A = {};
		int K = 1;
		A = solution(A, K);
		System.out.println("asdf");
	}

	private static int[] solution(int[] A, int K) {
		int[] result = new int[A.length];
		
		if (A.length == 0) {
			return result;
		} else if (K == 0) {
			return A;
		}
		
		for (int i = 0; i < K; i++) {
			result[0] = A[A.length-1];
			for (int x = 1; x < A.length; x++) {
				result[x] = A[x-1];
			}
			
			for (int y = 0; y < result.length; y++) {
				A[y] = result[y];
			}
		}
		
		return result;
	}
}
