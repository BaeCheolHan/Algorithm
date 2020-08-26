import java.util.ArrayList;
import java.util.List;

public class Combination {
	private static int count = 0;
	public static void main(String[] args) {
		String input = "apdkf35k47n1t2";
		solution(input);
		System.out.println(count);
		
	}
	
	private static int solution(String input) {
		int result = 0;
		
		String[] inputArr = input.split("");
		
		List<Integer> lst = new ArrayList<>();
		for(String str : inputArr) {
			if(str.matches("[0-9]"))
				lst.add(Integer.parseInt(str));
		}
		
		boolean[] visited = new boolean[lst.size()];
		
		for (int i = 1; i <= lst.size(); i++) {
			combination(lst, visited, 0, lst.size(), i);
        }
		
		return result;
	}
	
	
	/**
		arr	조합을 뽑아낼 배열
		output	조합에 뽑혔는지 체크하는 배열
		n	배열의 길이
		r	조합의 길이
	 */
	private static void combination(List<Integer> lst, boolean[] visited, int depth, int n, int r) {
	    if (r == 0) {
	        print(lst, visited, n);
	        return;
	    }

	    if (depth == n) {
	        return;
	    }

	    visited[depth] = true;
	    combination(lst, visited, depth + 1, n, r - 1);

	    visited[depth] = false;
	    combination(lst, visited, depth + 1, n, r);
	}
	
	private static void print(List<Integer> lst, boolean[] visited, int n) {
		List<Integer> resultLst = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
            	resultLst.add(lst.get(i));
            }
        }
        
        if(resultLst.stream().mapToInt(a -> a).sum() == 10) {
        	count++;
        	System.out.println(resultLst);
        }
    }


}