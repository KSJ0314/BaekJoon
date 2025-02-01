import java.io.*;
import java.util.*;

public class Main {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringBuilder sb = new StringBuilder();
	Map<Integer, List<Integer>> map = new HashMap<>();
	int[] counts;
	int k, x;
	
	public void init() throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
		counts = new int[n+1];
		counts[x] = -1;
		
		while (m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int sc = Integer.parseInt(st.nextToken());
			int ec = Integer.parseInt(st.nextToken());
			mapPut(sc, ec);
		}
		
		search(x, 1);
		countAppend();
	}
	
	public void mapPut(int key, int value) {
		if (!map.containsKey(key)) {
			map.put(key, new ArrayList<>());
		}
		map.get(key).add(value);
	}
	
	public void search(int key, int count) {
		if (count > k) {
			return;
		}
		if (map.get(key) == null) return;
		for (int value : map.get(key)) {
			if (counts[value] == 0 || counts[value] > count) {
				counts[value] = count;
				search(value, count+1);
			}
		}
	}
	
	public void countAppend() {
		for (int i = 0; i < counts.length; i++) {
			if (counts[i] == k) {
				sb.append(i).append("\n");
			}
		}
		if (sb.length() == 0) sb.append(-1);
	}

	public static void main(String[] args) throws IOException {
		Main m = new Main();
		m.init();
		System.out.println(m.sb.toString());
	}
}