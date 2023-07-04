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

		int[] student = new int[30];

		for (int i = 0; i < student.length; i++) {
			student[i] = i + 1;
		}

		for (int i = 0; i < 28; i++) {
			student[Integer.parseInt(br.readLine()) - 1] = 0;
		}
		
		for (int i : student) {
			if (i != 0) {
				System.out.println(i);
			}
		}

	}

}