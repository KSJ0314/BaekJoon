import java.io.*;
import java.util.*;

public class Main {
	static class Node{
		int y, x, no;
		Node next;
		
		public Node(int y, int x, int no, Node next) {
			this.y = y;
			this.x = x;
			this.no = no;
			this.next = next;
		}
	}
	static int N;
	static int[] p;
	static Node nodes;
	
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int t = Integer.parseInt(br.readLine());
		
		while (t-- >0) {
			String[] strs;
			
			N = Integer.parseInt(br.readLine());
			p = new int[N+2];
			nodes = null;
			
			for (int i = 0; i < N+2; i++) {
				p[i] = i;
			}
			
			for (int i = 0; i < N+2; i++) {
				strs =  br.readLine().split(" ");
				
				int y = Integer.parseInt(strs[0]);
				int x = Integer.parseInt(strs[1]);
				
				for (Node node = nodes; node != null; node = node.next) {
					if (Math.abs(y-node.y) + Math.abs(x-node.x) <= 1000) {
						union(i, node.no);
					}
				}
				nodes = new Node(y, x, i, nodes);
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