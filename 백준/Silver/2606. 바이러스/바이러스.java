import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static boolean[] visited;
	static Map<Integer, List<Integer>> map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		init(br);
		
		visited[1] = true;
		int count = map.containsKey(1) ? counting(1)-1 : 0;
		
		System.out.println(count);
	}
	
	public static int counting(int num) {
		int count = 1;
		for (int n : map.get(num)) {
			if (visited[n]) continue;
			visited[n] = true;
			count += counting(n);
		}
		
		return count;
	}
	
	public static void init(BufferedReader br) throws IOException {
		map = new HashMap<>();
		
		N = Integer.parseInt(br.readLine());
		visited = new boolean[N+1];
		
		int M = Integer.parseInt(br.readLine());
		for (int i = 0; i < M; i++) {
			String[] strs = br.readLine().split(" ");
			int a = Integer.parseInt(strs[0]);
			int b = Integer.parseInt(strs[1]);
			mapPut(a, b);
			mapPut(b, a);
		}
	}
	
	public static void mapPut(int a, int b) {
		if (!map.containsKey(a)) {
			map.put(a, new ArrayList<>());
		}
		map.get(a).add(b);
	}
	
}