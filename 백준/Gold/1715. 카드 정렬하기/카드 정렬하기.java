import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		PriorityQueue<Integer> pQ = new PriorityQueue<>();
		
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			pQ.add(Integer.parseInt(br.readLine()));
		}
		
		int sum = 0;
		while(pQ.size() > 1) {
			int a = pQ.poll();
			int b = pQ.poll();
			pQ.offer(a+b);
			sum += a+b;
		}
		
		System.out.println(sum);
	}
}