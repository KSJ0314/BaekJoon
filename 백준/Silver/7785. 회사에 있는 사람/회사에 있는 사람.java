import java.io.*;
import java.util.Comparator;
import java.util.TreeSet;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		TreeSet<String> set = new TreeSet<>(Comparator.reverseOrder());
		
		String[] inputStrArr;
		for (int i = 0; i < N; i++) {
			inputStrArr = br.readLine().split(" ");
			if (inputStrArr[1].charAt(0) == 'e') {
				set.add(inputStrArr[0]);
			} else {
				set.remove(inputStrArr[0]);
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for (String str : set) {
			sb.append(str+"\n");
		}
		System.out.println(sb.toString());
		
	}
}
