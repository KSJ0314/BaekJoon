import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String[] inputStrs = br.readLine().split(" ");
		int n = Integer.parseInt(inputStrs[0]);
		int m = Integer.parseInt(inputStrs[1]);
		
		Set<String> set = new HashSet<>();
		for (int i = 0; i < n; i++) {
			set.add(br.readLine());
		}
		
		int count = 0;
		Set<String> resultSet = new TreeSet<>();
		for (int i = 0; i < m; i++) {
			String str = br.readLine();
			if (set.contains(str)) {
				count++;
				resultSet.add(str);
			}
		}
		for (String str : resultSet) {
			sb.append(str).append("\n");
		}
		
		System.out.println(count);
		System.out.println(sb.toString());
	}

}