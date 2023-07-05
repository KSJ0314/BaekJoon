import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		for (int i = 0; i < N; i++) {
			for (int j = N - 1; j > i; j--) {
				System.out.print(" ");
			}
			for (int j = 0; j < 2 * (i + 1) - 1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for (int i = N - 2; i >= 0; i--) {
			for (int j = N - 1; j > i; j--) {
				System.out.print(" ");
			}
			for (int j = 0; j < 2 * (i + 1) - 1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

	}

}
