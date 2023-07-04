import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st;

		String S = br.readLine();

		int[] alpha = new int[26];

		for (int i = 0; i < alpha.length; i++) {
			alpha[i] = -1;
		}
		for (int i = 1; i <= S.length(); i++) {
			if (alpha[S.charAt(i - 1) - 97] == -1) {
				alpha[S.charAt(i - 1) - 97] += i;
			}
		}

		for (int i : alpha) {
			System.out.print(i + " ");
		}

	}

}
