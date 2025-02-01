import java.io.*;
import java.util.*;

public class Main {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringBuilder sb = new StringBuilder();
	Map<Integer, List<Integer>> map = new HashMap<>();
	Map<Integer, Integer> counts = new TreeMap<>();
	int k, x;
	
	public void init() throws IOException {
		String[] inpuStrs = br.readLine().split(" ");
		int n = Integer.parseInt(inpuStrs[0]);
		int m = Integer.parseInt(inpuStrs[1]);
		k = Integer.parseInt(inpuStrs[2]);
		x = Integer.parseInt(inpuStrs[3]);
		counts.put(x, 0);
		
		while (m-- > 0) {
			inpuStrs = br.readLine().split(" ");
			int sc = Integer.parseInt(inpuStrs[0]);
			int ec = Integer.parseInt(inpuStrs[1]);
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
			if (!counts.containsKey(value) || counts.get(value) > count) {
				counts.put(value, count);
				search(value, count+1);
			}
		}
	}
	
	public void countAppend() {
		for (int key : counts.keySet()) {
			int value = counts.get(key);
			if (value == k) {
				sb.append(key).append("\n");
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