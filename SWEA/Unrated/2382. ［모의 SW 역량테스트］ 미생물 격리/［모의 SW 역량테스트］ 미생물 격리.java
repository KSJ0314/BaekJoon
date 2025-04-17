import java.io.*;
import java.util.*;

public class Solution {
	static class Cell implements Comparable<Cell>{
		int y, x, cnt, delIdx;

		public Cell(int y, int x, int cnt, int delIdx) {
			this.y = y;
			this.x = x;
			this.cnt = cnt;
			this.delIdx = delIdx;
		}

		@Override
		public int compareTo(Cell o) {
			return Integer.compare(this.cnt, o.cnt) * -1;
		}
	}
	static int[][] dels = {{-1,0},{1,0},{0,-1},{0,1}};
	static int N, M;
	static int[][] arr, nextArr;
	static PriorityQueue<Cell> pQ, nextPQ;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			sb.append("#"+t+" ");
			
			init(br);
			fnc();
			sb.append(calTotal());
			
			sb.append("\n");
		}
		
		System.out.println(sb);
	}

	static void fnc() {
		while (M-- > 0) {
			nextArr = new int[N][N];
			int size = pQ.size();
			while (size-- > 0) {
				Cell cell = pQ.poll();
				
				if (arr[cell.y][cell.x] == 0) continue;
				
				cell.cnt = arr[cell.y][cell.x];
				arr[cell.y][cell.x] = 0;
				
				cell.y += dels[cell.delIdx][0];
				cell.x += dels[cell.delIdx][1];
				
				if (isEdge(cell.y, cell.x)) {
					cell.cnt/=2;
					cell.delIdx += cell.delIdx%2==0 ? 1 : -1;
				}
				
				nextArr[cell.y][cell.x] += cell.cnt;
				nextPQ.offer(cell);
			}
			arr = nextArr;
			pQ = nextPQ;
			nextPQ = new PriorityQueue<>();
		}
	}

	private static int calTotal() {
		int total = 0;
		while (!pQ.isEmpty()) {
			total += pQ.poll().cnt;
		}
		return total;
	}
	
	static boolean isEdge(int y, int x) {
		return y==0 || y==N-1 || x==0 || x==N-1;
	}

	static void init(BufferedReader br) throws IOException {
		String[] strs;
		strs =  br.readLine().split(" ");
		
		N = Integer.parseInt(strs[0]);
		M = Integer.parseInt(strs[1]);
		int K = Integer.parseInt(strs[2]);
		
		arr = new int[N][N];
		pQ = new PriorityQueue<>();
		nextPQ = new PriorityQueue<>();
		
		while (K-- >0){
			strs =  br.readLine().split(" ");
			int i = Integer.parseInt(strs[0]);
			int j = Integer.parseInt(strs[1]);
			int cnt = Integer.parseInt(strs[2]);
			int delIdx = Integer.parseInt(strs[3])-1;
			
			pQ.offer(new Cell(i, j, cnt, delIdx));
			arr[i][j] = cnt;
		}
	}
	
}