import java.io.*;
import java.util.*;

public class Main {
	static class Node {
		int no;
		Node next;
		
		public Node(int no, Node next) {
			this.no = no;
			this.next = next;
		}
	}
	
	static int n, max;
	static int[] nums;
	static Node[] nodes;
	static int[][] dp;
	
	public static void main(String[] args) throws IOException {
		init();
		dfs(1, 0);
		int max = 0;
		for (int n : dp[1]) {
			max = Math.max(max, n);
		}
		System.out.println(max);
	}

	private static void dfs(int no, int parent) {
		boolean allX = true;
		int minDiff = Integer.MAX_VALUE;
		for (Node node = nodes[no]; node != null; node = node.next) {
			if (node.no == parent) continue;
			dfs(node.no, no);
			
			dp[no][0] += Math.max(dp[node.no][1], dp[node.no][2]);
			dp[no][1] += dp[node.no][2];
			dp[no][2] += Math.max(dp[node.no][0], dp[node.no][2]);
			
			if (dp[node.no][0] > dp[node.no][2]) {
				allX = false;
			} else {
				minDiff = Math.min(minDiff, Math.abs(dp[node.no][0] - dp[node.no][2]));
			}
		}
		dp[no][0] += nums[no];
		if (allX) dp[no][2] -= minDiff;
	}

	private static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strs;
		
		strs = br.readLine().split(" ");
		n = Integer.parseInt(strs[0]);
		
		nums = new int[n+1];
		nodes = new Node[n+1];
		dp = new int[n+1][3];
		
		strs = br.readLine().split(" ");
		for (int i = 1; i <= n; i++) {
			nums[i] = Integer.parseInt(strs[i-1]);
		}
		
		for (int i = 0; i < n-1; i++) {
			strs = br.readLine().split(" ");
			int s = Integer.parseInt(strs[0]);
			int e = Integer.parseInt(strs[1]);
			
			nodes[s] = new Node(e, nodes[s]);
			nodes[e] = new Node(s, nodes[e]);
		}
	}
}