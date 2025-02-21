import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int N;
	static List<Integer> list = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		init(br);
		amazing(0, 0);
		System.out.println(sb.toString());
	}
	
	public static void amazing(int depth, int num) {
		if (depth == N) {
			sb.append(num/10).append("\n");
			return;
		}
		
		for (int i = 1; i <= 9; i++) {
			if (!isPrime(num+i)) continue;
			
			amazing(depth+1, (num+i)*10);
		}
	}
	
	public static boolean isPrime(int n) {
		if (n <= 1) return false;
		for (int i = 2; i < n; i++) {
			if (n % i == 0) return false;
		}
		return true;
	}
	
	// 입력, 초기화 등의 세팅
	public static void init(BufferedReader br) throws IOException {
		String[] strs = br.readLine().split(" ");
		N = Integer.parseInt(strs[0]);
	}
	
}
