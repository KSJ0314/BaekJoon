import java.util.*;
import java.io.*;

class Main {
	static int[][] dels = {{-1,0},{0,1},{1,0},{0,-1}}; // 상, 우, 하, 좌
	static class Snake{
		int r,c;

		public Snake(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}
	
	static int N;
	static int[][] map;
	static HashMap<Integer, Character> dirChange;
	static LinkedList<Snake> snake;
	
	
    public static void main(String[] args) throws IOException {
        init();
        
        int dir = 1, time = 0;
        while (true) {
        	time++;
        	
//        	먼저 뱀은 몸길이를 늘려 머리를 다음칸에 위치시킨다.
        	Snake head = snake.getFirst();
        	int nr = head.r + dels[dir][0];
        	int nc = head.c + dels[dir][1];
        	
//        	만약 벽이나 자기자신의 몸과 부딪히면 게임이 끝난다.
        	if (!isIn(nr, nc) || map[nr][nc] == 1) {
        		break;
        	}
        	snake.addFirst(new Snake(nr, nc));
        	
//        	만약 이동한 칸에 사과가 없다면, 몸길이를 줄여서 꼬리가 위치한 칸을 비워준다. 즉, 몸길이는 변하지 않는다.
        	if (map[nr][nc] != 2) {
        		Snake tail = snake.getLast();
        		map[tail.r][tail.c] = 0;
        		snake.removeLast();
        	}
        	
    		map[nr][nc] = 1;
        	
        	if (dirChange.containsKey(time)) {
        		dir += dirChange.get(time) == 'D' ? 1 : -1;
        		if (dir == -1) dir = 3;
        		if (dir == 4) dir = 0;
        	}
		}
        
        System.out.println(time);
    }
    
    public static boolean isIn(int r, int c) {
    	return r >= 0 && r < N && c >= 0 && c < N;
    }

	public static void init() throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	String[] inputs;
    	
    	inputs = br.readLine().split(" ");
        N = Integer.parseInt(inputs[0]);
        map = new int[N][N];
        
        inputs = br.readLine().split(" ");
        int K = Integer.parseInt(inputs[0]);
        for (int i = 0; i < K; i++) {
        	inputs = br.readLine().split(" ");
        	int r = Integer.parseInt(inputs[0])-1;
        	int c = Integer.parseInt(inputs[1])-1;
        	map[r][c] = 2;
		}
        
        dirChange = new HashMap<>();
        inputs = br.readLine().split(" ");
        int L = Integer.parseInt(inputs[0]);
        for (int i = 0; i < L; i++) {
        	inputs = br.readLine().split(" ");
        	int X = Integer.parseInt(inputs[0]);
        	char C = inputs[1].charAt(0);
        	dirChange.put(X, C);
        }
        
        snake = new LinkedList<>();
        snake.add(new Snake(0,0));
        map[0][0] = 1;
    }
}