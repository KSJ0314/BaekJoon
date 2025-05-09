import java.io.*;
import java.util.*;

public class Main {
	static class Jewel implements Comparable<Jewel>{
		int m, v;

		public Jewel(int m, int v) {
			this.m = m;
			this.v = v;
		}

		@Override
		public int compareTo(Jewel o) {
			return Integer.compare(this.v, o.v) * -1;
		}
	}
	
	static class Bag implements Comparable<Bag>{
		int no, c;

		public Bag(int no, int c) {
			this.no = no;
			this.c = c;
		}

		@Override
		public int compareTo(Bag o) {
			if (this.c != o.c) {
				return Integer.compare(this.c, o.c);
			} else {
				return Integer.compare(this.no, o.no);
			}
		}
	}
	
	static <T> boolean pollCeiling(TreeSet<T> set, T e) {
		T target = set.ceiling(e);
		
		if (target == null) return false;
		set.remove(target);
		return true;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strs;
		
		PriorityQueue<Jewel> jewelPQ = new PriorityQueue<>();
		TreeSet<Bag> bagSet = new TreeSet<>();
		
		strs = br.readLine().split(" ");
		int N = Integer.parseInt(strs[0]);
		int K = Integer.parseInt(strs[1]);
		
		for (int i = 0; i < N; i++) {
			strs = br.readLine().split(" ");
			int m = Integer.parseInt(strs[0]);
			int v = Integer.parseInt(strs[1]);
			jewelPQ.offer(new Jewel(m, v));
		}
		
		for (int i = 0; i < K; i++) {
			int c = Integer.parseInt(br.readLine());
			bagSet.add(new Bag(i, c));
		}
		
		long sum = 0;
		while (!jewelPQ.isEmpty() && !bagSet.isEmpty()) {
			Jewel jewel = jewelPQ.poll();
			if (pollCeiling(bagSet, new Bag(-1, jewel.m))) {
				sum += jewel.v;
			}
		}
		System.out.println(sum);
	}
}