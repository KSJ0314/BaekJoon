import java.io.*;

public class Main {
	static final int[][] dels = {{0,1},{1,0},{0,-1},{-1,0}};	// 우 하 좌 상
	static int N, M, K, sum, rollIdx, y, x;
	static int[] dice;
	static int[][] arr, scores;
	static boolean[][] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		init(br);
		calScore();
		while (K-- > 0) {
			move();
		}
		System.out.println(sum);
	}

	static void move() {
		// 1. 주사위가 이동 방향으로 한 칸 굴러간다. 만약, 이동 방향에 칸이 없다면, 이동 방향을 반대로 한 다음 한 칸 굴러간다.
		y += dels[rollIdx][0];
		x += dels[rollIdx][1];
		if (!isIn(y, x)) {
			rollIdx = (rollIdx+2)%4;
			y += dels[rollIdx][0]*2;
			x += dels[rollIdx][1]*2;
		}
		roll();
		//printDice();
		
		// 2. 주사위가 도착한 칸 (x, y)에 대한 점수를 획득한다.
		sum += scores[y][x];
		
		// 3. 주사위의 아랫면에 있는 정수 A와 주사위가 있는 칸 (x, y)에 있는 정수 B를 비교해 이동 방향을 결정한다.
		int num = arr[y][x];
		if (dice[5] > num) {				// A > B인 경우 이동 방향을 90도 시계 방향으로 회전시킨다.
			rollIdx++;
			if (rollIdx == 4) rollIdx = 0;
		} else if (dice[5] < num){			// A < B인 경우 이동 방향을 90도 반시계 방향으로 회전시킨다.
			rollIdx--;
			if (rollIdx == -1) rollIdx = 3;
		}
	}
	
	static void roll() {
		int temp = dice[5];				// 주사위 밑의 수를 잠시 저장
		dice[5] = dice[rollIdx];		// 선택한 방향의 수(n)가 주사위 밑으로 이동
		dice[rollIdx] = dice[4];		// n이 있던 자리로 주사위 위에 있던 수가 이동
		dice[4] = dice[(rollIdx+2)%4];	// n의 반대 방향에 있던 수가 주사위 위로 이동
		dice[(rollIdx+2)%4] = temp;		// 주사위 밑에 있던 수를 n이 있던 반대로 이동
	}

	static boolean isIn(int y, int x) {
		return y >= 0 && y < N && x >= 0 && x < M;
	}
	
	static void calScore() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				visited = new boolean[N][M];
				int num = arr[i][j];
				scores[i][j] = countingDfs(i, j, num) * num;
			}
		}
	}

	static int countingDfs(int y, int x, int num) {
		int cnt = 1;
		visited[y][x] = true;
		
		for (int[] del : dels) {
			int ny = y + del[0];
			int nx = x + del[1];
			if (!isIn(ny, nx)) continue;
			if (arr[ny][nx] != num) continue;
			if (visited[ny][nx]) continue;
			
			visited[ny][nx] = true;
			cnt += countingDfs(ny, nx, num);
		}
		
		return cnt;
	}

	static void init(BufferedReader br) throws IOException {
		String[] strs = br.readLine().split(" ");
		N = Integer.parseInt(strs[0]);
		M = Integer.parseInt(strs[1]);
		K = Integer.parseInt(strs[2]);
		arr = new int[N][M];
		scores = new int[N][M];
		sum = 0;
		rollIdx = 0;
		y = 0;
		x = 0;
		dice = new int[] {3,5,4,2,1,6};	// 우,하,좌,상,위,밑
		
		for (int i = 0; i < N; i++) {
			strs = br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				arr[i][j] = Integer.parseInt(strs[j]);
			}
		}
	}
	
	static void printDice() {
		System.out.println("==========");
		System.out.printf("   %2d   \n",dice[3]);
		System.out.printf("%2d %2d %2d\n",dice[2], dice[4], dice[0]);
		System.out.printf("   %2d   \n",dice[1]);
		System.out.printf("   %2d   \n",dice[5]);
		System.out.println("==========");
	}
	
	static void print(int[][] ar) {
		for (int i = 0; i < ar.length; i++) {
			for (int j = 0; j < ar[i].length; j++) {
				System.out.print(ar[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println("========================");
	}
	
}