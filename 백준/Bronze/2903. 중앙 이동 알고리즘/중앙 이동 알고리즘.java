import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int num = 2;
		
		for (int i = 0; i < N; i++) {
			num = num*2 -1;
		}
		System.out.println((int)Math.pow(num, 2));
		
	}

}
