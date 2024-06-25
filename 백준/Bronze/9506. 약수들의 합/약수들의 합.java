import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			int n = sc.nextInt();
			
			if (n == -1) {
				break;
			}
			
			String output = n + " = 1";
			
			int sum = 1;
			for (int i = 2; i < n; i++) {
				if (n % i == 0) {
					output += " + " + i;
					sum += i;
				}
			}
			
			if (n != sum) {
				output = n + " is NOT perfect.";
			}
			
			System.out.println(output);
		}
	}

}
