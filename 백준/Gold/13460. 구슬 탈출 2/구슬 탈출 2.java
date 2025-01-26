import java.io.*;
import java.util.*;

public class Main {
	int[][] dels = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };	// 상 하 좌 우
	Map<String, Integer> map = new HashMap<>();
	int min = 11;
	
	public int a(char[][] board, int[][] coors, int count) {
		if (count >= this.min) {
			return 12;
		}
		int min = 11;
		for (int[] del : dels) {
			int b = b(board, coors, del, count);
			min = Math.min(min, b);
		}
		this.min = min;
		return min;
	}

	public int b(char[][] board, int[][] coors, int[] del, int count) {
		if (count > 10) return count;
		int[][] newCoors = arrCopy(coors);
		char[][] newBoard = arrCopy(board);
		int r_b = priorityRB(del, newCoors);
		boolean[] isGoal = {
			rolling(newBoard, newCoors, del, r_b),
			rolling(newBoard, newCoors, del, r_b^1)
		};
		
		if (isGoal[r_b^1]) {	// B가 골인
			return 11;
		} else if (isGoal[r_b]) {	// A가 골인
			return count + 1;
		}
		String coorsToString = newCoors[0][0]+" "+newCoors[0][1]+" "+newCoors[1][0]+" "+newCoors[1][1];
		if (map.containsKey(coorsToString) && map.get(coorsToString) < count) {	// 이미 이동했던 좌표
			return 11;
		}
		map.put(coorsToString, count);
		return a(newBoard, newCoors, count+1);
	}
	
	public boolean rolling(char[][] board, int[][] coors, int[] del, int r_b) {
		board[coors[r_b][0]][coors[r_b][1]] = '.';
		while (true) {
			int ny = coors[r_b][0] + del[0];
			int nx = coors[r_b][1] + del[1];
			if (board[ny][nx] == 'O') return true;
			if (board[ny][nx] != '.') break;
			coors[r_b][0] = ny;
			coors[r_b][1] = nx;
		}
		board[coors[r_b][0]][coors[r_b][1]] = r_b == 0 ? 'R' : 'B';
		return false;
	}
	
	public int[][] arrCopy(int[][] arr){
		int[][] newArr = new int[arr.length][arr[0].length];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				newArr[i][j] = arr[i][j];
			}
		}
		return newArr;
	}
	public char[][] arrCopy(char[][] arr){
		char[][] newArr = new char[arr.length][arr[0].length];
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				newArr[i][j] = arr[i][j];
			}
		}
		return newArr;
	}
	
	public int priorityRB(int[] del, int[][] newCoors) {
		int y_x = del[1] == 0 ? 0 : 1;
		boolean smallFirst = del[y_x] < 0;
		if (smallFirst && newCoors[0][y_x] < newCoors[1][y_x] || !smallFirst && newCoors[0][y_x] > newCoors[1][y_x]) {
			return 0;
		}
		return 1;
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
		String coorsToString = coors[0][0]+" "+coors[0][1]+" "+coors[1][0]+" "+coors[1][1];
		m.map.put(coorsToString, 0);

		m.a(board, coors, 0);
		System.out.println(m.min > 10 ? -1 : m.min);
	}

}