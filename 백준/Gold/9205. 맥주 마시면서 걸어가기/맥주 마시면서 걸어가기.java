import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int[] p;
	static List<Long> nodes;
	
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());
		
		while (t-- >0) {
			String[] strs;
			
			N = Integer.parseInt(br.readLine());
			p = new int[N+2];
			nodes = new ArrayList<>();
			
			for (int i = 0; i < N+2; i++) {
				p[i] = i;
			}
			
			for (int i = 0; i < N+2; i++) {
				strs =  br.readLine().split(" ");
				
				int y = Integer.parseInt(strs[0]) + 40_000;
				int x = Integer.parseInt(strs[1]) + 40_000;
				
				for (int j = 0; j < nodes.size(); j++) {
					long nodeCoor = nodes.get(j);
					int ny = (int) (nodeCoor/100_000);
					int nx = (int) (nodeCoor%100_000);
					
					if (Math.abs(y-ny) + Math.abs(x-nx) <= 1000) {
						union(i, j);
					}
				}
				long coor = (long)y*100_000 + x;
				nodes.add(coor);
			}
			
			
			sb.append(union(0, N+1) ? "sad" : "happy").append("\n");
		}
		
		
		System.out.println(sb);
	}
	
	static boolean union(int a, int b) {
		int aR = find(a);
		int bR = find(b);
		
		if (aR == bR) return false;
		p[bR] = aR;
		return true;
	}
	
	static int find(int a) {
		if (a == p[a]) return a;
		return p[a] = find(p[a]);
	}

}