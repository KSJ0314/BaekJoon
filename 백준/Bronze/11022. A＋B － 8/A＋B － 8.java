import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		String a;
		String b;
		String c;
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			a = st.nextToken();
			b = st.nextToken();
			c = String.valueOf(Integer.parseInt(a) + Integer.parseInt(b));
			bw.write("Case #" + String.valueOf(i + 1) + ": " + a + " + " + b + " = " + c);
			bw.newLine();
		}

		bw.flush();
		bw.close();

	}

}