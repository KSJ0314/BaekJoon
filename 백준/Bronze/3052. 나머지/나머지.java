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

		int[] arr = new int[42];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = i;
		}

		for (int i = 0; i < 10; i++) {
			arr[Integer.parseInt(br.readLine()) % 42] = -1;
		}

		int sum = 0;
		for (int i : arr) {
			if (i == -1) {
				sum++;
			}
		}
		System.out.println(sum);

	}

}
