import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		PriorityQueue<Integer> pQ = new PriorityQueue<>((o1, o2) ->{
			int abs1 = Math.abs(o1);
			int abs2 = Math.abs(o2);
			if (abs1 != abs2) return Integer.compare(abs1, abs2);
			return Integer.compare(o1, o2);
		});
		
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			int oper = Integer.parseInt(br.readLine());
			
			if (oper == 0) {
				sb.append(pQ.isEmpty() ? 0 : pQ.poll()).append("\n");
			} else {
				pQ.add(oper);
			}
		}
		
		System.out.println(sb);
	}
}