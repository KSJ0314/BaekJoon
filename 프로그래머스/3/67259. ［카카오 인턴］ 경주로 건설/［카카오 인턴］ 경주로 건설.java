import java.io.*;
import java.util.*;

class Solution {
    int[][] dels = {{-1,0},{0,1},{1,0},{0,-1}};
    int N;
    
    public int solution(int[][] board) {
        N = board.length;
        
        int[][][] costs = new int[N][N][4];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                Arrays.fill(costs[i][j], Integer.MAX_VALUE);
            }
        }
        costs[0][0][1] = 0;
        costs[0][0][2] = 0;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> Integer.compare(o1[2], o2[2]));
        pq.add(new int[]{0,0,0,2});
        pq.add(new int[]{0,0,0,1});
        
        int ans = 0;
        while (!pq.isEmpty()) {
            int[] crt = pq.poll();
            int r = crt[0], c = crt[1], cost = crt[2], d = crt[3];
            if (cost > costs[r][c][d]) continue;
            
            if (r == N-1 && c == N-1){
                ans = cost;
                break;
            }
            
            for (int dir = 0; dir < 4; dir++) {
                int nr = r + dels[dir][0];
                int nc = c + dels[dir][1];
                int ncost = dir == d ? cost+100 : cost+600;
                
                if (!isIn(nr, nc)) continue;
                if (board[nr][nc] == 1) continue;
                if (costs[nr][nc][dir] <= ncost) continue;
                costs[nr][nc][dir] = ncost;
                
                pq.add(new int[]{nr, nc, ncost, dir});
            }
        }
        
        return ans;
    }
    
    public boolean isIn(int r, int c) {
        return r >= 0 && r < N && c >= 0 && c < N;
    }
}