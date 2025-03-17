import java.io.*;
import java.util.*;

public class Main {
	static int N, cnt, eY, eX, eOper;
	static int[][] arr;
	static Deque<int[]> deque;
	static boolean isGole;
	static boolean[][][] visited;
	static int[][] dels = {
		{0,1},{0,-1},{1,0},{-1,0}
	};

	public static void main(String[] args) throws IOException{
		//--------------솔루션 코드를 작성하세요.--------------------------------
		init();
		
		while(!deque.isEmpty()) {
			bfs();
			if (isGole) break;
			cnt++;
		}
		
		System.out.println(isGole?cnt:"0");
	}
	
	private static void bfs() {
		int size = deque.size();
		
		while (size-- > 0) {
			int[] coors = deque.pollFirst();
			int y = coors[0];
			int x = coors[1];
			int oper = coors[2];
			if (eOper == oper && eY == y && eX == x) {
				isGole = true;
				break;
			}
			
			for (int[] del : dels) {
				int ny = y + del[0];
				int nx = x + del[1];
				
				if (!isIn(ny, nx, oper)) continue;
				if (visited[oper][ny][nx]) continue;
				visited[oper][ny][nx] = true;
				deque.offerLast(new int[] {ny, nx, oper});
			}
			
			if(!canTurn(y, x, oper^1)) continue;
			if (visited[oper^1][y][x]) continue;
			visited[oper^1][y][x] = true;
			deque.offerLast(new int[] {y, x, oper^1});
		}
		
	}

	static boolean canTurn(int y, int x, int oper) {
		for (int i = y-1; i <= y+1; i++) {
			for (int j = x-1; j <= x+1; j++) {
				if (!isIn(i, j)) return false;
				if (arr[i][j] == 1) return false;
			}
		}
		return true;
	}
	
	static boolean isIn(int y, int x, int oper) {
		for (int i = -1; i <= 1; i++) {
			int ny = y + (oper == 0 ? i : 0);
			int nx = x + (oper == 1 ? i : 0);
			if (!isIn(ny, nx)) return false;
			if (arr[ny][nx] == 1) return false;
		}
		return true;
	}
	
	static boolean isIn(int y, int x) {
		return y>=0 && y <N && x>=0 && x<N;
	}
	
	static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		int[] coors = new int[3];
		deque = new ArrayDeque<>();
		isGole = false;
		visited = new boolean[2][N][N];
		int oper = 0;
		eOper = 0;
		
		String[] strs;
		boolean isCenter = false;
		boolean isCenter2 = false;
		for (int i = 0; i < N; i++) {
			strs = br.readLine().split("");
			int cnt = 0;
			int cnt2 = 0;
			for (int j = 0; j < N; j++) {
				int num = 0;
				if (strs[j].equals("B")) {
					num = 3;
					cnt++;
					
					if (isCenter) {
						coors[0] = i;
						coors[1] = j;
						isCenter = false;
					} else {						
						isCenter = true;
					}
				} else if (strs[j].equals("E")) {
					num = 2;
					cnt2++;
					
					if (isCenter2) {
						eY = i;
						eX = j;
						isCenter2 = false;
					} else {						
						isCenter2 = true;
					}
				} else if (strs[j].equals("1")){
					num = 1;
				}
				arr[i][j] = num;
			}
			if (cnt>1) oper = 1;
			if (cnt2>1) eOper = 1;
		}
		coors[2] = oper;
		visited[oper][coors[0]][coors[1]] = true;
		deque.offerLast(coors);
	}
}