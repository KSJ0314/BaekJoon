import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		boolean[][] black = new boolean[100][100];
		
		int N = sc.nextInt();
		
		for (int i = 0; i < N; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			for (int k = a; k < a+10; k++) {
				for (int l = b; l < b+10; l++) {
					black[k][l] = true;
				}
			}
				
		}
		
		int sum = 0;
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (black[i][j]) {
					sum++;
				}
			}
		}
		
		System.out.println(sum);
		
		
	}

}