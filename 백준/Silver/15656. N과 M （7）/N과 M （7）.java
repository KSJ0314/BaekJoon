import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int N, M;
    static int[] nums;
    static StringBuilder sb;
	
    public static void main(String[] args) throws IOException {
        init();
        
        dfs(0, "");
        
        System.out.println(sb);
    }
    
    public static void dfs(int depth, String str) {
    	if (depth == M) {
    		sb.append(str.trim()).append("\n");
    		return;
    	}
    	
    	for (int i = 0; i < N; i++) {
			dfs(depth+1, str+nums[i]+" ");
		}
    }
    
    public static void init() throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	String[] strs = br.readLine().split(" ");
        N = Integer.parseInt(strs[0]);
        M = Integer.parseInt(strs[1]);
        nums = new int[N];
        
        strs = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
        	nums[i] = Integer.parseInt(strs[i]);
        }
        Arrays.sort(nums);
        
        sb = new StringBuilder();
    }
}