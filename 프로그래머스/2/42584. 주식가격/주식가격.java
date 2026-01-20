import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] ans = new int[prices.length];
        Deque<Integer> deque = new ArrayDeque();
        for (int i = 0; i < prices.length; i++){
            ans[i] = prices.length-1-i;
            while (!deque.isEmpty() && prices[deque.peekLast()] > prices[i]){
                int idx = deque.pollLast();
                ans[idx] = i-idx;
            }
            deque.addLast(i);
        }
        return ans;
    }
}