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
	
	static int N, max;
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
			
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					if (map[i][j] != 0) continue;
					for (int k = 0; k < 4; k++) {
						pinball(i, j, k);
					}
				}
			}
			
			sb.append(max).append("\n");
		}
		System.out.println(sb);
	}

	static void pinball(int y, int x, int del) {
		int ny = y, nx = x, cnt = 0;
		W: while (true) {
			do {
				ny += DELS[del][0];
				nx += DELS[del][1];
				if ((ny == y && nx == x) || map[ny][nx] == -1) break W;
			} while (map[ny][nx] == 0);
			
			if (1 <= map[ny][nx] && map[ny][nx] <= 5) {
				del = changeDel(map[ny][nx], del);
				cnt++;
			} else {
				int key = ny*100 + nx;
				int value = wormhole.get(key);
				ny = value/100;
				nx = value%100;
			}
		}
		max = Math.max(max, cnt);
	}

	static int changeDel(int num, int del) {
		switch (num) {
			case 1 : return del == 0 ? 1 : del == 1 ? 3 : del == 2 ? 0 : 2;
			case 2 : return del == 0 ? 3 : del == 1 ? 0 : del == 2 ? 1 : 2;
			case 3 : return del == 0 ? 2 : del == 1 ? 0 : del == 2 ? 3 : 1;
			case 4 : return del == 0 ? 1 : del == 1 ? 2 : del == 2 ? 3 : 0;
			default : return (del + (del%2==0 ? 1 : -1));
		}
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
		max = Integer.MIN_VALUE;
		
		for (int i = 1; i <= N; i++) {
			map[i][0] = map[i][N+1] = 5;
			strs = br.readLine().split(" ");
			for (int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(strs[j-1]);
			}
		}
		Arrays.fill(map[0], 5);
		Arrays.fill(map[N+1], 5);
	}
}