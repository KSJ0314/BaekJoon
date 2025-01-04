import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();	// ax + by = c
		int b = sc.nextInt();	// dx + ey = f
		int c = sc.nextInt();
		int d = sc.nextInt();
		int e = sc.nextInt();
		int f = sc.nextInt();
		
		int x = (c*e - b*f) / (a*e - b*d);
		int y = (d*c - a*f) / (d*b - a*e);
		System.out.println(x + " " + y);
	}

}