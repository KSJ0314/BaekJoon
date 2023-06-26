import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);

		int T = s.nextInt();

		for (int i = 0; i < T; i++) {
			int A = s.nextInt();
			int B = s.nextInt();
			System.out.println(A + B);
		}

	}

}
