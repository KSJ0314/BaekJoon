import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long n = sc.nextLong();
		
		long sum = 0;
		while (n>0) {
			sum += n-1;
			n--;
		}
		System.out.println(sum);
		System.out.println(2);
	}

}
