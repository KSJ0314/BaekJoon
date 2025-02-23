import java.io.*;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		boolean boo = false;
		
		int p = sc.nextInt();
		if (p != 1 && p != 8) {
			System.out.println("mixed");
			return;
		}
		if (p == 1) boo = true;
		for (int i = 2; i <= 8; i++) {
			int n = sc.nextInt();
			if (n-p != (boo?1:-1)) {
				System.out.println("mixed");
				return;
			}
			p = n;
		}
		System.out.println(boo ? "ascending" : "descending");
	}
	
}