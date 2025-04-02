import java.io.*;
import java.util.*;

public class Main {
	static class Coor{
		double x, y;

		public Coor(double x, double y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static class Vertex implements Comparable<Vertex>{
		int no;
		double dis;
		
		public Vertex(int no, double dis) {
			this.no = no;
			this.dis = dis;
		}

		@Override
		public int compareTo(Main.Vertex o) {
			return Double.compare(this.dis, o.dis);
		}
	}
	
	static int n;
	static Coor[] coors;
	static double[] minDis;
	static PriorityQueue<Vertex> pQ;

	public static void main(String[] args) throws IOException {
		init();
		dij();
		System.out.println(minDis[1] / 5);
	}

	static void dij() {
		while (!pQ.isEmpty()) {
			Vertex vertex = pQ.poll();
			if (vertex.no == 1) break;
			if (vertex.dis > minDis[vertex.no]) continue;
			
			for (int i = 1; i < n+2; i++) {
				double dis = vertex.dis + 10 + Math.abs(50-calDis(vertex.no, i));
				if (minDis[i] <= dis) continue;
				minDis[i] = dis;
				pQ.offer(new Vertex(i, dis));
			}
		}
	}
	
	static double calDis(int o1, int o2) {
		return Math.sqrt(Math.pow(Math.abs(coors[o1].x-coors[o2].x),2) + Math.pow(Math.abs(coors[o1].y-coors[o2].y),2));
	}

	static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strs;
		
		strs = br.readLine().split(" ");
		double sX = Double.parseDouble(strs[0]);
		double sY = Double.parseDouble(strs[1]);
		
		strs = br.readLine().split(" ");
		double eX = Double.parseDouble(strs[0]);
		double eY = Double.parseDouble(strs[1]);
		
		n = Integer.parseInt(br.readLine());
		coors = new Coor[n+2];
		minDis = new double[n+2];
		
		coors[0] = new Coor(sX, sY);
		coors[1] = new Coor(eX, eY);
		for (int i = 2; i < n+2; i++) {
			strs = br.readLine().split(" ");
			double x = Double.parseDouble(strs[0]);
			double y = Double.parseDouble(strs[1]);
			
			coors[i] = new Coor(x, y);
		}
		
		for (int i = 0; i < n+2; i++) {
			minDis[i] = Double.MAX_VALUE;
		}
		
		minDis[0] = 0;
		minDis[1] = calDis(0,1);
		
		pQ = new PriorityQueue<>();
		
		for (int i = 1; i < n+2; i++) {
			double dis = calDis(0, i);
			minDis[i] = dis;
			pQ.offer(new Vertex(i, dis));
		}
	}
}