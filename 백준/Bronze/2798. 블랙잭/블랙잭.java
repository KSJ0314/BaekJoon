import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] arr = new int[N];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		int result = 0;
		for (int i = 0; i < N-2; i++) {
			J: for (int j = i+1; j < N-1; j++) {
				for (int k = j+1; k < N; k++) {
					int temp = arr[i] + arr[j] + arr[k];
					if (temp <= M) {
						result = Math.max(result, temp);
					} else if (k == j+1) {
						break J;
					}
				}
			}
		}
		System.out.println(result);
	}

}