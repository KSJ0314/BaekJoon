import java.util.*;

class Solution {
    public int[][] solution(int[][] arr) {
        int col = arr.length;
        int row = arr[0].length;
        int max = Math.max(col, row);
        
        int[][] answer = Arrays.copyOf(arr, max);
    	for (int i = col; i < max; i++) {
			answer[i] = new int[max];
		}
    	if (row < max) {
    		for (int i = 0; i < max; i++) {
    			answer[i] = Arrays.copyOf(arr[i], max);
    		}
    	}
    	
        return answer;
    }
}