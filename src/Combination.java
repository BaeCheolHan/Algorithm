import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Combination {
	private static int count = 0;
	
	public static void main(String[] args) {
		String input = "apdkf35k47n1t2";
		solution(input);
		System.out.println(count);
		
	}
	
	private static void solution(String input) {
		String[] inputArr = input.split("");
		// 문자열에서 정수 추출 
		List<Integer> lst = Arrays.asList(inputArr)
									.stream()
									.filter(e -> e.matches("[0-9]"))
									.map(Integer::parseInt)
									.collect(Collectors.toList());
		
		boolean[] visited = new boolean[lst.size()];
		
		for (int i = 1; i <= lst.size(); i++) {
			combination(lst, visited, 0, lst.size(), i);
        }
		
	}

	/**
	 * @param lst : 조합을 뽑아낼 List
	 * @param visited
	 * @param start : 기준
	 * @param n : 배열의 길이
	 * @param r : 조합의 길이
	 */
	private static void combination(List<Integer> lst, boolean[] visited, int start, int n, int r) {
	    if(r == 0) {
	        print(lst, visited, n);
	        return;
	    } 

	    for(int i = start; i < n; i++) {
	        visited[i] = true;
	        combination(lst, visited, i + 1, n, r - 1);
	        visited[i] = false;
	    }
	}
	
	private static void print(List<Integer> lst, boolean[] visited, int n) {
		
		List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
            	result.add(lst.get(i));
            }
        }

        if(result.stream().mapToInt(e -> e).sum() == 10) {
        	count++;
        	System.out.println(result);
        }
        
    }
	
}
