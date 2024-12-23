import java.util.*;

class Solution {
    public int[] solution(int[] arr, int k) {
        arr = Arrays.stream(arr).distinct().limit(k).toArray();
		int[] answer = new int[k];
		for (int i = 0; i < arr.length; i++) {
			answer[i] = arr[i];
		}
		for (int i = arr.length; i < k; i++) {
			answer[i] = -1;
		}
        return answer;
    }
}