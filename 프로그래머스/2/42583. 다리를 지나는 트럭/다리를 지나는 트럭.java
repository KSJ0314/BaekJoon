import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
    	int weightSum = 0;
        Deque<Integer> weightDeque = new ArrayDeque<>();
        Deque<Integer> removeTimeDeque = new ArrayDeque<>();
        int time = 0;
        for (int i = 0; i < truck_weights.length; time++) {
        	if (!removeTimeDeque.isEmpty() && removeTimeDeque.peekFirst() == time) {
        		removeTimeDeque.pollFirst();
        		weightSum -= weightDeque.pollFirst();
        	}
        	if (weight >= weightSum+truck_weights[i]) {
        		weightDeque.addLast(truck_weights[i]);
        		removeTimeDeque.addLast(time+bridge_length);
        		weightSum += truck_weights[i++];
        	}
		}
        
        return time + bridge_length;
    }
}