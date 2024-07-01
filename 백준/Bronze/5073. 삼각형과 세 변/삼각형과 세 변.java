import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			int[] degs = new int[3];
			for (int i = 0; i < degs.length; i++) {
				degs[i] = sc.nextInt();
			}
			
			if (degs[0] == 0) {
				break;
			}
			Arrays.sort(degs);
			
			if (degs[2] >= degs[0]+degs[1]) {
				System.out.println("Invalid");
			} else if (degs[0] == degs[1] && degs[0] == degs[2]) {
				System.out.println("Equilateral");
			} else if (degs[0] != degs[1] && degs[0] != degs[2] && degs[1] != degs[2]) {
				System.out.println("Scalene");
			} else {
				System.out.println("Isosceles");
			}
		}
		
	}

}
