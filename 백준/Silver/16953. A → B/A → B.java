import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strs;
		
		strs = br.readLine().split(" ");
		Long N = Long.parseLong(strs[0]);
		Long K = Long.parseLong(strs[1]);
		
		HashMap<Long, Integer> map = new HashMap<>();
		map.put(N, 1);
		
		ArrayDeque<Long> deq = new ArrayDeque<>();
		deq.add(N);
		
		while (!deq.isEmpty()) {
			long crt = deq.pollFirst();
			if (crt == K) break;
			
			long[] keys = {crt*2, crt*10+1};
			for (long key : keys) {
				if (Long.compare(key, 1_000_000_000) > 0) continue;
				if (key > K) continue;
				if (map.containsKey(key)) continue;
				map.put(key, map.get(crt)+1);
				deq.add(key);
			} 
		}
		
		System.out.println(map.getOrDefault(K, -1));
	}
}