import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a1 = sc.nextInt();
		int a0 = sc.nextInt();
		int c = sc.nextInt();
		int n0 = sc.nextInt();
		
		int result = (a0>=0 || a1<=c) && (a1*n0 + a0 <= c*n0) ? 1 : 0;
		System.out.println(result);
	}

}