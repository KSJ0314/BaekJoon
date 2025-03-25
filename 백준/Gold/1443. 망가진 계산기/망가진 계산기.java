import java.io.*;

public class Main {
	static int D, P, max;
	static boolean[] notDefault;
	
	public static void main(String[] args) throws IOException {
		init();
		combi(0, 2, 1);
		System.out.println(max == 0 ? -1 : max);
	}

	private static void combi(int depth, int start, int mul) {
		if (mul >= D) return;
		if (depth == P) {
			max = Math.max(max, mul);
			return;
		}
		
		for (int i = start; i <= 9; i++) {
			combi(depth+1, i, mul*i);
		}
	}

	static void init() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strs = br.readLine().split(" ");
		D = Integer.parseInt(strs[0]);
		P = Integer.parseInt(strs[1]);
		D = (int) Math.pow(10, D);
		max = 0;
	}
}