import java.io.*;

public class Main {
	static int sum;
	static int[] cnts;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] inputs;
		
		inputs = br.readLine().split(" ");
		int N = Integer.parseInt(inputs[0]);
		
		cnts = new int[4];
		inputs = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(inputs[i]);
			cnts[num]++;
		}
		
		int[][] xors = {
			{0, 3, 3},
			{1, 2, 3},
			{0, 2, 2},
			{1, 3, 2},
			{0, 1, 1},
			{2, 3, 1}
		};
		
		sum = 0;
		
		for (int[] xor : xors) {
			fnc(xor[0], xor[1], xor[2]);
		}
		
		System.out.println(sum);
	}

	public static void fnc(int i, int j, int value) {
		int min = Math.min(cnts[i], cnts[j]);
		sum += min*value;
		cnts[i] -= min;
		cnts[j] -= min;
	}
}