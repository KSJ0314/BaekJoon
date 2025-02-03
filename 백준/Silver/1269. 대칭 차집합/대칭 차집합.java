import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String[] inputStrs = br.readLine().split(" ");
		int n = Integer.parseInt(inputStrs[0]);
		int m = Integer.parseInt(inputStrs[1]);

		int count = 0;
		
		Set<Integer> set = new HashSet<>();
		inputStrs = br.readLine().split(" ");
		for (int i = 0; i < n; i++) {
			set.add(Integer.parseInt(inputStrs[i]));
		}
		
		inputStrs = br.readLine().split(" ");
		for (int i = 0; i < m; i++) {
			int b = Integer.parseInt(inputStrs[i]);
			if (set.contains(b)) {
				count++;
			}
		}
		
		System.out.println(n+m-(count*2));
	}
}