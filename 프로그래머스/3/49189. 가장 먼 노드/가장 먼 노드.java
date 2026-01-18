import java.util.*;

class Solution {
    public int solution(int n, int[][] edges) {
    	ArrayList<Integer>[] lists = new ArrayList[n+1];
        for (int[] edge : edges) {
			if (lists[edge[0]] == null) lists[edge[0]] = new ArrayList<>();
			if (lists[edge[1]] == null) lists[edge[1]] = new ArrayList<>();
			lists[edge[0]].add(edge[1]);
			lists[edge[1]].add(edge[0]);
		}
        
        boolean[] visited = new boolean[n+1];
        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(1);
        visited[1] = true;
        int size = 0;
        while (!deque.isEmpty()) {
        	size = deque.size();
        	for (int i = size; i > 0; i--) {
        		ArrayList<Integer> list = lists[deque.pollFirst()];
        		if (list == null) continue;
        		for (int next : list) {
        			if (visited[next]) continue;
        			visited[next] = true;
        			deque.addLast(next);
        		}
        	}
        }
        
        return size;
    }
}