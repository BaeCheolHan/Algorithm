import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Combination {
	private static int count = 0;
	private static List<List<Integer>> resultList = new ArrayList<>();
	
	public static void main(String[] args) {
		String input = "apdkf35k47n1t2";
		solution(input);
		System.out.println(String.format("output %d\n", count));
	
		String result = resultList
								.stream()
								.map(e -> e.stream().map(it -> String.valueOf(it)).collect(Collectors.joining(",", "", "")))
								.collect(Collectors.joining(" / ", "(", ")"));
		System.out.println(result);
	}
	
	private static void solution(String input) {
		String[] inputArr = input.split("");
		List<Integer> lst = Arrays.asList(inputArr)
												.stream()
												.filter(e -> e.matches("[0-9]"))
												.map(Integer::parseInt)
												.collect(Collectors.toList());
		Collections.sort(lst);
		boolean[] visited = new boolean[lst.size()];
		
		for (int length = 2; length <= lst.size(); length++) {
			combination(lst, visited, 0, lst.size(), length);
        }
		
	}

	
	private static void combination(List<Integer> lst, boolean[] visited, int start, int elemLength, int length) {
	    if(length == 0) {
	    	collect(lst, visited, elemLength);
	        return;
	    } 

	    for(int i = start; i < elemLength; i++) {
	        visited[i] = true;
	        combination(lst, visited, i + 1, elemLength, length - 1);
	        visited[i] = false;
	    }
	}
	
	private static void collect(List<Integer> lst, boolean[] visited, int elemLength) {
		
		List<Integer> result = new ArrayList<>();
        for (int i = 0; i < elemLength; i++) {
            if (visited[i]) {
            	result.add(lst.get(i));
            }
        }

        if(result.stream().mapToInt(e -> e).sum() == 10) {
        	count++;
        	resultList.add(result);
        }
        
    }
	
}
