import java.io.*;
import java.util.*;

public class Main {
	int[][] dels = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };	// 상 하 좌 우
	Map<String, Integer> map = new HashMap<>();
	int min = 11;

	public void f(char[][] board, int[][] coors, int count) {
		for (int[] del : dels) {
			if (count > 10) continue;	// 최대 10회 까지만 체크
			if (count >= this.min) continue;	// count가 이미 최소값보다 크면 검사 종료
			
			int[][] newCoors = arrCopy(coors);	// 배열은 참조가 전달되기 때문에 수정 시 원본 배열이 변경됨
			char[][] newBoard = arrCopy(board);	// 원본 수정을 막기 위해 복사해서 사용
			
			int r_b = priorityRB(del, newCoors);	// 먼저 굴러갈 구슬 체크
			boolean[] isGoal = {	// R,B 각각 골인('O'에 도착) 여부 체크
				rolling(newBoard, newCoors, del, r_b),
				rolling(newBoard, newCoors, del, r_b^1)
			};
			
			if (isGoal[r_b^1]) {	// B가 골인하면 검사 종료
				continue;
			} else if (isGoal[r_b]) {	// A가 골인
				min = Math.min(min, count + 1);
				continue;
			}
			
			// 이미 이동했던 좌표에 같거나 큰 횟수로 도착한 경우 검사 종료
			String coorsToStr = newCoors[0][0]+" "+newCoors[0][1]+" "+newCoors[1][0]+" "+newCoors[1][1];
			if (map.containsKey(coorsToStr) && map.get(coorsToStr) <= count) {
				continue;
			} else map.put(coorsToStr, count);
			
			f(newBoard, newCoors, count+1);
		}
	}
	
	// 구슬 굴리기, 골인 여부를 반환
	public boolean rolling(char[][] board, int[][] coors, int[] del, int r_b) {
		board[coors[r_b][0]][coors[r_b][1]] = '.';	// 원래 위치에 . 저장
		while (true) {
			int ny = coors[r_b][0] + del[0];
			int nx = coors[r_b][1] + del[1];
			if (board[ny][nx] == 'O') return true;	// 골인하면 true 반환
			if (board[ny][nx] != '.') break;	// 다음 칸이 . 이 아니면 스탑
			coors[r_b][0] = ny;
			coors[r_b][1] = nx;
		}
		board[coors[r_b][0]][coors[r_b][1]] = r_b == 0 ? 'R' : 'B';	// 최종 이동 칸에 R,B 저장
		return false;
	}
	
	// R,B중 먼저 굴러가는 구슬 체크
	public int priorityRB(int[] del, int[][] coors) {
		int y_x = del[1] == 0 ? 0 : 1;
		boolean smallFirst = del[y_x] < 0;
		if (smallFirst && coors[0][y_x] < coors[1][y_x] || !smallFirst && coors[0][y_x] > coors[1][y_x]) {
			return 0;
		} else return 1;
	}
	
	// 2차원 배열 복사
	public int[][] arrCopy(int[][] arr){
		int[][] newArr = new int[arr.length][];
		for (int i = 0; i < arr.length; i++) {
			newArr[i] = Arrays.copyOf(arr[i], arr[i].length);
		}
		return newArr;
	}
	
	// 2차원 배열 복사
	public char[][] arrCopy(char[][] arr){
		char[][] newArr = new char[arr.length][];
		for (int i = 0; i < arr.length; i++) {
			newArr[i] = Arrays.copyOf(arr[i], arr[i].length);
		}
		return newArr;
	}
	
	public static void main(String[] args) throws IOException {
		Main m = new Main();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] inStrs = br.readLine().split(" ");
		int N = Integer.parseInt(inStrs[0]);
		int M = Integer.parseInt(inStrs[1]);
		int[][] coors = new int[2][2];	// coors[0]: R의 좌표(y,x) | coors[1]: B의 좌표(y,x)
		char[][] board = new char[N][M];

		for (int i = 0; i < N; i++) {
			board[i] = br.readLine().toCharArray();
			for (int j = 0; j < M; j++) {
				if (board[i][j] == 'R') {
					coors[0][0] = i;
					coors[0][1] = j;
				} else if (board[i][j] == 'B') {
					coors[1][0] = i;
					coors[1][1] = j;
				}
			}
		}
		String coorsToStr = coors[0][0]+" "+coors[0][1]+" "+coors[1][0]+" "+coors[1][1];
		m.map.put(coorsToStr, 0);

		m.f(board, coors, 0);
		System.out.println(m.min > 10 ? -1 : m.min);
	}

}