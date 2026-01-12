import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        PriorityQueue<Integer> pQ = new PriorityQueue<>(Collections.reverseOrder());
    	for (int priority : priorities) {
    		pQ.add(priority);
    	}
    	Deque<Integer> deque = new ArrayDeque<>();
    	for (int i = 0; i < priorities.length; i++) {
			deque.addLast(i);
		}
    	
    	while (!deque.isEmpty()) {
    		int idx = deque.pollFirst();
    		if (priorities[idx] == pQ.peek()) {
    			if (idx == location) return priorities.length - pQ.size() +1;
    			pQ.poll();
    		} else {
    			deque.addLast(idx);
    		}
    	}  
        return -1;
    }
}