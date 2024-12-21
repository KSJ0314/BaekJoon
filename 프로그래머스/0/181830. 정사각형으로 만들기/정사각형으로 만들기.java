import java.util.*;

class Solution {
    public int[][] solution(int[][] arr) {
        int max = Math.max(arr.length, arr[0].length);
        int[][] answer = new int[max][max];
                           
		for (int i = 0; i < arr.length; i++) {
			answer[i] = Arrays.copyOf(arr[i], max);
		}
    	
        return answer;
    }
}