import java.io.*;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		String[] members = new String[201];
		
		String[] inputStr;
		for (int i = 0; i < N; i++) {
			inputStr = br.readLine().split(" ");
			int idx = Integer.parseInt(inputStr[0]);
			if (members[idx] == null) members[idx] = "";
			members[idx] += inputStr[1]+",";
		}
		
		for (int i = 0; i <= 200; i++) {
			if (members[i] == null) continue;
			for (String member : members[i].split(",")) {
				System.out.println(i+" "+ member);
			}
		}
		
	}
}
