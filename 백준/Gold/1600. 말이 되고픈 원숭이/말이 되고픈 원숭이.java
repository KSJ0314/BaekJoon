import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Main {
	static int[][][] delss = {
			{{2,1},{1,2},{-2,1},{-1,2},{1,-2},{2,-1},{-1,-2},{-2,-1}},	// 말 움직임
			{{1,0},{0,1},{-1,0},{0,-1}}	// 원숭이 움직임 하,우,상,좌
	};
	static int K,W,H,min;
	static int[][] arr;
	static boolean isEnd;
	static Deque<Move> que;
	static boolean[][][] visited;
	
	public static class Move{
		int y,x,horse;
		
		public Move(int y, int x, int horse) {
			this.y = y;
			this.x = x;
			this.horse = horse;
		}
		@Override
		public String toString() {
			return "Move [y=" + y + ", x=" + x + ", horse=" + horse + ", visited=" + Arrays.toString(visited) + "]";
		}
		
	}

	public static void main(String[] args) throws IOException {
		init();
		
		int count = -1;
		
		while (!que.isEmpty()) {
			bfs();
			count++;
			if (isEnd) {
				min = count;
				break;
			}
			//System.out.println();
		}
		
		System.out.println(min);
	}

	private static void bfs() {
		int size = que.size();
		while (size-- >0) {
			Move move = que.pollFirst();
			//System.out.println(move.toString());
			
			int y = move.y;
			int x = move.x;
			int horse = move.horse;
			
			if (y == H-1 && x == W-1) {
				isEnd = true;
				return;
			}
			
			int oper = 1;
			for (int[][] dels : delss) {
				if (oper == 1 && horse >= K) {
					oper = 0;
					continue;
				}
				for (int[] del : dels) {
					int ny = y + del[0];
					int nx = x + del[1];
					
					if (!isIn(ny, nx)) continue;
					if (arr[ny][nx] == 1) continue;
					if (visited[horse+oper][ny][nx]) continue;
					visited[horse+oper][ny][nx] = true;
					
					que.offerLast(new Move(ny, nx, horse+oper));
				}
				oper = 0;
			}
		}
	}
	
	public static boolean isIn(int y, int x) {
		return y>=0 && y<H && x>=0 && x<W;
	}

	public static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		String[] strs = br.readLine().split(" ");
		W = Integer.parseInt(strs[0]);
		H = Integer.parseInt(strs[1]);
		arr = new int[H][W];
		visited = new boolean[K+1][H][W];
		min = -1;
		isEnd = false;
		que = new ArrayDeque<>();
		que.offerLast(new Move(0,0,0));
		
		for (int i = 0; i < H; i++) {
			strs = br.readLine().split(" ");
			for (int j = 0; j < W; j++) {
				arr[i][j] = Integer.parseInt(strs[j]);
			}
		}
	}
	
}