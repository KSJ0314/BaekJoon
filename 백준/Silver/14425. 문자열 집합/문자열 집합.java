import java.io.*;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringBuilder sb = new StringBuilder();
		// int inputInt = Integer.parseInt(br.readLine());
		String[] inputStrArr = br.readLine().split(" ");
		
		int N = Integer.parseInt(inputStrArr[0]);
		int M = Integer.parseInt(inputStrArr[1]);
//		Map<Integer, ArrayList<String>> map = new HashMap<>();
		ArrayList<String> list = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
			String inputStr = br.readLine();
//			int idx = inputStr.charAt(0)-'a';
//			if (map.get(idx) == null) map.put(idx, new ArrayList<>());
//			map.get(idx).add(inputStr);
			list.add(inputStr);
		}
		
		int count = 0;
		for (int i = 0; i < M; i++) {
			String inputStr = br.readLine();
//			int idx = inputStr.charAt(0)-'a';
//			if (map.get(idx) != null && map.get(idx).contains(inputStr)) {
//				count++;
//			}
			if (list.contains(inputStr)) {
				count++;
			}
		}
		
		System.out.println(count);
		
	}
}
