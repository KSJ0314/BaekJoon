import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int k = sc.nextInt();
		
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		arr = Arrays.stream(arr)
				.boxed()
				.sorted(Comparator.reverseOrder())
				.mapToInt(Integer::valueOf)
				.toArray();
		
		System.out.println(arr[k-1]);
	}

}