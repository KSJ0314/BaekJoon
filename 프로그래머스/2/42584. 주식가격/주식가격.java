import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        for (int i = 0; i < prices.length; i++){
            boolean isEnd = false;
            for (int j = i+1; j < prices.length; j++){
                if (prices[i] > prices[j]) {
                    answer[i] = j-i;
                    isEnd = true;
                    break;
                }
            }
            if (!isEnd){
                answer[i] = (prices.length-1) - i;
            }
        }
        return answer;
    }
}