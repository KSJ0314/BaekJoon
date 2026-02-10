import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strs;
		
		strs = br.readLine().split(" ");
		int G = Integer.parseInt(strs[0]);
		strs = br.readLine().split(" ");
		int P = Integer.parseInt(strs[0]);
		
		TreeSet<Integer> ts = new TreeSet<>();
		
		for (int i = 1; i <= G; i++) {
			ts.add(i);
		}
		for (int i = 0; i < P; i++) {
			strs = br.readLine().split(" ");
			int n = Integer.parseInt(strs[0]);
			
			Integer ceil = ts.floor(n);
			if (ceil == null) break;
			ts.remove(ceil);
		}
		System.out.println(G - ts.size());
	}
}