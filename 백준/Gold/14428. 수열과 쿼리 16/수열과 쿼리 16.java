import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strs;
		
		strs = br.readLine().split(" ");
		N = Integer.parseInt(strs[0]);
		arr = new int[N+1];
		
		strs = br.readLine().split(" ");
		for (int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(strs[i-1]);
		}
		
		SegmentTree seg = new SegmentTree(arr);
		
		strs = br.readLine().split(" ");
		int T = Integer.parseInt(strs[0]);
		StringBuilder sb = new StringBuilder();
		
		for (int test_case = 1; test_case <= T; test_case++) {
			strs = br.readLine().split(" ");
			
			int flag = Integer.parseInt(strs[0]);
			int a = Integer.parseInt(strs[1]);
			int b = Integer.parseInt(strs[2]);
			if (flag == 1) {
				seg.update(a, b);
			} else {
				int ans = seg.query(a, b);
				sb.append(ans).append("\n");
			}
		}
		System.out.println(sb);
	}
	
	static class SegmentTree {
		int n;
		int[] tree, arr;
		
		public SegmentTree(int[] arr) {
			this.n = arr.length;
			tree = new int[n*4];
			this.arr = arr;
			
			makeTree(1, 0, n-1);
		}
		
		private int minIdx(int a, int b) {
	        return arr[a] <= arr[b] ? a : b;
	    }
		
		private void makeTree(int node, int s, int e) {
			if (s == e) {
				tree[node] = s;
				return;
			}
			
			int mid = (s+e)/2;
			makeTree(2*node, s, mid);
			makeTree(2*node+1, mid+1, e);
			tree[node] = minIdx(tree[2*node], tree[2*node+1]);
		}
		
		public void update(int idx, int v) {
			arr[idx] = v;
			update(1, 0, n-1, idx);
		}
		public void update(int node, int s, int e, int idx) {
			if (s == e) {
				tree[node] = s;
				return;
			}
			
			int mid = (s+e)/2;
			if (idx <= mid) {
				update(2*node, s, mid, idx);
			} else {
				update(2*node+1, mid+1, e, idx);
			}
			tree[node] = minIdx(tree[2*node], tree[2*node+1]);
		}
		
		public int query(int i, int j) {
			return query(1, 0, n-1, i, j);
		}

		private int query(int node, int s, int e, int i, int j) {
			if (e < i || j < s) return -1;				// 완전 밖
	        if (i <= s && e <= j) return tree[node];	// 내부

	        int mid = (s + e) / 2;
	        int left  = query(2 * node, s, mid, i, j);
	        int right = query(2 * node + 1, mid + 1, e, i, j);

	        if (left == -1)  return right;
	        if (right == -1) return left;
	        return minIdx(left, right);
		}
	}
}