import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		sb = new StringBuilder();
		
		String[] strs;
		strs = br.readLine().split(" ");
		N = Integer.parseInt(strs[0]);
		M = Integer.parseInt(strs[1]);
		
		per(0, 1, "");
		System.out.println(sb);
	}

	private static void per(int depth, int start, String result) {
		if (depth == M) {
			sb.append(result).append("\n");
			return;
		}
		
		for (int i = start; i <= N; i++) {
			per(depth+1, i,result+i+" ");
		}
	}
}