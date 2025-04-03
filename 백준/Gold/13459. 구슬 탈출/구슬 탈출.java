import java.io.*;
import java.util.*;

public class Main {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	int[][] dels = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };	// 상 하 좌 우
	boolean[] isGoal = new boolean[2];
	Deque<int[][]> coorQue = new ArrayDeque<>();	// 현재 레벨의 coor 저장
	Deque<char[][]> boardQue = new ArrayDeque<>();	// 현재 레벨의 board 저장
	Set<int[][]> coorList = new HashSet<>();		// 누적 coor 저장

	public boolean bfs() {
		int size = coorQue.size();
		while (size-- > 0) {
			char[][] board = boardQue.pollFirst();
			int[][] coor = coorQue.pollFirst();
			F: for (int[] del : dels) {
				char[][] newBoard = arrCopy(board);
				int[][] newCoors = arrCopy(coor);
				
				int r_b = priorityRB(del, coor);	// 먼저 굴러갈 구슬 체크
				
				// R,B 각각 골인('O'에 도착) 여부 체크
				isGoal[0] = rolling(newBoard, newCoors, del, r_b);
				isGoal[1] = rolling(newBoard, newCoors, del, r_b^1);
				
				if (isGoal[r_b^1]) {	// B가 골인하면 제외
					continue;
				} else if (isGoal[r_b]) {	// A가 골인하면 끝
					return false;
				}
				
				for (int[][] coors : coorList) {
					if (Arrays.deepEquals(coors, newCoors)) {
						continue F;
					}
				}
				
				boardQue.addLast(newBoard);
				coorQue.addLast(newCoors);
				coorList.add(newCoors);
			}
		}
		
		return true;
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
			newArr[i] = arr[i].clone();
		}
		return newArr;
	}
	
	// 2차원 배열 복사
	public char[][] arrCopy(char[][] arr){
		char[][] newArr = new char[arr.length][];
		for (int i = 0; i < arr.length; i++) {
			newArr[i] = arr[i].clone();
		}
		return newArr;
	}
	
	public int init() throws IOException {
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
		coorQue.add(coors);
		boardQue.add(board);
		int count = 1;
		
		while (bfs()) {
			count++;
			if (count > 10) {
				count = -1;
				break;
			}
		}
		
		return count;
	}
	
	public static void main(String[] args) throws IOException {
		Main m = new Main();
		int min = m.init();
		System.out.println(min != -1 ? 1 : 0);
	}

}