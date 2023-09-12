import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int[][] arr1 = new int[9][9];
		
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				arr1[i][j] = sc.nextInt();
			}
		}
		
		int max = 0;
		int x = 1;
		int y = 1;
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (max < arr1[i][j]) {
					max = arr1[i][j];
					x = i+1;
					y = j+1;
				}
			}
		}
		
		System.out.println(max);
		System.out.println(x + " " + y);
		
		
	}

}