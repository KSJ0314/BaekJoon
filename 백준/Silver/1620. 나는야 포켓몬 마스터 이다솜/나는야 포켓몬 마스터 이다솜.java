import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// int N = Integer.parseInt(br.readLine());
		String[] inputStrArr = br.readLine().split(" ");
		int N = Integer.parseInt(inputStrArr[0]);
		int M = Integer.parseInt(inputStrArr[1]);
		
		List<String> list = new ArrayList<>();
		Map<String, Integer> map = new HashMap<>();
		list.add("");
		for (int i = 1; i <= N; i++) {
			String str = br.readLine();
			list.add(str);
			map.put(str, i);
		}
		
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= M; i++) {
			String str = br.readLine();
			String result;
			if (str.charAt(0) < 65) {
				result = list.get(Integer.parseInt(str));
			} else {
				result = map.get(str).toString();
			}
			sb.append(result+"\n");
		}
		System.out.println(sb.toString());
	}
}
