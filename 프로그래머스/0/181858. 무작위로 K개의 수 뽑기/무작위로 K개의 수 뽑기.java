import java.util.*;

class Solution {
    public int[] solution(int[] arr, int k) {
        Deque<Integer> deq = new ArrayDeque<>();
		for (int i : arr) {
			if (!deq.contains(i)) {
				deq.addLast(i);
				if (deq.size() == k) {
					break;
				}
			}
		}
		while (deq.size() < k) {
			deq.addLast(-1);
		}
        return deq.stream().mapToInt(Integer::intValue).toArray();
    }
}