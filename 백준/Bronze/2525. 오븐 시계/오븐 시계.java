import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);

		int A = s.nextInt();
		int B = s.nextInt();
		int C = s.nextInt();

		B += C;
		if (B / 60 > 0) {
			A += B/60;
			B %= 60;
			if (A >= 24) {
				A -= 24;
			}
		}
		System.out.printf(A + " " + B);

	}

}
