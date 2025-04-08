import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] strs;
		
		int N = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> pQ = new PriorityQueue<>((o1,o2) -> o2-o1);
		
		for (int i = 0; i < N; i++) {
			strs = br.readLine().split(" ");
			int oper = Integer.parseInt(strs[0]);
			if (oper == 0) {
				sb.append(pQ.isEmpty() ? -1 : pQ.poll()).append("\n");
			} else {
				for (int j = 1; j <= oper; j++) {
					pQ.add(Integer.parseInt(strs[j]));
				}
			}
		}
		
		System.out.println(sb);
	}
}