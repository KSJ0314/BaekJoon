import java.io.*;
import java.util.*;

public class Main {
	static int N, r, c, cnt, crtCnt, idx, outSend;
	static int[][] arr;
	static int[][][] spreadDels = {
		{
			{-1, 1, 0},		// dr, dc, spreadSendIdx
			{1, 1, 0},
			{-2, 0, 1},
			{2, 0, 1},
			{0, -2, 2},
			{-1, 0, 3},
			{1, 0, 3},
			{-1, -1, 4},
			{1, -1, 4},
			{0, -1, 5}
		},{
			{-1, -1, 0},
			{-1, 1, 0},
			{0, -2, 1},
			{0, 2, 1},
			{2, 0, 2},
			{0, -1, 3},
			{0, 1, 3},
			{1, -1, 4},
			{1, 1, 4},
			{1, 0, 5}
		},{
			{-1, -1, 0},
			{1, -1, 0},
			{-2, 0, 1},
			{2, 0, 1},
			{0, 2, 2},
			{-1, 0, 3},
			{1, 0, 3},
			{-1, 1, 4},
			{1, 1, 4},
			{0, 1, 5}
		},{
			{1, -1, 0},
			{1, 1, 0},
			{0, -2, 1},
			{0, 2, 1},
			{-2, 0, 2},
			{0, -1, 3},
			{0, 1, 3},
			{-1, -1, 4},
			{-1, 1, 4},
			{-1, 0, 5}
		},
	};
	
	static int[][] dels = {
		{0, -1},
		{1, 0},
		{0, 1},
		{-1, 0}
	};
	
	public static void main(String[] args) throws IOException {
		init();
		while (r != 0 || c != 0) {
			move();
			spread();
		}
		System.out.println(outSend);
	}

	private static void move() {
		if (crtCnt == 0) {
			idx++;
			idx %= 4;
			if (idx % 2 == 0) {
				cnt++;
			}
			crtCnt = cnt;
		}
		
		r += dels[idx][0];
		c += dels[idx][1];
		crtCnt--;
	}
	
	private static void spread() {
		int send = arr[r][c];
		
		int[] spreadSend = new int[6];
		spreadSend[0] = arr[r][c] / 100;		// 1%
		spreadSend[1] = arr[r][c] / 50;			// 2%
		spreadSend[2] = arr[r][c] / 20;			// 5%
		spreadSend[3] = (arr[r][c] * 7) / 100;	// 7&
		spreadSend[4] = arr[r][c] / 10;			// 10%
		spreadSend[5] = send - spreadSend[0]*2 - spreadSend[1]*2 - spreadSend[2] - spreadSend[3]*2 - spreadSend[4]*2;	// 나머지
		
		for (int[] del : spreadDels[idx]) {
			int nr = r + del[0];
			int nc = c + del[1];
			if (!isIn(nr, nc)) {
				outSend += spreadSend[del[2]];
			} else {
				arr[nr][nc] += spreadSend[del[2]];
			}
		}
	}

	public static boolean isIn(int r, int c) {
		return r >= 0 && r < N && c >= 0 && c < N;
	}

	public static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = br.readLine().split(" ");
		N = Integer.parseInt(strs[0]);
		
		arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			strs = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(strs[j]);
			}
		}
		r = N/2;
		c = N/2;
		cnt = 1;
		crtCnt = 1;
		idx = 0;
	}
}