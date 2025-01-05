import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] arr = new int[5];
		for (int i = 0; i < 5; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		int sum = Arrays.stream(arr).sum();
		
		System.out.println(sum/5);
		System.out.println(arr[2]);
	}

}