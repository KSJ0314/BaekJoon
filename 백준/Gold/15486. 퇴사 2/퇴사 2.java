import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] maxProfit = new int[N+1];
		
		String[] strs;
		int max = 0;
		for (int i = 1; i <= N; i++) {
			maxProfit[i] = Math.max(maxProfit[i], maxProfit[i-1]);
			
			strs = br.readLine().split(" ");
			int time = Integer.parseInt(strs[0]);
			int price = Integer.parseInt(strs[1]);
			
			if (i + time - 1 > N) {
				continue;
			}
			
			maxProfit[i+time-1] = Math.max(maxProfit[i+time-1], maxProfit[i-1]+price);
			max = Math.max(max, maxProfit[i+time-1]);
		}
		
		System.out.println(max);
	}
}