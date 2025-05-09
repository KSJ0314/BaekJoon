import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
	static final int[][] DELS = {
		{-1, 0},	// 상
		{1, 0},		// 하
		{0, -1},	// 좌
		{0, 1}		// 우
	};
	static final int[][] DIR = {
		{},
		{1,3,0,2},
		{3,0,1,2},
		{2,0,3,1},
		{1,2,3,0},
		{1,0,3,2}
	};
	
	static int N;
	static int[][] map;
	static Map<Integer, Integer> wormhole;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			sb.append("#"+t+" ");
			
			init(br);
			wormholeSetting();
			
			int max = 0;
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (map[i][j] != 0) continue;
					for (int k = 0; k < 4; k++) {
						max = Math.max(max, pinball(i, j, k));
					}
				}
			}
			
			sb.append(max);
			sb.append("\n");
		}
		System.out.println(sb);
	}

	static int pinball(int y, int x, int del) {
		int ny = y, nx = x, cnt = 0;
		W: while (true) {
			int num;
			do {
				ny += DELS[del][0];
				nx += DELS[del][1];
				num = map[ny][nx];
				if ((ny == y && nx == x) || num == -1) break W;
			} while (num == 0);
			
			if (1 <= num && num <= 5) {
				del = DIR[num][del];
				cnt++;
			} else {
				int key = ny*100 + nx;
				int value = wormhole.get(key);
				ny = value/100;
				nx = value%100;
			}
		}
		return cnt;
	}

	// 같은 번호의 웜홀을 매핑
	static void wormholeSetting() {
		int flag = 0;
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				if (6 <= map[i][j] && map[i][j] <= 10) {
					if ((flag & 1<<map[i][j]) != 0) continue;
					flag = flag|1<<map[i][j];
					
					O:for (int i2 = i, j2 = j+1; i2 <= N; i2++, j2=1) {
						for (; j2 <= N; j2++) {
							if (map[i][j] == map[i2][j2]) {
								wormhole.put(i*100 + j, i2*100 + j2);
								wormhole.put(i2*100 + j2, i*100 + j);
								break O;
							}
						}
					}
				}
			}
		}
	}

	static void init(BufferedReader br) throws IOException {
		String[] strs;
		N = Integer.parseInt(br.readLine().trim());
		map = new int[N+2][N+2];
		wormhole = new HashMap<>();
		
		Arrays.fill(map[0], 5);
		for (int i = 1; i <= N; i++) {
			map[i][0] = map[i][N+1] = 5;
			strs = br.readLine().split(" ");
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(strs[j-1]);
			}
		}
		Arrays.fill(map[N+1], 5);
	}
}