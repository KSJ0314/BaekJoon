import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
        Main m = new Main();
        m.init();
        System.out.println(m.count);
    }
	
	// ↓↓↓↓↓↓↓↓ 구현 부 ↓↓↓↓↓↓↓↓
	
	int n;
	boolean[][] arr;		// 입력 배열
	// boolean[][][] visited;	// 끝까지 간 pipe의 경우 해당 경로는 더 이상 검사하지 않아도 됨.
	int count = 0;			// 파이프를 끝까지 가져갈 수 있는 방법의 수
	int[][][] dels = {	// 파이프가 움직일 수 있는 방법
		{	// 가로 파이프의 이동 방법
			{0,1},	// 가로 이동
			null,	// 세로 이동 없음 => 배열의 idx로 Pipe의 state를 설정할거라서 null 넣어둠
			{1,1}	// 대각 이동
		},{	// 세로 파이프의 이동 방법
			null,	// 가로 이동 없음
			{1,0},	// 세로 이동
			{1,1}	// 대각 이동
		},{	// 대각 파이프의 이동 방법
			{0,1},	// 가로 이동
			{1,0},	// 세로 이동
			{1,1}	// 대각 이동
		}
	};
	int cnt = 0;
	
	public void init() {
		input();
		dfs(0 ,1, 0);
	}
	
	public void dfs(int y, int x, int state) {
		cnt++;
		for (int i = 0; i < dels.length; i++) {
			int[] del = dels[state][i];
			if (del == null) continue;
			
			int ny = y + del[0];
			int nx = x + del[1];
			
			if (!isIn(ny, nx)) continue;
			if (arr[ny][nx]) continue;
			if (i == 2) {
				if (arr[ny][nx-1] || arr[ny-1][nx]) continue;
			}
			
//			if (i == 2 && (visited[ny][nx][0] || visited[ny][nx][1] || visited[ny][nx][2])
//					|| visited[ny][nx][i]) {	// 이미 목표 지점까지 도달 가능했던 경로 체크
//				count++;
//				continue;
//			}
			
			if (ny == n-1 && nx == n-1) {
				count++;
				continue;
			}
			
			dfs(ny, nx, i);
		}
	}
    
	// 배열 나간거 체크
    public boolean isIn(int y, int x) {
		return y >= 0 && y < n && x >= 0 && x < n;
	}
    
    // 입력과 초기화
    public void input() {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
			String[] strs;
			n = Integer.parseInt(br.readLine());
			arr = new boolean[n][n];
			// visited = new boolean[n][n][3];
			
			for (int i = 0; i < n; i++) {
				strs = br.readLine().split(" ");
				for (int j = 0; j < n; j++) {
					int num = Integer.parseInt(strs[j]);
					if (num == 1) {
						arr[i][j] = true;
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
}