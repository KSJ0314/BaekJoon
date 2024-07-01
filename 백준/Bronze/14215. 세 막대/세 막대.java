import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] edges = new int[3];
		
		for (int i = 0; i < 3; i++) {
			edges[i] = sc.nextInt();
		}
		
		Arrays.sort(edges);
		
		if (edges[2] >= edges[0]+edges[1]) {
			edges[2] = edges[0]+edges[1] - 1;
		}
		
		System.out.println(Arrays.stream(edges).sum());
		
	}

}
