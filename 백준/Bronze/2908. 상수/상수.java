import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st;

		st = new StringTokenizer(br.readLine());

		String a = st.nextToken();
		String b = st.nextToken();
		String c = "" + a.charAt(2) + a.charAt(1) + a.charAt(0);
		String d = "" + b.charAt(2) + b.charAt(1) + b.charAt(0);
		int intC = Integer.parseInt(c);
		int intD = Integer.parseInt(d);
		
		int result;
		if (intC > intD) {
			result = intC;
		} else {
			result = intD;
		}
		
		System.out.println(result);
	}

}
