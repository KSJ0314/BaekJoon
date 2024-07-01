import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] x = new int[N];
		int[] y = new int[N];
		
		for (int i = 0; i < N; i++) {
			x[i] = sc.nextInt();
			y[i] = sc.nextInt();
		}
		
		Arrays.sort(x);
		Arrays.sort(y);
		
		int wid = x[N-1]-x[0];
		int hei = y[N-1]-y[0];
		
		System.out.println(wid * hei);
		
	}

}
