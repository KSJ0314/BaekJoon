import java.io.*;
import java.util.*;

public class Main {
	static int[][][][] delss = {
		{	// isStanding = 0
			{{-1,0},{1,0},{0,-2},{0,2}},	// isVertical = 0
			{{-2,0},{2,0},{0,-1},{0,1}},	// isVertical = 1
		},	
		{	// isStanding = 1
			{{-2,0},{2,0},{0,-2},{0,2}},
			{{-2,0},{2,0},{0,-2},{0,2}}
		},	
	};
	static int[][][] checkIdx = {
		{{0,-1},{0,1}},	// isVertical = 0
		{{-1,0},{1,0}},	// isVertical = 1
	};
	static int N,M;
	static int[][] arr;
	static boolean[][][][] visited;
	static Deque<Box> deque = new ArrayDeque<>();
	
	static class Box{
		int y;
		int x;
		int isStanding;	// 0 or 1
		int isVertical;	// 0 or 1
		
		public Box(int y, int x, int isStanding, int isVertical) {
			super();
			this.y = y;
			this.x = x;
			this.isStanding = isStanding;
			this.isVertical = isVertical;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		init(br);
		int count = 0;
		while (!deque.isEmpty()) {
			count++;
			if (bfs()) {
				System.out.println(count);
				return;
			}
		}
		System.out.println(-2);
	}

	private static boolean bfs() {
		int size = deque.size();
		while (size-- > 0) {
			Box box = deque.pollFirst();
			
			for (int i = 0; i < 4; i++) {
				int[] del = delss[box.isStanding][box.isVertical][i];
				
				int y = box.y + del[0];
				int x = box.x + del[1];
				int isStanding = box.isStanding;
				int isVertical = box.isVertical;
				
				if (isStanding == 1) {
					isStanding = 0;
					isVertical = i < 2 ? 1 : 0;
				} else {
					isStanding = (isVertical == 0) ? (i < 2 ? 0 : 1) : (i < 2 ? 1 : 0);
				}
				
				Box nBox = new Box(y, x, isStanding, isVertical);
				if (!isIn(nBox)) continue;
				if (visited[y][x][isStanding][isVertical]) continue;
				visited[y][x][isStanding][isVertical] = true;
				
				int fallFlag = isFall(nBox);
				if (fallFlag == 3) return true;
				if (fallFlag == 0) continue;
				
				deque.offer(nBox);
			}
		}
		return false;
	}

	static int isFall(Box box) {
		int y = box.y, x = box.x, isStanding = box.isStanding, isVertical = box.isVertical;
		
		int y1 = y + checkIdx[isVertical][0][0];
		int x1 = x + checkIdx[isVertical][0][1];
		int y2 = y + checkIdx[isVertical][1][0];
		int x2 = x + checkIdx[isVertical][1][1];
		
		if (arr[y][x] == 3) return 3;
		if (isStanding == 0 && arr[y1][x1] == 3 && (arr[y][x] != 0 || arr[y2][x2] != 0)) return 3;
		if (isStanding == 0 && arr[y2][x2] == 3 && (arr[y][x] != 0 || arr[y1][x1] != 0)) return 3;
		
		if (arr[y][x] != 0) return 1;
		if (isStanding == 0 && arr[y1][x1] != 0 && arr[y2][x2] != 0) return 1;
		
		return 0;
	}

	public static boolean isIn(Box box) {
		int y = box.y, x = box.x, isStanding = box.isStanding, isVertical = box.isVertical;
		
		if (isStanding == 1) {
			return y>=0 && y<N && x>=0 && x<M;
		} else {
			if (isVertical == 1) {
				return y>=1 && y<N-1 && x>=0 && x<M;
			} else {
				return y>=0 && y<N && x>=1 && x<M-1;
			}
		}
	}

	public static void init(BufferedReader br) throws IOException {
		String[] strs = br.readLine().split(" ");
		N = Integer.parseInt(strs[0]);
		M = Integer.parseInt(strs[1]);
		arr = new int[N][M];
		visited = new boolean[N][M][2][2];
		
		for (int i = 0; i < N; i++) {
			strs = br.readLine().split("");
			for (int j = 0; j < M; j++) {
				int num = Integer.parseInt(strs[j]);
				arr[i][j] = num;
				if (num == 2) {
					Box box = new Box(i, j, 1, 0);
					deque.offerLast(box);
				}
			}
		}
		
	}
	
}