import java.io.*;
import java.util.*;

public class Main {
	static int N, K;
	static boolean[] onRobot;
	static int[] hps;
	static Deque<Integer> idxDeq1, idxDeq2;
	
	public static void main(String[] args) throws IOException {
		init();

		int level = 0;
		while (K > 0) {
			idxDeq1.addFirst(idxDeq2.pollFirst());
			idxDeq2.addLast(idxDeq1.pollLast());
			for (int j = N-1; j > 0; j--) {
				onRobot[j] = onRobot[j-1];
			}
			onRobot[0] = false;
			
			Iterator<Integer> rIterator = idxDeq1.descendingIterator();
			onRobot[N-1] = false;
			ArrayList<Integer> deleteList = new ArrayList<>();
			int i = N;
			while (rIterator.hasNext()) {
				i--;
				int idx = rIterator.next();
				if (i>0 && onRobot[i-1]) {
					if (hps[idx] > 0 && !onRobot[i]) {
						onRobot[i-1] = false;
						onRobot[i] = true;
						deleteList.add(idx);
					}
				}
			}
			if (hps[idxDeq1.peekFirst()] > 0) {
				onRobot[0] = true;
				deleteList.add(idxDeq1.peekFirst());
			}
			
			for (int idx : deleteList) {
				hps[idx]--;
				if (hps[idx] == 0) K--;
			}
			level++;
		}
		
		System.out.println(level);
	}
	
	public static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = br.readLine().split(" ");
		
		N = Integer.parseInt(strs[0]);
		K = Integer.parseInt(strs[1]);
		
		onRobot = new boolean[N];
		hps = new int[N*2];
		idxDeq1 = new ArrayDeque<>();
		idxDeq2 = new ArrayDeque<>();
		
		strs = br.readLine().split(" ");
		for (int i = 0; i < N*2; i++) {
			hps[i] = Integer.parseInt(strs[i]);
		}
		for (int i = 0; i < N; i++) {
			idxDeq1.addLast(i);
		}
		for (int i = N; i < N*2; i++) {
			idxDeq2.addFirst(i);
		}
	}
}