import java.io.*;

public class Main {
	static int N, MK;
	static long[] arr, tree, lazy;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		init(br);
		initTree(0,N-1,1);
		
		while (MK-- >0) {
			String[] strs = br.readLine().split(" ");
			int flag = Integer.parseInt(strs[0]);
			int l = Integer.parseInt(strs[1])-1;
			int r = Integer.parseInt(strs[2])-1;
			
			if (flag == 1) {
				long diff = Long.parseLong(strs[3]);
				updateTree(0, N-1, 1, l, r, diff);
			} else {
				long sum = sumTree(0, N-1, 1, l, r);
				sb.append(sum).append("\n");
			}
		}
		System.out.println(sb.toString());
	}

	private static long initTree(int s, int e, int n) {
		if (s == e) return tree[n] = arr[s];
		int mid = (s+e)/2;
		return tree[n] = initTree(s, mid, n*2) + initTree(mid+1, e, n*2+1);
	}

	private static long sumTree(int s, int e, int n, int l, int r) {
		propa(s, e, n);
		if (e < l || r < s) return 0;
		if (l <= s && e <= r) return tree[n];
		
		int mid = (s+e)/2;
		
		return sumTree(s, mid, n*2, l, r) + sumTree(mid+1, e, n*2+1, l, r);
	}
	
	private static void updateTree(int s, int e, int n, int l, int r, long diff) {
		propa(s, e, n);
		
		if (e < l || r < s) return;
		
		if (l <= s && e <= r) {
			lazy[n] = diff;
			propa(s, e, n);
			return;
		}
		
		int mid = (s+e)/2;
		updateTree(s, mid, n*2, l, r, diff);
		updateTree(mid+1, e, n*2+1, l, r, diff);
		tree[n] = tree[n*2]+tree[n*2+1];
	}
	
	public static void propa(int s, int e, int n) {
		if (lazy[n] == 0) return;
		
		if (s != e) {
			lazy[n*2] += lazy[n];
			lazy[n*2+1] += lazy[n];
		}
		
		tree[n] += (e-s+1) * lazy[n];
		lazy[n] = 0;
	}

	public static void init(BufferedReader br) throws IOException {
		String[] strs = br.readLine().split(" ");
		N = Integer.parseInt(strs[0]);
		MK = Integer.parseInt(strs[1]);
		MK += Integer.parseInt(strs[2]);
		arr = new long[N];
		tree = new long[4*N+1];
		lazy = new long[4*N+1];
		
		for (int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(br.readLine());
		}
	}
	
}