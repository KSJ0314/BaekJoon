import java.util.*;

class Solution {
	ArrayList<Integer>[] list;
	int answer, n;
	
    public int solution(int n, int[][] wires) {
    	this.n = n;
    	answer = Integer.MAX_VALUE;
    	list = new ArrayList[n+1];
    	for (int i = 1; i <= n; i++) {
    		list[i] = new ArrayList<>();
    	}
    	
    	for (int[] wire : wires) {
    		list[wire[0]].add(wire[1]);
    		list[wire[1]].add(wire[0]);
    	}
    	
    	calTreeSize(1, 0);
        return answer;
    }

	public int calTreeSize(int idx, int pIdx) {
		int size = 1;
		for (int child : list[idx]) {
			if (child == pIdx) continue;
			size += calTreeSize(child, idx);
		}
		int diff = Math.abs((n-size) - size);
		answer = Math.min(answer, diff);
		return size;
	}
}