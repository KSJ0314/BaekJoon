import java.io.*;

public class Main {
	static int N, MK;
	static long[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		init(br);
		
		LazySegment seg = new LazySegment(arr);
		
		while (MK-- > 0) {
			String[] strs = br.readLine().split(" ");
			int oper = Integer.parseInt(strs[0]);
			int l = Integer.parseInt(strs[1])-1;
			int r = Integer.parseInt(strs[2])-1;
			
			if (oper == 1) {
				long diff = Long.parseLong(strs[3]);
				seg.update(l, r, diff);
			} else {
				long sum = seg.querySum(l, r);
				sb.append(sum).append("\n");
			}
		}
		
		System.out.println(sb);
	}
	
	static void init(BufferedReader br) throws IOException {
		String[] strs = br.readLine().split(" ");
		N = Integer.parseInt(strs[0]);
		MK = Integer.parseInt(strs[1]);
		MK += Integer.parseInt(strs[2]);
		
		arr = new long[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = Long.parseLong(br.readLine());
		}
	}
	
	// 특정 노드가 아니라 특정 구간이 자주 변경될 때, 일반적인 SegmentTree는 구간에 속한 노드 수만큼 update가 실행된다.
	// LazySegment는 특정 노드가 속한 구간을 모두 변경하는게 아니라 구간을 찾으면 업데이트할 값을 저장해두고 나중에 반영한다.
	// 나중에 구간 탐색 중에 현재 구간에 대해 반영되지 않은 값이 있는지 확인하고 반영한다.
	public static class LazySegment {
		int n;
		long[] arr, tree, lazy;

		public LazySegment(long[] arr) {
			this.arr = arr;
			n = arr.length;
			tree = new long[4*n];
			lazy = new long[4*n];
			initTree(0, n-1, 1);
		}

		private long initTree(int start, int end, int node) {
			if (start==end) return tree[node] = arr[start];
			int mid = (start+end) / 2;
			return tree[node] = initTree(start, mid, node*2) + initTree(mid+1, end, node*2+1);
		}
		
		public void update(int left, int right, long diff) {
			update(0, n-1, 1, left, right, diff);
		}
		
		private void update(int start, int end, int node, int left, int right, long diff) {
			propagation(start, end, node);
			if (right < start || end < left) return;
			
			if (left <= start && end <= right) {
				lazy[node] = diff;
				propagation(start, end, node);
				return;
			}
			
			int mid = (start+end) / 2;
			update(start, mid, node*2, left, right, diff);
			update(mid+1, end, node*2+1, left, right, diff);
			tree[node] = tree[node*2] + tree[node*2+1];
		}
		
		public long querySum(int left, int right) {
			return querySum(0, n-1, 1, left, right);
		}
		
		private long querySum(int start, int end, int node, int left, int right) {
			propagation(start, end, node);
			
			if (right < start || end < left) return 0;
			if (left <= start && end <= right) return tree[node];
			int mid = (start+end) / 2;
			return querySum(start, mid, node*2, left, right) + querySum(mid+1, end, node*2+1, left, right);
		}
		
		private void propagation(int start, int end, int node) {
			if (lazy[node] == 0) return;	// 저장된 값 있는지 확인
			
			if (start != end) {	// 자식 노드에게 저장 값 물려주기
				lazy[node*2] += lazy[node];
				lazy[node*2+1] += lazy[node];
			}
			
			tree[node] += (end-start+1) * lazy[node];	// 자식 노드 수 만큼 업데이트 실행
			lazy[node] = 0;
		}
	}
}