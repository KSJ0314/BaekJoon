import java.io.*;
import java.util.*;

public class Solution {
	static int[] p;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#"+test_case+" ");
			String[] strs = br.readLine().split(" ");
			int N = Integer.parseInt(strs[0]);
			int M = Integer.parseInt(strs[1]);
			p = new int[N+1];
			for (int i = 1; i <= N; i++) {
				p[i] = i;
			}
			
			for (int i = 0; i < M; i++) {
				strs = br.readLine().split(" ");
				int oper = Integer.parseInt(strs[0]);
				int a = Integer.parseInt(strs[1]);
				int b = Integer.parseInt(strs[2]);
				
				if (oper == 0) {
					union(a, b);
				} else {
					sb.append(find(a) == find(b) ? 1 : 0);
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}

	static void union(int a, int b) {
		p[find(b)] = find(p[a]);
	}
	
	static int find(int a) {
		if (a == p[a]) return a;
		return p[a] = find(p[a]);
	}

}