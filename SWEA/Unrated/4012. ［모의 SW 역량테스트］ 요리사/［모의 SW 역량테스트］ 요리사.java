import java.io.*;
 
public class Solution {
    static StringBuilder sb = new StringBuilder();
    static int N, min;
    static int[][] arr;
    static int[] idxA, idxB, selectIdx;
    
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
        	init(br);
        	
        	bitCombi(0, 0, 0);
        	
            sb.append("#"+ test_case + " ").append(min).append("\n");
        }
        System.out.println(sb.toString());
    }
    
    // bit 마스킹을 이용한 식재료(index) 뽑기
    public static void bitCombi(int depth, int start, int flag) {
    	if (depth == N/2) {
    		for (int i = 0,j = 0,k=0; i < N; i++) {
    			if((flag & 1<<i)!=0) {
    				idxA[j++] = i;
    			} else {
    				idxB[k++] = i;
    			}
    		}
    		int diff = Math.abs(calSynergy(0,idxA,0) - calSynergy(0,idxB,0));
    		min = Math.min(min, diff);
    		return;
    	}
    	
    	for (int i = start; i < N; i++) {
    		if ((flag & 1 << i) != 0) continue;
    		bitCombi(depth+1, i+1, flag|1<<i);
    	}
    }
    
    // bit 마스킹을 이용한 뽑은 식재료 중 2개 뽑기
    public static int calSynergy(int depth, int[] idx, int flag) {
    	if (depth == 2) {
    		return arr[selectIdx[0]][selectIdx[1]];
    	}
    	
    	int synergySum = 0;
    	for (int i = 0; i < N/2; i++) {
    		if ((flag & 1 << i) != 0) continue;
    		selectIdx[depth] = idx[i];
    		synergySum += calSynergy(depth+1, idx, flag|1<<i);
		}
    	return synergySum;
    }

	public static void init(BufferedReader br) throws IOException {
        N = Integer.parseInt(br.readLine());
        min = Integer.MAX_VALUE;
        arr = new int[N][N];
        idxA = new int[N/2];
        idxB = new int[N/2];
        selectIdx = new int[2];
         
        for (int i = 0; i < N; i++) {
        	String[] strs = br.readLine().split(" ");
        	for (int j = 0; j < N; j++) {
        		arr[i][j] = Integer.parseInt(strs[j]);
			}
        }
    }
}