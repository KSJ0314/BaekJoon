class Solution {
	int n, k, maxDepth;
	int[][] dungeons;
	
	public int solution(int k, int[][] dungeons) {
		this.k = k;
		this.dungeons = dungeons;
		n = dungeons.length;
		perm(0, 0, 0);
		
        return maxDepth;
    }
    
    public void perm(int depth, int hp, int flag) {
    	if (depth == n)	{
    		maxDepth = n;
    		return;
    	}
    	
    	for (int i = 0; i < n; i++) {
			if ((flag&1<<i) != 0) continue;
			if (hp+dungeons[i][0] > k) continue;
			perm(depth+1, hp+dungeons[i][1], flag|1<<i);
		}
    	maxDepth = Math.max(maxDepth, depth);
    }
}