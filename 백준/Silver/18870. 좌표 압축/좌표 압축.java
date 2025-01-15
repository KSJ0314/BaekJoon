import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		long[] coors = new long[N];
		
		String[] inputStr = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			coors[i] = Long.parseLong(inputStr[i]);
		}
		
		Map<Long, Integer> map = new HashMap<>();
		long[] coor2 = Arrays.stream(coors).sorted().distinct().toArray();
		
		for (int i = 0; i < coor2.length; i++) {
			map.put(coor2[i], i);
		}
		
		StringBuilder sb = new StringBuilder();
		for (long coor : coors) {
			sb.append(map.get(coor)+" ");
		}
		System.out.println(sb.toString().trim());
	}
}
