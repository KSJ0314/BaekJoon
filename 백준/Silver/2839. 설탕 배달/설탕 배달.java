import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int remainder = N%5;
		int result = N/5;
		
		if (remainder != 0) {
			switch (remainder) {
				case 2:
					if (N<10) {
						result = -1;
						break;
					}
				case 4:
					result++;
				case 1:
					if (N<5) {
						result = -1;
						break;
					}
				case 3:
					result++;
			}
		}
		
		System.out.println(result);
		
	}

}