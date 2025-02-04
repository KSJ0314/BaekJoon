import java.io.*;
import java.util.*;

public class Main {
	public static int findGCD(int a, int b) {
		if (b == 0) return a;
		return findGCD(b, a%b);
	}

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[] arr = new int[n-1];
		int a = sc.nextInt();
		for (int i = 0; i < n-1; i++) {
			int b = sc.nextInt();
			arr[i] = b-a;
			a = b;
		}
		
		int gcd = arr[0];
		for (int i = 1; i < arr.length; i++) {
			gcd = findGCD(gcd, arr[i]);
		}
		
		int sum = 0;
		for (int i : arr) {
			sum += i/gcd -1;
		}
		System.out.println(sum);
	}
}
