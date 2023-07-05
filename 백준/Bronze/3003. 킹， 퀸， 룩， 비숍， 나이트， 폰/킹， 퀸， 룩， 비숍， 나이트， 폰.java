import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int[] piece = { 1, 1, 2, 2, 2, 8 };

		StringTokenizer st = new StringTokenizer(br.readLine());

		int[] piece2 = new int[6];

		for (int i = 0; i < 6; i++) {
			piece2[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < 6; i++) {
			piece[i] -= piece2[i];
			System.out.print(piece[i] + " ");
		}

	}

}
