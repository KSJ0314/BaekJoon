import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int M = sc.nextInt();
		int N = sc.nextInt();
		
		int sum = 0;
		int first = 0;
		O: for (int i = M; i <= N; i++) {
			if (i == 1) {
				continue O;
			}
			for (int j = 2; j < i; j++) {
				if (i % j == 0) {
					continue O;
				}
			}
			
			if (first == 0) {
				first = i;
			}
			sum += i;
		}
		
		if (first == 0) {
			System.out.println("-1");
			return;
		}
		
		System.out.println(sum);
		System.out.println(first);
	}

}
