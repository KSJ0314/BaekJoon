import java.io.*;
import java.util.*;

public class Main {
	static class Brick implements Comparable<Brick>{
		int no, area, height, weight;
		public Brick(int no, int area, int height, int weight) {
			this.no = no;
			this.area = area;
			this.height = height;
			this.weight = weight;
		}
		@Override
		public int compareTo(Main.Brick o) {
			return Integer.compare(this.area, o.area)*-1;
		}
		@Override
		public String toString() {
			return "Brick [no=" + no + ", area=" + area + ", height=" + height + ", weight=" + weight + "]";
		}
		
	}
	
	static int N, W;
	static Brick[] bricks;
	static int[] dp;
	static List<Integer>[] list;

	public static void main(String[] args) throws IOException {
		init();
		dp();
		print();
	}
	
	static void print() {
		System.out.println(list[1].size());
		for (int i = list[1].size()-1; i >= 0; i--) {
			System.out.println(list[1].get(i));
		}
	}

	static void dp() {
		for (int i = 0; i < N; i++) {
			int height = bricks[i].height;
			int weight = bricks[i].weight;
			
			int max = 0;
			int maxIdx = -1;
			for (int j = weight+1; j <= W; j++) {
				if (max < dp[j]) {
					max = dp[j];
					maxIdx = j;
				}
			}
			max += height;
			
			for (int j = 1; j <= weight; j++) {
				if (dp[j] < max) {
					dp[j] = max;
					if (maxIdx == -1) {
						list[j] = new ArrayList<>();
					} else {
						list[j] = new ArrayList<>(list[maxIdx]);
					}
					list[j].add(bricks[i].no);
				}
			}
			//System.out.println(Arrays.toString(dp));
			//System.out.println(list[i]);
		}
	}
	
	static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strs;
		
		N = Integer.parseInt(br.readLine());
		bricks = new Brick[N];
		W = 0;
		
		for (int i = 0; i < N; i++) {
			strs = br.readLine().split(" ");
			int area = Integer.parseInt(strs[0]);
			int height = Integer.parseInt(strs[1]);
			int weight = Integer.parseInt(strs[2]);
			bricks[i] = new Brick(i+1, area, height, weight);
			W = Math.max(W, weight);
		}
		
		dp = new int[W+1];
		list = new ArrayList[W+1];
		Arrays.sort(bricks);
	}
}