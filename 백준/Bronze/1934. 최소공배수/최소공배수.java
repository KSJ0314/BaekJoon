import java.io.*;
import java.util.Scanner;

public class Main {
	public static int findGCD(int a, int b) {
		if (b == 0) return a;
		return findGCD(b, a % b);
	}
	
	public static int findLCM(int a, int b) {
		return (a*b) / findGCD(a, b);
	}
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			sb.append(findLCM(sc.nextInt(), sc.nextInt())).append("\n");
		}
		System.out.println(sb.toString());
	}
}