import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strs;
		
		final int LIMIT = 100001;
		
		strs = br.readLine().split(" ");
		int N = Integer.parseInt(strs[0]);
		int K = Integer.parseInt(strs[1]);
		
		int[] depth = new int[LIMIT];
		int[] cnt = new int[LIMIT];
		
		Arrays.fill(depth, LIMIT);
		
		depth[N] = 0;
		cnt[N] = 1;
		
		ArrayDeque<Integer> deq = new ArrayDeque<>();
		deq.add(N);
		
		while (!deq.isEmpty()) {
			int crt = deq.pollFirst();
			if (depth[crt] > depth[K]) break;
			
			int[] nexts = {crt-1, crt+1, crt*2};
			
			for (int next : nexts) {
				if (next < 0 || next >= LIMIT) continue;
				
				if (depth[next] == LIMIT) {
					depth[next] = depth[crt] + 1;
                    cnt[next] = cnt[crt];
                    deq.addLast(next);
				} else if (depth[next] == depth[crt] + 1) {
					cnt[next] += cnt[crt];
	            }
			} 
		}
		
		System.out.println(depth[K]);
        System.out.println(cnt[K]);
	}
}