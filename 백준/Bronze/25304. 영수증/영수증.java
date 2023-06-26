import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);

		int X = s.nextInt();
		int N = s.nextInt();
		int sum = 0;

		for (int i = 0; i < N; i++) {
			sum += s.nextInt() * s.nextInt();
		}
		if (X == sum) {
			System.out.println("Yes");
		} else {
			System.out.println("No");
		}

	}

}