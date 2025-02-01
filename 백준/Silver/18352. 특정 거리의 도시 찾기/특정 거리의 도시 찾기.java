import java.io.*;
import java.util.*;

public class Main {
	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	StringBuilder sb = new StringBuilder();
	Map<Integer, List<Integer>> map = new HashMap<>();
	List<Integer> pkeys = new ArrayList<>();
	List<Integer> nkeys = new ArrayList<>();
	Set<Integer> counts = new TreeSet<>();
	boolean[] isGone;
	int k, x;
	
	public void init() throws IOException {
		StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        isGone = new boolean[n+1];
        isGone[x] = true;
		
		while (m-- > 0) {
			st = new StringTokenizer(br.readLine());
			int sc = Integer.parseInt(st.nextToken());
			int ec = Integer.parseInt(st.nextToken());
			mapPut(sc, ec);
		}
		nkeys.add(x);
		search(1);
		countAppend();
	}
	
	public void mapPut(int key, int value) {
		if (!map.containsKey(key)) {
			map.put(key, new ArrayList<>());
		}
		map.get(key).add(value);
	}
	
	public void search(int count) {
		pkeys = List.copyOf(nkeys);
		nkeys.clear();
		for (int key : pkeys) {
			if (!map.containsKey(key)) continue;
			
			for (int value : map.get(key)) {
				if (isGone[value]) continue;
				
				if (count == k) {
					counts.add(value);
					continue;
				}
				
				nkeys.add(value);
				isGone[value] = true;
			}
		}
		
		if (count < k) {
			search(count+1);
		}
	}
	
	public void countAppend() {
		for (int count : counts) {
			sb.append(count).append("\n");
		}
		if (sb.length() == 0) sb.append(-1);
	}

	public static void main(String[] args) throws IOException {
		Main m = new Main();
		m.init();
		System.out.println(m.sb.toString());
	}
}