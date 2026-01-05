class Solution {
    int n, count;
    int[] parents;
    
    public int solution(int n, int[][] computers) {
        this.n = n;
        count = n;
        parents = new int[n];
        for (int i = 0; i < n; i++) {
        	parents[i] = i;
        }
        
        for (int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                if (computers[i][j] == 0) continue;
                union(i, j);
            }
        }
        
        return count;
    }
    
    public int find(int a){
        if (a == parents[a]) return a;
        return parents[a] = find(parents[a]);
    }
    
    public boolean union(int a, int b){
        int aR = find(a);
        int bR = find(b);
        
        if (aR == bR) return false;
        parents[bR] = aR;
        count--;
        return true;
    }
}