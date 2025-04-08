import java.io.*;
import java.util.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String[] strs;
		
		strs = br.readLine().split(" ");
		int N = Integer.parseInt(strs[0]);
		int M = Integer.parseInt(strs[1]);
		
		Map<String, String> map = new HashMap<>();
		
		for (int i = 0; i < N; i++) {
			strs = br.readLine().split(" ");
			map.put(strs[0], strs[1]);
		}
		
		for (int i = 0; i < M; i++) {
			sb.append(map.get(br.readLine())).append("\n");
		}
		
		System.out.println(sb);
	}
}