import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String S = br.readLine();

		int N = S.length();
		char[] arrC = new char[S.length()];
		for (int i = 0; i < S.length(); i++) {
			arrC[i] = S.charAt(i);
		}

		for (int i = 0; i < S.length() - 1; i++) {
			if (S.charAt(i) == 'c' && (S.charAt(i + 1) == '=' || S.charAt(i + 1) == '-')) {
				N--;
			} else if (S.charAt(i) == 'd' && ((i < S.length() - 2 && S.charAt(i + 1) == 'z' && S.charAt(i + 2) == '=')
					|| S.charAt(i + 1) == '-')) {
				N--;
			} else if ((S.charAt(i) == 'l' || S.charAt(i) == 'n') && S.charAt(i + 1) == 'j') {
				N--;
			} else if ((S.charAt(i) == 's' || S.charAt(i) == 'z') && S.charAt(i + 1) == '=') {
				N--;
			}
		}
		
		System.out.println(N);
	}

}
