import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		int A = sc.nextInt();
		int B = sc.nextInt();
		int V = sc.nextInt();
		
		int a = A-B;
		int b = (V-B)/a;
		if ((V-B)%a != 0) {
			b++;
		}
		
		
		System.out.println(b);

	}

}