import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        Deque<Integer> deq = new ArrayDeque<>();
        
        for (int i : arr) {
        	if (!deq.isEmpty() && deq.peekLast() == i) {
        		deq.removeLast();
        	} else {
        		deq.addLast(i);
        	}
        }
        
        return deq.isEmpty() ? new int[] {-1} 
        		: deq.stream().mapToInt(Integer::intValue).toArray();
    }
}