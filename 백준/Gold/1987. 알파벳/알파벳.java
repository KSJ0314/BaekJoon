import java.io.*;

public class Main {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	int[][] dels = {{-1,0},{1,0},{0,-1},{0,1}};
	boolean[] visited = new boolean[26];
	char[][] arr;
	int h, w, maxCount;
	
	public void init() throws IOException {
		String[] inpuStrs = br.readLine().split(" ");
		h = Integer.parseInt(inpuStrs[0]);
		w = Integer.parseInt(inpuStrs[1]);
		
		arr = new char[h][w];
		for (int i = 0; i < h; i++) {
			arr[i] = br.readLine().toCharArray();
		}
		search(0, 0, 1);
	}
	
	public void search(int y, int x, int count) {
		visited[arr[y][x]-'A'] = true;
		
		boolean isEnd = true;
		for (int[] del : dels) {
			int ny = y + del[0];
			int nx = x + del[1];
			if (isIn(ny, nx) && !visited[arr[ny][nx]-'A']) {
				isEnd = false;
				search(ny, nx, count+1);
			}
		}
		visited[arr[y][x]-'A'] = false;
		if (isEnd) {
			maxCount = Math.max(maxCount, count);
		}
	}
	
	public boolean isIn(int y, int x) {
		return y >= 0 && y < h && x >= 0 && x < w;
	}

	public static void main(String[] args) throws IOException {
		Main m = new Main();
		m.init();
		System.out.println(m.maxCount);
	}
}