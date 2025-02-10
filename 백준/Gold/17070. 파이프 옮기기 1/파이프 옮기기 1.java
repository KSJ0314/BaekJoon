import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
        Main m = new Main();
        m.init();
        System.out.println(m.count);
    }
	
	// ↓↓↓↓↓↓↓↓ 구현 부 ↓↓↓↓↓↓↓↓
	
	boolean[][] arr;		// 입력 배열
	boolean[][][] visited;	// 끝까지 간 pipe의 경우 해당경로는 더 이상 검사하지 않아도 됨.
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
		Pipe initPipe = new Pipe(0, 1, 0);
		dfs(initPipe);
	}
	
	public void dfs(Pipe pipe) {
		cnt++;
		int state = pipe.state;
		for (int i = 0; i < dels.length; i++) {
			int[] del = dels[state][i];
			if (del == null) continue;
			
			int ny = pipe.y + del[0];
			int nx = pipe.x + del[1];
			
			if (!isIn(ny, nx)) continue;
			if (arr[ny][nx]) continue;
			if (i == 2) {
				if (arr[ny][nx-1] || arr[ny-1][nx]) continue;
			}
//			if (i == 2 && (visited[ny][nx][0] || visited[ny][nx][1] || visited[ny][nx][2])
//					|| visited[ny][nx][i]) {
//				count++;
//				continue;
//			}
			
			int leng = arr.length-1;
			if (ny == leng && nx == leng) {
				count++;
				//visitedSave(pipe.visited);
				continue;
			}
			
			dfs(new Pipe(ny, nx, i));
		}
	}
	
	public class Pipe{	// int 5중 배열 사용해도 될 듯? 일단 class가 보기 편함
		int y;		// 파이프 뒤y
		int x;		// 파이프 뒤x
		int state;	// 파이프 상태: 0=가로 | 1=세로 | 2=대각
		//boolean[][][] visited = new boolean[arr.length][arr.length][3];	// 파이프의 이동 경로 저장: (y, x, state)
		
		public Pipe(int y, int x, int state) {
			this.y = y;
			this.x = x;
			this.state = state;
			//this.visited[y][x][state] = true;
		}
	}
	
	// 끝까지 간 경로의 경우 값을 저장
	public void visitedSave(boolean[][][] visited) {
		for (int i = 0; i < visited.length; i++) {
			for (int j = 0; j < visited[i].length; j++) {
				for (int j2 = 0; j2 < visited[i][j].length; j2++) {
					if (visited[i][j][j2]) {
						this.visited[i][j][j2] = true;
					}
				}
			}
		}
	}
    
	// 배열 나간거 체크
    public boolean isIn(int y, int x) {
		return y >= 0 && y < arr.length && x >= 0 && x < arr[0].length;
	}
    
    // 입력과 초기화
    public void input() {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
			String[] strs;
			int n = Integer.parseInt(br.readLine());
			arr = new boolean[n][n];
			visited = new boolean[n][n][3];
			
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