import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int[][] arr, inputs;
	static int[][] dels = {
		{0, 0},
		{0, -1},	// ←
		{-1, -1},	// ↖
		{-1, 0},	// ↑
		{-1, 1},	// ↗
		{0, 1},		// → 
		{1, 1},		// ↘
		{1, 0},		// ↓
		{1, -1}		// ↙
	};
	static HashSet<Integer> cloudSet;
	
	public static void main(String[] args) throws IOException {
		init();
		for (int i = 0; i < M; i++) {
			move(inputs[i][0], inputs[i][1]);
			rain(1);
			magic();
			cloudChange();
			rain(-2);
		}
		System.out.println(getSum());
	}

	private static void move(int d, int s) {
		HashSet<Integer> movedCloudSet = new HashSet<>();
		
		for (int cloud : cloudSet) {
			int r = cloud/100;
			int c = cloud%100;
			// TODO: 귀찮아서 걍 s번 반복, 시간 터지면 여기 수정
			for (int i = 0; i < s; i++) {
				r += dels[d][0];
				c += dels[d][1];
				r = r < 0 ? N-1 : r >= N ? 0 : r;
				c = c < 0 ? N-1 : c >= N ? 0 : c;
			}
			movedCloudSet.add(r*100+c);
		}
		cloudSet = movedCloudSet;
	}

	private static void rain(int i) {
		for (int cloud : cloudSet) {
			int r = cloud/100;
			int c = cloud%100;
			arr[r][c] += i;
		}
	}

	private static void magic() {
		for (int cloud : cloudSet) {
			int r = cloud/100;
			int c = cloud%100;
			for (int i = 2; i <= 8; i+=2) {
				int nr = r + dels[i][0];
				int nc = c + dels[i][1];
				if (!isIn(nr, nc)) continue;
				if (arr[nr][nc] != 0) arr[r][c]++;
			}
		}
	}

	private static void cloudChange() {
		HashSet<Integer> changeCloudSet = new HashSet<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (arr[i][j] < 2) continue;
				if (cloudSet.contains(i*100+j)) continue;
				changeCloudSet.add(i*100+j);
			}
		}
		cloudSet = changeCloudSet;
	}

	private static int getSum() {
		int sum = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				sum += arr[i][j];
			}
		}
		return sum;
	}

	private static boolean isIn(int nr, int nc) {
		return nr >= 0 && nr < N && nc >= 0 && nc < N;
	}
	
	public static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = br.readLine().split(" ");
		
		N = Integer.parseInt(strs[0]);
		M = Integer.parseInt(strs[1]);
		
		arr = new int[N][N];
		for (int i = 0; i < N; i++) {
			strs = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(strs[j]);
			}
		}
		
		inputs = new int[M][2];
		for (int i = 0; i < M; i++) {
			strs = br.readLine().split(" ");
			inputs[i][0] = Integer.parseInt(strs[0]);
			inputs[i][1] = Integer.parseInt(strs[1]);
		}

		cloudSet = new HashSet<Integer>();
		cloudSet.add((N-1)*100);
		cloudSet.add((N-1)*100+1);
		cloudSet.add((N-2)*100);
		cloudSet.add((N-2)*100+1);
	}
}