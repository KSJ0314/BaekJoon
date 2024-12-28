import java.util.*;

class Solution {
	public PriorityQueue<Integer> pQ = new PriorityQueue<>();
	public int[][] timeArr;	// 각 지점의 도착 시간 저장

	public void raceStart(int A, int B, int C, int D, int[][] arr) {
		timeArr = new int[arr.length][arr.length];	// 도착 시간 초기화
		arr[A][B] = 1; // 처음 위치 다시 안돌아오기 위해 벽(1)으로 변경
		up(A, B, C, D, arr, 0);
		down(A, B, C, D, arr, 0);
		left(A, B, C, D, arr, 0);
		right(A, B, C, D, arr, 0);
	}
	public void race(int A, int B, int C, int D, int[][] arr, int time) {
		int N = arr.length;
		if (A<0 || A>=N || B<0 || B>=N || arr[A][B] == 1) {	// 벽(1)을 만나면 종료
			return;
		}
		time++;
		if (arr[A][B]==2 && (time%3)!=0) {	// 소용돌이 만나면 시간 증가
			time += 3-(time%3);
		}
		if (A==C && B==D) {	// 도착 지점에 도달하면 pQ에 time을 저장하고 종료
			pQ.offer(time);
			return;
		}
		if (timeArr[A][B] == 0 || timeArr[A][B] > time) {	// 해당 경로까지 도착 시간 저장
			timeArr[A][B] = time;
		} else {	// 더 빠른 경로가 있으면 종료
			return;
		}
		//
		// 위에서 return을 만나지 못하면 전진이 가능함
		
		int[][] copyArr = new int[N][N];	// 메서드에 배열을 넣으면 참조를 전달하므로 원본 배열을 건드리지 않으려면 복사가 필요
		for (int i = 0; i < N; i++) {
			copyArr[i] = arr[i].clone();
		}
		copyArr[A][B] = 1;	// 지나간 길은 벽(1)으로 바꿔서 다시 안지나가게 변경
		
		// 복사한 배열을 사용해 각 방향으로 전진
		up(A, B, C, D, copyArr, time);
		down(A, B, C, D, copyArr, time);
		left(A, B, C, D, copyArr, time);
		right(A, B, C, D, copyArr, time);
	}
	public void up(int A, int B, int C, int D, int[][] arr, int time) {
		race(--A, B, C, D, arr, time);
	}
	public void down(int A, int B, int C, int D, int[][] arr, int time) {
		race(++A, B, C, D, arr, time);
	}
	public void left(int A, int B, int C, int D, int[][] arr, int time) {
		race(A, --B, C, D, arr, time);
	}
	public void right(int A, int B, int C, int D, int[][] arr, int time) {
		race(A, ++B, C, D, arr, time);
	}
	
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		Solution s = new Solution();
		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int[][] arr = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					arr[i][j] = sc.nextInt();
				}
			}
			int A = sc.nextInt();
			int B = sc.nextInt();
			int C = sc.nextInt();
			int D = sc.nextInt();
			
			// 여기까지는 입력 데이터 받기 위한 코드
			// 아래는 구현부
			
			s.raceStart(A, B, C, D, arr);
			int result = s.pQ.isEmpty() ? -1 : s.pQ.poll();	// 도착 불가 시 -1 출력
			System.out.println("#"+test_case+" "+result);	// pQ는 자동 정렬이 됨, poll()호출 시 가장 작은 값이 나옴
			s.pQ.clear();	// 테스트케이스마다 초기화 필요
		}
	}
	
}
