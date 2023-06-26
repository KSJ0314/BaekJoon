
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);

		int A = s.nextInt();
		int B = s.nextInt();
		int C = s.nextInt();

		int money = 0;
		if (A == B) {
			if (A == C) {
				money = 10000 + A * 1000;
			} else {
				money = 1000 + A * 100;
			}
		} else if (B == C || A == C) {
			money = 1000 + C * 100;
		} else {
			if (A < B) {
				A = B;
			}
			if (A < C) {
				A = C;
			}
			money = A * 100;
		}

		System.out.println(money);

	}

}
