import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st;

		String a = br.readLine();

		int sum = 0;

		for (int i = 0; i < a.length(); i++) {
			int b = a.charAt(i);
			if (b == 0) {
				break;
			}
			if (b >= 83) {
				b--;
			}
			if (b >= 89) {
				b--;
			}
			sum += (b - 65) / 3 + 3;
		}
		System.out.println(sum);

	}

}
