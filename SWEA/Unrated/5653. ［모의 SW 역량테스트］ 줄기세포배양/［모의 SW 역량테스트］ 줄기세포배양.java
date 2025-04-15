import java.io.*;
import java.util.*;

public class Solution {
	
	static class Cell implements Comparable<Cell>{
		int y, x, life, time;

		public Cell(int y, int x, int life) {
			this.y = y;
			this.x = x;
			this.life = life;
			this.time = life;
		}

		@Override
		public int compareTo(Cell o) {
			return Integer.compare(o.life, this.life);
		}
	}
	static int[][] dels = {{-1,0},{1,0},{0,-1},{0,1}};
	static int N, M, K;
	static Set<Integer> keys;				// 세포가 저장된 좌표 저장 (좌표를 key로 매핑해서 이미 사용중인 key인지 확인)
	static Map<Integer, Cell> cells;		// 전체 순회, 추가, 특정 객체 제거 잦음 : HashSet
	static PriorityQueue<Cell> addCells;	// 정렬해서 하나씩 다 빼기 : PQ
	static List<Integer> removeCells;		// 추가, 전체 순회만 : ArrayList
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			sb.append("#"+t+" ");
			
			init(br);
			fnc();
			sb.append(cells.size());
			
			sb.append("\n");
		}
		
		System.out.println(sb);
	}

	static void fnc() {
		while (K-- > 0) {
			
			for (Cell cell : cells.values()) {
				cell.time--;
				if (cell.time == -1) {	// 분열할 세포 저장
					addCells.add(cell);
				}
				if (cell.time == cell.life*-1) {	// 사망할 세포 저장 (forEach 돌면서 remove 하면 안됨)
					removeCells.add(cell.y*1000 + cell.x);
				}
			}
			
			while (!addCells.isEmpty()) {	// 세포 분열(생명력이 큰 세포부터)
				Cell cell = addCells.poll();
				for (int[] del : dels) {
					int ny = cell.y + del[0];
					int nx = cell.x + del[1];
					int key = ny*1000 + nx;
					
					if (!keys.contains(key)) {	// 분열 성공
						keys.add(key);
						cells.put(key, new Cell(ny, nx, cell.life));
					}
				}
			}
			
			for (int key : removeCells) {
				cells.remove(key);
			}
			removeCells.clear();
		}
	}



	static void init(BufferedReader br) throws IOException {
		String[] strs;
		strs =  br.readLine().split(" ");
		
		keys = new HashSet<>();
		cells = new HashMap<>();
		addCells = new PriorityQueue<>();
		removeCells = new ArrayList<>();
		
		N = Integer.parseInt(strs[0]);
		M = Integer.parseInt(strs[1]);
		K = Integer.parseInt(strs[2]);
		
		for (int i = 0; i < N; i++) {
			strs =  br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				int num = Integer.parseInt(strs[j]);
				if (num != 0) {
					int key = (i+200)*1000 + (j+200);
					cells.put(key, new Cell(200+i, 200+j, num));
					keys.add(key);
				}
			}
		}
	}

}