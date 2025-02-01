import java.io.*;
import java.util.*;

public class Main {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringBuilder sb = new StringBuilder();
	int[][] map;
	Deque<Integer> cities = new ArrayDeque<>();
	int[] results;
	boolean[] visited;
	int k, x;
	int count = 1;
	
	public void init() throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        visited = new boolean[n+1];
        visited[x] = true;
        map = new int[n+1][0];
		
		while (m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int sc = Integer.parseInt(st.nextToken());
			int ec = Integer.parseInt(st.nextToken());
			mapPut(sc, ec);
		}
		cities.add(x);

		for (int i = 1; i <= k; i++, count++) {
			visit();
		}
		countAppend();
	}
	
	public void mapPut(int key, int value) {
		int length = map[key].length;
		map[key] = Arrays.copyOf(map[key], length + 1);
		map[key][length] = value;
	}
	
	public void visit() {
		int size = cities.size();
		while (size-- > 0) {
			int key = cities.pollFirst();
			
			for (int value : map[key]) {
				if (visited[value]) continue;
				visited[value] = true;
				cities.addLast(value);
			}
		}
		if (count == k) {
			results = new int[cities.size()];
			for (int i = 0; cities.size() > 0; i++) {
				results[i] = cities.poll();
			}
		}
	}
	
	public void countAppend() {
		Arrays.sort(results);
		for (int count : results) {
			sb.append(count).append("\n");
		}
		
		if (results.length == 0) {
			sb.append(-1);
		}
	}

	public static void main(String[] args) throws IOException {
		Main m = new Main();
		m.init();
		System.out.println(m.sb.toString());
	}
}