import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int N;
    static int[] w, v;
	
    public static void main(String[] args) throws IOException {
        init();
        final int hp = 100-1; // 최대 체력: 100, 체력이 0이 되면 안되기 때문에 99까지 가능
        int[] dp = new int[hp+1];
        
        for (int i = 0; i < N; i++) {
			for (int j = hp; j >= 0; j--) {
				if (j < w[i]) continue;
				dp[j] = Math.max(dp[j], dp[j-w[i]] + v[i]);
			}
		}
        
        System.out.println(dp[hp]);
    }
    
    public static void init() throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        w = new int[N];
        v = new int[N];
        
        String[] strs = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            w[i] = Integer.parseInt(strs[i]);
		}
        strs = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
        	v[i] = Integer.parseInt(strs[i]);
        }
    }
}