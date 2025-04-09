import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strs;
		
		PriorityQueue<Long> pQ = new PriorityQueue<>();
		
		strs = br.readLine().split(" ");
		int N = Integer.parseInt(strs[0]);
		int M = Integer.parseInt(strs[1]);
		
		strs = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			pQ.add(Long.parseLong(strs[i]));
		}
		
		for (int i = 0; i < M; i++) {
			long a = pQ.poll();
			long b = pQ.poll();
			pQ.add(a+b);
			pQ.add(a+b);
		}
		
		long sum = 0;
		for (long num : pQ) {
			sum += num;
		}
		
		System.out.println(sum);
	}
}