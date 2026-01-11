import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pQ = new PriorityQueue<>();
        for (int i = 0; i < scoville.length; i++) {
            pQ.add(scoville[i]);
        }
        int i = 0;
        for (; !pQ.isEmpty() && pQ.size() > 1; i++){
            int low1 = pQ.poll();
            if (low1 >= K) return i;
            int low2 = pQ.poll();
            pQ.add(low1 + low2*2);
        }
        return pQ.poll() >= K ? i : -1;
    }
}