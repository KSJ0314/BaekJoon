import java.io.*;
import java.util.*;

public class Solution {
	static int N, M, cnt;
	static int[] p;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			sb.append("#").append(test_case).append(" ");
			
			init(br);
			sb.append(cnt);
			
			sb.append("\n");
		}
		System.out.println(sb);
	}

	static void init(BufferedReader br) throws IOException {
		String[] strs = br.readLine().split(" ");
		N = Integer.parseInt(strs[0]);
		M = Integer.parseInt(strs[1]);
		p = new int[N+1];
		cnt = 0;
		
		for (int i = 0; i <= N; i++) {
			p[i] = i;
		}
		
		for (int i = 0; i < M; i++) {
			strs = br.readLine().split(" ");
			int a =Integer.parseInt(strs[0]);
			int b =Integer.parseInt(strs[1]);
			union(a,b);
		}
		for (int i = 1; i <= N; i++) {
			find(i);
		}
		Set<Integer> set = new HashSet<>();
		for (int i = 1; i <= N; i++) {
			set.add(p[i]);
		}
		cnt = set.size();
	}

	static void union(int a, int b) {
		p[find(b)] = find(a);
	}

	static int find(int a) {
		if (a == p[a]) return a;
		return p[a] = find(p[a]);
	}
}