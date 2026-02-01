import java.io.*;
import java.util.*;

public class Main {
	static int[][] arr;
	static int[][] dels = {
		{0, 1},
		{-1, 1},
		{1, 1},
		{1, 0}
	};
	
	public static void main(String[] args) throws IOException {
		init();
		
		for (int j = 0; j < 19; j++) {
			for (int i = 0; i < 19; i++) {
				if (arr[i][j] == 0) continue;
				
				int n = arr[i][j];
				for (int[] del : dels) {
					boolean isWin = true;
					for (int k = 1; k <= 4; k++) {
						int ni = i + del[0]*k;
						int nj = j + del[1]*k;
						if (!isIn(ni, nj)) {
							isWin = false;
							break;
						}
						
						if (arr[ni][nj] != n) isWin = false;
					}
					int ni = i - del[0];
					int nj = j - del[1];
					if (isIn(ni, nj) && arr[ni][nj] == n) isWin = false;
					ni = i + del[0]*5;
					nj = j + del[1]*5;
					if (isIn(ni, nj) && arr[ni][nj] == n) isWin = false;
					if (isWin) {
						System.out.println(n);
						System.out.println((i+1) + " " + (j+1));
						return;
					}
				}
			}
		}
		System.out.println(0);
	}
	
	public static boolean isIn(int r, int c) {
		return r >= 0 && r < 19 && c >= 0 && c < 19;
	}

	public static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		arr = new int[19][19];
		for (int i = 0; i < 19; i++) {
			String[] strs = br.readLine().split(" ");
			for (int j = 0; j < 19; j++) {
				arr[i][j] = Integer.parseInt(strs[j]);
			}
		}
	}
}