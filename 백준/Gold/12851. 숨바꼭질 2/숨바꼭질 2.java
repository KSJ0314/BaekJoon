import java.io.*;
import java.util.*;

public class Main {
	static int S, E;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strs;
		
		strs = br.readLine().split(" ");
		S = Integer.parseInt(strs[0]);
		E = Integer.parseInt(strs[1]);
		
		if (S == E) {
			System.out.println(0);
			System.out.println(1);
			return;
		}
		
		ArrayDeque<Integer> idxs = new ArrayDeque<>();
		idxs.add(S);
		int time = 0;
		boolean isEnd = false;
		int cnt = 0;
		boolean[] visited = new boolean[100001];
		visited[S] = true;
		while (!idxs.isEmpty()) {
			int size = idxs.size();
			time++;
			HashSet<Integer> visitedSet = new HashSet<>();
			
			while (size-- > 0) {
				int crt = idxs.pollFirst();
				
				int[] nexts = {crt-1, crt+1, crt*2};
				
				for (int next : nexts) {
					if (next == E) {
						isEnd = true;
						cnt++;
					}
					if (0 <= next && next <= 100000) {
						if (visited[next]) continue;
						visitedSet.add(next);
						idxs.addLast(next);
					}
				}
			}
			
			for (int v : visitedSet) {
				visited[v] = true;
			}
			
			if (isEnd) {
				System.out.println(time);
				System.out.println(cnt);
				break;
			}
		}
	}
}