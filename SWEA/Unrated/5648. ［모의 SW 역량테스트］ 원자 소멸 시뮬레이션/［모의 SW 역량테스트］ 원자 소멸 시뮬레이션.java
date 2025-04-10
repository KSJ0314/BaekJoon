import java.io.*;
import java.util.*;

public class Solution {
	static int[][] dels = {{1,0},{-1,0},{0,-1},{0,1}};
	static class Atom{
		int d, k;	// 이동 방향, 보유 에너지
		boolean e;	// 폭발 여부
		public Atom(int d, int k) {
			this.d = d;
			this.k = k;
		}
	}
	static int N, total;
	static Map<Long, Atom> preMap, nextMap;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			sb.append("#"+t+" ");
			
			init(br);
			fn();
			sb.append(total);
			
			sb.append("\n");
		}
		System.out.println(sb);
	}
	
	static void fn() {
		while (!nextMap.isEmpty()) {
			preMap = nextMap;
			nextMap = new HashMap<>();
			
			for (long key : preMap.keySet()) {
				Atom atom = preMap.get(key);
				if (atom.e) continue;
				long nx = (key/100000)-10000 + dels[atom.d][1];
				long ny = (key%100000)-10000 + dels[atom.d][0];
				if (!isIn(nx, ny)) continue;
				long coor = coorMapping(nx, ny);
				
				if (nextMap.containsKey(coor)) {
					Atom atom2 = nextMap.get(coor);
					if (!atom2.e) total += atom2.k;
					total += atom.k;
					atom2.e = true;
				} else {
					nextMap.put(coor, atom);
				}
			}
		}
	}

	static boolean isIn(long x, long y) {
		return x >= -2000 && x <= 2000 && y >= -2000 && y <= 2000;
	}

	static void init(BufferedReader br) throws IOException {
		preMap = new HashMap<>();
		nextMap = new HashMap<>();
		total = 0;
		
		N = Integer.parseInt(br.readLine());
		
		String[] strs;
		for (int i = 0; i < N; i++) {
			strs = br.readLine().split(" ");
			int x = Integer.parseInt(strs[0])*2;
			int y = Integer.parseInt(strs[1])*2;
			int d = Integer.parseInt(strs[2]);
			int k = Integer.parseInt(strs[3]);
			nextMap.put(coorMapping(x, y), new Atom(d, k));
		}
	}

	static long coorMapping(long x, long y) {
		return (x+10000)*100000 + (y+10000);
	}
}