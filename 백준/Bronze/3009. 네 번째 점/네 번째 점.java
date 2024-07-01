import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[][] coor = new int[3][3];
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 2; j++) {
				coor[i][j] = sc.nextInt();
			}
		}
		
		int x = coor[0][0];
		if (x == coor[1][0]) {
			x = coor[2][0];
		} else if (x == coor[2][0]) {
			x = coor[1][0];
		}
		
		int y = coor[0][1];
		if (y == coor[1][1]) {
			y = coor[2][1];
		} else if (y == coor[2][1]) {
			y = coor[1][1];
		}
		
		System.out.println(x + " " + y);
		
	}

}
