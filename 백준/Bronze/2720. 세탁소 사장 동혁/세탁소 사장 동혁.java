import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		int[][] coin = new int[T][4];
		
		for (int i = 0; i < T; i++) {
			int C = sc.nextInt();
			coin[i][0] = C/25;
			coin[i][1] = C%25/10;
			coin[i][2] = C%25%10/5;
			coin[i][3] = C%5/1;
		}
		
		for (int i = 0; i < T; i++) {
			for (int j = 0; j < 4; j++) {
				System.out.print(coin[i][j] + " ");
			}
			System.out.println();
		}
		
	}

}