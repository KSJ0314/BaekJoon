import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[][] arr;
	static int[][][] dpTable;	// 0: 가로, 1: 세로, 2: 대각

	public static void main(String[] args) throws IOException {
		init();
		dp();
		System.out.println(dpTable[N][N][0] + dpTable[N][N][1] + dpTable[N][N][2]);
	}

	static void dp() {
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (i==1 && j==1 || i==1 && j==2) continue;
				if (arr[i][j] == 1) continue;
				dpTable[i][j][0] = dpTable[i][j-1][0] + dpTable[i][j-1][2];
				dpTable[i][j][1] = dpTable[i-1][j][1] + dpTable[i-1][j][2];
				if (arr[i-1][j] == 1 || arr[i][j-1] == 1) continue;
				dpTable[i][j][2] = dpTable[i-1][j-1][0] + dpTable[i-1][j-1][1] + dpTable[i-1][j-1][2];
			}
		}
	}

	static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		arr = new int[N+1][N+1];
		dpTable = new int[N+1][N+1][3];
		dpTable[1][2][0] = 1;
		
		String[] strs;
		for (int i = 1; i <= N; i++) {
			strs = br.readLine().split(" ");
			for (int j = 1; j <= N; j++) {
				arr[i][j] = Integer.parseInt(strs[j-1]);
			}
		}
	}
}