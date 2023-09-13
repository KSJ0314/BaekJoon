import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		String N = sc.next();
		int B = sc.nextInt();
		
		int size = N.length();
		
		int sum = 0;
		int c = 1;
		for (int i = size-1; i >= 0; i --) {
			char a = N.charAt(i);
			int b = a-48;
			if (a >= 65) {
				b -= 7;
			}
			sum += b*c;
			c *= B;
		}
		System.out.println(sum);
		
		
	}

}