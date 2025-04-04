import java.io.*;
import java.util.*;

public class Solution {
	static final boolean UP = true, DOWN = false;
	static int N, cnt, count;
	static boolean[][] arr;
	static boolean[] check;
	static Map<Integer, List<Integer>> upMap, downMap;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		for (int t = 1; t <= T; t++) {
			sb.append("#"+t+" ");
			
			init(br);
			counting();
			sb.append(cnt);
			
			sb.append("\n");
		}
		System.out.println(sb);
	}

	private static void counting() {
		for (int i = 1; i <= N; i++) {
			Arrays.fill(check, false);
			count = 0;
			find(i, UP);
			find(i, DOWN);
			if (count == N+1) cnt++;
		}
	}

	private static void find(int a, boolean isUp) {
		count++;
		List<Integer> list = isUp ? upMap.get(a) : downMap.get(a);
		if (list == null) return;
		for (int next : list) {
			if (check[next]) continue;
			check[next] = true;
			find(next, isUp);
		}
	}

	static void init(BufferedReader br) throws IOException {
		N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());
		arr = new boolean[N+1][N+1];
		check = new boolean[N+1];
		cnt = 0;
		upMap = new HashMap<>();
		downMap = new HashMap<>();
		
		String[] strs;
		for (int i = 0; i < M; i++) {
			strs = br.readLine().split(" ");
			int a = Integer.parseInt(strs[0]);
			int b = Integer.parseInt(strs[1]);
			
			arr[a][b] = true;
			mapPut(upMap, a, b);
			mapPut(downMap, b, a);
		}
	}
	
	static void mapPut(Map<Integer, List<Integer>> map, int a, int b) {
		if (!map.containsKey(a)) map.put(a, new ArrayList<>());
		map.get(a).add(b);
	}
}