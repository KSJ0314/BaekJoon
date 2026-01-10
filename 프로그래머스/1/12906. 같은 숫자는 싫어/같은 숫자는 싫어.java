import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Deque<Integer> deque = new ArrayDeque<>();
        int crtNum = -1;
        for (int num : arr){
            if (crtNum == num) continue;
            crtNum = num;
            deque.addLast(num);
        }
        int[] answer = new int[deque.size()];
        for (int i = 0; !deque.isEmpty(); i++){
            answer[i] = deque.pollFirst();
        }
        return answer;
    }
}