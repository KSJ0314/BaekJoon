import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int INF = 100001;
		String[] strs;
		strs = br. readLine().split(" ");
		
		int N = Integer.parseInt(strs[0]);
		int K = Integer.parseInt(strs[1]);
		if (N==K) {
			System.out.println("0");
			return;
		}
		
		Deque<Integer> deque = new ArrayDeque<>();
		deque.offerLast(N);
		
		int[] cnts = new int[INF];
		Arrays.fill(cnts, INF);
		cnts[N] = 0;
		
		while (!deque.isEmpty()) {
			int crt = deque.pollFirst();
			
			if (crt != 0) {
				for (int i = 1; crt*i < INF; i*=2) {
					if (crt*i == K) {
						System.out.println(cnts[crt]);
						return;
					}
					
					if (cnts[crt*i] == INF) {
						deque.offerLast(crt*i);
						cnts[crt*i] = cnts[crt];
					}
				}
			}
			
			if (crt-1 == K || crt+1 == K) {
				System.out.println(cnts[crt]+1);
				return;
			}
			if (crt-1 > 0 && cnts[crt-1] == INF) {
				deque.offerLast(crt-1);
				cnts[crt-1] = cnts[crt]+1;
			}
			if (crt+1 < INF && cnts[crt+1] == INF) {
				deque.offerLast(crt+1);
				cnts[crt+1] = cnts[crt]+1;
			}
		}
		
	}

}
