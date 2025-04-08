import java.io.*;
import java.util.LinkedList;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		String[] strs;
		int mask = 0;
		while (n-- >0) {
			strs = br.readLine().split(" ");
			switch (strs[0]) {
				case "all":
					mask = Integer.MAX_VALUE;
					break;
				case "empty":
					mask = 0;
					break;
				case "add":
					mask |= 1 << Integer.parseInt(strs[1]);
					break;
				case "check":
					sb.append((mask & 1 << Integer.parseInt(strs[1])) != 0 ? 1 : 0).append("\n");
					break;
				case "remove":
					mask &= ~(1 << Integer.parseInt(strs[1]));
					break;
				case "toggle":
					mask ^= 1 << Integer.parseInt(strs[1]);
					break;
			}
		}
		
		System.out.println(sb);
	}
}
