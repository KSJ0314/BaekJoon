import java.io.*;
import java.util.*;

public class Main {
	static ArrayList<Integer> res;
	static boolean isCertain = true;
	static boolean isImpossible = false;
	static int n;
	static int[] inDegrees;
	static HashSet<Integer>[] outDegrees;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strs;
		
		strs = br.readLine().split(" ");
		int T = Integer.parseInt(strs[0]);
		
		for (int test_case = 1; test_case <= T; test_case++) {
			isCertain = true;
			isImpossible = false;
			res = new ArrayList<Integer>();
			
			strs = br.readLine().split(" ");
			n = Integer.parseInt(strs[0]);
			
			outDegrees = new HashSet[n+1];
			inDegrees = new int[n+1];
			int[] ranks = new int[n];
			int[] rankIdxs = new int[n+1];
			
			strs = br.readLine().split(" ");
			for (int i = 0; i < n; i++) {
				ranks[i] = Integer.parseInt(strs[i]);
				inDegrees[ranks[i]] = i;
				rankIdxs[ranks[i]] = i;
			}
			for (int i = 0; i < n; i++) {
				outDegrees[ranks[i]] = new HashSet<>();
				for (int j = i+1; j < n; j++) {
					outDegrees[ranks[i]].add(ranks[j]);
				}
			}
			
			strs = br.readLine().split(" ");
			int m = Integer.parseInt(strs[0]);
			for (int i = 0; i < m; i++) {
				strs = br.readLine().split(" ");
				int a = Integer.parseInt(strs[0]);
				int b = Integer.parseInt(strs[1]);
				
				int A, B;
				if (rankIdxs[a] > rankIdxs[b]) {
					A = a;
					B = b;
				} else {
					A = b;
					B = a;
				}
				
				inDegrees[B]++;
				inDegrees[A]--;
				outDegrees[B].remove(A);
				outDegrees[A].add(B);
			}
			
			topologicalSort();
			
			if (isImpossible) System.out.println("IMPOSSIBLE");
			else if (!isCertain) System.out.println("?");
			else {
				StringBuilder sb = new StringBuilder();
				for (int num : res) {
					sb.append(num+" ");
				}
				System.out.println(sb);
			}
		}
	}
	
	private static void topologicalSort() {
		ArrayDeque<Integer> deq = new ArrayDeque<>();
		
		for (int i = 1; i <= n; i++) {
			if (inDegrees[i] == 0) deq.add(i);
		}
		 
		int cnt = n;
		while(!deq.isEmpty()) {
			if (deq.size() > 1) isCertain = false;
			int crt = deq.poll();
			cnt--;
			res.add(crt);
			
			for (int out : outDegrees[crt]) {
				inDegrees[out]--;
				if (inDegrees[out] == 0) deq.add(out);
			}
		}
		if (cnt > 0) isImpossible = true;
	}
}