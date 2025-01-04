import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		
		long sum = 0;
		for (int i = 1; i <= n-2; i++) {
			sum += (n-i-1)*(n-i)/2;
		}
		System.out.println(sum);
		System.out.println(3);
	}

}