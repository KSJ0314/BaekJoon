import java.io.*;
import java.util.*;

public class Solution {
	static int N, max;
	static Map<Integer, List<Integer>> map;
	static Deque<Integer> deque;
	static Set<Integer> visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = 10;
		for (int test_case = 1; test_case <= T; test_case++) {
			init(br);
			bfs();
			sb.append("#").append(test_case).append(" ").append(max).append("\n");
		}
		System.out.println(sb);
	}

	static void bfs() {
		while (!deque.isEmpty()) {
			int size = deque.size();
			boolean first = true;
			while (size-- > 0) {
				int key = deque.pollFirst();
				if (visited.contains(key)) continue;
				visited.add(key);
				if (first) max = key;
				max = Math.max(max, key);
				first = false;
				if (!map.containsKey(key)) continue;
				for (int value : map.get(key)) {
					deque.offerLast(value);
				}
			}
		}
	}

	static void init(BufferedReader br) throws IOException {
		String[] strs = br.readLine().split(" ");
		N = Integer.parseInt(strs[0]);
		int start = Integer.parseInt(strs[1]);
		map = new HashMap<>();
		deque = new ArrayDeque<>();
		deque.offerLast(start);
		max = Integer.MIN_VALUE;
		visited = new HashSet<>();
		
		strs = br.readLine().split(" ");
		for (int i = 0; i < N; i+=2) {
			int key =Integer.parseInt(strs[i]);
			int value =Integer.parseInt(strs[i+1]);
			mapPut(key, value);
		}
	}

	static void mapPut(int key, int value) {
		if (!map.containsKey(key)) map.put(key, new ArrayList<>());
		map.get(key).add(value);
	}
}