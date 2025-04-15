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
	static List<Cell> removeCells;
	static PriorityQueue<Cell> addCells;
	static int[][] arr;
	static Set<Cell> cells;
	
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
			removeCells.clear();
			for (Cell cell : cells) {
				cell.time--;
				if (cell.time == -1) {	// 세포 분열
					addCells.add(cell);
				}
				if (cell.time == cell.life*-1) {
					removeCells.add(cell);
				}
			}
			
			while (!addCells.isEmpty()) {
				Cell cell = addCells.poll();
				for (int[] del : dels) {
					int ny = cell.y + del[0];
					int nx = cell.x + del[1];
					
					if (arr[ny][nx] == 0) {
						arr[ny][nx] = cell.life;
						cells.add(new Cell(ny, nx, cell.life));
					}
				}
			}
			
			for (Cell cell : removeCells) {
				cells.remove(cell);
			}
		}
	}



	static void init(BufferedReader br) throws IOException {
		String[] strs;
		strs =  br.readLine().split(" ");
		
		cells = new HashSet<>();
		addCells = new PriorityQueue<>();
		removeCells = new ArrayList<>();
		arr = new int[500][500];
		
		N = Integer.parseInt(strs[0]);
		M = Integer.parseInt(strs[1]);
		K = Integer.parseInt(strs[2]);
		
		for (int i = 0; i < N; i++) {
			strs =  br.readLine().split(" ");
			for (int j = 0; j < M; j++) {
				int num = Integer.parseInt(strs[j]);
				if (num != 0) {
					cells.add(new Cell(200+i, 200+j, num));
					arr[200+i][200+j] = num;
				}
			}
		}
	}

}