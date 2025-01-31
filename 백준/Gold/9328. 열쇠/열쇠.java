import java.io.*;
import java.util.*;

public class Main {
	char[][] arr;
	int[][] dels = {{-1,0},{1,0},{0,-1},{0,1}};
	boolean[] hasKey;
	int count;
	boolean isEnd;
	
	public void search(int y, int x, char[][] arr) {
		if (!isIn(y, x)) return;
		if (!isEnd) return;
		
		if (arr[y][x] >= 'a' && arr[y][x] <= 'z') {
			hasKey[arr[y][x]-'a'] = true;
			arr[y][x] = '.';
			this.arr[y][x] = '.';
			isEnd = false;
			return;
		} else if (arr[y][x] >= 'A' && arr[y][x] <='Z' && hasKey[arr[y][x]-'A']) {
			arr[y][x] = '.';
			this.arr[y][x] = '.';
		} else if (arr[y][x] == '$') {
			count++;
			arr[y][x] = '.';
			this.arr[y][x] = '.';
		}
		if (arr[y][x] == '.') {
			arr[y][x]= ' ';
			for (int[] del : dels) {
				int ny = y + del[0];
				int nx = x + del[1];
				search(ny, nx, arr);
			}
		}
	}
	
	public int searchAll() {
		while (!isEnd) {
			isEnd = true;
			for (int i = 0; i < arr.length && isEnd; i++) {
				search(i, 0, copyArr(arr));
				search(i, arr[i].length-1, copyArr(arr));
			}
			for (int i = 0; i < arr[0].length && isEnd; i++) {
				search(0, i, copyArr(arr));
				search(arr.length-1, i, copyArr(arr));
			}
		}
		return count;
	}
	
	public boolean isIn(int y, int x) {
		return y >= 0 && y < arr.length && x >= 0 && x < arr[0].length;
	}
	
	public char[][] copyArr(char[][] arr){
		char[][] newChar = new char[arr[0].length][];
		for (int i = 0; i < arr.length; i++) {
			newChar[i] = arr[i].clone();
		}
		return newChar;
	}

	public static void main(String[] args) throws IOException {
		Main m = new Main();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 0; test_case < T; test_case++) {
			String[] inpuStrs = br.readLine().split(" ");
			int h = Integer.parseInt(inpuStrs[0]);
			int w = Integer.parseInt(inpuStrs[1]);
			
			m.arr = new char[h][w];
			m.hasKey = new boolean[26];
			m.count = 0;
			m.isEnd = false;
			
			for (int i = 0; i < h; i++) {
				m.arr[i] = br.readLine().toCharArray();
			}
			for (String str : br.readLine().split("")) {
				int idx = str.charAt(0)-'a';
				if (idx >= 0) {
					m.hasKey[idx] = true;
				}
			}
			sb.append(m.searchAll()+"\n");
		}
		
		System.out.println(sb.toString());
	}
}