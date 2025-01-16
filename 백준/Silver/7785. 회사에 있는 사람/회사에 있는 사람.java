import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		HashSet<String> set = new HashSet<>();
		
		String[] inputStrArr;
		for (int i = 0; i < N; i++) {
			inputStrArr = br.readLine().split(" ");
			if (inputStrArr[1].charAt(0) == 'e') {
				set.add(inputStrArr[0]);
			} else {
				set.remove(inputStrArr[0]);
			}
		}
		
		List<String> list = new ArrayList<>(set);
		Collections.sort(list, Collections.reverseOrder());
		
		StringBuilder sb = new StringBuilder();
		for (String str : list) {
			sb.append(str+"\n");
		}
		System.out.println(sb.toString());
		
	}
}
