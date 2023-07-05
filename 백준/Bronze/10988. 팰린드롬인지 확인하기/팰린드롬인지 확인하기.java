import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st;

		String S = br.readLine();

		char[] S2 = new char[S.length()];

		for (int i = S.length() - 1; i >= 0; i--) {
			S2[S.length() - 1 - i] = S.charAt(i);
		}
		String S22 = String.valueOf(S2);
		
		if (S.equals(S22)) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}

	}

}
