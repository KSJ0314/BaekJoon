import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int deg1 = sc.nextInt();
		int deg2 = sc.nextInt();
		int deg3 = sc.nextInt();
		
		if (deg1 +deg2 +deg3 != 180) {
			System.out.println("Error");
		} else if (deg1 == deg2 && deg1 == deg3) {
			System.out.println("Equilateral");
		} else if (deg1 != deg2 && deg1 != deg3 && deg2 != deg3) {
			System.out.println("Scalene");
		} else {
			System.out.println("Isosceles");
		}
		
	}

}
