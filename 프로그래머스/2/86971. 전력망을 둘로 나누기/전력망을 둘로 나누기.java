class Solution {
	int n;
	boolean[][] isConnectOrigin;
	boolean[][] isConnect;
	
    public int solution(int n, int[][] wires) {
    	this.n = n;
    	isConnectOrigin = new boolean[n+1][n+1];
    	isConnect = new boolean[n+1][n+1];
    	for (int[] wire : wires) {
    		isConnectOrigin[wire[0]][wire[1]] = true;
    		isConnectOrigin[wire[1]][wire[0]] = true;
    	}
    	int minAbs = Integer.MAX_VALUE;
    	for (int[] wire : wires) {
    		for (int i = 0; i <= n; i++) {
    			isConnect[i] = isConnectOrigin[i].clone();
			}
			isConnect[wire[0]][wire[1]] = false;
			isConnect[wire[1]][wire[0]] = false;
    		minAbs = Math.min(minAbs, Math.abs(n-calcTreeSize(wire[0])*2));
    	}
        return minAbs;
    }

	public int calcTreeSize(int idx) {
		int size = 1;
		for (int i = 0; i <= n; i++) {
			if (!isConnect[idx][i]) continue;
			isConnect[idx][i] = false;
			isConnect[i][idx] = false;
			size += calcTreeSize(i);
		}
		return size;
	}
}