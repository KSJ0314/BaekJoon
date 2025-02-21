import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
	static int S, P, count, start, end;
	static String DNA;
	static int[] cnts;
	static Map<Character, Integer> map;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		init(br);
		while (end < S) {
			cnts[map.get(DNA.charAt(start++))]++;
			cnts[map.get(DNA.charAt(end++))]--;
			
			if (isAvailablePassword()) count++;
		}
		
		System.out.println(count);
	}

	public static boolean isAvailablePassword() {
		for (int n : cnts) {
			if (n > 0) return false;
		}
		return true;
	}

	public static void init(BufferedReader br) throws IOException {
		count = 0;
		cnts = new int[4];
		map = new HashMap<>();
		map.put('A', 0);
		map.put('C', 1);
		map.put('G', 2);
		map.put('T', 3);
		
		String[] strs = br.readLine().split(" ");
		S = Integer.parseInt(strs[0]);
		P = Integer.parseInt(strs[1]);
		start = 0;
		end = P;
		
		
		DNA = br.readLine();
		
		strs = br.readLine().split(" ");
		for (int i = 0; i < 4; i++) {
			cnts[0] = Integer.parseInt(strs[0]);
			cnts[1] = Integer.parseInt(strs[1]);
			cnts[2] = Integer.parseInt(strs[2]);
			cnts[3] = Integer.parseInt(strs[3]);
		}
		
		for (int i = 0; i < P; i++) {
			cnts[map.get(DNA.charAt(i))]--;
		}
		if (isAvailablePassword()) count++;
	}
	
}
