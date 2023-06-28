import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);

		int[] num = new int[9];

		for (int i = 0; i < 9; i++) {
			num[i] = s.nextInt();
		}
		int max = num[0];
		int maxIndex = 1;

		for (int i = 1; i < 9; i++) {
			if (max < num[i]) {
				max = num[i];
				maxIndex = i + 1;
			}
		}
		System.out.println(max);
		System.out.println(maxIndex);

	}

}