import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// int N = Integer.parseInt(br.readLine());
		
		HashMap<Integer, Integer> map = new HashMap<>();
		
		br.readLine();
		String[] inputStrArr = br.readLine().split(" ");
		
		for (String str : inputStrArr) {
			int i = Integer.parseInt(str);
			if (!map.containsKey(i)) {
				map.put(i, 0);
			}
			map.put(i, map.get(i)+1);
		}
		
		br.readLine();
		inputStrArr = br.readLine().split(" ");
		
		StringBuilder sb = new StringBuilder();
		for (String str : inputStrArr) {
			int i = Integer.parseInt(str);
			int result = 0;
			if (map.containsKey(i)) {
				result = map.get(i);
			}
			sb.append(result+" ");
		}
		System.out.println(sb.toString());
	}
}
