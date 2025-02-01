import java.io.*;

public class Main {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	int[][] dels = {{-1,0},{1,0},{0,-1},{0,1}};
	char[][] arr, copyArr;
	boolean[] hasKey;
	boolean isEnd;
	int count, h, w;
	
	// main()에서 작성하기 번거로워 만든 메서드
	public int init() throws IOException {
		String[] inpuStrs = br.readLine().split(" ");
		h = Integer.parseInt(inpuStrs[0]);
		w = Integer.parseInt(inpuStrs[1]);
		
		arr = new char[h][w];
		hasKey = new boolean[26];
		isEnd = false;
		count = 0;
		
		for (int i = 0; i < h; i++) {
			arr[i] = br.readLine().toCharArray();
		}
		for (String str : br.readLine().split("")) {
			int idx = str.charAt(0)-'a';
			if (idx >= 0) {
				hasKey[idx] = true;
			}
		}
		return searchAll();
	}
	
	// 가장자리에서 탐색 시작
	// for문 조건에 isEnd를 넣음으로 isEnd가 false이면(열쇠를 찾았으면) 즉시 모두 종료후 처음부터 다시 진행
	// "."을 지나면 " "으로 변경하여 왔던 길은 탐색하지 않는다. 재 탐색을 위해, 원본 배열을 복사하여 탐색함.
	public int searchAll() {
		while (!isEnd) {
			isEnd = true;
			copyArr = copyArr(arr);
			for (int i = 0; i < h && isEnd; i++) {
				search(i, 0);
				search(i, arr[i].length-1);
			}
			for (int i = 0; i < w && isEnd; i++) {
				search(0, i);
				search(arr.length-1, i);
			}
		}
		return count;
	}
	
	public void search(int y, int x) {
		if (!isIn(y, x) || !isEnd) return;
		
		char ch = copyArr[y][x];
		if (ch == '*' || ch == ' ' || (ch >= 'A' && ch <='Z' && !hasKey[ch-'A'])) {
			return;
		}
		
		this.arr[y][x] = '.';
		copyArr[y][x] = ' ';
		
		if (ch >= 'a' && ch <= 'z') {	// 소문자(열쇠) 발견시 즉시 종료
			hasKey[ch-'a'] = true;
			isEnd = false;
			return;
		} else if (ch == '$') {
			count++;
		}
		
		for (int[] del : dels) {
			int ny = y + del[0];
			int nx = x + del[1];
			search(ny, nx);
		}
	}
	
	public boolean isIn(int y, int x) {
		return y >= 0 && y < arr.length && x >= 0 && x < arr[0].length;
	}
	
	// 배열 복사 (탐색 메서드의 가독성을 위해 따로 뺌)
	public char[][] copyArr(char[][] arr){
		char[][] newChar = new char[arr[0].length][];
		for (int i = 0; i < arr.length; i++) {
			newChar[i] = arr[i].clone();
		}
		return newChar;
	}

	public static void main(String[] args) throws IOException {
		Main m = new Main();
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(m.br.readLine());
		
		for (int test_case = 0; test_case < T; test_case++) {
			sb.append(m.init()+"\n");
		}
		
		System.out.println(sb.toString());
	}
}