import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringBuilder[] members = new StringBuilder[201];
		
		String[] inputStr;
		for (int i = 0; i < N; i++) {
			inputStr = br.readLine().split(" ");
			int idx = Integer.parseInt(inputStr[0]);
			if (members[idx] == null) members[idx] = new StringBuilder();
			members[idx].append(inputStr[1]+",");
		}
		
		for (int i = 0; i <= 200; i++) {
			if (members[i] == null) continue;
			for (String member : members[i].toString().split(",")) {
				System.out.println(i+" "+ member);
			}
		}
		
	}
}
