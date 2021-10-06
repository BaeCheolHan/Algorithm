package codility.lesson3.timeComplexity;

public class FrogJmp {
	public static void main(String[] args) {
		System.out.println(solution(10, 85, 30));
	}

	public static int solution(int X, int Y, int D) {
		int result = 0;

		if (Y <= X) {
			return 0;
		} else {
			result = (Y - X) / D;
			if (((Y - X) % D) != 0)
				result++;
		}
		return result;
	}

}
