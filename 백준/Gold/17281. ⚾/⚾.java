import java.io.*;

public class Main {
	static final int HEADCOUNT = 9;
	static int N, sum, maxScore, turn, c;
	static int[] batter, bat;
	static int[][] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		init(br);
		bitDfs(0, 1);
		System.out.println(maxScore);
		
	}

	// 9명의 선수에 대한 순열을 뽑는다. (1명 고정이라서 8!)
	// flag를 이용해 visited 체크를 대신한다.
	// 4번 타자는 1번 선수(idx=0)로 고정 되어 있기에 main에서 flag의 기본값을 1로 준다.
	// 다른 선수로 고정하려면 Math.pow(2, 선수 번호)를 기본값으로 사용한다.
	static void bitDfs(int depth, int flag) {
		
		// 4번 타자는 1번 선수로 고정
		if (depth == 3) {
			bitDfs(depth+1, flag);
			return;
		}
		
		if (depth == HEADCOUNT) {
			turn = 0;
			maxScore = Math.max(maxScore, calGameScore());
			return;
		}
		
		for (int i = 1; i < HEADCOUNT; i++) {
			if ((flag&1<<i) != 0) continue;
			batter[depth] = i;
			bitDfs(depth+1, flag|1<<i);
		}
		
	}
	
	static int calGameScore() {
		int scoreSum = 0;
		for (int i = 0; i < N; i++) {
			scoreSum += calInningScore(i);
		}
		return scoreSum;
	}

	static int calInningScore(int inning) {
		int score = 0;
		bat = new int[3];
		
		int life = 3;
		while (life > 0) {
			int num = arr[inning][batter[turn]];
			turn++;
			turn%=9;
			if (num == 0) {
				life--;
				continue;
			}
			
			boolean isFirst = true;
			while (num-- > 0) {
				score += bat[2];
				bat[2] = bat[1];
				bat[1] = bat[0];
				bat[0] = isFirst ? 1 : 0;
				isFirst = false;
			}
		}
		
		return score;
	}

	static void init(BufferedReader br) throws IOException {
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N][HEADCOUNT];
		batter = new int[HEADCOUNT];
		maxScore = Integer.MIN_VALUE;
		
		for (int i = 0; i < N; i++) {
			String[] strs = br.readLine().split(" ");
			for (int j = 0; j < HEADCOUNT; j++) {
				arr[i][j] = Integer.parseInt(strs[j]);
			}
		}
	}
	
}