import java.util.*;

class Solution {
	int n, m;
	public boolean isIn(int y, int x) {
		return y >= 0 && y < n && x >=0 && x < m;
	}
    public int solution(int[][] maps) {
    	int[][] dels = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    	n = maps.length;
    	m = maps[0].length;
    	int cnt = 0;
    	
    	Deque<Integer> deque = new ArrayDeque<>();
    	deque.addLast(0);
    	while (!deque.isEmpty()) {
    		int coor = deque.pollFirst();
    		int y = coor / 1000;
    		int x = coor % 1000;
    		cnt = maps[y][x];
    		if (y == n-1 && x == m-1) return cnt;
    		
    		for (int[] del : dels) {
    			int ny = y + del[0];
    			int nx = x + del[1];
    			if (!isIn(ny, nx) || maps[ny][nx] != 1) continue;
    			maps[ny][nx] = cnt+1;
    			deque.addLast(ny*1000+nx);
    		}
    	}
    	
        return -1;
    }
}