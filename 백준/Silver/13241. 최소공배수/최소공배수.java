import java.io.*;
import java.util.Scanner;

public class Main {
	public static long findGCD(long a, long b) {
		if (b == 0) return a;
		return findGCD(b, a % b);
	}
	
	public static long findLCM(long a, long b) {
		return (a*b) / findGCD(a, b);
	}
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		System.out.println(findLCM(sc.nextLong(), sc.nextLong()));
	}
}