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

		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());

		int[] num = new int[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}

		int v = Integer.parseInt(br.readLine());

		int sum = 0;

		for (int i = 0; i < N; i++) {
			if (num[i] == v) {
				sum++;
			}
		}
		System.out.println(sum);

		bw.close();

	}

}
