import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        
        for (int i : arr) {
        	if (!stack.isEmpty() && stack.peek() == i) {
        		stack.pop();
        	} else {
        		stack.push(i);
        	}
        }
        
        return stack.isEmpty() ? new int[] {-1} 
        		: stack.stream().mapToInt(Integer::intValue).toArray();
    }
}