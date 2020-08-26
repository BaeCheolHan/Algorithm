import java.util.ArrayList;
import java.util.List;

public class Test {
    private static int count = 0;

    public static void main(String[] args) {
        String input = "apdkf35k47n1t2";
//        String input = "1234";
        solution(input);
        System.out.println(count);

    }

    private static void solution(String input) {

        String[] inputArr = input.split("");

        List<Integer> lst = new ArrayList<>();
        for (String str : inputArr) {
            if (str.matches("[0-9]"))
                lst.add(Integer.parseInt(str));
        }

        System.out.println();
        System.out.println(lst);

        boolean[] visited = new boolean[lst.size()];

        for (int i = 1; i <= lst.size(); i++) {
            System.out.println(i);
            combination(lst, visited, 0, i);
            System.out.println();
        }

    }


    /**
     * lst	    조합을 뽑아낼 배열
     * visited	조합에 뽑혔는지 체크하는 배열
     * depth    현재 조사중인 배열의 인덱스 
     * size	    목표하는 조합의 길이 
     */
    /*
        cSize 가 0이면 더이상 조합에 포함 시킬 수 없다는 이야기임
        위에 함수에서 i가 2 라고 가정하고 주석해보겠음
        n: 은 depth 가 n 일때 라는 말임 
     */
    private static void combination(List<Integer> lst, boolean[] visited, int depth, int cSize) {
        int n = lst.size();
        
        // 1: cSize 는 1이기 때문에 넘어감 (3)
        // 2: cSize 는 1이기 때문에 넘어감 (9)
        if (cSize == 0) {
            // 2: cSize 는 0, 현재 조합은 [1, 2] (6) 
            // 3: cSize 는 0, 현재 조합은 [1, 3] (11)
            print(lst, visited, n);
            return;
        }

        if (depth == n) { // 이건 그냥 주어진 배열을 넘어서지 않기 위한 조건문
            return;
        }

        // 0: 숫자 1을 조합에 포함시킴 [1] (1)
        // 1: 숫자 2를 조합에 포함시킴 [1, 2] (4)
        // 2: 숫자 3을 조합에 포함시킴 [1, 3] (9)
        // 3: 숫자 4를 조합에 포함시킴 [1, 4] (13) ...
        visited[depth] = true;
        // 0: 남은 조합의 자리는 1 (2)
        // 1: 남은 조합의 자리는 0 (5)
        // 2: 남은 조합의 자리는 0 (10)
        combination(lst, visited, depth + 1, cSize - 1); 
        
        // 1: 숫자 2를 조합에서 뺌 [1] (7)
        // 2: 숫자 3을 조합에서 뺌 [1] (11)
        visited[depth] = false;
        // 1: 남은 조합의 자리는 1 (8)
        // 2: 남은 조합의 자리는 1 (12)
        combination(lst, visited, depth + 1, cSize);
    }

    // 이건 설명 안하겠음. 그냥 주어진 조합이 합이 10이 되는지 체크하는 거임
    private static void print(List<Integer> lst, boolean[] visited, int n) {

        List<Integer> resultLst = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                resultLst.add(lst.get(i));
            }
        }

        System.out.println("candidate : " + resultLst + " // "  + n);

        if (resultLst.stream().mapToInt(a -> a).sum() == 10) {
            count++;
            System.out.println(resultLst);
        }
    }
}