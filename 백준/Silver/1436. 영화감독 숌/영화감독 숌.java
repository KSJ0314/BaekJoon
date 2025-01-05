import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int count = 665;
		while (N>0) {
			count++;
			if (String.valueOf(count).contains("666")) {
				N--;
			}
		}
		
		System.out.println(count);
		
	}

}