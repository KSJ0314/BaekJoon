import java.io.*;

public class Main {
	static int N, MK;
	static long[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		init(br);
		
		Segment seg = new Segment(arr);
		
		while (MK-- > 0) {
			String[] strs = br.readLine().split(" ");
			int oper = Integer.parseInt(strs[0]);
			
			if (oper == 1) {
				int idx = Integer.parseInt(strs[1])-1;
				long value = Long.parseLong(strs[2]);
				
				seg.update(idx, value);
			} else {
				int l = Integer.parseInt(strs[1])-1;
				int r = Integer.parseInt(strs[2])-1;
				
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
    
	
	// SegmentTree는 노드의 변경이 자주 일어나는 구간의 합, 곱, max등을 구할때 사용한다.
	// init, update, query(합, 곱, max 등 반환) 3가지 메서드를 구현한다.
	// init: O(n)  |  update: O(logN)  |  query: O(longN)
	public static class Segment {
		int n;
		long[] arr, tree;

		// initTree는 세그먼트 트리가 생성될 때 초기에 단 한번 실행된다.
		// 생성자를 호출할 때 구간합을 구할 배열을 바로 받아서 생성자 내부에서 트리를 초기화한다.
		public Segment(long[] arr) {
			this.arr = arr;
			n = arr.length;
			tree = new long[4*n];	// 넉넉잡아 4n 크기로 만든다.
			initTree(0, n-1, 1);
		}

		private long initTree(int start, int end, int node) {
			if (start==end) return tree[node] = arr[start];
			
			int mid = (start+end) / 2;
			return tree[node] = initTree(start, mid, node*2) + initTree(mid+1, end, node*2+1);
		}
		
		// 항상 초기 실행은 start=0, end=n-1, node=1이다.
		// 사용성 향상을 위해 idx와 value만으로 이용할 수 있게 오버로딩해둠
		public void update(int idx, long value) {
			long diff = value - arr[idx];
			update(0, n-1, 1, idx, diff);
			arr[idx] = value;
		}
		
		// start, end => 현재 보고있는 구간
		// idx => 찾으려는 위치
		private void update(int start, int end, int node, int idx, long diff) {
			if (idx < start || end < idx) return;	// 찾으려는 위치가 현재 보고있는 구간 밖에 있는 경우
			
			tree[node] += diff;		// 찾으려는 위치가 현재 보고 있는 구간에 포함되는 경우 값 업데이트
			
			if (start == end) return;	// 하위 노드가 없으면 종료
			
			// 하위 노드도 모두 업데이트 해준다.
			int mid = (start+end) / 2;
			update(start, mid, node*2, idx, diff);
			update(mid+1, end, node*2+1, idx, diff);
		}
		
		// 오버로딩
		public long querySum(int left, int right) {
			return querySum(0, n-1, 1, left, right);
		}
		
		// start, end => 현재 보고있는 구간
		// left, right => 찾으려는 구간
		private long querySum(int start, int end, int node, int left, int right) {
			if (right < start || end < left) return 0;				// 찾으려는 구간이 현재 보고있는 구간 밖에 있는 경우
			if (left <= start && end <= right) return tree[node];	// 현재 보고있는 구간이 찾으려는 구간에 완전히 포함되면 값을 리턴
			
			// 현재 보고있는 구간이 찾으려는 구간과 걸쳐진 경우, 구간을 분할해서 정밀하게 찾는다.
			int mid = (start+end) / 2;
			return querySum(start, mid, node*2, left, right) + querySum(mid+1, end, node*2+1, left, right);
		}
	}
}