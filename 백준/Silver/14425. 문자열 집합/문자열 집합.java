import java.io.*;
import java.util.HashSet;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// StringBuilder sb = new StringBuilder();
		// int inputInt = Integer.parseInt(br.readLine());
		String[] inputStrArr = br.readLine().split(" ");
		
		int N = Integer.parseInt(inputStrArr[0]);
		int M = Integer.parseInt(inputStrArr[1]);
		HashSet<String> set = new HashSet<>();
		
		for (int i = 0; i < N; i++) {
			set.add(br.readLine());
		}
		
		int count = 0;
		for (int i = 0; i < M; i++) {
			if (set.contains(br.readLine())) {
				count++;
			}
		}
		
		System.out.println(count);
		
	}
}
