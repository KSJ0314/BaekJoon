import java.util.*;
import java.io.*;

class Main {
	static final int[][] dels = {{-1,0}, {0,1}, {1,0}, {0,-1}};
    static int N, M, y1, x1, y2, x2;
    static int[][] map;
    static boolean[][] visited;
    static Deque<int[]> deq;
    static boolean flag;
	
    public static void main(String[] args) throws IOException {
        init();
        deq = new ArrayDeque<>();
        setEdge();
        
        // 시작 세팅이랑 세팅 후 사이클이랑 다름
        // visited는 전체로 관리해도 될 듯
        // 시작 세팅
        // 사방탐색, 주변이 전부 0이면? 1이 있으면?
        // 1이 있으면 가장자리임. 초기 세팅 deque에 추가
        // 0이면? 해당 칸으로 이동.
        // visited로 쫙 돌면 끝.
        // 여기서 목적지 만나는 경우도 체크
        
        // 사이클
        // 현재 deque 크기만큼만 돌기
        // visited 관리 하는 중이니까
        // 주변에 1이 있으면? visited 관리하고 그 위치 deque에 추가
        // 목적지 만나면? 종료.
        int cnt = 1;
        for (int size = deq.size(); !flag && !deq.isEmpty(); size = deq.size(), cnt++) {
        	while(size-- > 0) {
            	int[] yx = deq.pollFirst();
            	
            	for (int[] del : dels) {
                	int ny = yx[0] + del[0];
                	int nx = yx[1] + del[1];
                	if (!isIn(ny, nx)) continue;
                	if (ny == y2 && nx == x2) {
                		flag = true;
                		break;
                	}
                	if (visited[ny][nx]) continue;
                    visited[ny][nx] = true;
                    
                    if (map[ny][nx] == 1) {
                    	deq.addLast(new int[] {ny, nx});
                    } else {
                    	deq.addFirst(new int[] {ny, nx});
                    	size++;
                    }
                }
            	if (flag) break;
        	}
		}
        System.out.println(cnt);
    }


	private static void setEdge() {
        visited[y1][x1] = true;
        
        Deque<int[]> setDeq = new ArrayDeque<>();
        setDeq.addLast(new int[] {y1, x1});
        
        while(!setDeq.isEmpty()) {
        	int[] yx = setDeq.pollFirst();
        	
            for (int[] del : dels) {
            	int ny = yx[0] + del[0];
            	int nx = yx[1] + del[1];
            	if (!isIn(ny, nx)) continue;
            	if (ny == y2 && nx == x2) {
            		flag = true;
            		break;
            	}
            	if (visited[ny][nx]) continue;
                visited[ny][nx] = true;
                
                if (map[ny][nx] == 1) {
                	deq.addLast(new int[] {ny, nx});
                } else {
                	setDeq.addLast(new int[] {ny, nx});
                }
            }
        	if (flag) break;
        }
	}
	private static boolean isIn(int y, int x) {
		return y >= 1 && y <= N && x >= 1 && x <= M;
	}

	public static void init() throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	String[] inputs;
    	
    	inputs = br.readLine().split(" ");
        N = Integer.parseInt(inputs[0]);
        M = Integer.parseInt(inputs[1]);
        
        map = new int[N+1][M+1];
        visited = new boolean[N+1][M+1];
        
        inputs = br.readLine().split(" ");
        y1 = Integer.parseInt(inputs[0]);
        x1 = Integer.parseInt(inputs[1]);
        y2 = Integer.parseInt(inputs[2]);
        x2 = Integer.parseInt(inputs[3]);
        
        
        for (int i = 1; i <= N; i++) {
        	inputs = br.readLine().split("");
        	for (int j = 1; j <= M; j++) {
        		if ((i == y1 && j == x1) || (i == y2 && j == x2)) continue;
				map[i][j] = Integer.parseInt(inputs[j-1]);
			}
		}
        flag = false;
    }
}