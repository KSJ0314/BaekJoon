import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static int[][] dels = {{-1,0},{1,0},{0,-1},{0,1}};	// 상하좌우
	public static int R,C,N;
	public static boolean[][] prev;
	public static boolean[][] next;

	public static void main(String[] args) throws IOException{
		//--------------솔루션 코드를 작성하세요.--------------------------------
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] strs = br.readLine().split(" ");
		R = Integer.parseInt(strs[0]);
		C = Integer.parseInt(strs[1]);
		N = Integer.parseInt(strs[2]);
		prev = new boolean[R][C];
		next = new boolean[R][C];
		
		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				if (str.charAt(j) == 'O') prev[i][j]=true; 
			}
		}
		if (N % 2 == 0) {
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					System.out.print("O");
				}
				System.out.println();
			}
			return;
		}
		N--;
		
		while(N-- > 0) {
			if (N%2 == 1) {
				for (int i = 0; i < R; i++) {
					for (int j = 0; j < C; j++) {
						next[i][j] = !prev[i][j]; 
					}
				}
			} else {
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
			}
		}
		
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				String str = ".";
				if (prev[i][j]) {
					str = "O";
				}
				System.out.print(str);
			}
			System.out.println();
		}
	}
	
	public static boolean isIn(int y, int x) {
		return y>=0 && y<R && x>=0 && x<C;
	}

}
