
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
	private static int m, min; // m: 사람 수
	private static int[][] distance;
	private static Stairs[] stairs;
	private static boolean[] choice;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n, idx, input;
		ArrayList<Index> people = new ArrayList<>();

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			stairs = new Stairs[2]; // 초기화
			min = Integer.MAX_VALUE;
			idx = 0;
			people.clear();

			n = Integer.parseInt(br.readLine()); // 입력
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					input = Integer.parseInt(st.nextToken());
					if (input == 1)
						people.add(new Index(i, j));
					else if (input != 0)
						stairs[idx++] = new Stairs(i, j, input);
				}
			}

			m = people.size();
			choice = new boolean[m];
			distance = new int[2][m];
			
			//2개의 계단과 사람간의 거리 구해서 저장
			for (int i = 0; i < 2; i++) {
				for (int j = 0; j < m; j++) {
					distance[i][j] = getDist(stairs[i].index, people.get(j));
				}
			}
			choice(0);
			System.out.println("#" + t + " " + min);
		}
	}

	//모든 사람에 대해 계단을 선택하는 경우의 수 구하기
	private static void choice(int depth) {
		if (m == depth) {
			//계단을 다 선택했다면
			solution(getDistInfo());
			return;
		}
		choice[depth] = true;
		choice(depth + 1);
		
		choice[depth] = false;
		choice(depth + 1);
	}

	private static void solution(int[] dst) {
		boolean[] check = new boolean[m];
		int time = 0;
		stairs[0].reset();
		stairs[1].reset();
		
		ArrayList<Integer> wait = new ArrayList<>();

		// min보다 오래 걸리면 종료
		while (++time < min) { 
			wait.clear();
			
			for (int i = 0; i < m; i++) {
				if (check[i])
					continue; // 이미 다 내려간 사람
				int s = (choice[i]) ? 0 : 1; // 계단 종류

				// 계단 도착했을 경우 대기목록에 추가
				if (dst[i] == 0)
					wait.add(i); 
				else {
					//계단을 완전히 내려왔을 때 (이동완료)
					if (--dst[i] < (-1) * stairs[s].value) {
						stairs[s].out(); 
						//완료 여부 체크
						check[i] = true;
					}
				}
			}
			//대기목록에 있는 사람들
			for (Integer i : wait) {
				int s = (choice[i]) ? 0 : 1;
				// 내려갈 수 있으면 내려감
				if (stairs[s].status) { 
					dst[i]--;
					stairs[s].down();
				}
			}
			if (isFinish(check))
				min = time; // 다 내려오면
		}
	}

	//모든 사람이 계단을 다 내려왔는지 확인
	private static boolean isFinish(boolean[] check) {
		for (int i = 0; i < m; i++) {
			if (!check[i])
				return false;
		}
		return true;
	}

	//선택한 계단에 따른 거리 값들을 저장한 배열 반환
	private static int[] getDistInfo() {
		int[] result = new int[m];
		for (int i = 0; i < m; i++) {
			result[i] = (choice[i]) ? distance[0][i] : distance[1][i];
		}
		return result;
	}

	// 사람과 계단 사이 거리 측정
	private static int getDist(Index a, Index b) { 
		return Math.abs(a.x - b.x) + Math.abs(a.y - b.y);
	}
}

class Index {
	int x, y;

	public Index(int x, int y) {
		this.x = x;
		this.y = y;
	}
}


class Stairs {
	Index index;
	int value, count;
	boolean status; //꽉찼는지 안찼는지 상태

	public Stairs(int x, int y, int value) {
		this.index = new Index(x, y);
		this.value = value;
		this.count = 0;
		this.status = true;
	}

	public void down() {
		if (++count == 3)
			this.status = false; // 꽉차면 false 처리
	}

	public void reset() {
		this.count = 0;
		this.status = true;
	}

	public void out() {
		count--;
		this.status = true;
	}
}
