import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[][] coors = new int[3][3];
		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 2; j++) {
				coors[i][j] = sc.nextInt();
			}
		}
		
		int[] coor = new int[2];
		for (int i = 0; i < 2; i++) {
			coor[i] = coors[0][i];
			if (coor[i] == coors[1][i]) {
				coor[i] = coors[2][i];
			} else if (coor[i] == coors[2][i]) {
				coor[i] = coors[1][i];
			}
		}
		System.out.println(coor[0] + " " + coor[1]);
		
	}

}
