import java.io.*;
import java.util.*;

public class Main {
	static class Num implements Comparable<Num>{
		int no, value;

		public Num(int no, int value) {
			this.no = no;
			this.value = value;
		}

		@Override
		public int compareTo(Num o) {
			if (this.value != o.value) return Integer.compare(this.value, o.value);
			return this.no - o.no;
		}
		
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			
			TreeSet<Num> set = new TreeSet<>();
			
			int N = Integer.parseInt(br.readLine());
			
			String[] strs;
			for (int i = 0; i < N; i++) {
				strs = br.readLine().split(" ");
				String code = strs[0];
				int num = Integer.parseInt(strs[1]);
				
				if (code.equals("I")) {
					set.add(new Num(i, num));
				} else {
					if (num == 1) {
						set.pollLast();
					} else {
						set.pollFirst();
					}
				}
			}
			
			sb.append(set.isEmpty() ? "EMPTY" : set.last().value +" " + set.first().value);
			
			sb.append("\n");
		}
		System.out.println(sb);
	}
}