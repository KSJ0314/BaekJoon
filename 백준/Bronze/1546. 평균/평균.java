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

		double[] arrGrade = new double[N];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arrGrade[i] = Double.parseDouble(st.nextToken());
		}

		double max = arrGrade[0];
		for (int i = 1; i < N; i++) {
			if (max < arrGrade[i]) {
				max = arrGrade[i];
			}
		}
		double sum = 0;
		for (int i = 0; i < N; i++) {
			arrGrade[i] = arrGrade[i] / max * 100;
			sum += arrGrade[i];
		}
		double avg = sum / N;
		System.out.println(avg);

	}

}