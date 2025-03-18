import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Main {
	static int M, N;
	static List<int[]> lst;
	static int[] degree;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[] s = br.readLine().split(" ");
		M = Integer.parseInt(s[0]);
		N = Integer.parseInt(s[1]);

		lst = new ArrayList<>();

		degree = new int[M + 1];

		for (int i = 0; i < N; i++) {
			s = br.readLine().split(" ");
			int a = Integer.parseInt(s[0]);
			int b = Integer.parseInt(s[1]);
			lst.add(new int[] { a, b });
		}

		lst.sort(Comparator.comparingInt(a -> a[0]));

		for (int i = 0; i < N; i++) {
			int[] arr = lst.get(i);
			int ans = Math.max(degree[arr[1]], degree[arr[0]] + 1);
			degree[arr[1]] = ans;

		}
		for (int i = 1; i <= M; i++) {
			System.out.print((degree[i] + 1) + " ");
		}
	}

}
