import java.io.*;

public class Main {
	static int N, MK;
	static long[] arr, tree;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] strs;
		init(br);
		
		makeTree(0,N-1,1);
		
		while (MK-- > 0) {
			strs = br.readLine().split(" ");
			int oper = Integer.parseInt(strs[0]);
			
			if (oper == 1) {
				int idx = Integer.parseInt(strs[1])-1;
				long value = Long.parseLong(strs[2]);
				long diff = value - arr[idx];
				updateTree(0, N-1, 1, idx, diff);
				arr[idx] = value;
			} else {
				int l = Integer.parseInt(strs[1])-1;
				int r = Integer.parseInt(strs[2])-1;
				long sum = sumTree(0, N-1, 1, l, r);
				sb.append(sum).append("\n");
			}
		}
		
		System.out.println(sb);
	}

	static long makeTree(int s, int e, int n) {
		if (s == e) return tree[n] = arr[s];
		int mid = (s+e)/2;
		return tree[n] = makeTree(s, mid, n*2) + makeTree(mid+1, e, n*2+1);
	}
	
	static long sumTree(int s, int e, int n, int l, int r) {
		if (r < s || e < l) return 0;
		if (l <= s && e <= r) return tree[n];
		int mid = (s+e)/2;
		return sumTree(s, mid, n*2, l, r) + sumTree(mid+1, e, n*2+1, l, r);
	}
	
	static void updateTree(int s, int e, int n, int idx, long diff) {
		if (idx < s || e < idx) return;
		
		tree[n] += diff;
		
		if (s == e) return;
		
		int mid = (s+e)/2;
		updateTree(s, mid, n*2, idx, diff);
		updateTree(mid+1, e, n*2+1, idx, diff);
	}

	static void init(BufferedReader br) throws IOException {
		String[] strs = br.readLine().split(" ");
		N = Integer.parseInt(strs[0]);
		MK = Integer.parseInt(strs[1]);
		MK += Integer.parseInt(strs[2]);
		
		arr = new long[N];
		tree = new long[4*N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(br.readLine());
		}
		
	}
	
}