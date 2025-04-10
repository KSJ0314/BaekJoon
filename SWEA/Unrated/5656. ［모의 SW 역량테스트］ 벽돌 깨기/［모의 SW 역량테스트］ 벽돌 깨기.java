import java.io.*;

public class Solution {
	static int[][] dels = {{-1,0},{1,0},{0,-1},{0,1}};
	static int N,W,H,min;
	static int[][] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= t; test_case++) {
			init(br);
			
			dfs(0);
			
			sb.append("#"+test_case+" ").append(min).append("\n");
		}
		System.out.println(sb.toString());
		
	}

	private static void dfs(int depth) {
		if (depth == N) {
			min = Math.min(min, countBrick());
			return;
		}
		
		for (int i = 0; i < W; i++) {
			int[][] copyArr = arrDeepCopy();
			brickOut(i);
			dfs(depth+1);
			arr = copyArr;
		}
		
	}

	private static void brickOut(int x) {
		int y = 0;
		for (int i = 0; i < H; i++) {
			y = i;
			if (arr[i][x] != 0) break;
		}
		
		brickOutDFS(y, x);
		brickDown();
	}

	private static void brickOutDFS(int y, int x) {
		if (!isIn(y, x)) return;
		
		int range = arr[y][x]-1;
		arr[y][x] = 0;
		
		for (int[] del : dels) {
			int ny = y;
			int nx = x;
			
			for (int i = 0; i < range; i++) {
				ny += del[0];
				nx += del[1];
				
				brickOutDFS(ny, nx);
			}
		}
		
	}

	private static void brickDown() {
		for (int j = 0; j < W; j++) {
			for (int i = H-1; i > 0; i--) {
				if (arr[i][j] != 0) continue;
				boolean down = false;
				for (int i2 = i; i2 > 0; i2--) {
					if (arr[i2-1][j] != 0) down = true;
					arr[i2][j] = arr[i2-1][j];
				}
				arr[0][j] = 0;
				if (down) i++;
			}
		}
	}
	
	private static int countBrick() {
		int count = 0;
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				if (arr[i][j] != 0) count++;
			}
		}
		return count;
	}

	public static int[][] arrDeepCopy(){
		int[][] copy = new int[H][W];
		for (int i = 0; i < H; i++) {
			copy[i] = arr[i].clone();
		}
		return copy;
	}

	public static boolean isIn(int y, int x) {
		return y>=0 && y<H && x>=0 && x<W;
	}
	
	public static void init(BufferedReader br) throws IOException {
		String[] strs = br.readLine().split(" ");
		N = Integer.parseInt(strs[0]);
		W = Integer.parseInt(strs[1]);
		H = Integer.parseInt(strs[2]);
		arr = new int[H][W];
		min = Integer.MAX_VALUE;
		
		for (int i = 0; i < H; i++) {
			strs = br.readLine().split(" ");
			for (int j = 0; j < W; j++) {
				arr[i][j] = Integer.parseInt(strs[j]);
			}
		}
	}
}