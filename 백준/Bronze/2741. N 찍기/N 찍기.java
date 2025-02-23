import java.io.*;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int n = sc.nextInt();
		
		for (int i = 1; i <= n; i++) {
			sb.append(i).append("\n");
		}
		System.out.println(sb.toString());
	}
	
}