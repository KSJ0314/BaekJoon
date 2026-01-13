import java.util.*;

class Solution {
    public int solution(int[] citations) {
    	int answer = 0;
        Arrays.sort(citations);
        for (int i = 0; i < citations.length; i++) {
			if (citations[citations.length-1-i] <= i) break;
			answer++;
		}
        return answer;
    }
}