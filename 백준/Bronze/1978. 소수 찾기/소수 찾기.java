import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int sum = N;
		for (int i = 0; i < N; i++) {
			int num = sc.nextInt();
			
			if (num == 1) {
				sum--;
			}
			for (int j = 2; j < num; j++) {
				if (num % j == 0) {
					sum--;
					break;
				}
			}
		}
		
		System.out.println(sum);
	}

}
