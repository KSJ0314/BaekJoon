import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] strs;
		
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pQ = new PriorityQueue<>();
		
		for (int i = 0; i < N; i++) {
			strs = br.readLine().split(" ");
			int oper = Integer.parseInt(strs[0]);
			
			if (oper == 0) {
				sb.append(pQ.isEmpty() ? 0 : pQ.poll()).append("\n");
			} else {
				pQ.add(oper);
			}
		}
		
		System.out.println(sb);
	}
}