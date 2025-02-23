import java.io.*;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int[] cnts = new int[10];
		
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		
		for (int mul = a*b*c; mul > 0; mul /= 10) {
			cnts[mul%10]++;
		}
		
		for (int i = 0; i < 10; i++) {
			System.out.println(cnts[i]);
		}
	}
	
}