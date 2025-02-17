import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	public static int[][] dels = {{0,0},{-1,0},{1,0},{0,-1},{0,1}};	// 상하좌우
	public static int R,C,N;
	public static boolean[][] prev;
	public static boolean[][] next;
	public static boolean[][][] pattern;

	public static void main(String[] args) throws IOException{
		//--------------솔루션 코드를 작성하세요.--------------------------------
		init();
		
		if (N <= 2) {
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					String str = "O";
					if (N == 1) str = prev[i][j] ? "O" : ".";
					System.out.print(str);
				}
				System.out.println();
			}
			return;
		}
		N-=3;
		findPattern();
		
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				String str = ".";
				if (pattern[N%4][i][j]) {
					str = "O";
				}
				System.out.print(str);
			}
			System.out.println();
		}
	}
	
	public static void findPattern() {
		for (int k = 0; k < 4; k++) {
			if (k%2 == 0) {
				for (int i = 0; i < R; i++) {
					for (int j = 0; j < C; j++) {
						if (prev[i][j]) {
							for (int[] del : dels) {
								int ni = i +del[0];
								int nj = j +del[1];
								if (!isIn(ni, nj)) continue;
								next[ni][nj] = false; 
							}
						}
					}
				}
				for (int i = 0; i < R; i++) {
					prev[i] = next[i].clone(); 
				}
			} else {
				for (int i = 0; i < R; i++) {
					for (int j = 0; j < C; j++) {
						next[i][j] = !prev[i][j]; 
					}
				}
			}
			if (k%2 == 0) {
				for (int i = 0; i < R; i++) {
					pattern[k][i] = prev[i].clone();
				}
			} else {
				for (int i = 0; i < R; i++) {
					for (int j = 0; j < C; j++) {
						pattern[k][i][j] = true;
					}
				}
			}
		}
	}
	
	public static boolean isIn(int y, int x) {
		return y>=0 && y<R && x>=0 && x<C;
	}
	
	public static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] strs = br.readLine().split(" ");
		R = Integer.parseInt(strs[0]);
		C = Integer.parseInt(strs[1]);
		N = Integer.parseInt(strs[2]);
		prev = new boolean[R][C];
		next = new boolean[R][C];
		pattern = new boolean[4][R][C];
		
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				next[i][j] = true;
				if (str.charAt(j) == 'O') prev[i][j]=true; 
			}
		}
		
	}

}