import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
	public static void main(String[] args) throws IOException {
        Main m = new Main();
        m.init();
        System.out.println(m.count);
    }
	
	int[][] arr = new int[5][5];
	int[][] dels = {{-1,0},{1,0},{0,-1},{0,1}};
	Deque<Student> que = new ArrayDeque<>();
	int count = 0;
    
    public void init() {
    	input();
    	while (bfs()) {
    		count++;
		}
    }
    
    public boolean bfs() {
    	int size = que.size();
    	if (size == 0) {
    		count = -1;
    		return false;
    	}
    	while (size-- > 0) {
    		Student student = que.pollFirst();
			int r = student.r;
			int c = student.c;
			int count = student.count;
			if (arr[r][c] == 1) {
				count++;
			}
			if (count == 3) {
				return false;
			}
			
			boolean[][] visited = new boolean[5][];
			for (int i = 0; i < visited.length; i++) {
				visited[i] = student.visited[i].clone();
			}
			visited[r][c] = true;
			
			for (int[] del : dels) {
				int nr = r + del[0];
				int nc = c + del[1];
				if (isIn(nr, nc) && !visited[nr][nc]) {
					que.offerLast(new Student(nr, nc, count, visited));
				}
			}
		}
    	return true;
    }
    
	// 현재 좌표와 방문 정보를 저장
	private class Student {
		int r, c, count;
		boolean[][] visited;
		
		public Student(int r, int c, int count, boolean[][] visited) {
			this.r = r;
			this.c = c;
			this.count = count;
			this.visited = visited;
		}
	}
    
	// 배열 나간거 체크
    public boolean isIn(int r, int c) {
		return r >= 0 && r < arr.length && c >= 0 && c < arr[0].length;
	}
    
    // 입력과 초기화
    public void input() {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
			String[] strs;
			boolean[][] visited = new boolean[5][5];
			for (int i = 0; i < 5; i++) {
				strs = br.readLine().split(" ");
				for (int j = 0; j < 5; j++) {
					int num = Integer.parseInt(strs[j]);
					arr[i][j] = num;
					if (num == -1) {
						visited[i][j] = true;
					}
				}
			}
			strs = br.readLine().split(" ");
			int r = Integer.parseInt(strs[0]);
			int c = Integer.parseInt(strs[1]);
			
			que.add(new Student(r, c, 0, visited));
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
}