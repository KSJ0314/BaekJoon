import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);

		int H = s.nextInt();
		int M = s.nextInt();

		M -= 45;
		if (M < 0) {
			M += 60;
			H -= 1;
			if (H < 0) {
				H += 24;
			}
		}
		System.out.printf(H + " " + M);

	}

}
