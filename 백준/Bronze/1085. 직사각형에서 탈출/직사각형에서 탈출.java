import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int x = sc.nextInt();
		int y = sc.nextInt();
		int w = sc.nextInt();
		int h = sc.nextInt();
		
		int xw = Math.abs(x-w);
		int yh = Math.abs(y-h);
		
		int[] min = {x, y, xw, yh};
		Arrays.sort(min);
		System.out.println(min[0]);
		
	}

}
