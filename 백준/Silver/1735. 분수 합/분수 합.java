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
		int a_c = sc.nextInt();
		int a_p = sc.nextInt();
		int b_c = sc.nextInt();
		int b_p = sc.nextInt();
		
		int r_p = findLCM(a_p, b_p);
		int r_c = r_p/a_p*a_c+r_p/b_p*b_c;
		
		int r_GCD = findGCD(r_c, r_p);
		if (r_GCD != 1) {
			r_c /= r_GCD;
			r_p /= r_GCD;
		}
		System.out.print(r_c + " " + r_p);
	}
}