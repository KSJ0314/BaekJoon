import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
	public static void main(String[] args) throws IOException {
        Main m = new Main();
        m.init();
        System.out.println(m.count);
    }
	
	// ↓↓↓↓↓↓↓↓ 구현 부 ↓↓↓↓↓↓↓↓
	
	int[][] arr;							// 입력 받은 보드 저장 배열
	boolean[][] visited;					// 이동한 경로 저장, 최소 이동을 찾으면 되서 안들린 곳만 찾으면 됨
	Deque<Coor> que = new ArrayDeque<>();	// bfs에서 사용하는 que
	int count = 1;							// bfs 몇 회 진행했는지 저장 (이동 횟수 저장)
	
	public void init() {
		input();
		que.offerLast(new Coor(0, 0));
		while (bfs()) {
			count++;
		}
	}
	
	public boolean bfs() {
		int size = que.size();
		
		while (size-- > 0) {
			Coor coor = que.pollFirst();
			int y = coor.y;
			int x = coor.x;
			int booster = arr[y][x];
			
			if (move(y, x, 1, 0, booster)) return false; // 아래로 이동
			if (move(y, x, 0, 1, booster)) return false; // 우측으로 이동
		}
		
		return true;
	}
	
	public boolean move(int y, int x, int yOper, int xOper, int booster) {
		for (int i = 1; i <= booster; i++) {
			int ny = y + i*yOper;
			int nx = x + i*xOper;
			if (isIn(ny, nx) && !visited[ny][nx]) {
				if (ny == arr.length-1 && nx == arr[0].length-1) return true;
				visited[ny][nx] = true;
				que.addLast(new Coor(ny, nx));
			}
		}
		return false;
	}
	
	public class Coor{
		int y;
		int x;
		public Coor(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
    
	// 배열 나간거 체크
    public boolean isIn(int y, int x) {
		return y >= 0 && y < arr.length && x >= 0 && x < arr[0].length;
	}
    
    // 입력과 초기화
    public void input() {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
			String[] strs = br.readLine().split(" ");
			int y = Integer.parseInt(strs[0]);
			int x = Integer.parseInt(strs[1]);
			arr = new int[y][x];
			visited = new boolean[y][x];
			
			for (int i = 0; i < y; i++) {
				strs = br.readLine().split(" ");
				for (int j = 0; j < x; j++) {
					int num = Integer.parseInt(strs[j]);
					arr[i][j] = num;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
}