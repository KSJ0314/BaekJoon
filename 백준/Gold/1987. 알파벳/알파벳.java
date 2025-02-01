import java.io.*;

public class Main {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	int[][] dels = {{-1,0},{1,0},{0,-1},{0,1}};
	char[][] arr;
	int h, w, maxCount;
	
	public int init() throws IOException {
		String[] inpuStrs = br.readLine().split(" ");
		h = Integer.parseInt(inpuStrs[0]);
		w = Integer.parseInt(inpuStrs[1]);
		
		arr = new char[h][w];
		for (int i = 0; i < h; i++) {
			arr[i] = br.readLine().toCharArray();
		}
		search(0, 0, 1, new boolean[26]);
		return maxCount;
	}
	
	public void search(int y, int x, int count, boolean[] isGone) {
		boolean[] copyIsGone = isGone.clone();
		
		copyIsGone[arr[y][x]-'A'] = true;
		
		boolean canGo = false;
		for (int[] del : dels) {
			int ny = y + del[0];
			int nx = x + del[1];
			if (isIn(ny, nx) && !copyIsGone[arr[ny][nx]-'A']) {
				canGo = true;
				search(ny, nx, count+1, copyIsGone);
			}
		}
		if (!canGo) {
			maxCount = Math.max(maxCount, count);
		}
	}
	
	public boolean isIn(int y, int x) {
		return y >= 0 && y < h && x >= 0 && x < w;
	}

	public static void main(String[] args) throws IOException {
		System.out.println(new Main().init());
	}
}