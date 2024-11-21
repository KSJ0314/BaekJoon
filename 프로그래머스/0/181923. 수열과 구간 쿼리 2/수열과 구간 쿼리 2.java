import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = new int [queries.length];
        
        for (int i = 0; i < queries.length; i++) {
			int[] q = queries[i];
			int min = Arrays
				.stream(Arrays.copyOfRange(arr, q[0], q[1]+1))
				.reduce(-1, (a,b) -> b > q[2] && (a == -1 || a > b) ? b : a);
			answer[i] = min;
		}
        
        return answer;
    }
}